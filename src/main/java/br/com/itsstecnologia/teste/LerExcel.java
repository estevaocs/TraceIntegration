package br.com.itsstecnologia.teste;

import java.io.File;

import br.com.itsstecnologia.util.ExcelRead;
import br.com.itsstecnologia.util.VerificaPlanilha;
import jxl.Sheet;
import jxl.Workbook;

public class LerExcel {

	public static final String EXCEL_FILE_LOCATION = "C:\\Users\\admin\\Downloads\\Demandas.xls";
	public static final File file = new File(EXCEL_FILE_LOCATION);
	public static Workbook workbook = null;

	public static void main(String[] args) {

		try {

			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			if (VerificaPlanilha.verifica(sheet)) {
				ExcelRead excelRead = new ExcelRead();
				int j = sheet.getColumn(1).length;
				for (int i = 3; i <= j; i++) {
					excelRead.create(sheet, i);
					System.out.println("Persistindo");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (workbook != null) {
				workbook.close();
			}
		}
	}

}