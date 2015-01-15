package systemaccount.relationcheck;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.elementList.ElementName;
import systemaccount.service.ManagementsystemInfo;

public class ManagementsystemRelationCheck extends BaseRelationCheck {

	@Override
	public boolean exsistForeignKey(String param) {
		ManagementsystemInfo inhusr = new ManagementsystemInfo(
				ElementName.MngSystemID);
		try {
			inhusr.getManagementSystemInfoByManagementsystemId(param);
		} catch (EntityExistsException e) {
			return true;
		}
		return false;
	}

}
