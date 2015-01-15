package systemaccount.relationcheck;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.ws.rs.core.Response;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.constantitem.ElementName;
import systemaccount.exception.RelationCheckException;
import systemaccount.service.PermissionInfo;

public class PermissionRelationCheck extends BaseRelationCheck {

	@Override
	public void exsistForeignKey(String id) {
	}

	public void exsistForeignKey(LinkedHashMap<ElementName, String> param) {
		ArrayList<ElementName> keyLst = new ArrayList<ElementName>(2);
		keyLst.set(0, ElementName.MngSystemID);
		keyLst.set(1, ElementName.PermID);
		PermissionInfo perm = new PermissionInfo(keyLst);
		try {
			perm.getPermissionInfoByPermissionId(param);
		} catch (EntityExistsException e) {
			throw new RelationCheckException(e,Response.Status.BAD_REQUEST,
					"権限がへん");
		}
	}

}
