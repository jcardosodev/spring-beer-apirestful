package br.org.serratec.springbeer.dto;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Endereco;

public record EnderecoDto(
		
		 String cep,
		 String rua,
		 String bairro,
		 String numero,
		 String complemento,
		 String uf
		
		) {
	
	public Endereco toEntity() {
		return Mapper.getMapper().convertValue(this, Endereco.class);
	}

}
