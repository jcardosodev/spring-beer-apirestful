package br.org.serratec.springbeer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.dto.ProdutoDto;
import br.org.serratec.springbeer.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<ProdutoDto> buscaPorProduto(Produto produto);


	Optional<Produto> findById();
	

}
