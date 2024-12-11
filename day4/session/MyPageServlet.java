package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

class MypageDTO{
	String id, pw, name, phone, email;

	public MypageDTO() {}

	@Override
	public String toString() {
		return "<h3>아이디 = " +id + ", name = "+name+" , phone = "+phone+" , 이메일 = "+email+"</h3>";
	}

	public MypageDTO(String id, String pw, String name, String phone, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	
}

@WebServlet("/mypagesession")
public class MyPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MypageDTO dto = new MypageDTO((String)session.getAttribute("sessionid"),"1234","김창서","010-2222-3333","kin@c.com");
		
		String result="";
		if(session.getAttribute("sessionid") != null) {
			result+= dto.toString();
		}
		else {
			result+="<h3><a href=loginsession?id=sessiontest&pw=1234>로그인</a> 하지않으면 회원정보를 보여줄 수 없습니다";
		}
		response.setContentType("text/html;chatset=utf-8");
		PrintWriter o = response.getWriter();
		o.println(result);
	}


}
