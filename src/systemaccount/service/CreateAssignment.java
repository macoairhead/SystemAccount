package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Assignment;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Unit;

public class CreateAssignment extends BaseService {
	public CreateAssignment() {
	}

	public void createAssignment(LinkedHashMap<ElementName, String> input) {

		et.begin();
		Assignment record = new Assignment();
		record.setInhouseuser(new Inhouseuser());
		record.getInhouseuser().setUserID(new BigInteger(input.get(ElementName.UserID)));
		record.setUnit(new Unit());
		record.getUnit().setUnitID(Integer.parseInt(input.get(ElementName.UnitID)));
		record.setAssignmentDate(new Date());
		em.merge(record);
		et.commit();
	}

}
