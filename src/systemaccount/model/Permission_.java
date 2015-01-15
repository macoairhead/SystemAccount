package systemaccount.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-09-21T20:46:42.336+0900")
@StaticMetamodel(Permission.class)
public class Permission_ {
	public static volatile SingularAttribute<Permission, Date> inputDate;
	public static volatile SingularAttribute<Permission, Byte> isValid;
	public static volatile SingularAttribute<Permission, String> permissionName;
	public static volatile SingularAttribute<Permission, Managementsystem> managementsystem;
	public static volatile SingularAttribute<Permission, Date> updateDate;
	public static volatile SingularAttribute<Userpermission, PermissionPK> pk;
	public static volatile ListAttribute<Permission, Userpermission> userpermissions;
}
