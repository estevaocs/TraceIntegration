package br.com.itsstecnologia.util;

import java.io.IOException;
import java.text.ParseException;

import br.com.itsstecnologia.builder.DemandaBuilder;
import br.com.itsstecnologia.model.Demanda;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class ExcelRead {
	
	public Demanda create(Sheet sheet, int linha) throws IOException, BiffException {
		Demanda demanda = null;
		try {

				Cell idCell = sheet.getCell("B" + linha);
				Cell empresaCell = sheet.getCell("F" + linha);
				Cell estadoCell = sheet.getCell("G" + linha);
				Cell destinoCell = sheet.getCell("H" + linha);
				Cell prioridadeCell = sheet.getCell("I" + linha);
				Cell responsavelAtendimentoCell = sheet.getCell("S" + linha);
				Cell dataHoraCriacaoCell = sheet.getCell("U" + linha);
				
				
				demanda = new DemandaBuilder().instId(idCell.getContents())
						.instEmpresa(empresaCell.getContents())
						.instEstado(estadoCell.getContents())
						.instDestino(destinoCell.getContents())
						.instPrioridade(prioridadeCell.getContents())
						.instRespAtend(responsavelAtendimentoCell.getContents())
						.instData(dataHoraCriacaoCell.getContents()).builder();

				
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return demanda; 
	}

	
	
}
