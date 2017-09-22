package com.situ.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    
    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();
		
		if (method.equalsIgnoreCase("get")) {
			EnhancedRequest enhancedRequest = new EnhancedRequest(req);
			chain.doFilter(enhancedRequest, response);
			
		} else {
			request.setCharacterEncoding("utf-8");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

class EnhancedRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	public EnhancedRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String parameter = request.getParameter(name);
		if ((parameter != null) && !(parameter.equals(""))) {
			try {
				parameter = new String(parameter.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
		}
		return parameter;
	}
	
}
