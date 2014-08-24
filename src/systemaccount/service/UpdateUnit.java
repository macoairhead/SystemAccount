package systemAccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemAccount.elementList.ElementName;
import systemAccount.model.Unit;

public class UpdateUnit extends BaseService {

	public UpdateUnit(String key) {
		super(key);
	}

	public void updateUnit(LinkedHashMap<String, String> k,
			LinkedHashMap<String, String> input) {
		et.begin();
		Unit record = em.find(Unit.class, k.get(this.key));
		if (input.containsKey(this.key)) {
			record.setUnitID(Integer.parseInt(input.get(this.key)));
		}
		record.setUpdateDate(new Date());
		if (input.containsKey(ElementName.UnitName)) {
			record.setUnitName(input.get(ElementName.UnitName));
		}
		em.merge(record);
		et.commit();
	}

}
