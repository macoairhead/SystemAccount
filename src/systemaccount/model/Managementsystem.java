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
 * The persistent class for the managementsystem database table.
 *
 */
@Entity
@NamedQuery(name = "Managementsystem.findAll", query = "SELECT m FROM Managementsystem m")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Managementsystem")
public class Managementsystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement(name = "ManagementSystemID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	@XmlSchemaType(name = "ID")
	private int managementSystemID;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "InputDate", required = true)
	private Date inputDate;

	@XmlElement(name = "IsValid", required = true)
	private byte isValid;

	@XmlElement(name = "ManagementSystemName", required = true)
	@Column(length = 45)
	private String managementSystemName;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "UpdateDate", required = true)
	private Date updateDate;

	// bi-directional many-to-one association to Permission
	@OneToMany(mappedBy = "managementsystem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference("Managementsystem")
	private List<Permission> permissions;

	public int getManagementSystemID() {
		return managementSystemID;
	}

	public void setManagementSystemID(int managementSystemID) {
		this.managementSystemID = managementSystemID;
	}

	public Managementsystem() {
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

	public String getManagementSystemName() {
		return this.managementSystemName;
	}

	public void setManagementSystemName(String managementSystemName) {
		this.managementSystemName = managementSystemName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setManagementsystem(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setManagementsystem(null);

		return permission;
	}

}