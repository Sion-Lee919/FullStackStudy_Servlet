package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		int cntOfPage=3;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list= dao.getMembers(page, cntOfPage);
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
		response.getWriter().println(result);
	}

}
