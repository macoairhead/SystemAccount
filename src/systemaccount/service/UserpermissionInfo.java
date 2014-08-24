package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;

public class UserpermissionInfo extends BaseService {

	public UserpermissionInfo(List<String> k) {
		super(k);
	}

	public Userpermission getUserpermissionByPK(
			LinkedHashMap<String, String> keys) {
		UserpermissionPK pk = new UserpermissionPK();
		pk.setLoginID(keys.get(this.keyLst.get(0)));
		pk.setManagementSystemID(Integer.parseInt(keys.get(this.keyLst.get(1))));
		pk.setPermissionID(Integer.parseInt(keys.get(this.keyLst.get(2))));
		return em.find(Userpermission.class, pk);
	}

	public List<Userpermission> getUserpermissionInfoList() {
		return em.createQuery("select i from unit i").getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListByMngSysID(
			String mngSysId) {
		return em.createQuery(
				"select i from userpermission i where i.managementsystem.ManagementSystemID = "
						+ mngSysId).getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListByPermID(String permId) {
		return em.createQuery(
				"select i from userpermission i where i.permission.PermissionID = "
						+ permId).getResultList();
	}

	public List<Userpermission> getUserpermissionInfoListBySysUsrID(
			String sysUsrId) {
		return em
				.createQuery(
						"select i from userpermission i where i.systemuserbind.ManagementSystemUserID = "
								+ sysUsrId).getResultList();
	}

}
