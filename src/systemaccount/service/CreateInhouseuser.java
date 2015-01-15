package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.elementList.ElementName;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Unit;

public class CreateInhouseuser extends BaseService {
	public CreateInhouseuser(String key) {
		super(key);
	}

	public void createInhouseuser(LinkedHashMap<String, String> input) {

		et.begin();
		Inhouseuser record = new Inhouseuser();
		record.setUserID(new BigInteger(input.get(ElementName.UserID)));
		record.setIsValid((byte) 0);
		record.setInputDate(new Date());
		record.setUpdateDate(new Date());
		record.setUnit(new Unit());
		record.getUnit().setUnitID(
				Integer.parseInt(input.get(ElementName.UnitID)));
		record.setUserNameFirst(input.get(ElementName.UserNameFirst));
		record.setUserNameLast(input.get(ElementName.UserNameLast));
		em.merge(record);
		et.commit();
	}

}