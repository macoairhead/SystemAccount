package systemaccount.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import systemaccount.json.ApplicationFault;

public class ItemCheckException extends WebApplicationException {

	public ItemCheckException() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
	}

	public ItemCheckException(Status sts, String msg) {
		super(Response.status(sts)
				.entity(new ApplicationFault("ItemCheckException", msg))
				.type(MediaType.APPLICATION_JSON_TYPE).build());
	}

	public ItemCheckException(Throwable cause, Status sts, String msg) {
		super(cause, Response.status(sts)
				.entity(new ApplicationFault(cause.getMessage(), msg))
				.type(MediaType.APPLICATION_JSON_TYPE).build());
	}

}
