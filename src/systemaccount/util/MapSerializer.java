package systemaccount.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import systemaccount.constantitem.ElementName;

public class MapSerializer {

	public MapSerializer() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public LinkedHashMap<ElementName, String> serialize (LinkedHashMap<String,String> param){
		LinkedHashMap<ElementName, String> r = new LinkedHashMap<ElementName, String>();
		for(Iterator<Entry<String, String>> it = param.entrySet().iterator(); it.hasNext();){
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			r.put(ElementName.valueOf(entry.getKey()), entry.getValue());
		}

		return r;

	}

}
