package systemaccount.service;

import java.math.BigInteger;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Inhouseuser;

public class CreateInhouseuser extends BaseService {
	public CreateInhouseuser(ElementName key) {
		super(key);
	}

	public void createInhouseuser(LinkedHashMap<ElementName, String> input) {

		et.begin();
		Inhouseuser record = new Inhouseuser();
		record.setUserID(new BigInteger(input.get(this.key)));
		record.setUserNameFirst(input.get(ElementName.UserNameFirst));
		record.setUserNameLast(input.get(ElementName.UserNameLast));
		em.merge(record);
		et.commit();
	}

}