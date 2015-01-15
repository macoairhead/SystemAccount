package systemaccount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import systemaccount.json.NumericSerializer;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class UserpermissionPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "loginID", length = 20)
	private String loginID;

	@Column(name = "Permission_ManagementSystemID")
	@JsonSerialize(using = NumericSerializer.class)
	private int managementSystemID;

	@Column(name = "Permission_PermissionID")
	@JsonSerialize(using = NumericSerializer.class)
	private int permissionID;

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public int getManagementSystemID() {
		return managementSystemID;
	}

	public void setManagementSystemID(int managementSystemID) {
		this.managementSystemID = managementSystemID;
	}

	public int getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + managementSystemID;
		result = prime * result + ((loginID == null) ? 0 : loginID.hashCode());
		result = prime * result + permissionID;
		return result;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserpermissionPK other = (UserpermissionPK) obj;
		if (managementSystemID != other.managementSystemID)
			return false;
		if (loginID == null) {
			if (other.loginID != null)
				return false;
		} else if (!loginID.equals(other.loginID))
			return false;
		if (permissionID != other.permissionID)
			return false;
		return true;
	}

}
