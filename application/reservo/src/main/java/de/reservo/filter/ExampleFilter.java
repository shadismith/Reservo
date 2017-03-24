package de.reservo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Required;

import de.reservo.service.AuthService;

public class ExampleFilter implements Filter {

	private AuthService authService;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) pRequest;
		HttpSession session = request.getSession(true);
//		if (!authService.isTestStringSet()) {
//			Double i = Math.random();
//			System.out.println("Nicht gesetzt, setze auf " + i);
//			authService.setTestString(i.toString());
//		} else {
//			System.out.println("Ist gesetzt auf " + authService.getTestString());
//		}
		if (session.getAttribute("auth") == null) {
			Double i = Math.random();
			System.out.println("neue session: " + i);
			session.setAttribute("auth", i);
		} else {
			System.out.println("session da: " + (Double) session.getAttribute("auth"));
		}
		pFilterChain.doFilter(pRequest, pResponse);
	}

	@Override
	public void init(FilterConfig pFilterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Required
	public void setAuthService(AuthService pAuthService) {
		this.authService = pAuthService;
	}

}
