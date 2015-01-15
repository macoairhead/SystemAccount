package systemaccount.service;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Inhouseuser;

public class DeleteInhouseuser extends BaseService {

	public DeleteInhouseuser(ElementName key) {
		super(key);
	}

	public void deleteInhouseuser(String key) {
		et.begin();
		Inhouseuser record = em.find(Inhouseuser.class, key);
		em.remove(record);
		et.commit();
	}

}
