package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-02T10:18:38.711+0900")
@StaticMetamodel(Managementsystemchangelog.class)
public class Managementsystemchangelog_ {
	public static volatile SingularAttribute<Managementsystemchangelog, Date> changeDate;
	public static volatile SingularAttribute<Managementsystemchangelog, BigInteger> id;
	public static volatile SingularAttribute<Managementsystemchangelog, Integer> managementSystemEventID;
	public static volatile SingularAttribute<Managementsystemchangelog, Integer> managementSystemID;
	public static volatile SingularAttribute<Managementsystemchangelog, String> managementSystemName;
}
