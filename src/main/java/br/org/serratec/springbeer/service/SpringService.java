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

@Service
public class SpringService {
	
	@Autowired
	private PedidoRepository pedidoRepositorio;
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Autowired
	private ProdutoRepository produtoRepositorio;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepositorio;
	
	
	
	public List<ProdutoDto> obterTodosProdutos() {
		
		Optional<Produto> produto = produtoRepositorio.findById();
		return produtoRepositorio.buscaPorProduto(produto.get()).stream()
				.map(p -> ProdutoDto.toDto(p)).toList();
		
	}

}
