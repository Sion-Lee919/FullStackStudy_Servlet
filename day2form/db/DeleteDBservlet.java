package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/deletedb")
public class DeleteDBservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginid = request.getParameter("loginid");
		int loginpw = Integer.parseInt(request.getParameter("loginpw"));
		
		MemberDAO dao = new MemberDAO();
		String result= dao.DeleteMenber(loginid, loginpw);
		//응답
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		out.print("<h3>"+result+"</h3>");
		
		
		

	}

}
