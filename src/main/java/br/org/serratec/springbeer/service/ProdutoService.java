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
	
	 public ProdutoDto cadastrarProduto(ProdutoDto produtoDto) {
	        Produto produto = convertToEntity(produtoDto);
	        produtoRepositorio.save(produto);
	        return convertToDto(produto);
	    }


	private ProdutoDto convertToDto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}


	private Produto convertToEntity(ProdutoDto produtoDto) {
		// TODO Auto-generated method stub
		return null;
	}


	public Optional<ProdutoDto> obterProdutoPorId(Long id) {
        return produtoRepositorio.findById(id)
                .map(this::convertToDto);
    }


	public Optional<ProdutoDto> atualizarProduto(Long id, ProdutoDto produtoDto) {
        if (produtoRepositorio.existsById(id)) {
            Produto produto = convertToEntity(produtoDto);
            produto.setid(id);
            produtoRepositorio.save(produto);
            return Optional.of(convertToDto(produto));
        }
        return Optional.empty();
    }


	public boolean excluirProduto(Long id) {
        if (produtoRepositorio.existsById(id)) {
            produtoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
