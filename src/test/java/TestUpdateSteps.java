package test.java;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import systemaccount.elementList.ElementName;
import systemaccount.json.webresource.InhouseuserResource;
import systemaccount.json.webresource.ManagementsystemResource;
import systemaccount.json.webresource.PermissionResource;
import systemaccount.json.webresource.UnitResource;
import systemaccount.json.webresource.UserpermissionResource;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Managementsystem;
import systemaccount.model.Permission;
import systemaccount.model.Unit;
import systemaccount.model.Userpermission;

public class TestUpdateSteps {

	private Inhouseuser inhusr;
	private Unit unit;
	private Managementsystem mngSys;
	private Permission perm;
	private Userpermission userPerm;

	@Given("ユーザID $UserID を更新します")
	public void givenUpdateUser(@Named("UserID") String id) throws Exception {
		inhusr = (new InhouseuserResource()).getItem(id);
	}

	@When("名前を $UserNameFirst $UserNameLast に変更します")
	public void whenUpdateUser(@Named("UserNameFirst") String userNameFirst,
			@Named("UserNameLast") String userNameLast) throws Exception {
		LinkedHashMap<String, String> key = new LinkedHashMap<String, String>();
		key.put(ElementName.UserID, inhusr.getUserID().toString());
		LinkedHashMap<String, String> detail = new LinkedHashMap<String, String>();
		detail.put(ElementName.UserNameFirst, userNameFirst);
		detail.put(ElementName.UserNameLast, userNameLast);
		ArrayList<LinkedHashMap<String, String>> list = new ArrayList(2);
		list.add(key);
		list.add(detail);
		(new InhouseuserResource()).updateItem(list);
		inhusr = (new InhouseuserResource()).getItem(key
				.get(ElementName.UserID));

	}

	@Then("以下が表示されていること $userTable")
	public void thenTheResultShouldEqualToTheUser(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(inhusr.getUserID(),
					is(new BigInteger(row.get("UserID"))));
			assertThat(inhusr.getUserNameFirst(), is(row.get("UserNameFirst")));
			assertThat(inhusr.getUserNameLast(), is(row.get("UserNameLast")));
		}
	}

	@Given("部署ID $UnitID を更新します")
	public void givenUpdateUnit(@Named("UnitID") String id) throws Exception {
		unit = (new UnitResource()).getItem(id);
	}

	@When("部署名を $UnitName に変更します")
	public void whenUpdateUnit(@Named("UnitName") String unitName)
			throws Exception {
		LinkedHashMap<String, String> key = new LinkedHashMap<String, String>();
		key.put(ElementName.UnitID, Integer.toString(unit.getUnitID()));
		LinkedHashMap<String, String> detail = new LinkedHashMap<String, String>();
		detail.put(ElementName.UnitName, unitName);
		ArrayList<LinkedHashMap<String, String>> list = new ArrayList(2);
		list.add(key);
		list.add(detail);
		(new UnitResource()).updateItem(list);
		unit = (new UnitResource()).getItem(key.get(ElementName.UnitID));

	}

	@Then("以下の部署が表示されていること $unitTable")
	public void thenTheResultShouldEqualToTheUnit(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(unit.getUnitID(),
					is(Integer.parseInt(row.get("UnitID"))));
			assertThat(unit.getUnitName(), is(row.get("UnitName")));
		}
	}

	@Given("管理システムID $MngSysID を更新します")
	public void givenUpdateManagementSystem(@Named("MngSysID") String id)
			throws Exception {
		mngSys = (new ManagementsystemResource()).getItem(id);
	}

	@When("名前を $MngSysName に変更します")
	public void whenUpdateManagementSystem(
			@Named("MngSysName") String mngSysName) throws Exception {
		LinkedHashMap<String, String> key = new LinkedHashMap<String, String>();
		key.put(ElementName.MngSystemID,
				Integer.toString(mngSys.getManagementSystemID()));
		LinkedHashMap<String, String> detail = new LinkedHashMap<String, String>();
		detail.put(ElementName.MngSystemName, mngSysName);
		ArrayList<LinkedHashMap<String, String>> list = new ArrayList(2);
		list.add(key);
		list.add(detail);
		(new ManagementsystemResource()).updateItem(list);
		mngSys = (new ManagementsystemResource()).getItem(key
				.get(ElementName.MngSystemID));

	}

	@Then("以下の管理システムが表示されていること $MngSysTable")
	public void thenTheResultShouldEqualToTheManagementSystem(
			ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(mngSys.getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(mngSys.getManagementSystemName(),
					is(row.get("ManagementSystemName")));
		}
	}

	@Given("管理システムID、権限ID $MngSysID $PermID を更新します")
	public void givenUpdatePermission(@Named("MngSysID") String sysId,
			@Named("PermID") String permId) throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		input.put(ElementName.MngSystemID, sysId);
		input.put(ElementName.PermID, permId);
		perm = new PermissionResource().getItem(input);
	}

	@When("権限名を $PermName に変更します")
	public void whenUpdatePermission(@Named("PermName") String permName)
			throws Exception {
		ArrayList<LinkedHashMap<String, String>> list = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> keys = new LinkedHashMap<String, String>();
		keys.put(ElementName.MngSystemID,
				Integer.toString(perm.getPk().getManagementSystemID()));
		keys.put(ElementName.PermID,
				Integer.toString(perm.getPk().getPermissionID()));
		LinkedHashMap<String, String> param = new LinkedHashMap<String, String>();
		param.put(ElementName.PermName, permName);
		list.add(0, keys);
		list.add(1, param);
		new PermissionResource().updateItem(list);
		perm = new PermissionResource().getItem(keys);
	}

	@Then("以下の権限が表示されていること $permTable")
	public void thenTheResultShouldEqualToThePermission(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(perm.getPk().getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(perm.getPk().getPermissionID(),
					is(Integer.parseInt(row.get("PermissionID"))));
			assertThat(perm.getPermissionName(), is(row.get("PermissionName")));
		}
	}

	@Given("システムアカウントID、管理システムID、権限ID $LoginID $MngSysID $PermID の権限を更新します")
	public void givenUpdateUserPermission(@Named("LoginID") String loginId,
			@Named("MngSysID") String sysId, @Named("PermID") String permId)
			throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		input.put(ElementName.LoginID, loginId);
		input.put(ElementName.MngSystemID, sysId);
		input.put(ElementName.PermID, permId);
		userPerm = new UserpermissionResource().getItem(input);
	}

	@When("対象の権限を $PermID に変更します")
	public void whenUpdateUserPermission(@Named("PermID") String permId)
			throws Exception {
		ArrayList<LinkedHashMap<String, String>> list = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> keys = new LinkedHashMap<String, String>();
		keys.put(ElementName.LoginID, userPerm.getPk().getLoginID());
		keys.put(ElementName.MngSystemID,
				Integer.toString(userPerm.getPk().getManagementSystemID()));
		keys.put(ElementName.PermID,
				Integer.toString(userPerm.getPk().getPermissionID()));
		LinkedHashMap<String, String> param = new LinkedHashMap<String, String>();
		param.put(ElementName.PermID, permId);
		list.add(0, keys);
		list.add(1, param);
		new UserpermissionResource().updateItem(list);
	}

	@Then("以下の権限が付与されていること $userPermTable")
	public void thenTheResultShouldEqualToTheUserPermission(ExamplesTable table)
			throws Exception {
		LinkedHashMap<String, String> keys = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			keys.put(ElementName.LoginID, row.get("LoginID"));
			keys.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			keys.put(ElementName.PermID, row.get("PermissionID"));
		}
		userPerm = new UserpermissionResource().getItem(keys);
		for (Map<String, String> row : table.getRows()) {
			assertThat(userPerm.getPk().getLoginID(), is(row.get("LoginID")));
			assertThat(userPerm.getPk().getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(userPerm.getPk().getPermissionID(),
					is(Integer.parseInt(row.get("PermissionID"))));
		}
	}
}
