package cart;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/cartsave")
public class CartSaveServlet extends HttpServlet {
	HashMap<String,Integer> map; //밖에다 선언
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map= new HashMap<>(); //지역변수로 선언되면 doGet에서 못쓰기 때문에 밖에다가 선언
		map.put("상품1", 3000);	
		map.put("상품2", 10000);	
		map.put("상품3", 7000);	
		map.put("상품4", 14000);	
		map.put("상품5", 50000);	
		map.put("상품6", 35000);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int num=0;
		String output=null;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		if(request.getParameter("num") != null && !request.getParameter("num").equals("")) {
			num = Integer.parseInt(request.getParameter("num"));//값이 없으면 null인데 인티저파스인트로 변환못하기 떄문에 오류되어서 if로 체크 필수
		}
		

		if(!map.containsKey(name)) {
			output ="<h3>장바구니에 저장할 수 있는 제품이 아닙니다.</h3>";
		}
		else {
			int price =  map.get(name);
			int totalprice = price*num;
			CartDTO dto = new CartDTO(id,name,num,totalprice);
			ArrayList<CartDTO> cartList = new ArrayList();
			cartList.add(dto);
			
			HttpSession session = request.getSession();//세션 생성
			//세션에 이미 장바구니가 있는지 없는지
			if(session.getAttribute("sessioncart") !=null) {
				cartList = (ArrayList<CartDTO>)session.getAttribute("sessioncart");//가져온 리스트에
				cartList.add(dto);//하나더추가
				session.setAttribute("sessioncart",cartList);//저장
			}
			else {
				cartList.add(dto);//최초장바구니 추가
				session.setAttribute("sessioncart",cartList);//저장완료
			}
			output ="<h3>장바구니에 저장되었습니다.</h3>";
		}
		out.println(output);
		

		

		
	}

}
