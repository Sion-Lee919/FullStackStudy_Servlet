package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/membermenu")
public class Membermenu extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String membermenu = context.getInitParameter("membermenu");
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		
		/*String a = membermenu;
		String[] url = {"/servlettest/insertform_DB.html",
				"/servlettest/Loginform_DB.html"
				,"/servlettest/updateform_DB.html"
				,"/servlettest/deleteform_DB.html"
				,"/servlettest/memberlist?page=3"
				,"/servlettest/searchform_DB.html"};
		String[] menu = a.split(" ");
		String sum = "<ul>";
		for (int i = 0; i < menu.length; i++) {
			sum+="<li><a href='"+url[i]+"'>"+menu[i]+"</a></li>";
		}
		sum+="</ul>";
		o.println(sum);*/
		
		//개선
		 Map<String, String> menuMap = new HashMap<>();
	        menuMap.put("회원가입", "/servlettest/insertform_DB.html");
	        menuMap.put("로그인", "/servlettest/Loginform_DB.html");
	        menuMap.put("내정보조회및수정", "/servlettest/updateform_DB.html");
	        menuMap.put("회원탈퇴", "/servlettest/deleteform_DB.html");
	        menuMap.put("페이징조회", "/servlettest/memberlist?page=3");
	        menuMap.put("검색조회", "/servlettest/searchform_DB.html");

	        String[] menuItems = membermenu.split(" ");
	        StringBuilder sum = new StringBuilder("<ul>");

	        for (String menu : menuItems) {
	            String url = menuMap.get(menu);
	            if (url != null) { // URL이 존재할 때만 추가
	                sum.append("<li><a href='").append(url).append("'>").append(menu).append("</a></li>");
	            }
	        }
	        sum.append("</ul>");
	        o.println(sum.toString());
	        
	        //visitservlet1 include 방문자 수 추가
	        o.println("<hr>");
	        RequestDispatcher rd= request.getRequestDispatcher("visit1");
	        rd.include(request, response);
	    }
}

