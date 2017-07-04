package br.com.itsstecnologia.enums;

public enum PrioridadeEnum {
	URGENTE("Urgente"), ALTA("Alta"), MEDIA("Média"), BAIXA("Baixa"), NC("NC-"), VAZIA("");
	
	private String descricao;
	PrioridadeEnum(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
