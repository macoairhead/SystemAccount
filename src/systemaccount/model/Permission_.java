package systemaccount.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.238+0900")
@StaticMetamodel(Permission.class)
public class Permission_ {
	public static volatile SingularAttribute<Permission, PermissionPK> pk;
	public static volatile SingularAttribute<Permission, String> permissionName;
	public static volatile SingularAttribute<Permission, Managementsystem> managementsystem;
	public static volatile ListAttribute<Permission, Userpermission> userpermissions;
}
