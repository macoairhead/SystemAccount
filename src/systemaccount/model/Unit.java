package systemaccount.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import systemaccount.json.DateSerializer;
import systemaccount.json.NumericSerializer;
/**
 * The persistent class for the unit database table.
 *
 */
@Entity
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Unit")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement(name = "UnitID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	@XmlSchemaType(name = "ID")
	private int unitID;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "InputDate", required = true)
	private Date inputDate;

	@XmlElement(name = "IsValid", required = true)
	private byte isValid;

	@XmlElement(name = "UnitName", required = true)
	@Column(length = 45)
	private String unitName;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "UpdateDate", required = true)
	private Date updateDate;

	// bi-directional many-to-one association to Inhouseuser
	@OneToMany(mappedBy = "unit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference("Unit")
	private List<Inhouseuser> inhouseusers;

	public int getUnitID() {
		return unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public Unit() {
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public byte getIsValid() {
		return this.isValid;
	}

	public void setIsValid(byte isValid) {
		this.isValid = isValid;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Inhouseuser> getInhouseusers() {
		return this.inhouseusers;
	}

	public void setInhouseusers(List<Inhouseuser> inhouseusers) {
		this.inhouseusers = inhouseusers;
	}

	public Inhouseuser addInhouseuser(Inhouseuser inhouseuser) {
		getInhouseusers().add(inhouseuser);
		inhouseuser.setUnit(this);

		return inhouseuser;
	}

	public Inhouseuser removeInhouseuser(Inhouseuser inhouseuser) {
		getInhouseusers().remove(inhouseuser);
		inhouseuser.setUnit(null);

		return inhouseuser;
	}

}