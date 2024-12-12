package listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener, ServletContextAttributeListener {

    public MyContextListener() {//생성자
        System.out.println("[context listener 객체 생성]");
    }
    
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	// ServletContext객체.serAttribute("id","value") 최초 호출시점 자동 실행
    	System.out.println("[context 속성 추가]");
    	System.out.println("["+scae.getName()+"]");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // ServletContext객체.serAttribute("id","value")속성이 있는데 값이 바뀌면 실행
    	System.out.println("[context 속성값 수정]");
    	System.out.println("["+scae.getName()+"]");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	// ServletContext객체.removeAttribute("id","value")호출시점 자동 실행
    	System.out.println("["+scae.getName()+"]");
    	System.out.println("[context 속성 삭제]");
    	
    }

    /*
    public void contextInitialized(ServletContextEvent sce)  { 
         // tomcat 서버시작 - (spring mvc 설정 초기화 구현부분) 자동실행
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	// tomcat 서버 중단 - 삭제 정리 구현부분 자동실행
    }
	*/
	
}
