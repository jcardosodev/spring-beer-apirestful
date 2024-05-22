package br.org.serratec.springbeer.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.springbeer.dto.ProdutoDto;
import br.org.serratec.springbeer.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	

	Optional<Produto> findById();

	Collection<ProdutoDto> buscaPorProduto(Produto produto);
	

}
