package br.org.serratec.springbeer.dto;

import java.time.LocalDate;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Cliente;
import br.org.serratec.springbeer.model.Endereco;

public record ClienteDto(
		
		 Long idCliente,	
		 String email,
		 String nomeCompleto,
		 String cpf,
		 String telefone,
		 LocalDate dataNascimento,
		 Endereco endereco
		) {
	
	public Cliente toEntity() {
		return Mapper.getMapper().convertValue(this, Cliente.class);
	}


}
