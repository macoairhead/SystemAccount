package systemaccount.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;


/**
 * The persistent class for the userpermission database table.
 *
 */
@Entity
@NamedQuery(name="Userpermission.findAll", query="SELECT u FROM Userpermission u")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Userpermission")
public class Userpermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserpermissionPK pk;

	//bi-directional many-to-one association to Inhouseuser
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Inhouseuser")
	@JoinColumn(name = "Inhouseuser_UserID", referencedColumnName = "UserID", updatable = false)
	private Inhouseuser inhouseuser;

	//bi-directional many-to-one association to Permission
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Permission")
	@JoinColumns({
		@JoinColumn(name="Permission_ManagementSystemID", referencedColumnName="ManagementSystem_ManagementSystemID"),
		@JoinColumn(name="Permission_PermissionID", referencedColumnName="PermissionID")
		})
	private Permission permission;

	public Userpermission() {
	}

	public UserpermissionPK getPk() {
		return pk;
	}

	public void setPk(UserpermissionPK pk) {
		this.pk = pk;
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