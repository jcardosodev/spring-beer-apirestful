package br.org.serratec.springbeer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCategoria;
	private String descricaoCategoria;

	
	
	public Categoria() {
	}
	
	public Categoria(Long id, String nomeCategoria) {
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getnomeCategoria() {
		return nomeCategoria;
	}

	public void setnomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getdescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setdescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
