package br.org.serratec.springbeer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.springbeer.dto.ClienteDto;
import br.org.serratec.springbeer.dto.DadosViaCep;
import br.org.serratec.springbeer.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService servico;
	
	@GetMapping
	 public ResponseEntity<List<ClienteDto>> obterTodosClientes() {
      return new ResponseEntity<>(servico.obterTodosCliente(), HttpStatus.OK);
	}
	
	@GetMapping("/busca/{id}")
    public ResponseEntity<ClienteDto> obterClienteId(@PathVariable Long id) {
        Optional<ClienteDto> dto = servico.obterClientePorId(id);
        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	
	@GetMapping("/{cep}")
	public DadosViaCep obterDadosCep(@PathVariable String cep) {
		return servico.obterDadosViaCep(cep);
	}
	
	@PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteDto cliente) {
        return new ResponseEntity<>(servico.cadastrarCliente(cliente), HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarClienteId(@PathVariable Long id, @RequestBody @Valid ClienteDto cliente) {
        Optional<ClienteDto> dto = servico.atualizarCliente(id, cliente);

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto.get());
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirClientePorId(@PathVariable Long id) {
        if (!servico.excluirClientePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
		
}
