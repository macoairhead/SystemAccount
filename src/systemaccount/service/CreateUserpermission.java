package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.elementList.ElementName;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;

public class CreateUserpermission extends BaseService {

	public CreateUserpermission(List<String> k) {
		super(k);
	}

	public void createUserpermission(LinkedHashMap<String, String> input) {
		et.begin();
		Userpermission record = new Userpermission();
		record.setPk(new UserpermissionPK());
		record.getPk().setLoginID(input.get(this.keyLst.get(0)));
		record.getPk().setManagementSystemID(
				Integer.parseInt(input.get(this.keyLst.get(1))));
		record.getPk().setPermissionID(
				Integer.parseInt(input.get(this.keyLst.get(2))));
		Inhouseuser inhusr = new Inhouseuser();
		inhusr.setUserID(new BigInteger(input.get(ElementName.UserID)));
		record.setInhouseuser(inhusr);
		record.setInputDate(new Date());
		record.setUpdateDate(new Date());
		em.merge(record);
		et.commit();
	}
}
