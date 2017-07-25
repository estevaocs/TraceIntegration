package br.com.itsstecnologia.util;

import jxl.*;

public class VerificaPlanilha {
	
	public static boolean verifica(Sheet planilha) {
		if(planilha.getRow(2).length == 24 && planilha.getCell("A1").getContents().contains("Demandas")){
			return true;
		}
		return false;
		
	}
}
