package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginsession")//
public class LoginSessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//아이디, 암호 일치하는걸 만났다 (로그인 생략)
		//id =sessiontest ,pw =1234 일치조건 가정
		HttpSession session = request.getSession();
		if(id != null && pw != null) {
			if(id.equalsIgnoreCase("sessiontest") && pw.equals("1234")){
				session.setAttribute("sessionid", id);
			}
		}
		String result = "";
		if(session.getAttribute("sessionid") != null ) {//내정보 보기 로그아웃하러가기
			result+="<h3>사용가능한 메뉴는 다음과 같습니다.</h3>";
			result+="<h3><a href='mypagesession'>내정보 조회하기.</a></h3>";
			result+="<h3><a href='logoutsession'>로그아웃하러 가기.</a></h3>";
		}
		else {
			result+="<h3>로그인한적이 없습니다</h3>";
		}
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}

}
