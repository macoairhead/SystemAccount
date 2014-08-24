package test.java;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
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

public class CreateSteps {
	public CreateSteps() {
	}

	@Given("空の社員を作成します")
	public void givenCreateInhouseuser() {
	}

	@When("フランスからの新入社員を追加します $createUserTable")
	public void whenCreateInhouseuser(ExamplesTable table) throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.UserID, row.get("UserID"));
			input.put(ElementName.UserNameFirst, row.get("UserNameFirst"));
			input.put(ElementName.UserNameLast, row.get("UserNameLast"));
			input.put(ElementName.UnitID, row.get("UnitID"));
		}

		(new InhouseuserResource()).createItem(input);
	}

	@Then("以下の社員が追加されていること $table")
	public void thenTheContainsShouldUserdata(ExamplesTable table)
			throws Exception {
		for (Map<String, String> row : table.getRows()) {
			Inhouseuser inhusr = (new InhouseuserResource()).getItem(row
					.get("UserID"));
			assertThat(inhusr.getUserID(),
					is(new BigInteger(row.get("UserID"))));
			assertThat(inhusr.getUnit().getUnitID(),
					is(Integer.parseInt(row.get("UnitID"))));
			assertThat(inhusr.getUserNameFirst(), is(row.get("UserNameFirst")));
			assertThat(inhusr.getUserNameLast(), is(row.get("UserNameLast")));
		}
	}

	@Given("新しい部署を作成します")
	public void givenCreateUnit() {
	}

	@When("人事部を追加します $createUnitTable")
	public void whenCreateUnit(ExamplesTable table) throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.UnitID, row.get("UnitID"));
			input.put(ElementName.UnitName, row.get("UnitName"));
		}

		(new UnitResource()).createItem(input);
	}

	@Then("以下の部署が追加されていること $table")
	public void thenTheContainsShouldUnitdata(ExamplesTable table)
			throws Exception {
		for (Map<String, String> row : table.getRows()) {
			Unit unit = (new UnitResource()).getItem(row.get("UnitID"));
			assertThat(unit.getUnitID(),
					is(Integer.parseInt(row.get("UnitID"))));
			assertThat(unit.getUnitName(), is(row.get("UnitName")));
		}
	}

	@Given("新しい管理システムを作成します")
	public void givenCreatManagementSystem() {
	}

	@When("給与システムを作成します $createSysTable")
	public void whenCreateManagementSystem(ExamplesTable table)
			throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			input.put(ElementName.MngSystemName,
					row.get("ManagementSystemName"));
		}

		(new ManagementsystemResource()).createItem(input);
	}

	@Then("以下の管理システムが追加されていること $table")
	public void thenTheContainsShouldSysdata(ExamplesTable table)
			throws Exception {
		for (Map<String, String> row : table.getRows()) {
			Managementsystem mngSys = (new ManagementsystemResource())
					.getItem(row.get("ManagementSystemID"));
			assertThat(mngSys.getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(mngSys.getManagementSystemName(),
					is(row.get("ManagementSystemName")));
		}
	}

	@Given("新しい権限を作成します")
	public void givenCreatePermission() {

	}

	@When("システム管理者権限を作成します $permTable")
	public void whenCreatePermission(ExamplesTable table) throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			input.put(ElementName.PermID, row.get("PermissionID"));
			input.put(ElementName.PermName, row.get("PermissionName"));
			(new PermissionResource()).createItem(input);
		}

	}

	@Then("以下の権限が追加されていること $permissionTable")
	public void thenTheContainsShouldPermData(ExamplesTable table)
			throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			input.put(ElementName.PermID, row.get("PermissionID"));
			Permission perm = (new PermissionResource()).getItem(input);
			assertThat(perm.getPk().getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(perm.getPk().getPermissionID(),
					is(Integer.parseInt(row.get("PermissionID"))));
			assertThat(perm.getPermissionName(), is(row.get("PermissionName")));
		}
	}

	@Given("新しい権限を付与します")
	public void givenAddPermission() {

	}

	@When("以下のシステムアカウントに新しい権限を付与します $userPermTable")
	public void whenAddPermission(ExamplesTable table) throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.UserID, row.get("UserID"));
			input.put(ElementName.PermID, row.get("PermissionID"));
			input.put(ElementName.LoginID, row.get("LoginID"));
			input.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			(new UserpermissionResource()).createItem(input);
		}

	}

	@Then("以下の権限が付与されていること $userPermTable")
	public void thenTheContainsShouldUserPermission(ExamplesTable table)
			throws Exception {
		LinkedHashMap<String, String> input = new LinkedHashMap<String, String>();
		for (Map<String, String> row : table.getRows()) {
			input.put(ElementName.UserID, row.get("UserID"));
			input.put(ElementName.PermID, row.get("PermissionID"));
			input.put(ElementName.LoginID, row.get("LoginID"));
			input.put(ElementName.MngSystemID, row.get("ManagementSystemID"));
			Userpermission usrPerm = (new UserpermissionResource())
					.getItem(input);
			assertThat(usrPerm.getInhouseuser().getUserID(), is(new BigInteger(
					row.get("UserID"))));
			assertThat(usrPerm.getPk().getPermissionID(),
					is(Integer.parseInt(row.get("PermissionID"))));
			assertThat(usrPerm.getPk().getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(usrPerm.getPk().getLoginID(), is(row.get("LoginID")));
		}
	}
}