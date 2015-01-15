package systemaccount.itemcheck;

public class BaseItemCheck {

	protected int len;

	public boolean isEmpty(String param) {
		if (param.equals(null) || param.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean maxLen(String param) {
		if (param.length() > len) {
			return true;
		}
		return false;
	}

}
