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

@WebServlet("/cartread")
public class CartGetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//ArrayList<CartDTO> cartlist = null;
		ArrayList<CartDTO> cartlist = new ArrayList();
		//장바구니에 아무것도없으면 오류 if문으로 처리
		if(session.getAttribute("sessioncart") != null) {
			cartlist = (ArrayList<CartDTO>)session.getAttribute("sessioncart");
		}
			//응답
			String result = "<style> td {border:2px solid pink}  </style>";
			result += "<table style='border:2px solid blue'>";
			
			for(CartDTO dto : cartlist) {
				result += "<tr>";
				result +="<td style='border:2px solid pink'>" + dto.getId() + "</td>";
				result +="<td>" + dto.getProductname() + "</td>";
				result +="<td>" + dto.getAmount() + "</td>";
				result +="<td>" + dto.getTotalprice() + "</td>";
				result += "</tr>";
			}
			
			result += "</table>";
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println(result);
	}

}
