package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.266+0900")
@StaticMetamodel(Unitchangelog.class)
public class Unitchangelog_ {
	public static volatile SingularAttribute<Unitchangelog, Date> changeDate;
	public static volatile SingularAttribute<Unitchangelog, BigInteger> id;
	public static volatile SingularAttribute<Unitchangelog, Integer> unitID;
	public static volatile SingularAttribute<Unitchangelog, String> unitName;
	public static volatile SingularAttribute<Unitchangelog, Integer> unitEventID;
}
