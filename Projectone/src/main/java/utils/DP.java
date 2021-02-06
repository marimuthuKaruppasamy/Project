package utils;
	
	

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.DataProvider;


	public class DP {
		
		@DataProvider(name="fetchData")
		public static String[][] getdata() throws IOException{
			
			String[][] testData ;
			
		/*	int rc = 2;
			int cc = 4;
			System.out.println(rc);
			System.out.println(cc);
			String[][] testData1 = new String[rc][cc];
			testData1[0][0]="priya";
			testData1[0][1]="Challa";
			testData1[0][2]="Ram";
			testData1[0][3]="Prakesh";
			
			testData1[1][0]="Mahesh";
			testData1[1][1]="babu";
			testData1[1][2]="Sivaji";
			testData1[1][3]="More";
			*/
			
			FileInputStream fis=new FileInputStream("./testData/Book3.xlsx");
//			It is find the path of the excel the taking data
			System.out.println(fis);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			//It will read only the entire workbook
			System.out.println(wb);
			XSSFSheet sheet=wb.getSheetAt(0);
			
			System.out.println(sheet);
			
					
			int rowCount=sheet.getLastRowNum();
			int columnCount=sheet.getRow(0).getLastCellNum();
			System.out.println(rowCount);
			System.out.println(columnCount);
			testData=new String[rowCount][columnCount];
			
			for (int i=1;i<=rowCount;i++){
				
				XSSFRow row=sheet.getRow(i);
				
				System.out.println(row);
				for (int j=0;j<columnCount;j++){
					String cellData=row.getCell(j).getStringCellValue();
					System.out.println("the value of row:"+i+"and column"+j+"is:"+cellData);
					testData[i-1][j]=cellData;
				}
				
				
			}
			
			
			return testData;
			
			
		}


	}



