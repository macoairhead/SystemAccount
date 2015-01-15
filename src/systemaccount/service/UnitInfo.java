package systemaccount.service;

import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Unit;
import systemaccount.model.Unitchangelog;

public class UnitInfo extends BaseService {

	public UnitInfo(ElementName key) {
		super(key);
	}

	public Unit getUnitByUnitId(String unitId) {
		return em.find(Unit.class, Integer.parseInt(unitId));
	}

	public List<Unit> getUnitInfoList() {
		return em.createQuery("Unit.findAll").getResultList();
	}
	public List<Unitchangelog> getUnitInfoChangeList() {
		return em.createQuery("Unitchangelog.findAll").getResultList();
	}
}
