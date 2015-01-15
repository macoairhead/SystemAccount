package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-02T15:19:57.934+0900")
@StaticMetamodel(Assignmentchangelog.class)
public class Assignmentchangelog_ {
	public static volatile SingularAttribute<Assignmentchangelog, Integer> assignmentEventID;
	public static volatile SingularAttribute<Assignmentchangelog, Date> changeDate;
	public static volatile SingularAttribute<Assignmentchangelog, BigInteger> id;
	public static volatile SingularAttribute<Assignmentchangelog, Integer> unitID;
	public static volatile SingularAttribute<Assignmentchangelog, String> unitName;
	public static volatile SingularAttribute<Assignmentchangelog, BigInteger> userID;
	public static volatile SingularAttribute<Assignmentchangelog, String> userNameFirst;
	public static volatile SingularAttribute<Assignmentchangelog, String> userNameLast;
}
