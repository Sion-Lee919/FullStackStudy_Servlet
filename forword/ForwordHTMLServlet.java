package forword;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forwordhtml")
public class ForwordHTMLServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//멤버리스트 출력 조건 id=admin 이어야한다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o= response.getWriter();
		o.println("로그인 화면으로 이동합니다.");
		//'o' 객체 출력내용 작성하면 -브라우저 즉각 전송 출력 아니다
		//'o' 객체 출력내용 작성하면 -서버내부 임시기억공간 임시적 저장 후 버리고 이동
		
		
		//로그인화면 이동
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Loginform_DB.html"); 
		rd.forward(request, response);
	}

}
