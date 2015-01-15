package systemaccount.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import systemaccount.elementList.ElementName;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;

public class UpdateUserpermission extends BaseService {

	public UpdateUserpermission(List<String> k) {
		super(k);
	}

	public void updateUserpermission(LinkedHashMap<String, String> k,
			LinkedHashMap<String, String> input) throws Exception {
		et.begin();
		UserpermissionPK pk = new UserpermissionPK();
		pk.setLoginID(k.get(this.keyLst.get(0)));
		pk.setManagementSystemID(Integer.parseInt(k.get(this.keyLst.get(1))));
		pk.setPermissionID(Integer.parseInt(k.get(this.keyLst.get(2))));
		Userpermission record = em.find(Userpermission.class, pk);
		if (input.containsKey(this.keyLst.get(0))
				|| input.containsKey(this.keyLst.get(1))
				|| input.containsKey(this.keyLst.get(2))) {
			Userpermission newRecord = new Userpermission();
			newRecord.setPk(new UserpermissionPK());
			newRecord.setInhouseuser(new Inhouseuser());

			if (input.containsKey(ElementName.UserID)) {
				newRecord.getInhouseuser().setUserID(
						new BigInteger(input.get(ElementName.UserID)));
			} else {
				newRecord.getInhouseuser().setUserID(
						record.getInhouseuser().getUserID());
			}
			if (input.containsKey(ElementName.IsValid)) {
				newRecord.setIsValid(new Byte(input.get(ElementName.IsValid)));
			} else {
				newRecord.setIsValid(record.getIsValid());
			}
			if (input.containsKey(this.keyLst.get(0))) {
				newRecord.getPk().setLoginID(input.get(this.keyLst.get(0)));
			} else {
				newRecord.getPk().setLoginID(record.getPk().getLoginID());
			}
			if (input.containsKey(this.keyLst.get(1))) {
				newRecord.getPk().setManagementSystemID(
						Integer.parseInt(input.get(this.keyLst.get(1))));
			} else {
				newRecord.getPk().setManagementSystemID(
						record.getPk().getManagementSystemID());
			}
			if (input.containsKey(this.keyLst.get(2))) {
				newRecord.getPk().setPermissionID(
						Integer.parseInt(input.get(this.keyLst.get(2))));
			} else {
				newRecord.getPk().setPermissionID(
						record.getPk().getPermissionID());
			}
			newRecord.setInputDate(new Date());
			newRecord.setUpdateDate(new Date());
			em.merge(newRecord);
			em.remove(record);
		} else {
			if (input.containsKey(ElementName.UserID)) {
				record.getInhouseuser().setUserID(
						new BigInteger(input.get(ElementName.UserID)));
			}
			if (input.containsKey(ElementName.IsValid)) {
				record.setIsValid(new Byte(input.get(ElementName.IsValid)));
			}
			record.setUpdateDate(new Date());
			em.merge(record);
		}
		et.commit();

	}

}
