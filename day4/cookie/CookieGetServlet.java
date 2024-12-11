package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieget")
public class CookieGetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "<h3>클라이언트로부터 얻어온 쿠키</h3>";
		//1. 쿠키 객체를 가져온다
		Cookie[] cookies= request.getCookies();
		//2. 쿠키 정보를 출력한다
		if(cookies!=null) {
		for (int i = 0; i < cookies.length; i++) {
			result+= cookies[i].getName()+" : "+ cookies[i].getValue()+"<br>";
		}
		}
		else {
			result+="<h3>저장된 쿠키 없음</h3>";
		}
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}

}
