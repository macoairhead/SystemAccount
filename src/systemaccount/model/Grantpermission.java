package systemaccount.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import systemaccount.json.DateSerializer;
import systemaccount.json.NumericSerializer;


/**
 * The persistent class for the grantpermission database table.
 *
 */
@Entity
@NamedQuery(name="Grantpermission.findAll", query="SELECT g FROM Grantpermission g")
public class Grantpermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "GrantDate", required = true)
	private Date grantDate;

	@Id
	@SequenceGenerator(name="GRANTPERMISSION_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRANTPERMISSION_ID_GENERATOR")
	@XmlSchemaType(name = "ID")
	@XmlElement(name = "ID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger id;

	@XmlElement(name = "LoginID", required = true)
	@Column(length = 20)
	private String loginID;

	@XmlElement(name = "ManagementSystemID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int managementSystemID;

	@XmlElement(name = "PermissionID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int permissionID;

	@XmlElement(name = "UserID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger userID;

	@XmlElement(name = "GrantEventID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int grantEventID;

	public Grantpermission() {
	}

	public Date getGrantDate() {
		return grantDate;
	}

	public void setGrantDate(Date grantDate) {
		this.grantDate = grantDate;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getLoginID() {
		return this.loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public int getManagementSystemID() {
		return this.managementSystemID;
	}

	public void setManagementSystemID(int managementSystemID) {
		this.managementSystemID = managementSystemID;
	}

	public int getPermissionID() {
		return this.permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	public BigInteger getUserID() {
		return this.userID;
	}

	public void setUserID(BigInteger userID) {
		this.userID = userID;
	}

	public int getGrantEventID() {
		return grantEventID;
	}

	public void setGrantEventID(int grantEventID) {
		this.grantEventID = grantEventID;
	}


}