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
public class PermissionPK implements Serializable {

	@Column(name = "PermissionID", length = 11)
	@JsonSerialize(using = NumericSerializer.class)
	private int permissionID;

	@Column(name = "ManagementSystem_ManagementSystemID")
	@JsonSerialize(using = NumericSerializer.class)
	private int managementSystemID;

	public int getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	public int getManagementSystemID() {
		return managementSystemID;
	}

	public void setManagementSystemID(int managementSystemID) {
		this.managementSystemID = managementSystemID;
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
		PermissionPK other = (PermissionPK) obj;
		if (managementSystemID != other.managementSystemID)
			return false;
		if (permissionID != other.permissionID)
			return false;
		return true;
	}

}
