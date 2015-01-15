package systemaccount.service;

import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;
import systemaccount.model.Managementsystemchangelog;

public class ManagementsystemInfo extends BaseService {

	public ManagementsystemInfo(ElementName key) {
		super(key);
	}

	public Managementsystem getManagementSystemInfoByManagementsystemId(
			String mngSysId) {
		return em.find(Managementsystem.class, mngSysId);
	}

	public List<Managementsystem> getManagementsystemInfoList() {
		return em.createQuery("Managementsystem.findAll")
				.getResultList();
	}

	public List<Managementsystemchangelog> getManagementsystemchangelogList(){
		return em.createQuery("Managementsystemchangelog.findAll")
				.getResultList();
	}

}
