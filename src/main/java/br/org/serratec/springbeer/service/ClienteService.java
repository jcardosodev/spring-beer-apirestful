package br.org.serratec.springbeer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.springbeer.dto.ClienteDto;
import br.org.serratec.springbeer.dto.DadosViaCep;
import br.org.serratec.springbeer.model.Cliente;
import br.org.serratec.springbeer.repository.ClienteRepository;
import jakarta.validation.Valid;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repositorioCliente;
	
	
	
	@Autowired
	private ConverterDados conversor;

	public DadosViaCep obterDadosViaCep(String cep) {
		var json = ViaCepApi.obterDadosViaCep(cep);
		DadosViaCep dadosViaCep = conversor.converter(json, DadosViaCep.class);
	
		
		return dadosViaCep;
	}

	public List<ClienteDto> obterTodosCliente(){        
        return repositorioCliente.findAll().stream()
        		.map(c -> ClienteDto.toDto(c)).toList();
    }
	
	@SuppressWarnings("unused")
	public ClienteDto cadastrarCliente(ClienteDto cliente) {
		DadosViaCep dados = obterDadosViaCep(cliente.endereco().cep());
		if(dados == null) {
        	throw new IllegalArgumentException("Digite um cep válido");
        }
		DadosViaCep enderecoCompleto = new DadosViaCep(dados.cep(), dados.rua(), dados.bairro(), 
				cliente.endereco().numero(), dados.cidade(), dados.uf(), cliente.endereco().complemento());
        Cliente clienteEntity = cliente.toEntity();     
        clienteEntity.setEndereco(enderecoCompleto.toEntity());
        
        return ClienteDto.toDto(repositorioCliente.save(clienteEntity));
    }
	
	public Optional<ClienteDto> obterClientePorId(Long id) {
        Optional<Cliente> clienteEntity = repositorioCliente.findById(id);
        if (clienteEntity.isEmpty()) {
            return Optional.of(ClienteDto.toDto(clienteEntity.get()));
        }
        return Optional.empty();
    }
	 
	public Optional<ClienteDto> atualizarCliente(Long id, @Valid ClienteDto cliente) {
        if (repositorioCliente.existsById(id)) {
            Cliente clienteEntity = cliente.toEntity();
            DadosViaCep dados = obterDadosViaCep(cliente.endereco().cep());
            DadosViaCep enderecoCompleto = new DadosViaCep(dados.cep(), dados.rua(), dados.bairro(), 
    				cliente.endereco().numero(), dados.cidade(), dados.uf(), cliente.endereco().complemento());
            clienteEntity.setId(id);
            clienteEntity.setEndereco(enderecoCompleto.toEntity());
            repositorioCliente.save(clienteEntity);
            return Optional.of(ClienteDto.toDto(clienteEntity));
        }
        return Optional.empty(); 
    }
	
	public boolean excluirClientePorId (Long id) {
        Optional<Cliente> cliente = repositorioCliente.findById(id);
        if(cliente.isEmpty()) {
            return false;
        }
        repositorioCliente.deleteById(id);
        return true;
    }
	
}
