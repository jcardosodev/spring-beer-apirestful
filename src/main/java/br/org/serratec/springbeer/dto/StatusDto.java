package br.org.serratec.springbeer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatusDto(
		
		String statusUsuario
		
		) {
	
	public Status toEntity() {
		return Mapper.getMapper().convertValue(this, Status.class);
	}

}
