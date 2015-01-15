package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Permissionchangelog;

public class CreatePermissionchangelog extends BaseService {

	public CreatePermissionchangelog() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void createPermissionchangelog(LinkedHashMap<ElementName, String> input) {

		EventID ev = EventID.valueOf(EventID.class,input.get(ElementName.PermEventID));
		et.begin();
		Permissionchangelog record = new Permissionchangelog();
		record.setManagementSystemID(Integer.parseInt(input.get(ElementName.MngSystemID)));
		record.setPermissionID(Integer.parseInt(input.get(ElementName.PermID)));
		record.setPermissionName(input.get(ElementName.PermName));
		record.setPermissionEventID(ev.ordinal());
		record.setChangeDate(new Date());
		em.persist(record);
		et.commit();
	}

}
