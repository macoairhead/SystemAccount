package systemaccount.relationcheck;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.openjpa.persistence.EntityExistsException;

import systemaccount.elementList.ElementName;
import systemaccount.service.PermissionInfo;

public class PermissionRelationCheck extends BaseRelationCheck {

	@Override
	public boolean exsistForeignKey(String id) {
		return false;
	}

	public boolean exsistForeignKey(LinkedHashMap<String, String> param) {
		ArrayList<String> keyLst = new ArrayList<String>(2);
		keyLst.set(0, ElementName.MngSystemID);
		keyLst.set(1, ElementName.PermID);
		PermissionInfo perm = new PermissionInfo(keyLst);
		try {
			perm.getPermissionInfoByPermissionId(param);
		} catch (EntityExistsException e) {
			return true;
		}
		return false;
	}

}
