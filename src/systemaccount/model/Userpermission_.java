package systemaccount.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.278+0900")
@StaticMetamodel(Userpermission.class)
public class Userpermission_ {
	public static volatile SingularAttribute<Userpermission, UserpermissionPK> pk;
	public static volatile SingularAttribute<Userpermission, Inhouseuser> inhouseuser;
	public static volatile SingularAttribute<Userpermission, Permission> permission;
}
