package de.reservo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig pFilterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) pRequest;
		request.getSession(true);
		pFilterChain.doFilter(pRequest, pResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
