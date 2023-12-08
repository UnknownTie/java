package common.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)	throws IOException, ServletException {
		
		System.out.println();
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		System.out.println("접속 : " + url);
		System.out.println("A Filter 전 ---------------------");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		chain.doFilter(request, response);

		System.out.println("B Filter 후  ---------------------");
		System.out.println();
	}

}
