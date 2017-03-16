package de.reservo.dto;

import de.reservo.pao.AuthPAO;
import de.reservo.pao.ClientPAO;

public class RegisterClientDTO {

	private ClientPAO client;
	private AuthPAO auth;

	public ClientPAO getClient() {
		return client;
	}

	public void setClient(ClientPAO client) {
		this.client = client;
	}

	public AuthPAO getAuth() {
		return auth;
	}

	public void setAuth(AuthPAO auth) {
		this.auth = auth;
	}

}
