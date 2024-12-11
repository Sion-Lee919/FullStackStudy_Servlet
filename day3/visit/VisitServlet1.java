package visit;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visit1")
public class VisitServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1>방문자 저장 변수
		//2>ServletContext.getAttribute(방문자수)읽어온다
		//3>ServletContext.setAttribute() 저장
		//2-2>있다면 2번결과 +1 출력

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
