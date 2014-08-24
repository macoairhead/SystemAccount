package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.elementList.ElementName;
import systemaccount.model.Unit;

public class CreateUnit extends BaseService {

	public CreateUnit(String key) {
		super(key);
	}

	public void createUnit(LinkedHashMap<String, String> input) {

		et.begin();
		Unit record = new Unit();
		record.setUnitID(Integer.parseInt(input.get(ElementName.UnitID)));
		record.setInputDate(new Date());
		record.setUpdateDate(new Date());
		record.setUnitName(input.get(ElementName.UnitName));
		em.persist(record);
		et.commit();
	}

}
