package cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cartremove")
public class CartRemoveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<CartDTO> cartlist = new ArrayList();
		//장바구니에 아무것도없으면 오류 if문으로 처리
		int payprice =0;
		String result="";
		if(session.getAttribute("sessioncart") != null) {
			cartlist = (ArrayList<CartDTO>)session.getAttribute("sessioncart");
			for(CartDTO dto : cartlist) {
				payprice+= dto.getTotalprice();
			}
			result = "<h3> 결제하신 금색은"+payprice + " 원입니다.</h3>";
			session.invalidate();//세션지우기
		}
		else {
			result = "<h3>이미 결제 완료하셨습니다. 또는 장바구니에 저장된 상품이 없습니다.</h3>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		out.println(result);
			
	}

}
