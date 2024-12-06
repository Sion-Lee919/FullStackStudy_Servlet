package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	//http프로토콜이 정한 규칙에 맞는 방법으로 요청-처리-응답
	//httpServletReqest 클래스
	//HttpServletResponse 클래스
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//10 20 + 클라이언트 요청정보에 포함. 추출
		//http://ip:port/servlettest/calc?su1=20&su2=10&op=%2B
		// ?부터는 입력값이 들어감
		//검증
		int su1=0;
		if(request.getParameter("su1")!=null && !request.getParameter("su1").equals("")) {//변수도 없고 입력되지 않은 파라미터 처리
		su1 = Integer.parseInt( request.getParameter("su1"));
		}
		
		int su2 = Integer.parseInt(request.getParameter("su2"));
		String op = request.getParameter("op");
		//url 뒤 '+' 기호 --> 공백으로 인식 (' ')
		//10 + 20 자바문장 구현
		int result = 0;
		if(op.equals("+")) {result = su1  +  su2;} //%2B -> + //url에서 +는 공백
		else if(op.equals("-")) {result = su1  -  su2;}
		else if(op.equals("*")) {result = su1  *  su2;}
		else if(op.equals("/") &&su2 !=0) {result = su1  /  su2;}
		else {
			result =-1;
		}
		System.out.println(result);
		
		//연산자가 여러개 입력 들어왔을때
		//String multipleop = request.getParameter("multipleop");//여러개 선택시 1개밖에 안읽어옴
		String []multipleop = request.getParameterValues("multipleop");//배열로 여러개를 가져옴
		
		
		//결과를 클라이언트 브라우저 전송(http 응답한다(HttpServletResponse)). 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o =  response.getWriter();
		o.print("<h3>"+result+"</h3>");
		o.print("<h3>"+Arrays.toString(multipleop)+"</h3>");
	}

}
