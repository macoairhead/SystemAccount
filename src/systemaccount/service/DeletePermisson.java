package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;

public class DeletePermisson extends BaseService {

	public DeletePermisson() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public DeletePermisson(List<String> k) {
		super(k);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void deletePermission(LinkedHashMap<String, String> input) {
		et.begin();
		PermissionPK pk = new PermissionPK();
		pk.setManagementSystemID(Integer.parseInt(input.get(this.keyLst.get(0))));
		pk.setPermissionID(Integer.parseInt(input.get(this.keyLst.get(1))));
		Permission record = em.find(Permission.class, pk);
		em.remove(record);
		et.commit();
	}

}
