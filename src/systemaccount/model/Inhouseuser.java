package systemaccount.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import systemaccount.json.NumericSerializer;

/**
 * The persistent class for the inhouseuser database table.
 * 
 */
@Entity
@NamedQuery(name = "Inhouseuser.findAll", query = "SELECT i FROM Inhouseuser i")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Inhouseuser")
public class Inhouseuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement(name = "UserID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	@XmlSchemaType(name = "ID")
	private BigInteger userID;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "InputDate", required = true)
	private Date inputDate;

	@XmlElement(name = "IsValid", required = true)
	private byte isValid;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "UpdateDate", required = true)
	private Date updateDate;

	@XmlElement(name = "UserNameFirst", required = true)
	@Column(length = 45)
	private String userNameFirst;

	@XmlElement(name = "UserNameLast", required = true)
	@Column(length = 45)
	private String userNameLast;

	// bi-directional many-to-one association to Unit
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Unit")
	@JoinColumn(name = "Unit_UnitID", referencedColumnName = "UnitID", updatable = false)
	private Unit unit;

	// bi-directional many-to-one association to Userpermission
	@OneToMany(mappedBy = "inhouseuser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference("Inhouseuser")
	private List<Userpermission> userpermissions;

	public Inhouseuser() {
	}

	public BigInteger getUserID() {
		return userID;
	}

	public void setUserID(BigInteger userID) {
		this.userID = userID;
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

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserNameFirst() {
		return this.userNameFirst;
	}

	public void setUserNameFirst(String userNameFirst) {
		this.userNameFirst = userNameFirst;
	}

	public String getUserNameLast() {
		return this.userNameLast;
	}

	public void setUserNameLast(String userNameLast) {
		this.userNameLast = userNameLast;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<Userpermission> getUserpermissions() {
		return this.userpermissions;
	}

	public void setUserpermissions(List<Userpermission> userpermissions) {
		this.userpermissions = userpermissions;
	}

	public Userpermission addUserpermission(Userpermission userpermission) {
		getUserpermissions().add(userpermission);
		userpermission.setInhouseuser(this);

		return userpermission;
	}

	public Userpermission removeUserpermission(Userpermission userpermission) {
		getUserpermissions().remove(userpermission);
		userpermission.setInhouseuser(null);

		return userpermission;
	}

}