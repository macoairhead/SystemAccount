package systemaccount.service;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;

public class DeleteManagementsystem extends BaseService {

	public DeleteManagementsystem(ElementName key) {
		super(key);
	}

	public void deleteManagementsystem(String param) {
		et.begin();
		Managementsystem record = em.find(Managementsystem.class, param);
		em.remove(record);
		et.commit();
	}
}
