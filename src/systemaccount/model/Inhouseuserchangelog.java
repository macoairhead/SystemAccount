package systemaccount.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

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
 * The persistent class for the inhouseuserchangelog database table.
 * 
 */
@Entity
@NamedQuery(name="Inhouseuserchangelog.findAll", query="SELECT i FROM Inhouseuserchangelog i")
public class Inhouseuserchangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "ChangeDate", required = true)
	private Date changeDate;

	@Id
	@SequenceGenerator(name="INHOUSEUSERCHANGELOG_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INHOUSEUSERCHANGELOG_ID_GENERATOR")
	@XmlSchemaType(name = "ID")
	@XmlElement(name = "ID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private BigInteger id;

	@XmlElement(name = "InhouseuserEventID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	private int inhouseuserEventID;

	private BigInteger userID;

	private String userNameFirst;

	private String userNameLast;

	public Inhouseuserchangelog() {
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

	public int getInhouseuserEventID() {
		return this.inhouseuserEventID;
	}

	public void setInhouseuserEventID(int inhouseuserEventID) {
		this.inhouseuserEventID = inhouseuserEventID;
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