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
		else {
			//이미 로그아웃 1번 했거나 브라우저 열고 아직 로그인안했거나
			result+="<h3>이미 로그아웃 1번 했거나 브라우저 열고 아직 로그인한 적이 없습니다</h3>  ";
		}
		//session.removeAttribute("sessionid");//'sessionid'로그아웃
		session.invalidate();//세션 무효화. 모든 속성 다 삭제
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}

}
