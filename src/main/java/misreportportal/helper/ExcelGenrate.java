package misreportportal.helper;
import java.io.FileOutputStream;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class ExcelGenrate {

	public static void createExcel() {

		Workbook wb = new HSSFWorkbook();

		Sheet sh = wb.createSheet("Consolidate");
		try {
			FileOutputStream file = new FileOutputStream("/home/vas/Desktop/safaricom" + new Date().getTime() + ".xls");

			Row row = sh.createRow(0);
			Row row1 = sh.createRow(1);
			row.createCell(0).setCellValue("EtisalatGameIT Dubai (1111)");
			
			row1.createCell(0).setCellValue("  Date ");
			row1.createCell(1).setCellValue("  New Subscription Count ");
			row1.createCell(2).setCellValue("  Renewal Count ");
			row1.createCell(3).setCellValue("  New Subscription Revenue  ");
			row1.createCell(4).setCellValue("  Renewal Revenue  ");
			row1.createCell(5).setCellValue("  Total Revenue(IN AED) ");
			row1.createCell(6).setCellValue("  Total Revenue(IN USD) ");
			row1.createCell(7).setCellValue("  Total Revenue(IN INR) ");
			row1.createCell(8).setCellValue("  Revenue Share (IN AED) ");
			row1.createCell(9).setCellValue("  Churn ");
	      // sh.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

			wb.write(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		createExcel();

	}

}
