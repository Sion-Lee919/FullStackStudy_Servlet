package visit;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visit2")
public class VisitServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count =0;
		ServletContext context = request.getServletContext();
		if(context.getAttribute("count")!=null) {
			count = (Integer)context.getAttribute("count");//이전까지의 누적방문자 수
		}
		context.setAttribute("count", ++count);//이전까지의 누적방문자 수+1 컨텍스트에 저장
		
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(count+"번째 방문자이십니다.");
	}
}
