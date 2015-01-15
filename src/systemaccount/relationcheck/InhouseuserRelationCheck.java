package systemaccount.relationcheck;

import javax.ws.rs.core.Response;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.constantitem.ElementName;
import systemaccount.exception.RelationCheckException;
import systemaccount.service.InhouseuserInfo;

public class InhouseuserRelationCheck extends BaseRelationCheck {

	@Override
	public void exsistForeignKey(String param) {
		InhouseuserInfo inhusr = new InhouseuserInfo(ElementName.UserID);
		try {
			inhusr.getInhouseuserInfoByUserId(param);
		} catch (EntityExistsException e) {
			throw new RelationCheckException(e, Response.Status.BAD_REQUEST,
					"ユーザがへん");
		}
	}

}
