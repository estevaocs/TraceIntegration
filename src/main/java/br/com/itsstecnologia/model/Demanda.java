package br.com.itsstecnologia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.itsstecnologia.enums.PrioridadeEnum;

@Entity
@Table(name="tb_demanda")
public class Demanda {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nm_empresa")
	private String empresa;
	
	@Column(name="nm_estado")
	private String estado;
	
	@Column(name="nm_destino")
	private String destino;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="nm_prioridade")
	private PrioridadeEnum prioridade;
	
	@Column(name="nm_resp_atendimento")
	private String responsavelAtendimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao")
	private Date dataHoraCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_sla")
	private Date sla;
	
	public Demanda(){
		
	}

	public Demanda(long id, String empresa, String estado, String destino, PrioridadeEnum prioridade,
			String responsavelAtendimento, Date dataHoraCriacao, Date sla) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.estado = estado;
		this.destino = destino;
		this.prioridade = prioridade;
		this.responsavelAtendimento = responsavelAtendimento;
		this.dataHoraCriacao = dataHoraCriacao;
		this.sla = sla;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

	public String getResponsavelAtendimento() {
		return responsavelAtendimento;
	}

	public void setResponsavelAtendimento(String responsavelAtendimento) {
		this.responsavelAtendimento = responsavelAtendimento;
	}

	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Date dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public Date getSla() {
		return sla;
	}

	public void setSla(Date sla) {
		this.sla = sla;
	}
	
	
}
	
	