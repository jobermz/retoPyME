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
@Table(name = "dataset", schema="hackaton")
public class Dataset implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "srl_id")
	private Integer srlId;
	
	@Column(name = "int_index")
	private Integer intIndex;
	
	@Column(name = "var_nombre1")
	private String strNombre1;
	
	@Column(name = "var_nombre2")
	private String strNombre2;
	
	@Column(name = "var_nombre3")
	private String strNombre3;
	
	@Column(name = "var_direccion1")
	private String strDireccion1;
	
	@Column(name = "var_direccion2")
	private String strDireccion2;
	
	@Column(name = "var_direccion3")
	private String strDireccion3;
	
	@Column(name = "var_colonia")
	private String strColonia;
	
	@Column(name = "var_municipio_del")
	private String strMunicipioDel;
	
	@Column(name = "var_cp")
	private String strCp;
	
	@Column(name = "var_entre_calle1")
	private String strEntreCalle1;
	
	@Column(name = "var_entre_calle2")
	private String strEntreCalle2;
	
	@Column(name = "var_estado")
	private String strEstado;
	
	@Column(name = "var_nomb_comp")
	private String strNombComp;
	
	public Dataset() {}
	
	public Dataset(int srlId) {
		this.srlId		= srlId;
	}
	
	public Dataset(int srlId, int intIndex, String strNombre1, String strNombre2, String strNombre3, String strDireccion1, String strDireccion2, String strDireccion3, String strColonia, String strMunicipioDel, String strCp, String strEntreCalle1, String strEntreCalle2, String strEstado, String strNombComp) {
		this.srlId		= srlId;
		this.intIndex		= intIndex;
		this.strNombre1		= strNombre1;
		this.strNombre2		= strNombre2;
		this.strNombre3		= strNombre3;
		this.strDireccion1		= strDireccion1;
		this.strDireccion2		= strDireccion2;
		this.strDireccion3		= strDireccion3;
		this.strColonia		= strColonia;
		this.strMunicipioDel		= strMunicipioDel;
		this.strCp		= strCp;
		this.strEntreCalle1		= strEntreCalle1;
		this.strEntreCalle2		= strEntreCalle2;
		this.strEstado		= strEstado;
		this.strNombComp		= strNombComp;
	}
	
	public Integer getSrlId() {
		return srlId;
	}
	public Dataset setSrlId(Integer srlId) {
		this.srlId = srlId;
		return this;
	}
	public Integer getIntIndex() {
		return intIndex;
	}
	public Dataset setIntIndex(Integer intIndex) {
		this.intIndex = intIndex;
		return this;
	}
	public String getStrNombre1() {
		return strNombre1;
	}
	public Dataset setStrNombre1(String strNombre1) {
		this.strNombre1 = strNombre1;
		return this;
	}
	public String getStrNombre2() {
		return strNombre2;
	}
	public Dataset setStrNombre2(String strNombre2) {
		this.strNombre2 = strNombre2;
		return this;
	}
	public String getStrNombre3() {
		return strNombre3;
	}
	public Dataset setStrNombre3(String strNombre3) {
		this.strNombre3 = strNombre3;
		return this;
	}
	public String getStrDireccion1() {
		return strDireccion1;
	}
	public Dataset setStrDireccion1(String strDireccion1) {
		this.strDireccion1 = strDireccion1;
		return this;
	}
	public String getStrDireccion2() {
		return strDireccion2;
	}
	public Dataset setStrDireccion2(String strDireccion2) {
		this.strDireccion2 = strDireccion2;
		return this;
	}
	public String getStrDireccion3() {
		return strDireccion3;
	}
	public Dataset setStrDireccion3(String strDireccion3) {
		this.strDireccion3 = strDireccion3;
		return this;
	}
	public String getStrColonia() {
		return strColonia;
	}
	public Dataset setStrColonia(String strColonia) {
		this.strColonia = strColonia;
		return this;
	}
	public String getStrMunicipioDel() {
		return strMunicipioDel;
	}
	public Dataset setStrMunicipioDel(String strMunicipioDel) {
		this.strMunicipioDel = strMunicipioDel;
		return this;
	}
	public String getStrCp() {
		return strCp;
	}
	public Dataset setStrCp(String strCp) {
		this.strCp = strCp;
		return this;
	}
	public String getStrEntreCalle1() {
		return strEntreCalle1;
	}
	public Dataset setStrEntreCalle1(String strEntreCalle1) {
		this.strEntreCalle1 = strEntreCalle1;
		return this;
	}
	public String getStrEntreCalle2() {
		return strEntreCalle2;
	}
	public Dataset setStrEntreCalle2(String strEntreCalle2) {
		this.strEntreCalle2 = strEntreCalle2;
		return this;
	}
	public String getStrEstado() {
		return strEstado;
	}
	public Dataset setStrEstado(String strEstado) {
		this.strEstado = strEstado;
		return this;
	}
	public String getStrNombComp() {
		return strNombComp;
	}
	public Dataset setStrNombComp(String strNombComp) {
		this.strNombComp = strNombComp;
		return this;
	}

	@Override
	public String toString() {
		return "Dataset [srlId=" + srlId + ", intIndex=" + intIndex + ", strNombre1=" + strNombre1 + ", strNombre2="
				+ strNombre2 + ", strNombre3=" + strNombre3 + ", strDireccion1=" + strDireccion1 + ", strDireccion2="
				+ strDireccion2 + ", strDireccion3=" + strDireccion3 + ", strColonia=" + strColonia
				+ ", strMunicipioDel=" + strMunicipioDel + ", strCp=" + strCp + ", strEntreCalle1=" + strEntreCalle1
				+ ", strEntreCalle2=" + strEntreCalle2 + ", strEstado=" + strEstado + ", strNombComp=" + strNombComp
				+ "]";
	}
	
}
