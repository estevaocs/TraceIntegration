package br.com.itsstecnologia.util;

import java.io.IOException;
import java.text.ParseException;

import br.com.itsstecnologia.builder.DemandaBuilder;
import br.com.itsstecnologia.model.Demanda;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class ExcelRead {

	public Demanda create(Sheet sheet, int linha) throws IOException, BiffException, ParseException {
		Demanda demanda = null;

		Cell idCell = sheet.getCell("B" + linha);
		Cell empresaCell = sheet.getCell("F" + linha);
		Cell estadoCell = sheet.getCell("G" + linha);
		Cell destinoCell = sheet.getCell("H" + linha);
		Cell prioridadeCell = sheet.getCell("I" + linha);
		Cell responsavelAtendimentoCell = sheet.getCell("S" + linha);
		Cell dataHoraCriacaoCell = sheet.getCell("U" + linha);

		if (idCell.getContents().isEmpty() || idCell.getContents() != null
				|| dataHoraCriacaoCell.getContents().isEmpty() || dataHoraCriacaoCell.getContents() != null) {
			throw new RuntimeException("Planilha sem o id da tupla " + linha );
		}

		demanda = new DemandaBuilder().instId(idCell.getContents()).instEmpresa(empresaCell.getContents())
				.instEstado(estadoCell.getContents()).instDestino(destinoCell.getContents())
				.instPrioridade(prioridadeCell.getContents()).instRespAtend(responsavelAtendimentoCell.getContents())
				.instData(dataHoraCriacaoCell.getContents()).builder();

		return demanda;
	}

}
