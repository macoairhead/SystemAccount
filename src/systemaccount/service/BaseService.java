package systemaccount.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import systemaccount.dao.SystemAccountDAO;

public class BaseService {

	protected static EntityManager em;
	protected static EntityTransaction et;
	protected String key;
	protected List<String> keyLst;

	protected BaseService() {
		this.getEM();
	}

	protected BaseService(String strKey) {
		this.getEM();
		key = strKey;
	}

	protected BaseService(List<String> param) {
		this.getEM();
		keyLst = param;
	}

	private void getEM() {
		em = (new SystemAccountDAO()).getEm();
		et = em.getTransaction();

	}
}
