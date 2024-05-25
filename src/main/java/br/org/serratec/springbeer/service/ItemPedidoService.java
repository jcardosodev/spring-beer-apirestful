package br.org.serratec.springbeer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.springbeer.dto.ItemPedidoDto;
import br.org.serratec.springbeer.model.ItemPedido;
import br.org.serratec.springbeer.model.Produto;
import br.org.serratec.springbeer.repository.ItemPedidoRepository;
import br.org.serratec.springbeer.repository.ProdutoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repositorioItemPedido;
	
	@Autowired
	private ProdutoRepository repositorioProduto;

	public List<ItemPedidoDto> obterTodosItemPedidos() {        
        return repositorioItemPedido.findAll().stream()
        		.map(ip -> ItemPedidoDto.toDto(ip)).toList();
    }
	
//	public List<ItemPedidoDto> cadastrarItemPedido(List<ItemPedidoDto> itensPedidoDtos) {
//		
//        List<ItemPedido> itensPedidos = itensPedidoDtos.stream().map(dto -> {
//            ItemPedido itemPedido = dto.toEntity();
//            Produto produto = repositorioProduto.findById(dto.produto().getId())
//                                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
//            itemPedido.setProduto(produto);
//
//            Double valorBruto = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
//            Double valorDesconto = valorBruto * (itemPedido.getPercentualDesconto() / 100);
//            itemPedido.setValorBruto(valorBruto);
//            itemPedido.setValorLiquido(valorBruto - valorDesconto);
//          
//            return itemPedido;
//        }).collect(Collectors.toList());
//
//        List<ItemPedido> itensPedidosSalvos = repositorioItemPedido.saveAll(itensPedidos);
//
//        return itensPedidosSalvos.stream()
//        		.map(ItemPedidoDto::toDto)
//        		.collect(Collectors.toList());
//    } 
	
	public List<ItemPedidoDto> cadastrarItemPedido(List<ItemPedidoDto> itensPedidoDtos) {
	    List<ItemPedido> itensPedidos = itensPedidoDtos.stream().map(dto -> {
	    ItemPedido itemPedido = dto.toEntity();
	        
	        if (dto.produto() == null) {
	            throw new IllegalArgumentException("Produto não pode ser nulo");
	        }
	        
	        Produto produto = repositorioProduto.findById(dto.produto().id())
	                            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
	        itemPedido.setProduto(produto);

	        Double valorBruto = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
	        Double valorDesconto = valorBruto * (itemPedido.getPercentualDesconto() / 100);
	        itemPedido.setValorBruto(valorBruto);
	        itemPedido.setValorLiquido(valorBruto - valorDesconto);
	      
	        return itemPedido;
	    }).collect(Collectors.toList());

	    List<ItemPedido> itensPedidosSalvos = repositorioItemPedido.saveAll(itensPedidos);

	    return itensPedidosSalvos.stream()
	            .map(ItemPedidoDto::toDto)
	            .collect(Collectors.toList());
	}
	
	public Optional<ItemPedidoDto> obterItemPedidoPorId(Long id) {
        Optional<ItemPedido> ItemPedidoEntity = repositorioItemPedido.findById(id);
        if (ItemPedidoEntity.isEmpty()) {
            return Optional.of(ItemPedidoDto.toDto(ItemPedidoEntity.get()));
        }
        return Optional.empty();
    }
	
	public Optional<ItemPedidoDto> atualizarItemPedido(Long id, ItemPedidoDto ItemPedido) {
        if (repositorioItemPedido.existsById(id)) {
            ItemPedido ItemPedidoEntity = ItemPedido.toEntity();
            ItemPedidoEntity.setid(id);
            repositorioItemPedido.save(ItemPedidoEntity);
            return Optional.of(ItemPedidoDto.toDto(ItemPedidoEntity));
        }
        return Optional.empty();
    }
	
	public boolean excluirItemPedidoPorId (Long id) {
        Optional<ItemPedido> ItemPedido = repositorioItemPedido.findById(id);
        if(ItemPedido.isEmpty()) {
            return false;
        }
        repositorioItemPedido.deleteById(id);
        return true;
    }
	
	
}
