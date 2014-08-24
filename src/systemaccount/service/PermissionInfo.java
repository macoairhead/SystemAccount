package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;

public class PermissionInfo extends BaseService {

	public PermissionInfo(List<String> k) {
		super(k);
	}

	public Permission getPermissionInfoByPermissionId(
			LinkedHashMap<String, String> param) {
		PermissionPK pk = new PermissionPK();
		pk.setManagementSystemID(Integer.parseInt(param.get(this.keyLst.get(0))));
		pk.setPermissionID(Integer.parseInt(param.get(this.keyLst.get(1))));
		return em.find(Permission.class, pk);
	}

	public List<Permission> getPermissionInfoList() {
		return em.createQuery("select i from permission i").getResultList();
	}

	public List<Permission> getPermissionInfoByMngSysId(String mngSysId) {
		return em.createQuery(
				"select i from permission i where i.managementsystem.ManagementsystemID = "
						+ mngSysId).getResultList();
	}

}
