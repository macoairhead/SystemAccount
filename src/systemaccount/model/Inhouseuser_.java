package systemaccount.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.199+0900")
@StaticMetamodel(Inhouseuser.class)
public class Inhouseuser_ {
	public static volatile SingularAttribute<Inhouseuser, BigInteger> userID;
	public static volatile SingularAttribute<Inhouseuser, String> userNameFirst;
	public static volatile SingularAttribute<Inhouseuser, String> userNameLast;
	public static volatile ListAttribute<Inhouseuser, Userpermission> userpermissions;
}
