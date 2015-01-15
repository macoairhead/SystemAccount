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
 * The persistent class for the permissionchangelog database table.
 *
 */
@Entity
@NamedQuery(name="Permissionchangelog.findAll", query="SELECT p FROM Permissionchangelog p")
public class Permissionchangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "ChangeDate", required = true)
	private Date changeDate;

	@Id
	@SequenceGenerator(name="PERMISSIONCHANGELOG_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONCHANGELOG_ID_GENERATOR")
	@XmlSchemaType(name = "ID")
	@XmlElement(name = "ID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger id;

	@XmlElement(name = "ManagementSystemID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int managementSystemID;

	@XmlElement(name = "PermissionEventID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int permissionEventID;

	@XmlElement(name = "PermissionID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int permissionID;

	@XmlElement(name = "PermissionName", required = true)
	@Column(length = 45)
	private String permissionName;

	public Permissionchangelog() {
	}

	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public int getManagementSystemID() {
		return this.managementSystemID;
	}

	public void setManagementSystemID(int managementSystemID) {
		this.managementSystemID = managementSystemID;
	}

	public int getPermissionEventID() {
		return this.permissionEventID;
	}

	public void setPermissionEventID(int permissionEventID) {
		this.permissionEventID = permissionEventID;
	}

	public int getPermissionID() {
		return this.permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

}