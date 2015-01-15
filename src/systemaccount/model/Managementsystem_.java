package systemaccount.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-09-21T20:50:16.303+0900")
@StaticMetamodel(Managementsystem.class)
public class Managementsystem_ {
	public static volatile SingularAttribute<Managementsystem, Date> inputDate;
	public static volatile SingularAttribute<Inhouseuser, Byte> isValid;
	public static volatile SingularAttribute<Managementsystem, String> managementSystemName;
	public static volatile SingularAttribute<Managementsystem, Date> updateDate;
	public static volatile ListAttribute<Managementsystem, Permission> permission;
	public static volatile SingularAttribute<Managementsystem, Integer> managementSystemID;
}
