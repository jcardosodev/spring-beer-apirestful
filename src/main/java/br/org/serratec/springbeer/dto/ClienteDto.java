package br.org.serratec.springbeer.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Cliente;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDto(
		
		 Long id,	
		 String email,
		 String nomeCompleto,
		 String cpf,
		 String telefone,
		 LocalDate dataNascimento,
		 DadosViaCep endereco
		) {
	
	public Cliente toEntity() {
		return Mapper.getMapper().convertValue(this, Cliente.class);
	}

	public static ClienteDto toDto(Cliente clienteEntity) {
		return Mapper.getMapper().convertValue(clienteEntity, ClienteDto.class);
	}
}
