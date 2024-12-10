package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/updatedb1")
public class UpdateDBservlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginid = request.getParameter("loginid");
		int loginpw = Integer.parseInt(request.getParameter("loginpw"));
		//내정보 조회항목출력
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(loginid, loginpw);
		//응답
		String result = "";
		if(dto !=null) {
			if(dto.getPw()==loginpw) {
				result = "<h3 style=color:green>" + loginid + " 회원님의 정보를 보여드립니다.</h3>";
				result+="<form action='updatedb2'>";
				result+="아이디<input type='text' name='id' value='"+dto.getId()+"'readonly>";
				result+="이름<input type='text' name='name' value='"+dto.getName()+"'>";
				result+="폰<input type='text' name='phone' value='"+dto.getPhone()+"'>";
				result+="이메일<input type='text' name='email' value='"+dto.getEmail()+"'>";
				result+="<input type='submit' value='내정보수정'>";
				result+="</form>";
			}
			else {
				result = "<h3 style=color:blue>" + loginid + " 회원님 로그인 실패</h3>";
				result +="<a href='Loginform_DB.html'> 로그인페이지로 이동 </a>";
			}
		}
		else {
			result = "<h3 style=color:red>" + loginid + " 손님 회원가입부터 하세요.</h3>";
			result +="<a href='insertform_DB.html'> 회원가입페이지로 이동 </a>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		out.print(result);
		
		
		

	}

}
