package systemaccount.json.webresource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Resource(name = "jdbc/MARIA_JDBC")
public abstract class BaseResource {

	protected String key;
	protected List<String> keys;

	public BaseResource() {
		super();
	}

	public BaseResource(String k) {
		super();
		this.key = k;
	}

	public BaseResource(List<String> k) {
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
