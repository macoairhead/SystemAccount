package systemaccount.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import systemaccount.json.ApplicationFault;

public class RelationCheckException extends WebApplicationException {

	public RelationCheckException() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
	}

	public RelationCheckException(Status sts, String msg) {
		super(Response.status(sts)
				.entity(new ApplicationFault("RelationCheckException", msg))
				.type(MediaType.APPLICATION_JSON_TYPE).build());
	}

	public RelationCheckException(Throwable cause, Status sts, String msg) {
		super(cause, Response.status(sts)
				.entity(new ApplicationFault(cause.getMessage(), msg))
				.type(MediaType.APPLICATION_JSON_TYPE).build());
	}

}
