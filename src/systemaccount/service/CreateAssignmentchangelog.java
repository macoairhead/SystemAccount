package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Assignmentchangelog;

public class CreateAssignmentchangelog extends BaseService {

	public CreateAssignmentchangelog() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void createAssignmentchangelog(LinkedHashMap<ElementName, String> input) {

		EventID ev = EventID.valueOf(EventID.class, input.get(ElementName.AssignmentEventID));
		et.begin();
		Assignmentchangelog record = new Assignmentchangelog();
		record.setUserID(new BigInteger(input.get(ElementName.UserID)));
		record.setUserNameFirst(input.get(ElementName.UserNameFirst));
		record.setUserNameLast(input.get(ElementName.UserNameLast));
		record.setUnitID(Integer.parseInt(input.get(ElementName.UnitID)));
		record.setUnitName(input.get(ElementName.UnitName));
		record.setAssignmentEventID(ev.ordinal());
		record.setChangeDate(new Date());
		em.merge(record);
		et.commit();
	}

}
