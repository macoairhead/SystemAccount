package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.elementList.ElementName;
import systemaccount.model.Managementsystem;

public class CreateManagementsystem extends BaseService {

	public CreateManagementsystem(String key) {
		super(key);
	}

	public void createManagementsystem(LinkedHashMap<String, String> input) {

		et.begin();
		Managementsystem record = new Managementsystem();
		record.setManagementSystemID(Integer.parseInt(input.get(this.key)));
		record.setInputDate(new Date());
		record.setUpdateDate(new Date());
		record.setManagementSystemName(input.get(ElementName.MngSystemName));
		em.persist(record);
		et.commit();
	}

}
