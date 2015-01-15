package systemaccount.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-23T12:33:39.211+0900")
@StaticMetamodel(Managementsystem.class)
public class Managementsystem_ {
	public static volatile SingularAttribute<Managementsystem, Integer> managementSystemID;
	public static volatile SingularAttribute<Managementsystem, String> managementSystemName;
	public static volatile ListAttribute<Managementsystem, Permission> permissions;
}
