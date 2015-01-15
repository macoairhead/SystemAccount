package systemaccount.service;

import java.util.Date;
import java.util.LinkedHashMap;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.model.Inhouseuserchangelog;

public class CreateInhouseuserchangelog extends BaseService {

	public CreateInhouseuserchangelog() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void createInhouseuserchangelog(LinkedHashMap<ElementName, String> input) {

		EventID ev = EventID.valueOf(EventID.class,input.get(ElementName.MngSystemEventID));
		et.begin();
		Inhouseuserchangelog record = new Inhouseuserchangelog();
		record.setManagementSystemID(Integer.parseInt(input.get(ElementName.MngSystemID)));
		record.setManagementSystemName(input.get(ElementName.PermID));
		record.setManagementSystemEventID(ev.ordinal());
		record.setChangeDate(new Date());
		em.merge(record);
		et.commit();
	}

}
