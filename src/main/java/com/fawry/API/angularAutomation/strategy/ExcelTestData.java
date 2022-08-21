package com.fawry.API.angularAutomation.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.constants.excelIndices.ExcelInices;
import com.fawry.API.angularAutomation.utils.PropertiesFilesHandler;
import org.apache.poi.ss.usermodel.Row;
import com.fawry.API.angularAutomation.utils.ExcelHandler;


public class ExcelTestData implements TestDataStrategy{

	public ArrayList<ArrayList<Object>> loadTestData(String filePathAndSheetNo)
	{
		ArrayList<ArrayList<Object>> results = new ArrayList<ArrayList<Object>>();
		try {

			String filePath = filePathAndSheetNo.split(";")[0];
			String sheetNo = filePathAndSheetNo.split(";")[1];

			Iterator<Row> rows = ExcelHandler.loadExcelSheetRows(filePath, Integer.parseInt(sheetNo));

			//get get header columns number
			short headerColumnsNum = rows.next().getLastCellNum();

			// get smoke test scope flag config from properties file
			PropertiesFilesHandler propLoader = new PropertiesFilesHandler();
			Properties prop = propLoader.loadPropertiesFile(GeneralConstants.GENERAL_CONFIG_FILE_NAME);
			String isSmockTestScopeEnabled = prop.getProperty(GeneralConstants.SMOKE_TEST_FLAG);

			while (rows.hasNext()) {
				Row row = rows.next();
				ArrayList<Object> cellsObjects = new ArrayList<Object>();
				ArrayList<String> rowCells = ExcelHandler.getExcelRowCells(row, headerColumnsNum);

				for (int i = 0; i < rowCells.size(); i++) {
					Object cell = new Object();
					cell = rowCells.get(i);
					cellsObjects.add(cell);
				}
				// if smoke test scope is enabled, load rows that are marked as smoke only
				if (isSmockTestScopeEnabled.equalsIgnoreCase(GeneralConstants.TRUE)) {
					if (cellsObjects.get(ExcelInices.TEST_SCOPE_INDEX).toString().equalsIgnoreCase(GeneralConstants.TEST_SCOPE_SMOKE))
						results.add(cellsObjects);
				} else
					results.add(cellsObjects);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return results;

	}





}
