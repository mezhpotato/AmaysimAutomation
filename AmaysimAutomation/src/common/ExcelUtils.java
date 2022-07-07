package common;

public class ExcelUtils {

//	Private XSSFSheet excelWSheet;
//
//	private XSSFWorkbook excelWBook;
//
//	private XSSFCell cell;
//
//	//private static XSSFRow Row;
//	
//	public Boolean switchToSheet(String sheetName) {
//		if (excelWBook != null) {
//			excelWSheet = excelWBook.getSheet(sheetName);
//			return true;
//		}
//		return false;
//	}
//
//	public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
//
//		String[][] tabArray = null;
//
//		try {
//
//			
//			// Access the required test data sheet
//			if (excelWBook == null) {
//				FileInputStream ExcelFile = new FileInputStream(FilePath);
//				excelWBook = new XSSFWorkbook(ExcelFile);
//				if (excelWBook == null) {
//					System.out.println("Unable to load the data file specified! Filename: " + FilePath);
//				}
//			}
//			excelWSheet = excelWBook.getSheet(SheetName);
//
//			int startRow = 1;
//			int startCol = 0;
//			int ci, cj;
//			int totalRows = excelWSheet.getLastRowNum();
//			// you can write a function as well to get Column count
//			//int totalCols = 2;
//			int totalCols = excelWSheet.getRow(0).getPhysicalNumberOfCells();
//			//System.out.println("Number of Excel Columns: " + totalCols);
//			tabArray = new String[totalRows][totalCols];
//			ci = 0;
//			for (int i = startRow; i <= totalRows; i++, ci++) {
//				cj = 0;
//				for (int j = startCol; j < totalCols; j++, cj++) {
//					tabArray[ci][cj] = getCellData(i, j);
//					//System.out.println(tabArray[ci][cj]);
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.err.println("Could not read the Excel sheet");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.err.println("Could not read the Excel sheet");
//			e.printStackTrace();
//		}
//		return (tabArray);
//
//	}
//
//	public XSSFWorkbook getExcelWorkBook() {
//		return excelWBook;
//	}
//	
//	public XSSFSheet getExcelWorksheet() {
//		return excelWSheet;
//	}
//	public String getCellData(int RowNum, int ColNum) throws Exception {
//
//		try {
//			DataFormatter formatter = new DataFormatter();
//			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
//			if (cell == null) {
//				//System.out.println("Cell has a null value: row: " + RowNum + " col: + ColNum");
//				return "";
//			}
//			int dataType = cell.getCellType();
//			if (dataType == 3) {
//				return "";
//			} else {
//				//String CellData = cell.getStringCellValue();
//				String cellData = formatter.formatCellValue(cell);
//				return cellData;
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			throw (e);
//		}
//
//	}
//	
//	public void reset() {
//		try {
//			excelWBook.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		excelWBook = null;
//		excelWSheet = null;
//		
//	}
//	
//	public void writeReport(String targetFile) {
//		try {
//			FileOutputStream out = new FileOutputStream(new File(targetFile));
//			excelWBook.write(out);
//			out.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
}
