package pe.com.bbva.hackaton.core.model.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.io.Serializable;
import pe.com.bbva.hackaton.common.CadenaUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

import pe.com.bbva.hackaton.core.model.entity.EmpresaGoogle;
	

@Entity
@Table(name = "empresa_google_comentarios", schema="hackaton")
public class EmpresaGoogleComentarios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srl_id")
	private Integer srlId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_empresa_google")
	private EmpresaGoogle idEmpresaGoogle;
	
	@Column(name = "var_comentario")
	private String strComentario;
	
	@Column(name = "int_sentimiento_comentarios")
	private Integer intSentimientoComentarios;
	
	public EmpresaGoogleComentarios() {}
	
	public EmpresaGoogleComentarios(int srlId) {
		this.srlId		= srlId;
	}
	
	public EmpresaGoogleComentarios(int srlId, EmpresaGoogle idEmpresaGoogle, String strComentario, int intSentimientoComentarios) {
		this.srlId		= srlId;
		this.idEmpresaGoogle		= idEmpresaGoogle;
		this.strComentario		= strComentario;
		this.intSentimientoComentarios		= intSentimientoComentarios;
	}
	
	public EmpresaGoogle getIdEmpresaGoogle() {
		return idEmpresaGoogle;
	}
	public EmpresaGoogleComentarios setIdEmpresaGoogle(EmpresaGoogle idEmpresaGoogle) {
		this.idEmpresaGoogle = idEmpresaGoogle;
		return this;
	}
	public Integer getSrlId() {
		return srlId;
	}
	public EmpresaGoogleComentarios setSrlId(Integer srlId) {
		this.srlId = srlId;
		return this;
	}
	public String getStrComentario() {
		return strComentario;
	}
	public EmpresaGoogleComentarios setStrComentario(String strComentario) {
		this.strComentario = strComentario;
		return this;
	}
	public Integer getIntSentimientoComentarios() {
		return intSentimientoComentarios;
	}
	public EmpresaGoogleComentarios setIntSentimientoComentarios(Integer intSentimientoComentarios) {
		this.intSentimientoComentarios = intSentimientoComentarios;
		return this;
	}
	
	}
