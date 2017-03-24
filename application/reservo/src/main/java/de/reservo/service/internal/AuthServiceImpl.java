package de.reservo.service.internal;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import de.reservo.service.AuthService;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AuthServiceImpl implements AuthService {

	private String testString;
	
	@Override
	public void test() {
		System.out.println("Test called");
	}

	@Override
	public boolean isTestStringSet() {
		return testString != null;
	}

	@Override
	public void setTestString(String pTestString) {
		this.testString = pTestString;
	}

	@Override
	public String getTestString() {
		return this.testString;
	}

}
