package br.org.serratec.springbeer.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.model.Cliente;
import br.org.serratec.springbeer.model.Endereco;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosViaCep(
		@JsonAlias("cep") String cep,
		@JsonAlias("logradouro") String logradouro,
		@JsonAlias("bairro") String bairro,
		@JsonAlias("localidade") String cidade,
		@JsonAlias("uf") String uf) {
	
	public Endereco toEntity() {
		Endereco endereco = new Endereco();
		endereco.setCep(this.cep);
		endereco.setlogradouro(this.logradouro);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		endereco.setUf(this.uf);
		return endereco;
	}
	
}
