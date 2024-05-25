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

import br.org.serratec.springbeer.dto.ItemPedidoDto;
import br.org.serratec.springbeer.service.ItemPedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/item_pedidos")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService servico;
	
	@GetMapping
	 public ResponseEntity<List<ItemPedidoDto>> obterTodosItemPedido() {
     return new ResponseEntity<>(servico.obterTodosItemPedidos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> obterItemPedidoId(@PathVariable Long id) {
        Optional<ItemPedidoDto> dto = servico.obterItemPedidoPorId(id);
        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping
    public ResponseEntity<List<ItemPedidoDto>> cadastroItemPedido(@RequestBody @Valid List<ItemPedidoDto> ItemPedido) {
		 List<ItemPedidoDto> savedItems = servico.cadastrarItemPedido(ItemPedido);
		    return ResponseEntity.status(HttpStatus.CREATED).body(savedItems);
}
	
	@PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDto> atualizarItemPedidoId(@PathVariable Long id, @RequestBody @Valid ItemPedidoDto ItemPedido) {
        Optional<ItemPedidoDto> dto = servico.atualizarItemPedido(id, ItemPedido);

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto.get());
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItemPedidoPorId(@PathVariable Long id) {
        if (!servico.excluirItemPedidoPorId(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}