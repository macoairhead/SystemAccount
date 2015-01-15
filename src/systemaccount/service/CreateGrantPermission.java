package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Grantpermission;

public class CreateGrantPermission extends BaseService {

	public CreateGrantPermission() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void createGrantPermission(LinkedHashMap<ElementName, String> input) {

		EventID ev = EventID.valueOf(EventID.class,input.get(ElementName.GrantPermEventID));
		et.begin();
		Grantpermission record = new Grantpermission();
		record.setUserID(new BigInteger(input.get(ElementName.UserID)));
		record.setLoginID(input.get(ElementName.LoginID));
		record.setManagementSystemID(Integer.parseInt(input.get(ElementName.MngSystemID)));
		record.setPermissionID(Integer.parseInt(input.get(ElementName.PermID)));
		record.setGrantEventID(ev.ordinal());
		record.setGrantDate(new Date());
		em.merge(record);
		et.commit();
	}

}
