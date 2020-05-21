package com.koreait.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.calculator.Calc;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Calc c = new Calc();
		
		String opers = "+-*/";
		String input = request.getParameter("input");
		String[] temp = null;
		boolean check = false;
		
//		out.println("<html><body><h1>서블릿으로 만든 페이지</h1>");
		out.print("<html><body><p>결과 : ");
		for(int i = 0; i < opers.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == opers.charAt(i)) {
					check = true;
					try {
						temp = input.split("\\"+opers.charAt(i));
						
						switch(i) {
						case 0:
							out.println(c.add(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
							break;
						case 1:
							out.println(c.sub(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
							break;
						case 2:
							out.println(c.mul(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
							break;
						case 3:
							try {
								out.println(c.div(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
							} catch (ArithmeticException e) {
								out.println("0으로 나눌 수 없습니다.");
							}
							break;
						}
					} catch (Exception e) {
						out.print("정수만 입력해주세요");
					}
					break;
				}
			}
		}
		if(!check) {
			out.println("연산자를 찾지 못했습니다.");
		}
		
//		out.println("<a href=\"index.jsp\">JSP로 만든 페이지</a>");
		out.println("</p><a href=\"index.jsp\">다시 계산하기</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
