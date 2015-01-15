package systemaccount.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

import systemaccount.json.DateSerializer;

/**
 * The persistent class for the assignment database table.
 *
 */
@Entity
@NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Assignment")
public class Assignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using = DateSerializer.class)
	@XmlElement(name = "AssignmentDate", required = true)
	private Date assignmentDate;

	// bi-directional many-to-one association to Inhouseuser
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Inhouseuser")
	@JoinColumn(name = "Inhouseuser_UserID", referencedColumnName = "UserID", updatable = false)
	private Inhouseuser inhouseuser;

	// bi-directional many-to-one association to Unit
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JsonBackReference("Unit")
	@JoinColumn(name = "Unit_UnitID", referencedColumnName = "UnitID", updatable = false)
	private Unit unit;

	public Inhouseuser getInhouseuser() {
		return inhouseuser;
	}

	public void setInhouseuser(Inhouseuser inhouseuser) {
		this.inhouseuser = inhouseuser;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Assignment() {
	}

	public Date getAssignmentDate() {
		return this.assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

}