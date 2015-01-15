package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-02T10:18:38.725+0900")
@StaticMetamodel(Permissionchangelog.class)
public class Permissionchangelog_ {
	public static volatile SingularAttribute<Permissionchangelog, Date> changeDate;
	public static volatile SingularAttribute<Permissionchangelog, BigInteger> id;
	public static volatile SingularAttribute<Permissionchangelog, Integer> managementSystemID;
	public static volatile SingularAttribute<Permissionchangelog, Integer> permissionEventID;
	public static volatile SingularAttribute<Permissionchangelog, Integer> permissionID;
	public static volatile SingularAttribute<Permissionchangelog, String> permissionName;
}
