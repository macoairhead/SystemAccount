package systemaccount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import systemaccount.json.NumericSerializer;


/**
 * The persistent class for the unit database table.
 *
 */
@Entity
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Unit")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@XmlElement(name = "UnitID", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@JsonSerialize(using = NumericSerializer.class)
	@XmlSchemaType(name = "ID")
	private int unitID;

	@XmlElement(name = "UnitName", required = true)
	@Column(length = 45)
	private String unitName;

	public Unit() {
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

}