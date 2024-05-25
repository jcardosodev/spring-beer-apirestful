package br.org.serratec.springbeer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.springbeer.dto.ProdutoDto;
import br.org.serratec.springbeer.model.Produto;
import br.org.serratec.springbeer.repository.ClienteRepository;
import br.org.serratec.springbeer.repository.ItemPedidoRepository;
import br.org.serratec.springbeer.repository.PedidoRepository;
import br.org.serratec.springbeer.repository.ProdutoRepository;
import jakarta.validation.Valid;


@Service
public class ProdutoService {
	
	@Autowired
	private PedidoRepository pedidoRepositorio;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Autowired
	private ProdutoRepository produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepositorio;
	
	public List<ProdutoDto> obterTodosProdutos() {
			return produtoRepositorio.findAll().stream()
					.map(p -> ProdutoDto.toDto(p)).toList();
	}
	
	 public ProdutoDto cadastrarProduto(ProdutoDto produto) {
	        Produto produtoEntity = produtoRepositorio.save(produto.toEntity());
	        return ProdutoDto.toDto(produtoEntity);
	    }

	public Optional<ProdutoDto> obterProdutoPorId(Long id) {
		Optional<Produto> produtoEntity = produtoRepositorio.findById(id);
		if (produtoEntity.isPresent()) {
			return Optional.of(ProdutoDto.toDto(produtoEntity.get()));
		}
        return Optional.empty();
    }


	public Optional<ProdutoDto> atualizarProduto(Long id, @Valid ProdutoDto produto) {
        if (produtoRepositorio.existsById(id)) {
            Produto produtoEntity = produto.toEntity();
            produtoEntity.setId(id);;
            produtoRepositorio.save(produtoEntity);
            return Optional.of(ProdutoDto.toDto(produtoEntity));
        }
        return Optional.empty();
    }


	public boolean excluirProdutoPorId(Long id) {
		Optional<Produto> produto = produtoRepositorio.findById(id);
		
        if (produto.isEmpty()) {
        	return false;
        }
        
        produtoRepositorio.deleteById(id);
        
        return true;
    }

}
