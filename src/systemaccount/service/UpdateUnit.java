package systemaccount.service;

import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.model.Unit;

public class UpdateUnit extends BaseService {

	public UpdateUnit(ElementName key) {
		super(key);
	}

	public void updateUnit(LinkedHashMap<ElementName, String> k,
			LinkedHashMap<ElementName, String> input) {
		et.begin();
		Unit record = em.find(Unit.class, k.get(this.key));
		if (input.containsKey(this.key)) {
			record.setUnitID(Integer.parseInt(input.get(this.key)));
		}
		if (input.containsKey(ElementName.UnitName)) {
			record.setUnitName(input.get(ElementName.UnitName));
		}
		em.merge(record);
		et.commit();
	}

}
