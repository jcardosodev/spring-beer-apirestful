package br.org.serratec.springbeer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Categoria;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoriaDto(

		 String categoriaProduto
		 
		) {
	
	public Categoria toEntity() {
		return Mapper.getMapper().convertValue(this, Categoria.class);
	}

}
