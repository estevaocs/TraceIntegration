package br.com.itsstecnologia.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public enum DateFormat {
	
	DATA_TIME("dd/MM/yy HH:mm"), HORA("HH:mm"), DATA("dd/MM/yy");
	
	public SimpleDateFormat format;
	DateFormat(String sdf){
		format = new SimpleDateFormat(sdf);
	}
	
	public SimpleDateFormat getFormat() throws ParseException{
		return format;
	}
	
}
