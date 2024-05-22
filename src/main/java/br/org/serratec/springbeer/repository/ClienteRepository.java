package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
