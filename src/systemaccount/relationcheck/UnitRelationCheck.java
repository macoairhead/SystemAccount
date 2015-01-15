package systemaccount.relationcheck;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.elementList.ElementName;
import systemaccount.service.UnitInfo;

public class UnitRelationCheck extends BaseRelationCheck {

	@Override
	public boolean exsistForeignKey(String param) {
		UnitInfo inhusr = new UnitInfo(ElementName.UnitID);
		try {
			inhusr.getUnitByUnitId(param);
		} catch (EntityExistsException e) {
			return true;
		}
		return false;
	}

}
