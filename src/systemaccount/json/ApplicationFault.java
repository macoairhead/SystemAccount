package systemaccount.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ApplicationFault")
public class ApplicationFault implements Serializable {

	private static final long serialVersionUID = 1L;

	public ApplicationFault() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
	}

	private String error;
	private String messages;

	public ApplicationFault(String err, String msg) {
		this();
		this.setError(err);
		this.setMessages(msg);
	}

	@XmlElement
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@XmlElement
	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}
