package systemaccount.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.167+0900")
@StaticMetamodel(Grantpermission.class)
public class Grantpermission_ {
	public static volatile SingularAttribute<Grantpermission, Date> grantDate;
	public static volatile SingularAttribute<Grantpermission, BigInteger> id;
	public static volatile SingularAttribute<Grantpermission, String> loginID;
	public static volatile SingularAttribute<Grantpermission, Integer> managementSystemID;
	public static volatile SingularAttribute<Grantpermission, Integer> permissionID;
	public static volatile SingularAttribute<Grantpermission, BigInteger> userID;
	public static volatile SingularAttribute<Grantpermission, Integer> grantEventID;
}
