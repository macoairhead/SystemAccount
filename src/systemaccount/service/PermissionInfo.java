package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;
import systemaccount.model.Permissionchangelog;

public class PermissionInfo extends BaseService {

	public PermissionInfo(List<ElementName> k) {
		super(k);
	}

	public Permission getPermissionInfoByPermissionId(
			LinkedHashMap<ElementName, String> param) {
		PermissionPK pk = new PermissionPK();
		pk.setManagementSystemID(Integer.parseInt(param.get(this.keyLst.get(0))));
		pk.setPermissionID(Integer.parseInt(param.get(this.keyLst.get(1))));
		return em.find(Permission.class, pk);
	}

	public List<Permission> getPermissionInfoList() {
		return em.createQuery("Permission.findAll").getResultList();
	}

	public List<Permission> getPermissionInfoByMngSysId(String mngSysId) {
		return em.createQuery(
				"select p from Permission p where p.managementsystem.ManagementsystemID = "
						+ mngSysId).getResultList();
	}

	public List<Permissionchangelog> getPermissionInfoChangeList() {
		return em.createQuery("Permissionchangelog.findAll").getResultList();
	}


}
