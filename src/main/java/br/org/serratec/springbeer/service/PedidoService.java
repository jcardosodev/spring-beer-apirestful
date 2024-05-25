package br.org.serratec.springbeer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.springbeer.dto.ClienteDto;
import br.org.serratec.springbeer.dto.PedidoDto;
import br.org.serratec.springbeer.model.Cliente;
import br.org.serratec.springbeer.model.ItemPedido;
import br.org.serratec.springbeer.model.Pedido;
import br.org.serratec.springbeer.model.Status;
import br.org.serratec.springbeer.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositorioPedido;
	
	@Autowired
	private ClienteService servicoCliente;

	public List<PedidoDto> obterTodosPedidos() {        
        return repositorioPedido.findAll().stream()
        		.map(p -> PedidoDto.toDto(p)).toList();
    }

    public PedidoDto cadastrarPedido(PedidoDto pedidoDto) {    
    ClienteDto cliente = servicoCliente.cadastrarCliente(pedidoDto.cliente());
    Pedido pedidoEntity = pedidoDto.toEntity();
    pedidoEntity.setCliente(cliente.toEntity());
    List<ItemPedido> itensPedido = pedidoDto.itemPedido().stream()
        .map(itemDto -> {
        	
            ItemPedido itemPedido = itemDto.toEntity();
            itemPedido.setPedido(pedidoEntity);
            Double valorBruto = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
            Double valorDesconto = valorBruto * (itemPedido.getPercentualDesconto() / 100);
            itemPedido.setValorBruto(valorBruto);
            itemPedido.setValorLiquido(valorBruto - valorDesconto);
            itemPedido.setProduto(itemDto.produto().toEntity());
            return itemPedido;
        })
        .collect(Collectors.toList());
    
    Double valorTotal = itensPedido.stream()
        .mapToDouble(ItemPedido::getValorLiquido)
        .sum();

    pedidoEntity.setItemPedido(itensPedido);
    pedidoEntity.setValorTotal(valorTotal);

    repositorioPedido.save(pedidoEntity);

    return PedidoDto.toDto(pedidoEntity);
}
	
	public Optional<PedidoDto> obterPedidoPorId(Long id) {
        Optional<Pedido> pedidoEntity = repositorioPedido.findById(id);
        if (pedidoEntity.isPresent()) {
            return Optional.of(PedidoDto.toDto(pedidoEntity.get()));
        }
        return Optional.empty();
    }
	
	public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedidoDto) {
	    if (repositorioPedido.existsById(id)) {
	        Optional<Pedido> pedidoSalvoOpt = repositorioPedido.findById(id);

	        if (pedidoSalvoOpt.isEmpty()) {
	            return Optional.empty();
	        }

	        Pedido pedidoEntity = pedidoSalvoOpt.get();
	     
	        ClienteDto clienteDto = pedidoDto.cliente();
	        Cliente clienteEntity;
	        if (clienteDto.id() != null && servicoCliente.obterClientePorId(clienteDto.id()).isPresent()) {
	            clienteEntity = servicoCliente.obterClientePorId(clienteDto.id()).get().toEntity();
	        } else {
	            clienteEntity = servicoCliente.cadastrarCliente(clienteDto).toEntity();
	        }

	        pedidoEntity.setCliente(clienteEntity);
	        
	        pedidoEntity.setDataPedido(pedidoDto.dataPedido());
	        pedidoEntity.setDataEntrega(pedidoDto.dataEntrega());
	        pedidoEntity.setDataEnvio(pedidoDto.dataEnvio());
	        pedidoEntity.setStatus(Status.valueOf(pedidoDto.status()));
	        
	        List<ItemPedido> itensPedido = pedidoDto.itemPedido().stream()
	            .map(itemDto -> {
	                ItemPedido itemPedido = itemDto.toEntity();
	                itemPedido.setPedido(pedidoEntity);
	                Double valorBruto = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
	                Double valorDesconto = valorBruto * (itemPedido.getPercentualDesconto() / 100);
	                itemPedido.setValorBruto(valorBruto);
	                itemPedido.setValorLiquido(valorBruto - valorDesconto);
	                itemPedido.setProduto(itemDto.produto().toEntity());
	                return itemPedido;
	            })
	            .collect(Collectors.toList());
	        
	        Double valorTotal = itensPedido.stream()
	            .mapToDouble(ItemPedido::getValorLiquido)
	            .sum();
	        
	        pedidoEntity.setItemPedido(itensPedido);
	        pedidoEntity.setValorTotal(valorTotal);
	       
	        repositorioPedido.save(pedidoEntity);

	        return Optional.of(PedidoDto.toDto(pedidoEntity));
	    } else {
	        return Optional.empty();
	    }
	}

	
	public boolean excluirPedidoPorId (Long id) {
        Optional<Pedido> pedido = repositorioPedido.findById(id);
        if(pedido.isEmpty()) {
            return false;
        }
        repositorioPedido.deleteById(id);
        return true;
    }
	
}
