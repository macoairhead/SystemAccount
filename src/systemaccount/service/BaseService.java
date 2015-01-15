package systemaccount.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import systemaccount.constantitem.ElementName;
import systemaccount.dao.SystemAccountDAO;

public class BaseService {

	protected static EntityManager em;
	protected static EntityTransaction et;
	protected ElementName key;
	protected List<ElementName> keyLst;

	protected BaseService() {
		this.getEM();
	}

	protected BaseService(ElementName strKey) {
		this.getEM();
		key = strKey;
	}

	protected BaseService(List<ElementName> param) {
		this.getEM();
		keyLst = param;
	}

	private void getEM() {
		em = (new SystemAccountDAO()).getEm();
		et = em.getTransaction();

	}
}
