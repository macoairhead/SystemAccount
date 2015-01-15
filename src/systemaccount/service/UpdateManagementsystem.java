package systemaccount.service;

import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;

public class UpdateManagementsystem extends BaseService {

	public UpdateManagementsystem(ElementName key) {
		super(key);
	}

	public void updateManagementsystem(LinkedHashMap<ElementName, String> keyMap,
			LinkedHashMap<ElementName, String> input) {
		et.begin();
		Managementsystem record = em.find(Managementsystem.class,
				keyMap.get(this.key));
		if (input.containsKey(this.key)) {
			record.setManagementSystemID(Integer.parseInt(input.get(this.key)));
		}
		if (input.containsKey(ElementName.MngSystemName)) {
			record.setManagementSystemName(input.get(ElementName.MngSystemName));
		}
		em.merge(record);
		et.commit();
	}

}
