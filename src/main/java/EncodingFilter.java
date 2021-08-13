import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EncodingFilter::init");
//		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter::doChain Begin");
		
		//	요청과 응답에 필터 적용
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//	다음 연결된 필터로 요청과 응답 전달
		chain.doFilter(req, resp);
		
		System.out.println("EncodingFilter::doChain End");
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter::destroy");
//		Filter.super.destroy();
	}

}