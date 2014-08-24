package systemaccount.relationcheck;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.elementList.ElementName;
import systemaccount.service.InhouseuserInfo;

public class InhouseuserRelationCheck extends BaseRelationCheck {

	@Override
	public boolean exsistForeignKey(String param) {
		InhouseuserInfo inhusr = new InhouseuserInfo(ElementName.UserID);
		try {
			inhusr.getInhouseuserInfoByUserId(param);
		} catch (EntityExistsException e) {
			return true;
		}
		return false;
	}

}
