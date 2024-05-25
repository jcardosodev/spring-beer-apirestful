package br.org.serratec.springbeer.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.model.Endereco;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosViaCep(
		@JsonAlias("cep") String cep,
		@JsonAlias("logradouro") String rua,
		@JsonAlias("bairro") String bairro,
		int numero,
		@JsonAlias("localidade") String cidade,
		@JsonAlias("uf") String uf,
		String complemento) {
	
	public Endereco toEntity() {
		Endereco endereco = new Endereco();
		endereco.setCep(this.cep);
		endereco.setRua(this.rua);
		endereco.setBairro(this.bairro);
		endereco.setNumero(this.numero);
		endereco.setCidade(this.cidade);
		endereco.setUf(this.uf);
		endereco.setComplemento(this.complemento);
		return endereco;
	}
	
}
