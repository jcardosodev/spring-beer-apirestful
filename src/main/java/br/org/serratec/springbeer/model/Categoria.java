package br.org.serratec.springbeer.model;

public enum Categoria {
	EQUIPAMENTOS("Equipamentos"),
	MALTES("Maltes"),
	LUPULOS("Lúpulos"),
	FERMENTO("Fermento"),
	KITSRECEITAS("Kits");

	
	private String categoriaProduto;
	
	private Categoria(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
	public static Categoria toCategoria(String categoriaProduto) {
		
		for (Categoria categoria : Categoria.values()) {
			
			if (categoria.categoriaProduto.equalsIgnoreCase(categoriaProduto)) {
				return categoria;
			}
		}
		
		return null;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

}
