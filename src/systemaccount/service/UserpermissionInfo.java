package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;

public class UserpermissionInfo extends BaseService {

	public UserpermissionInfo(List<ElementName> k) {
		super(k);
	}

	public Userpermission getUserpermissionByPK(
			LinkedHashMap<ElementName, String> keys) {
		UserpermissionPK pk = new UserpermissionPK();
		pk.setLoginID(keys.get(this.keyLst.get(0)));
		pk.setManagementSystemID(Integer.parseInt(keys.get(this.keyLst.get(1))));
		pk.setPermissionID(Integer.parseInt(keys.get(this.keyLst.get(2))));
		return em.find(Userpermission.class, pk);
	}

	public List<Userpermission> getUserpermissionInfoList() {
		return em.createQuery("Userpermission.findAll").getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListByMngSysID(
			String mngSysId) {
		return em.createQuery(
				"select u from Userpermission u where u.managementsystem.ManagementSystemID = "
						+ mngSysId).getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListByPermID(String permId) {
		return em.createQuery(
				"select u from Userpermission u where u.permission.PermissionID = "
						+ permId).getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListByLoginID(
			String loginId) {
		return em
				.createQuery(
						"select u from userpermission u where u.loginID = "
								+ loginId).getResultList();
	}

}
