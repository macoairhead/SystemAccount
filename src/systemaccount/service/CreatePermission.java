package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.elementList.ElementName;
import systemaccount.model.Managementsystem;
import systemaccount.model.Permission;
import systemaccount.model.PermissionPK;

public class CreatePermission extends BaseService {

	public CreatePermission(List<String> k) {
		super(k);
	}

	public void createPermission(LinkedHashMap<String, String> input) {

		et.begin();
		Permission record = new Permission();
		record.setPk(new PermissionPK());
		record.getPk().setManagementSystemID(
				Integer.parseInt(input.get(this.keyLst.get(0))));
		record.getPk().setPermissionID(
				Integer.parseInt(input.get(this.keyLst.get(1))));
		record.setIsValid((byte) 0);
		record.setInputDate(new Date());
		record.setUpdateDate(new Date());
		record.setPermissionName(input.get(ElementName.PermName));
		Managementsystem mngSys = new Managementsystem();
		mngSys.setManagementSystemID(Integer.parseInt(input.get(this.keyLst
				.get(0))));
		record.setManagementsystem(mngSys);
		em.merge(record);
		et.commit();
	}

}
