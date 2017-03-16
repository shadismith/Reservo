package de.reservo.dto;

import de.reservo.pao.AuthPAO;
import de.reservo.pao.EmployeePAO;

public class RegisterEmployeeDTO {

	private EmployeePAO employee;
	private AuthPAO auth;

	public EmployeePAO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePAO pEmployee) {
		employee = pEmployee;
	}

	public AuthPAO getAuth() {
		return auth;
	}

	public void setAuth(AuthPAO pAuth) {
		auth = pAuth;
	}

}
