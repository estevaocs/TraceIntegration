package br.com.itsstecnologia.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import br.com.itsstecnologia.enums.Horarios;


public class CalculaSLA {

	public static Date calcula(Date dataInicial, int horas) throws ParseException {
		Calendar date = Calendar.getInstance();
		date.setTime(dataInicial);
		date = verificaHora(date);
		Calendar sla = null;
		int qntDias = horas / 8;
		int qntHoras = horas % 8;
		sla = calculaDias(date, qntDias);
		sla = calculaHoras(sla, qntHoras);

		return sla.getTime();
	}

	private static Calendar calculaDias(Calendar dataInicial, int qntDias) {

		if (dataInicial.get(Calendar.DAY_OF_WEEK) == 7) {
			dataInicial.add(Calendar.DATE, +2);
			calculaDias(dataInicial, qntDias);
		} else if (dataInicial.get(Calendar.DAY_OF_WEEK) == 1) {
			dataInicial.add(Calendar.DATE, +1);
			calculaDias(dataInicial, qntDias);
		} else if (qntDias > 0) {
			dataInicial.add(Calendar.DATE, +1);
			calculaDias(dataInicial, qntDias - 1);
		}

		return dataInicial;
	}

	private static Calendar calculaHoras(Calendar dataInicial, int qntHoras) throws ParseException {

		if (DateServices.between(dataInicial.getTime(), Horarios.HORA_INICIAL.getHorario(),
				Horarios.HOR_ENTRADA.getHorario())) {

			dataInicial.add(Calendar.HOUR, +8);

		} else if (DateServices.between(dataInicial.getTime(), Horarios.HOR_INI_INTER.getHorario(),
				Horarios.HOR_FIM_INTER.getHorario())) {

			dataInicial.add(Calendar.HOUR, +1);
			dataInicial.add(Calendar.MINUTE, +30);

		} else if (DateServices.between(dataInicial.getTime(), Horarios.HOR_SAIDA.getHorario(),
				Horarios.HORA_FINAL.getHorario())) {

			dataInicial.add(Calendar.HOUR, +14);
		}

		if (qntHoras > 0) {
			dataInicial.add(Calendar.HOUR, +1);
			calculaHoras(dataInicial, qntHoras - 1);
		}

		return dataInicial;
	}

	/**
	 * Metodo que verifica se o horario de criação foi criado fora de espediente, 
	 * caso seja o fora ele seta o horario para o incio do espediente mais proximo.
	 * @param dataInicial - data criação da demanda.
	 * @return	data com o horario do indio do espediente mais proximo.
	 * @throws ParseException
	 */
	private static Calendar verificaHora(Calendar dataInicial) throws ParseException {
		if (DateServices.between(dataInicial.getTime(), Horarios.HORA_INICIAL.getHorario(),
				Horarios.HOR_ENTRADA.getHorario())) {

			dataInicial.setTime(DateServices.setHora(dataInicial, Horarios.HOR_ENTRADA.getHorarioString()));

		} else if (DateServices.between(dataInicial.getTime(), Horarios.HOR_INI_INTER.getHorario(),
				Horarios.HOR_FIM_INTER.getHorario())) {

			dataInicial.setTime(DateServices.setHora(dataInicial, Horarios.HOR_FIM_INTER.getHorarioString()));

		} else if (DateServices.between(dataInicial.getTime(), Horarios.HOR_SAIDA.getHorario(),
				Horarios.HORA_FINAL.getHorario())) {
			dataInicial.add(Calendar.DATE, +1);
			dataInicial.setTime(DateServices.setHora(dataInicial, Horarios.HOR_ENTRADA.getHorarioString()));

		}

		return dataInicial;
	}

}
