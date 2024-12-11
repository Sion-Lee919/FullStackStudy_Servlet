package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/*")
public class MYFilter /*extends HttpFilter*/ implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	//HttpServletRequest request
	//class HttpServletRequest extends ServletRequest //둘의 관계
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청시점 서블릿마다 공통처리 내용 구현
		//서블릿이름, 클라이언트 ip, 시간
		String servletname = ((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr();
		String now = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date());
		
		System.out.println("서블릿명="+servletname+" , ip="+clientip+" , 요청시각="+now);
		long start = System.currentTimeMillis();
		//MyFilter 이외에 다른 Filter가 있으면 메소드 이동
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"밀리세컨드");
		
		response.setContentType("text/html;charset=utf-8");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
