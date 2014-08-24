package systemaccount.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-09-21T20:52:15.102+0900")
@StaticMetamodel(Unit.class)
public class Unit_ {
	public static volatile SingularAttribute<Unit, Date> inputDate;
	public static volatile SingularAttribute<Unit, Byte> isValid;
	public static volatile SingularAttribute<Unit, String> unitName;
	public static volatile SingularAttribute<Unit, Date> updateDate;
	public static volatile ListAttribute<Unit, Inhouseuser> inhouseusers;
	public static volatile SingularAttribute<Unit, Integer> unitID;
}
