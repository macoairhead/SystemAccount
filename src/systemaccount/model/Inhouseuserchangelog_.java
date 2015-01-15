package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-02T19:09:36.676+0900")
@StaticMetamodel(Inhouseuserchangelog.class)
public class Inhouseuserchangelog_ {
	public static volatile SingularAttribute<Inhouseuserchangelog, Date> changeDate;
	public static volatile SingularAttribute<Inhouseuserchangelog, BigInteger> id;
	public static volatile SingularAttribute<Inhouseuserchangelog, Integer> inhouseuserEventID;
	public static volatile SingularAttribute<Inhouseuserchangelog, BigInteger> userID;
	public static volatile SingularAttribute<Inhouseuserchangelog, String> userNameFirst;
	public static volatile SingularAttribute<Inhouseuserchangelog, String> userNameLast;
}
