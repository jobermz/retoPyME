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

	

@Entity
@Table(name = "inegi", schema="hackaton")
public class Inegi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srl_id")
	private Integer srlId;
	
	@Column(name = "int_id_dataset")
	private Integer intIdDataset;
	
	@Column(name = "var_nomb_comp")
	private String strNombComp;
	
	@Column(name = "var_direccion")
	private String strDireccion;
	
	@Column(name = "int_estrato_perso_ocupado")
	private Integer intEstratoPersoOcupado;
	
	@Column(name = "int_tipo_establecimiento")
	private Integer intTipoEstablecimiento;
	
	public Inegi() {}
	
	public Inegi(int srlId) {
		this.srlId		= srlId;
	}
	
	public Inegi(int srlId, int intIdDataset, String strNombComp, String strDireccion, int intEstratoPersoOcupado, int intTipoEstablecimiento) {
		this.srlId		= srlId;
		this.intIdDataset		= intIdDataset;
		this.strNombComp		= strNombComp;
		this.strDireccion		= strDireccion;
		this.intEstratoPersoOcupado		= intEstratoPersoOcupado;
		this.intTipoEstablecimiento		= intTipoEstablecimiento;
	}
	
	public Integer getSrlId() {
		return srlId;
	}
	public Inegi setSrlId(Integer srlId) {
		this.srlId = srlId;
		return this;
	}
	public Integer getIntIdDataset() {
		return intIdDataset;
	}
	public Inegi setIntIdDataset(Integer intIdDataset) {
		this.intIdDataset = intIdDataset;
		return this;
	}
	public String getStrNombComp() {
		return strNombComp;
	}
	public Inegi setStrNombComp(String strNombComp) {
		this.strNombComp = strNombComp;
		return this;
	}
	public String getStrDireccion() {
		return strDireccion;
	}
	public Inegi setStrDireccion(String strDireccion) {
		this.strDireccion = strDireccion;
		return this;
	}
	public Integer getIntEstratoPersoOcupado() {
		return intEstratoPersoOcupado;
	}
	public Inegi setIntEstratoPersoOcupado(Integer intEstratoPersoOcupado) {
		this.intEstratoPersoOcupado = intEstratoPersoOcupado;
		return this;
	}
	public Integer getIntTipoEstablecimiento() {
		return intTipoEstablecimiento;
	}
	public Inegi setIntTipoEstablecimiento(Integer intTipoEstablecimiento) {
		this.intTipoEstablecimiento = intTipoEstablecimiento;
		return this;
	}
	
	}
