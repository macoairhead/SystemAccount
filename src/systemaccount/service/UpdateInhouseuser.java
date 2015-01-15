package systemaccount.service;

import java.math.BigInteger;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Inhouseuser;

public class UpdateInhouseuser extends BaseService {

	public UpdateInhouseuser(ElementName key) {
		super(key);
	}

	public void updateInhouseuser(LinkedHashMap<ElementName, String> keyMap,
			LinkedHashMap<ElementName, String> input) {

		et.begin();
		Inhouseuser record = em.find(Inhouseuser.class, keyMap.get(this.key));
		if (input.containsKey(this.key)) {
			record.setUserID(new BigInteger(input.get(this.key)));
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
