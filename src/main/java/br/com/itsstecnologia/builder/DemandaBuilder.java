package br.com.itsstecnologia.builder;

import java.text.ParseException;
import java.util.Date;

import br.com.itsstecnologia.dao.DemandaDAO;
import br.com.itsstecnologia.dao.RegraPrioridadeDAO;
import br.com.itsstecnologia.enums.DateFormat;
import br.com.itsstecnologia.enums.PrioridadeEnum;
import br.com.itsstecnologia.model.Demanda;
import br.com.itsstecnologia.services.CalculaSLA;

public class DemandaBuilder {

	private long id;
	private String empresa;
	private String destino;
	private String estado;
	private PrioridadeEnum prioridade;
	private String responsavelAtendimento;
	private Date dataHoraCriacao;
	private Date sla;

	public DemandaBuilder instId(String id) {
		this.id = Long.parseLong(id);
		return this;
	}

	public DemandaBuilder instEmpresa(String empresa) {
		this.empresa = empresa;
		return this;
	}
	
	public DemandaBuilder instEstado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public DemandaBuilder instDestino(String destino) {
		this.destino = destino;
		return this;
	}

	public DemandaBuilder instPrioridade(String prioridade) {
		switch (prioridade) {
		case "Urgente":
			this.prioridade = PrioridadeEnum.URGENTE;
		case "Alta":
			this.prioridade = PrioridadeEnum.ALTA;
		case "Média":
			this.prioridade = PrioridadeEnum.MEDIA;
		case "Baixa":
			this.prioridade = PrioridadeEnum.BAIXA;
		case "NC-":
			this.prioridade = PrioridadeEnum.NC;
		default:
			this.prioridade = PrioridadeEnum.VAZIA;
		}
		return this;
	}

	public DemandaBuilder instRespAtend(String responsavelAtendimento) {
		this.responsavelAtendimento = responsavelAtendimento;
		return this;
	}

	public DemandaBuilder instData(String data) throws ParseException {
		this.dataHoraCriacao = DateFormat.DATA_TIME.format.parse(data);
		return this;
	}

	private void calculaSla() throws ParseException {
		int horas = RegraPrioridadeDAO.getInstance().getHora(this.empresa, this.prioridade);
		this.sla = CalculaSLA.calcula(this.dataHoraCriacao, horas);
	}

	public Demanda builder() throws ParseException {
		if (this.id <= 0 || this.empresa.isEmpty() || this.prioridade == null) {
			throw new RuntimeException("campos obrigatórios não preenchidos!");
		} else {
			calculaSla();
			Demanda demanda = new Demanda(this.id, this.empresa, this.estado, this.destino, this.prioridade,
					this.responsavelAtendimento, this.dataHoraCriacao, this.sla);
			DemandaDAO.getInstance().persist(demanda);
			return demanda;
		}
	}

}
