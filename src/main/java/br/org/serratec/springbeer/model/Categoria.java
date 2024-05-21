package br.org.serratec.springbeer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	private Long id_categoria;
	private String nome_categoria;
	private String descricao_categoria;
	
	
	 public Categoria() {
	    }

	    public Categoria(Long id_categoria, String nome_categoria) {
	        this.id_categoria = id_categoria;
	        this.nome_categoria = nome_categoria;
	    }

		public Long getId_categoria() {
			return id_categoria;
		}

		public void setId_categoria(Long id_categoria) {
			this.id_categoria = id_categoria;
		}

		public String getNome_categoria() {
			return nome_categoria;
		}

		public void setNome_categoria(String nome_categoria) {
			this.nome_categoria = nome_categoria;
		}

		public String getDescricao_categoria() {
			return descricao_categoria;
		}

		public void setDescricao_categoria(String descricao_categoria) {
			this.descricao_categoria = descricao_categoria;
		}
	    
   
}
