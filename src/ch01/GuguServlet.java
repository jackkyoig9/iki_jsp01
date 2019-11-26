package ch01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// uri pattern
@WebServlet("/ch01/gugu.do")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get방식 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan = Integer.parseInt(request.getParameter("dan"));
		String result = "";
		for (int i = 0; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i+"<br>";
		}
		System.out.println(result);
		// request 객체에 저
		request.setAttribute("result", result);
		// 출력 페이지 저장
		String page = "/ch01/gugu_result2.jsp";
		// 출력 페이지의 정보 분석 객체
		RequestDispatcher rd = request.getRequestDispatcher(page);
		// 화면 전환 + 데이터 전달
		rd.forward(request, response);
	}

	// post방식 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
