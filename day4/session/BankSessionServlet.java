package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/banksession")
public class BankSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionid") != null) {
			//자동 로그아웃
			session.setMaxInactiveInterval(60*3);
			o.println("<h3>"+session.getAttribute("sessionid")+"고객님 인증되셨습니다</h3>");
			o.println("<h3>인증시간은 3분입니다.</h3>");

		}
		else {
			o.println("<h3>고객님 아직 미인증상태입니다.</h3>");
		}
	}

}
