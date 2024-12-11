package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logoutsession")
public class LogoutSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MypageDTO dto = new MypageDTO((String)session.getAttribute("sessionid"),"1234","김창서","010-2222-3333","kin@c.com");
		
		String result="";
		if(session.getAttribute("sessionid") != null) {
			result+="<h3>"+session.getAttribute("sessionid")+"회원님 로그아웃하셨습니다. 다시 로그인하셔야 정상 사용 가능합니다</h3>";
		}
		session.removeAttribute("sessionid");//로그아웃
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}

}
