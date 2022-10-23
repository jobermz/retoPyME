package pe.com.bbva.hackaton.core.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestHeader implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("idSesion")
	private String idSesion;


	public String getUsuario() {
		return usuario;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

}
