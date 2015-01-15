package systemaccount.json.webresource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;

import systemaccount.constantitem.ElementName;

@RequestScoped
@Resource(name = "jdbc/MARIA_JDBC")
public abstract class BaseResource {

	protected ElementName key;
	protected List<ElementName> keys;

	public BaseResource() {
		super();
	}

	public BaseResource(ElementName k) {
		super();
		this.key = k;
	}

	public BaseResource(List<ElementName> k) {
		super();
		this.keys = k;
	}

	// リクエスト
	public abstract Object getItem(String obj) throws Exception;

	public abstract <T> List<T> getList() throws Exception;

	public abstract void createItem(LinkedHashMap<String, String> input)
			throws Exception;

	public abstract void updateItem(
			ArrayList<LinkedHashMap<String, String>> input) throws Exception;

	public abstract void deleteItem(String str) throws Exception;

	// チェック処理
	abstract void check(String obj) throws Exception;

}
