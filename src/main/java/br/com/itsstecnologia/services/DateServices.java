package br.com.itsstecnologia.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import br.com.itsstecnologia.enums.DateFormat;


public class DateServices {
	/**
	 * Método que modifica a hora de uma determinada data.
	 * 
	 * @param data
	 *            - data a qual deseja modificar(set) a hora.
	 * @param hora
	 *            - o novo horario que se deseja colocar. Formato da String
	 *            "HH:mm"
	 * @return a data com o horario modificado.
	 * @throws ParseException
	 */
	public static Date setHora(Calendar data, String hora) throws ParseException {
		String dt = DateFormat.DATA.getFormat().format(data.getTime());
		String form = dt + " " + hora;
		Date date = DateFormat.DATA_TIME.getFormat().parse(form);
		return date;
	}

	/**
	 * Verica se uma data está entre duas datas distintas;
	 * 
	 * @param ref
	 *            - o dia referente à questão
	 * @param init
	 *            - dia do inicio da faixa de verificação.
	 * @param end
	 *            - dia do fim da faixa de verificação
	 * 
	 * @return booleano: true - caso a data procurada se encontra dentro da
	 *         faixa especificada. false - caso a data não esteja dentro da
	 *         faixa especificada.
	 * 
	 * @throws ParseException.
	 */
	public static boolean between(Date ref, Date init, Date end) throws ParseException {

		Date data = DateFormat.HORA.getFormat().parse(
				DateFormat.HORA.getFormat().format(ref));
		boolean bool = (data.after(init) && data.before(end));
		return bool;
	}

}
