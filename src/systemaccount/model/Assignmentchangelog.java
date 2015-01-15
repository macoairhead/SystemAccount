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
 * The persistent class for the assignmentchangelog database table.
 *
 */
@Entity
@NamedQuery(name="Assignmentchangelog.findAll", query="SELECT a FROM Assignmentchangelog a")
public class Assignmentchangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "AssignmentEventID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int assignmentEventID;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "ChangeDate", required = true)
	private Date changeDate;

	@Id
	@SequenceGenerator(name="ASSIGNMENTCHANGELOG_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSIGNMENTCHANGELOG_ID_GENERATOR")
	@XmlSchemaType(name = "ID")
	@XmlElement(name = "ID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger id;

	@XmlElement(name = "UnitID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int unitID;

	@XmlElement(name = "UnitName", required = true)
	@Column(length = 45)
	private String unitName;

	@XmlElement(name = "UserID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger userID;

	@XmlElement(name = "UserNameFirst", required = true)
	@Column(length = 45)
	private String userNameFirst;

	@XmlElement(name = "UserNameLast", required = true)
	@Column(length = 45)
	private String userNameLast;

	public Assignmentchangelog() {
	}

	public int getAssignmentEventID() {
		return this.assignmentEventID;
	}

	public void setAssignmentEventID(int assignmentEventID) {
		this.assignmentEventID = assignmentEventID;
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

	public int getUnitID() {
		return this.unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public BigInteger getUserID() {
		return this.userID;
	}

	public void setUserID(BigInteger userID) {
		this.userID = userID;
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

}