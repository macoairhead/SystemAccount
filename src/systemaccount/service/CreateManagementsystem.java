package systemaccount.service;

import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Managementsystem;

public class CreateManagementsystem extends BaseService {

	public CreateManagementsystem(ElementName key) {
		super(key);
	}

	public void createManagementsystem(LinkedHashMap<ElementName, String> input) {

		et.begin();
		Managementsystem record = new Managementsystem();
		record.setManagementSystemID(Integer.parseInt(input.get(this.key)));
		record.setManagementSystemName(input.get(ElementName.MngSystemName));
		em.persist(record);
		et.commit();
	}

}
