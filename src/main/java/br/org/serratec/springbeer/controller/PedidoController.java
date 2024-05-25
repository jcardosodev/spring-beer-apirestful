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
import br.org.serratec.springbeer.dto.PedidoDto;
import br.org.serratec.springbeer.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService servico;
	
	@GetMapping
	 public ResponseEntity<List<PedidoDto>> obterTodosPedido() {
     return new ResponseEntity<>(servico.obterTodosPedidos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obterPedidoId(@PathVariable Long id) {
        Optional<PedidoDto> dto = servico.obterPedidoPorId(id);
        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping
    public ResponseEntity<PedidoDto> cadastrarPedido(@RequestBody @Valid PedidoDto Pedido) {
        return new ResponseEntity<>(servico.cadastrarPedido(Pedido), HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedidoId(@PathVariable Long id, @RequestBody @Valid PedidoDto Pedido) {
        Optional<PedidoDto> dto = servico.atualizarPedido(id, Pedido);

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto.get());
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedidoPorId(@PathVariable Long id) {
        if (!servico.excluirPedidoPorId(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
