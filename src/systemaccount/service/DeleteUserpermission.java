package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;

public class DeleteUserpermission extends BaseService {

	public DeleteUserpermission(List<String> param) {
		super(param);
	}

	public void deleteUserpermission(LinkedHashMap<String, String> input) {
		et.begin();
		UserpermissionPK pk = new UserpermissionPK();
		pk.setLoginID(input.get(this.keyLst.get(0)));
		pk.setManagementSystemID(Integer.parseInt(input.get(this.keyLst.get(1))));
		pk.setPermissionID(Integer.parseInt(input.get(this.keyLst.get(2))));
		Userpermission record = em.find(Userpermission.class, pk);
		em.remove(record);
		et.commit();

	}
}
