package br.org.serratec.springbeer.dto;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Status;

public record StatusDto(
		
		String statusUsuario
		
		) {
	
	public Status toEntity() {
		return Mapper.getMapper().convertValue(this, Status.class);
	}

}
