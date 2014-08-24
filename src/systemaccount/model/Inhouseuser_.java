package systemaccount.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-09-21T20:48:30.088+0900")
@StaticMetamodel(Inhouseuser.class)
public class Inhouseuser_ {
	public static volatile SingularAttribute<Inhouseuser, Date> inputDate;
	public static volatile SingularAttribute<Inhouseuser, Byte> isValid;
	public static volatile SingularAttribute<Inhouseuser, Date> updateDate;
	public static volatile SingularAttribute<Inhouseuser, String> userNameFirst;
	public static volatile SingularAttribute<Inhouseuser, String> userNameLast;
	public static volatile SingularAttribute<Inhouseuser, Unit> unit;
	public static volatile ListAttribute<Inhouseuser, Userpermission> userpermissions;
	public static volatile SingularAttribute<Inhouseuser, Long> userID;
}
