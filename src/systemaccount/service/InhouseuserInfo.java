package systemaccount.service;

import java.util.List;

import systemaccount.model.Inhouseuser;

public class InhouseuserInfo extends BaseService {

	public InhouseuserInfo(String key) {
		super(key);
	}

	public Inhouseuser getInhouseuserInfoByUserId(String userId) {
		return em.find(Inhouseuser.class, userId);
	}

	public List<Inhouseuser> getInhouseuserInfoList() {
		return em.createQuery("select i from Inhouseuser i").getResultList();
	}

	public List<Inhouseuser> getInhouseuserInfoByUnitId(String unitId) {
		return em.createQuery(
				"select i from Inhouseuser i where i.unit.UnitID = " + unitId)
				.getResultList();
	}
}
