package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/cookieremove")
public class CookieRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//특정 쿠키 1개삭제
		/*Cookie cookie = new Cookie("name", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		String result = "<h3>쿠키가 삭제되었습니다.</h3>";
		result +="<a href=cookieget> 쿠기삭제확인</a>";
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);*/
		
		
		//모든 쿠키 삭제
		Cookie[] cookies=request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
		String result = "<h3>모든 쿠키가 삭제되었습니다.</h3>";
		result +="<a href=cookieget> 쿠기삭제확인</a>";
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}

}
