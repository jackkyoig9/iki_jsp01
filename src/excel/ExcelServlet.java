package excel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

@WebServlet("/excel/excel01.do")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("ExcelServlet>> ");
		
		response.reset();
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = "test.xls";

		response.setHeader("Centent-Disposition", dispositionPrefix + encodedFilename);

		HSSFWorkbook wb = new HSSFWorkbook(); 
		HSSFSheet sheet = wb.createSheet("가");
		HSSFCellStyle cStyle = wb.createCellStyle();
//		HSSFDataFormat = wb.createDataFormat();
		HSSFRow row = null;
		HSSFCell cell = null;

//		// 엑셀 스타일 설정
//		cStyle,setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 엑셀 행 , 1
		row = sheet.createRow(0);
		// 셀 병합
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 4));
		// 엑셀의 열, B
		cell = row.createCell(1);
		// 엑셀의 스타일
		cell.setCellStyle(cStyle);
		// 엑셀에 들어가는 값
		cell.setCellValue("a");
		

		ServletOutputStream os = response.getOutputStream();
//
		System.out.println("ExcelServlet>> " + os);
		
		wb.write(os);
		os.flush();
		os.close();
		
		return;
		
//		request.setAttribute("result", wb);
//		
//		String page = "/excel/excel01.jsp";
//		// 출력 페이지의 정보 분석 객체
//		RequestDispatcher rd = request.getRequestDispatcher(page);
//		// 화면 전환 + 데이터 전달
//		rd.forward(request, response);
		
		//return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
