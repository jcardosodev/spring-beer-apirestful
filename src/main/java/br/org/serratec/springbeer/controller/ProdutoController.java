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

import br.org.serratec.springbeer.dto.ProdutoDto;
import br.org.serratec.springbeer.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService servico;
	
	@GetMapping
	 public ResponseEntity<List<ProdutoDto>> obterProdutos() {
        return new ResponseEntity<>(servico.obterTodosProdutos(), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoDto produto) {
        return new ResponseEntity<>(servico.cadastrarProduto(produto), HttpStatus.CREATED);
    }

	@GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> obterProdutoId(@PathVariable Long id) {
        Optional<ProdutoDto> dto = servico.obterProdutoPorId(id);
        if (dto.isPresent()) {
            return new ResponseEntity<>(dto.get(), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizarProdutoId(@PathVariable Long id, @RequestBody @Valid ProdutoDto produto) {
        Optional<ProdutoDto> dto = servico.atualizarProduto(id, produto);

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto.get());
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirProdutoId(@PathVariable Long id) {
	        if (!servico.excluirProdutoPorId(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.noContent().build();
	    }
	}


