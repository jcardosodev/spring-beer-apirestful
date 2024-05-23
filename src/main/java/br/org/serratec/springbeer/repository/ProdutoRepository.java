package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	

}
