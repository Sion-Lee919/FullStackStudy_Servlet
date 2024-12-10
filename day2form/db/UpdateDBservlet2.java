package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/updatedb2")
public class UpdateDBservlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberDTO dto = new MemberDTO(id,name,phone,email);
		MemberDAO dao = new MemberDAO();
		String result = dao.UpdateMenber(dto);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h3>"+result+"</h3>");
	}

}
