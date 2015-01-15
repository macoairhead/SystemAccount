package systemaccount.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-09-21T23:39:29.150+0900")
@StaticMetamodel(Userpermission.class)
public class Userpermission_ {
	public static volatile SingularAttribute<Userpermission, Date> inputDate;
	public static volatile SingularAttribute<Userpermission, Inhouseuser> inhouseuser;
	public static volatile SingularAttribute<Userpermission, Date> updateDate;
	public static volatile SingularAttribute<Userpermission, Permission> permission;
	public static volatile SingularAttribute<Userpermission, UserpermissionPK> pk;
}
