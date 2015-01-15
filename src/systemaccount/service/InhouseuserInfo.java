package systemaccount.service;

import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Assignment;
import systemaccount.model.Inhouseuser;

public class InhouseuserInfo extends BaseService {

	public InhouseuserInfo(ElementName key) {
		super(key);
	}

	public Inhouseuser getInhouseuserInfoByUserId(String userId) {
		return em.find(Inhouseuser.class, userId);
	}

	public List<Inhouseuser> getInhouseuserInfoList() {
		return em.createNamedQuery("Inhouseuser.findAll").getResultList();
	}

	public List<Inhouseuser> getInhouseuserInfoByUnitId(String unitId) {
		return em
				.createQuery(
						"select i from Inhouseuser i where i.userID = "
								+ "(select max(a.id), a.userID from Assignment a where a.unitID = "
								+ unitId + " and a.assingmentEventID != "
								+ EventID.Resigned.ordinal() + ")")
				.getResultList();
	}

	public List<Assignment> getInhouseuserInfoAssignmentList() {
		return em.createNamedQuery("Assignment.findAll").getResultList();
	}

	public List<Assignment> getInhouseuserInfoResignedList() {
		return em.createNamedQuery(
				"select a from Assignment a where a.assingmentEventID = "
						+ EventID.Resigned.ordinal()).getResultList();
	}
	public List<Assignment> getInhouseuserInfoChangesList() {
		return em.createNamedQuery(
				"select a from Assignment a where a.assingmentEventID = "
						+ EventID.Changes.ordinal()).getResultList();
	}

}
