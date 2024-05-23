package br.org.serratec.springbeer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.springbeer.controller.DadosViaCep;
import br.org.serratec.springbeer.model.Endereco;
import br.org.serratec.springbeer.repository.ClienteRepository;
import br.org.serratec.springbeer.repository.EnderecoRepository;

@Service
public class ClienteService {
	
//	@Autowired
//	private ClienteRepository repositorioCliente;
	
	@Autowired
	private EnderecoRepository repositorio;
	
	@Autowired
	private ConverterDados conversor;

	public DadosViaCep obterDadosViaCep(String cep) {
		var json = ViaCepApi.obterDadosViaCep(cep);
		DadosViaCep dadosViaCep = conversor.converter(json, DadosViaCep.class);
		Optional<Endereco> enderecoEntity = repositorio
				.findByCep(dadosViaCep.cep());
		
		if(enderecoEntity.isEmpty()) {
			repositorio.save(dadosViaCep.toEntity());
		}
		
		return dadosViaCep;
	}

}
