package br.org.serratec.springbeer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.springbeer.dto.ProdutoDto;
import br.org.serratec.springbeer.service.SpringService;

@RestController
@RequestMapping("/spring")
public class SpringBeerController {
	@Autowired
	private SpringService servico;
	
	@GetMapping
	 public ResponseEntity<List<ProdutoDto>> obterTodos() {
        return new ResponseEntity<>(servico.obterTodosProdutos(), HttpStatus.OK);
	}
	
	

}
