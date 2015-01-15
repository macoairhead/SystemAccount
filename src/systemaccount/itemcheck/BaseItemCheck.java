package systemaccount.itemcheck;

import javax.ws.rs.core.Response;

import systemaccount.exception.ItemCheckException;

public class BaseItemCheck {

	protected int len;

	public void isEmpty(String param) {
		if (param.equals(null) || param.isEmpty()) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}
	}

	public void maxLen(String param) {
		if (param.length() > len) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}
	}

}
