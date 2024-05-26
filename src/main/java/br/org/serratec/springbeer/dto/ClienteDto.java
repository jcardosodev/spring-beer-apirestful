package br.org.serratec.springbeer.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDto(
		
		 Long id,
		 @NotBlank(message ="Informe um email válido, por favor.")
		 String email,
		 @NotBlank(message ="Campo nome não pode ser vazio.")
		 String nomeCompleto,
		 @NotBlank(message ="Informe o cpf no formato correto.")
		 String cpf,
		 @NotBlank(message = "Por favor informe um telefone para contato.")
		 String telefone,
		 @NotNull(message = "Informe a data de nascimento do Cliente.")
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
