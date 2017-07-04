package br.com.itsstecnologia.model;

import java.util.Arrays;

import javax.persistence.*;

import br.com.itsstecnologia.enums.PrioridadeEnum;

@Entity
@Table(name = "tb_reg_prioridade")
public class RegraPrioridade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nm_empresa")
	private String empresa;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "nm_prioridade")
	private PrioridadeEnum prioridade;
	
	@Column(name = "qnt_horas")
	private int hora;

	public RegraPrioridade() {

	}
	
	public RegraPrioridade(String empresa, String prioridade, int hora) {
		this.empresa = empresa;
		this.prioridade = (prioridade == null || prioridade == "") ? PrioridadeEnum.VAZIA : Arrays.asList(PrioridadeEnum.values()).stream()
				.filter(item -> item.getDescricao().equals(prioridade)).findFirst().get();
		this.hora = hora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
}
