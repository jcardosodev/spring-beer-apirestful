package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
