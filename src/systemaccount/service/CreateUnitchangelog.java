package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Unitchangelog;

public class CreateUnitchangelog extends BaseService {

	public CreateUnitchangelog() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void createUnitchangelog(LinkedHashMap<ElementName, String> input) {

		EventID ev = EventID.valueOf(EventID.class,input.get(ElementName.UnitEventID));
		et.begin();
		Unitchangelog record = new Unitchangelog();
		record.setUnitID(Integer.parseInt(input.get(ElementName.UnitID)));
		record.setUnitName(input.get(ElementName.UnitName));
		record.setUnitEventID(ev.ordinal());
		record.setChangeDate(new Date());
		em.persist(record);
		et.commit();
	}

}
