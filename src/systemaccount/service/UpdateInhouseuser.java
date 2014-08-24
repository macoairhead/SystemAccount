package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.elementList.ElementName;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Unit;

public class UpdateInhouseuser extends BaseService {

	public UpdateInhouseuser(String key) {
		super(key);
	}

	public void updateInhouseuser(LinkedHashMap<String, String> keyMap,
			LinkedHashMap<String, String> input) {

		et.begin();
		Inhouseuser record = em.find(Inhouseuser.class, keyMap.get(this.key));
		if (input.containsKey(this.key)) {
			record.setUserID(new BigInteger(input.get(this.key)));
		}
		record.setUpdateDate(new Date());
		if (input.containsKey(ElementName.IsValid)) {
			record.setIsValid(new Byte(input.get(ElementName.IsValid)));
		}
		if (input.containsKey(ElementName.UnitID)) {
			record.setUnit(new Unit());
			record.getUnit().setUnitID(
					Integer.parseInt(input.get(ElementName.UnitID)));
		}
		if (input.containsKey(ElementName.UserNameFirst)) {
			record.setUserNameFirst(input.get(ElementName.UserNameFirst));
		}
		if (input.containsKey(ElementName.UserNameLast)) {
			record.setUserNameLast(input.get(ElementName.UserNameLast));
		}
		em.merge(record);
		et.commit();
	}
}
