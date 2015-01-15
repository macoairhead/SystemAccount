package systemaccount.relationcheck;

import javax.ws.rs.core.Response;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.constantitem.ElementName;
import systemaccount.exception.RelationCheckException;
import systemaccount.service.UnitInfo;

public class UnitRelationCheck extends BaseRelationCheck {

	@Override
	public void exsistForeignKey(String param) {
		UnitInfo inhusr = new UnitInfo(ElementName.UnitID);
		try {
			inhusr.getUnitByUnitId(param);
		} catch (EntityExistsException e) {
			throw new RelationCheckException(e, Response.Status.BAD_REQUEST,
					"所属がへん");
		}
	}

}
