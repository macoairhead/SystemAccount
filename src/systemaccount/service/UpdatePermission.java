package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;
import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;

public class UpdatePermission extends BaseService {

	public UpdatePermission(List<ElementName> k) {
		super(k);
	}

	public void updatePermission(LinkedHashMap<ElementName, String> keyMap,
			LinkedHashMap<ElementName, String> input) {
		et.begin();
		PermissionPK pk = new PermissionPK();
		pk.setManagementSystemID(Integer.parseInt(keyMap.get(this.keyLst.get(0))));
		pk.setPermissionID(Integer.parseInt(keyMap.get(this.keyLst.get(1))));
		Permission record = em.find(Permission.class, pk);
		if (input.containsKey(ElementName.PermName)) {
			record.setPermissionName(input.get(ElementName.PermName));
		}
		if (input.containsKey(this.keyLst.get(0))) {
			record.setManagementsystem(new Managementsystem());
			record.getPk().setManagementSystemID(
					Integer.parseInt(input.get(this.keyLst.get(0))));
		}
		if (input.containsKey(this.keyLst.get(1))) {
			record.getPk().setPermissionID(
					Integer.parseInt(input.get(this.keyLst.get(1))));
		}
		em.merge(record);
		et.commit();
	}
}
