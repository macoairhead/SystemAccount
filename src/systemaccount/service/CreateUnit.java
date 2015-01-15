package systemaccount.service;

import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Unit;

public class CreateUnit extends BaseService {

	public CreateUnit(ElementName key) {
		super(key);
	}

	public void createUnit(LinkedHashMap<ElementName, String> input) {

		et.begin();
		Unit record = new Unit();
		record.setUnitID(Integer.parseInt(input.get(this.key)));
		record.setUnitName(input.get(ElementName.UnitName));
		em.persist(record);
		et.commit();
	}

}
