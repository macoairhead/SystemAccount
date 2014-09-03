package systemaccount.service;

import java.util.List;

import systemaccount.model.Unit;

public class UnitInfo extends BaseService {

	public UnitInfo(String key) {
		super(key);
	}

	public Unit getUnitByUnitId(String unitId) {
		return em.find(Unit.class, Integer.parseInt(unitId));
	}

	public List<Unit> getUnitInfoList() {
		return em.createQuery("select i from Unit i").getResultList();
	}
}
