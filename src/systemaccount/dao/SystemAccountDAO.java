package systemaccount.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SystemAccountDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	/**
	 * @return emf
	 */
	public EntityManagerFactory getEmf() {
		return emf;
	}

	/**
	 * @return em
	 */
	public EntityManager getEm() {
		return em;
	}

	public SystemAccountDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		emf = Persistence.createEntityManagerFactory("SystemAccount");
		em = emf.createEntityManager();
	}

}
