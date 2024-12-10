package forward;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/forward1")
public class ForwardServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터 입력
		String id = request.getParameter("id");
		String upperid = id.toUpperCase();
		
		//처리
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO>list= dao.getMembers(1, 3);
		
		//list를 forward2에게 전달
		request.setAttribute("list", list);
		//upperid forward2에게 전달
		request.setAttribute("upperid", upperid); //rd.forward(request, response); 전에 해야지 전달됨 후에하면 다 무시
		
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response);
		//rd.include(request, response);
		
		
		//응답-forward 인해 무시 //include하면 포함
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o =  response.getWriter();
		o.println("<h3>"+request.getRequestURI()+"</h3>");
		o.println("<h3>"+id+" : "+upperid+"</h3>");

	}

}
