package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.springbeer.model.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
