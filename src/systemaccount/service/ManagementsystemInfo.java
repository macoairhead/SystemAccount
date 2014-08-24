package systemaccount.service;

import java.util.List;

import systemaccount.model.Managementsystem;

public class ManagementsystemInfo extends BaseService {

	public ManagementsystemInfo(String key) {
		super(key);
	}

	public Managementsystem getManagementSystemInfoByManagementsystemId(
			String mngSysId) {
		return em.find(Managementsystem.class, mngSysId);
	}

	public List<Managementsystem> getManagementsystemInfoList() {
		return em.createQuery("select i from managementsystem i")
				.getResultList();
	}

}
