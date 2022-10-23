package pe.com.bbva.hackaton.core.bean;

import java.io.Serializable;

public class ResponseHeader implements Serializable {

	private static final long serialVersionUID = 1L;
	private String estadoServicio;
	private String codigoServicio;
	private String mensajeServicio;
	private String idSesion;
	private String idOperacion;

	public String getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codServicio) {
		this.codigoServicio = codServicio;
	}

	public String getMensajeServicio() {
		return mensajeServicio;
	}

	public void setMensajeServicio(String mensajeServicio) {
		this.mensajeServicio = mensajeServicio;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
}
