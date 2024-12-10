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

@WebServlet("/insertdb")
public class InsertDBservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		String name =  request.getParameter("name");
		String num =  request.getParameter("num");
		String email =  request.getParameter("email");
		
		//MemberDTO dto = new MemberDTO(id, name, pw, num, email); //생성자를 만들면 이것도 가능
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setPw(pw);
		dto.setPhone(num);
		dto.setEmail(email);
		
	    MemberDAO dao = new MemberDAO();
	    String result = dao.insertMenber(dto);
	    System.out.println(result);
	    
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out= response.getWriter();
	}

}
