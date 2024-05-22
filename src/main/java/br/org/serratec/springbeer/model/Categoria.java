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
	private Long idCategoria;
	private String nomeCategoria;
	private String descricaoCategoria;

	
	
	public Categoria() {
	}
	
	public Categoria(Long idCategoria, String nomeCategoria) {
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public Long getidCategoria() {
		return idCategoria;
	}

	public void setidCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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
