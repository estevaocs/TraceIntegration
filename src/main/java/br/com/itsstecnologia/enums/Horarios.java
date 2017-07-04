package br.com.itsstecnologia.enums;

import java.text.ParseException;
import java.util.Date;

public enum Horarios {
	HOR_ENTRADA("08:00"), HOR_INI_INTER("12:00"), HOR_FIM_INTER("13:30"), HOR_SAIDA("18:00"), HORA_INICIAL("00:00"), HORA_FINAL("23:59");
	
	
	private String horario;
	Horarios(String hora){
		horario = hora;
	}
	
	public Date getHorario() throws ParseException{
		return DateFormat.HORA.format.parse(horario);
	}
	
	public String getHorarioString() throws ParseException{
		return horario;
	}
}
