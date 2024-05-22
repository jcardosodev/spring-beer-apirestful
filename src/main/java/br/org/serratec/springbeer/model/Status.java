package br.org.serratec.springbeer.model;


public enum Status {
	PEDIDORECEBIDO("Pedido recebido"),
	PEDIDOEMSEPARACAO("Pedido em separação"),
	PEDIDOCOLETADO("Pedido coletado"),
	EMTRANSPORTE("Pedido em transporte"),
	PEDIDOENTREGUE("Pedido entregue"),
	PEDIDOCANCELADO("Pedido foi cancelado");
	
	private String statusUsuario;
	
	private Status(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}
	
	public static Status toStatus(String statusUsuario) {
		
		for (Status status : Status.values()) {
			
			if (status.statusUsuario.equalsIgnoreCase(statusUsuario)) {
				return status;
			}
		}
		
		return null;
	}
	
}
