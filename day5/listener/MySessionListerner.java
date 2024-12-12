package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListerner implements HttpSessionListener, HttpSessionAttributeListener {

    public MySessionListerner() {
    	System.out.println("(sessionlistener 새로 생성)");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	// HttpSession객체.serAttribute("id","value") 호출시점 자동 실행
    	System.out.println("(session에 속성이 새로 추가)");
    	System.out.println("(session에 추가된 속성="+se.getName()+" : "+se.getValue()+")");

    }
   
    public void sessionCreated(HttpSessionEvent se)  { 
    	// 세션 최초 생성 - 브라우저 최초 open 자동실행
    	System.out.println("(session 새로 생성)");
    	System.out.println("(sessionid="+se.getSession().getId()+")");
    }
    /*
    public void attributeReplaced(HttpSessionBindingEvent se)  { 

    }
    
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	// TODO Auto-generated method stub
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }*/

	
}
