package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int pw = Integer.parseInt( request.getParameter("pw"));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter a = response.getWriter();
		HashMap<String, Integer> box = new HashMap();
		box.put("java",1111);
		box.put("html",2222);
		box.put("spring",3333);
		box.put("servlet",4444);
		box.put("jsp",5555);
		
		if(box.containsKey(id) && box.containsValue(pw)) {
			a.print(id+"회원님 로그인 성공했습니다");
		}
		else if(box.containsKey(id) && !box.containsValue(pw)) {
			a.print(id+"회원님 로그인 실패했습니다.<br>");
			a.print("<a href= 'http://localhost:8060/servlettest/Loginform.html'>로그인페이지로 되돌아가기</a>");
		}
		else {
			a.print(id+"회원님의 아이디가 없습니다 회원가입 하시겠습니까?.<br>");
		}
	}

}
