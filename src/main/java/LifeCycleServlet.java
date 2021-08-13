import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init() 메서드 호출");
		
		ServletContext context = getServletContext();
		//	컨텍스트 파라미터 받아오기
		String dbuser = context.getInitParameter("dbuser");
		String dbpass = context.getInitParameter("dbpass");
		
		System.out.println("컨텍스트 파라미터 dbuser:" + dbuser);
		System.out.println("컨텍스트 파라미터 dbpass:" + dbpass);
	}
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 메서드 호출");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 메서드 호출");
		
		//	서블릿 초기화 파라미터 받아오기
		ServletConfig config = getServletConfig();
		String servletParam = config.getInitParameter("servlet-param");
		System.out.println("서블릿 초기화 파라미터:" + servletParam);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 메서드 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
		super.destroy();
	}

}