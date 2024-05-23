package br.org.serratec.springbeer.dto;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Categoria;

public record CategoriaDto(
		
		 Long id,
		 String nomeCategoria,
		 String descricaoCategoria
		) {
	
	public Categoria toEntity() {
		return Mapper.getMapper().convertValue(this, Categoria.class);
	}

}
