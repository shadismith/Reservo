package de.reservo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ExampleFilter implements javax.servlet.Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain)
			throws IOException, ServletException {
		pFilterChain.doFilter(pRequest, pResponse);
	}

	@Override
	public void init(FilterConfig pArg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
