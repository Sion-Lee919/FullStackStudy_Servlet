package forword;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/forward2")
public class ForwardServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Arraylist 출력
		//처리
		ArrayList<MemberDTO>list= (ArrayList<MemberDTO>)request.getAttribute("list");
		
		//응답
		String result = "<table style='border:2px solid blue'>";
		for(MemberDTO dto : list) {
			result += "<tr>";
			result +="<td style='border:2px solid pink'>"+ dto.getId() +"</td>";
			result +="<td style='border:2px solid pink'>"+ dto.getName() +"</td>";
			result +="<td style='border:2px solid pink'>"+ dto.getPhone() +"</td>";
			result +="<td style='border:2px solid pink'>"+ dto.getEmail() +"</td>";
			result +="<td style='border:2px solid pink'>"+ dto.getRegdate() +"</td>";
			result += "</tr>";
		}
		result += "</table>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =  response.getWriter();
		out.println(result);
		String id = request.getParameter("id");
		/*String upperid = (String)request.getAttribute("upperid");
		out.println("<h3>"+request.getRequestURI()+"</h3>");
		out.println("<h3>"+id+" : "+upperid+"</h3>");*/
	}

}
