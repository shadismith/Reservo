package de.reservo.pao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTH")
public class AuthPAO {

	@Id
	@GeneratedValue
	private Long authId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ClientPAO client;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EmployeePAO employee;
	@Column(nullable = false, unique = true, updatable = false)
	private String login;
	@Column(nullable = false, unique = false, updatable = true)
	private String password;
	@Column(nullable = true, unique = false, updatable = true) // ignored for
																// testing
	private String salt;
	@Column(nullable = true, unique = false, updatable = true) // ignored for
																// testing
	private String secretQuestion;
	@Column(nullable = true, unique = false, updatable = true) // ignored for
																// testing
	private String secretAnswer;

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long pAuthId) {
		authId = pAuthId;
	}

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO pClient) {
		client = pClient;
	}

	public EmployeePAO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePAO pEmployee) {
		employee = pEmployee;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String pLogin) {
		login = pLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pPassword) {
		password = pPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String pSalt) {
		salt = pSalt;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String pSecretQuestion) {
		secretQuestion = pSecretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String pSecretAnswer) {
		secretAnswer = pSecretAnswer;
	}

}
