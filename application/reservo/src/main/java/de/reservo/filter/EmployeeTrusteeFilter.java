package de.reservo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;

import com.mchange.rmi.NotAuthorizedException;

import de.reservo.Util;
import de.reservo.enums.EmployeeRole;
import de.reservo.pao.EmployeePAO;

public class EmployeeTrusteeFilter implements Filter {

	@Override
	public void init(FilterConfig pFilterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) pRequest;
		HttpServletResponse response = (HttpServletResponse) pResponse;
		HttpSession session = request.getSession();
		Object authAttribute = session.getAttribute(Util.AUTHENTICATION_OBJECT);
		if (authAttribute != null) {
			try {
				EmployeePAO employeePAO = (EmployeePAO) authAttribute;
				if (employeePAO.getRole() != EmployeeRole.MANAGER && employeePAO.getRole() != EmployeeRole.TRUSTEE) {
					throw new NotAuthorizedException();
				}
				pChain.doFilter(pRequest, pResponse);
			} catch (Exception e) {
				response.sendError(HttpStatus.FORBIDDEN.value());
			}
		} else {
			response.sendError(HttpStatus.BAD_REQUEST.value());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
