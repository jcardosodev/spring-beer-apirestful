package br.org.serratec.springbeer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.springbeer.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService servico;
	
	@GetMapping("/{cep}")
	public DadosViaCep obterDadosCep(@PathVariable String cep) {
		return servico.obterDadosViaCep(cep);
	}
}
