package br.org.serratec.springbeer.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Categoria;
import br.org.serratec.springbeer.model.Produto;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProdutoDto(
		
		 Long id,
		 String nomeProduto,
		 String descricao,
		 int quantidadeEstoque,
		 LocalDate dataCadastro,
		 Double valorUnitario,		
		 String imagem,
		 Categoria categoriaProduto
		
		) {
	
	public Produto toEntity() {
		return Mapper.getMapper().convertValue(this, Produto.class);
	}

	public static ProdutoDto toDto(Produto produtoEntity) {
		return Mapper.getMapper().convertValue(produtoEntity, ProdutoDto.class);
		
	}

}
