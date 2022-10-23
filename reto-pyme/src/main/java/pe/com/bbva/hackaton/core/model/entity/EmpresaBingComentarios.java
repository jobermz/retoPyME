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

import pe.com.bbva.hackaton.core.model.entity.EmpresaBing;
	

@Entity
@Table(name = "empresa_bing_comentarios", schema="hackaton")
public class EmpresaBingComentarios implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srl_id")
	private Integer srlId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_empresa_bing")
	private EmpresaBing idEmpresaBing;
	
	@Column(name = "var_comentario")
	private String strComentario;
	
	@Column(name = "int_sentimiento_comentarios")
	private Integer intSentimientoComentarios;
	
	public EmpresaBingComentarios() {}
	
	public EmpresaBingComentarios(int srlId) {
		this.srlId		= srlId;
	}
	
	public EmpresaBingComentarios(int srlId, EmpresaBing idEmpresaBing, String strComentario, int intSentimientoComentarios) {
		this.srlId		= srlId;
		this.idEmpresaBing		= idEmpresaBing;
		this.strComentario		= strComentario;
		this.intSentimientoComentarios		= intSentimientoComentarios;
	}
	
	public EmpresaBing getIdEmpresaBing() {
		return idEmpresaBing;
	}
	public EmpresaBingComentarios setIdEmpresaBing(EmpresaBing idEmpresaBing) {
		this.idEmpresaBing = idEmpresaBing;
		return this;
	}
	public Integer getSrlId() {
		return srlId;
	}
	public EmpresaBingComentarios setSrlId(Integer srlId) {
		this.srlId = srlId;
		return this;
	}
	public String getStrComentario() {
		return strComentario;
	}
	public EmpresaBingComentarios setStrComentario(String strComentario) {
		this.strComentario = strComentario;
		return this;
	}
	public Integer getIntSentimientoComentarios() {
		return intSentimientoComentarios;
	}
	public EmpresaBingComentarios setIntSentimientoComentarios(Integer intSentimientoComentarios) {
		this.intSentimientoComentarios = intSentimientoComentarios;
		return this;
	}
	
	}
