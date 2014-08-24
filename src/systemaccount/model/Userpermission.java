package systemaccount.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * The persistent class for the userpermission database table.
 * 
 */
@Entity
@NamedQuery(name = "Userpermission.findAll", query = "SELECT u FROM Userpermission u")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Userpermission")
public class Userpermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserpermissionPK pk;

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

	// bi-directional many-to-one association to Inhouseuser
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Inhouseuser")
	@JoinColumn(name = "Inhouseuser_UserID", referencedColumnName = "UserID", updatable = false)
	private Inhouseuser inhouseuser;

	// bi-directional many-to-one association to Permission
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Permission")
	@JoinColumns({
			@JoinColumn(name = "Permission_ManagementSystemID", referencedColumnName = "ManagementSystem_ManagementSystemID", updatable = false),
			@JoinColumn(name = "Permission_PermissionID", referencedColumnName = "PermissionID", updatable = false) })
	private Permission permission;

	public UserpermissionPK getPk() {
		return pk;
	}

	public void setPk(UserpermissionPK pk) {
		this.pk = pk;
	}

	public Userpermission() {
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

	public Inhouseuser getInhouseuser() {
		return this.inhouseuser;
	}

	public void setInhouseuser(Inhouseuser inhouseuser) {
		this.inhouseuser = inhouseuser;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}