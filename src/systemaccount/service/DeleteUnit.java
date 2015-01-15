package systemaccount.service;

import systemaccount.model.Unit;

public class DeleteUnit extends BaseService {

	public DeleteUnit(String key) {
		super(key);
	}

	public void deleteUnit(String unitId) {
		et.begin();
		Unit record = em.find(Unit.class, unitId);
		em.remove(record);
		et.commit();
	}

}
