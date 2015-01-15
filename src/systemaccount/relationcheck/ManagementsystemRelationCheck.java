package systemaccount.relationcheck;

import javax.ws.rs.core.Response;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.constantitem.ElementName;
import systemaccount.exception.RelationCheckException;
import systemaccount.service.ManagementsystemInfo;

public class ManagementsystemRelationCheck extends BaseRelationCheck {

	@Override
	public void exsistForeignKey(String param) {
		ManagementsystemInfo inhusr = new ManagementsystemInfo(
				ElementName.MngSystemID);
		try {
			inhusr.getManagementSystemInfoByManagementsystemId(param);
		} catch (EntityExistsException e) {
			throw new RelationCheckException(e, Response.Status.BAD_REQUEST,
					"対象システムがへん");
		}
	}

}
