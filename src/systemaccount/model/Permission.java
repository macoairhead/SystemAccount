package systemaccount.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermissionPK pk;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "UpdateDate", required = true)
	private Date inputDate;

	@XmlElement(name = "IsValid", required = true)
	private byte isValid;

	@XmlElement(name = "PermissionName", required = true)
	@Column(length = 45)
	private String permissionName;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "UpdateDate", required = true)
	private Date updateDate;

	// bi-directional many-to-one association to Managementsystem
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Managementsystem")
	@JoinColumn(name = "ManagementSystem_ManagementSystemID", referencedColumnName = "ManagementSystemID", updatable = false)
	private Managementsystem managementsystem;

	// bi-directional many-to-one association to Userpermission
	@OneToMany(mappedBy = "permission", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference("Permission")
	private List<Userpermission> userpermissions;

	public PermissionPK getPk() {
		return pk;
	}

	public void setPk(PermissionPK pk) {
		this.pk = pk;
	}

	public Permission() {
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

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Managementsystem getManagementsystem() {
		return this.managementsystem;
	}

	public void setManagementsystem(Managementsystem managementsystem) {
		this.managementsystem = managementsystem;
	}

	public List<Userpermission> getUserpermissions() {
		return this.userpermissions;
	}

	public void setUserpermissions(List<Userpermission> userpermissions) {
		this.userpermissions = userpermissions;
	}

	public Userpermission addUserpermission(Userpermission userpermission) {
		getUserpermissions().add(userpermission);
		userpermission.setPermission(this);

		return userpermission;
	}

	public Userpermission removeUserpermission(Userpermission userpermission) {
		getUserpermissions().remove(userpermission);
		userpermission.setPermission(null);

		return userpermission;
	}

}