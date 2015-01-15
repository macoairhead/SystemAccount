package systemaccount.service;

import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;
import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;

public class CreatePermission extends BaseService {

	public CreatePermission(List<ElementName> k) {
		super(k);
	}

	public void createPermission(LinkedHashMap<ElementName, String> input) {

		et.begin();
		Permission record = new Permission();
		record.setPk(new PermissionPK());
		record.getPk().setManagementSystemID(
				Integer.parseInt(input.get(this.keyLst.get(0))));
		record.getPk().setPermissionID(
				Integer.parseInt(input.get(this.keyLst.get(1))));
		record.setPermissionName(input.get(ElementName.PermName));
		Managementsystem mngSys = new Managementsystem();
		mngSys.setManagementSystemID(Integer.parseInt(input.get(this.keyLst
				.get(0))));
		record.setManagementsystem(mngSys);
		em.merge(record);
		et.commit();
	}

}
