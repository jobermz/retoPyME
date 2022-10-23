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

import pe.com.bbva.hackaton.core.model.entity.Dataset;
	

@Entity
@Table(name = "empresa_google", schema="hackaton")
public class EmpresaGoogle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srl_id")
	private Integer srlId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "int_id_dataset")
	private Dataset idDataset;
	
	@Column(name = "var_nomb_comp")
	private String strNombComp;
	
	@Column(name = "var_direccion")
	private String strDireccion;
	
	@Column(name = "int_califi_estrellas")
	private Integer intCalifiEstrellas;
	
	@Column(name = "int_sentimiento_comentarios")
	private Integer intSentimientoComentarios;
	
	public EmpresaGoogle() {}
	
	public EmpresaGoogle(int srlId) {
		this.srlId		= srlId;
	}
	
	public EmpresaGoogle(int srlId, Dataset idDataset, String strNombComp, String strDireccion, int intCalifiEstrellas, int intSentimientoComentarios) {
		this.srlId		= srlId;
		this.idDataset		= idDataset;
		this.strNombComp		= strNombComp;
		this.strDireccion		= strDireccion;
		this.intCalifiEstrellas		= intCalifiEstrellas;
		this.intSentimientoComentarios		= intSentimientoComentarios;
	}
	
	public Dataset getIdDataset() {
		return idDataset;
	}
	public EmpresaGoogle setIdDataset(Dataset idDataset) {
		this.idDataset = idDataset;
		return this;
	}
	public Integer getSrlId() {
		return srlId;
	}
	public EmpresaGoogle setSrlId(Integer srlId) {
		this.srlId = srlId;
		return this;
	}
	public String getStrNombComp() {
		return strNombComp;
	}
	public EmpresaGoogle setStrNombComp(String strNombComp) {
		this.strNombComp = strNombComp;
		return this;
	}
	public String getStrDireccion() {
		return strDireccion;
	}
	public EmpresaGoogle setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
		return this;
	}
	public Integer getIntCalifiEstrellas() {
		return intCalifiEstrellas;
	}
	public EmpresaGoogle setIntCalifiEstrellas(Integer intCalifiEstrellas) {
		this.intCalifiEstrellas = intCalifiEstrellas;
		return this;
	}
	public Integer getIntSentimientoComentarios() {
		return intSentimientoComentarios;
	}
	public EmpresaGoogle setIntSentimientoComentarios(Integer intSentimientoComentarios) {
		this.intSentimientoComentarios = intSentimientoComentarios;
		return this;
	}
	
	}
