package test.java;

import java.util.LinkedHashMap;

import org.apache.openjpa.persistence.EntityExistsException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import systemaccount.elementList.ElementName;
import systemaccount.json.webresource.InhouseuserResource;
import systemaccount.json.webresource.ManagementsystemResource;
import systemaccount.json.webresource.PermissionResource;
import systemaccount.json.webresource.UnitResource;
import systemaccount.json.webresource.UserpermissionResource;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Managementsystem;
import systemaccount.model.Unit;

public class DeleteSteps {

	private Inhouseuser inhusr;
	private Unit unit;
	private Managementsystem mngSys;

	@Given("ユーザを削除します")
	public void givenDeleteInhouseuser() {
	}

	@When("ユーザID $UserID を削除します")
	public void whenDeleteUser(@Named("UserID") String id) throws Exception {
		(new InhouseuserResource()).deleteItem(id);

	}

	@Test(expected = EntityExistsException.class)
	@Then("ユーザID $UserID が存在しないこと")
	public void thenTheResultShouldNoUser(@Named("UserID") String id)
			throws Exception {
		Inhouseuser inhusr = (new InhouseuserResource()).getItem(id);
	}

	@Given("部署を削除します")
	public void givenDeleteUnit() {
	}

	@When("部署ID $UnitID を削除します")
	public void whenDeleteUnit(@Named("UnitID") String id) throws Exception {
		(new UnitResource()).deleteItem(id);

	}

	@Test(expected = EntityExistsException.class)
	@Then("部署ID $UnitID が存在しないこと")
	public void thenTheResultShouldNoUnit(@Named("UnitID") String id)
			throws Exception {
		(new UnitResource()).getItem(id);

	}

	@Given("管理システムを削除します")
	public void givenDeleteManagementSystem() {
	}

	@When("管理システムID $ManagementSystemID を削除します")
	public void whenDeleteManagementSystem(
			@Named("ManagementSystemID") String id) throws Exception {
		(new ManagementsystemResource()).deleteItem(id);

	}

	@Test(expected = EntityExistsException.class)
	@Then("管理システムID $ManagementSystemID が存在しないこと")
	public void thenTheResultShouldNoManagementSystem(
			@Named("ManagementSystemID") String id) throws Exception {

		(new ManagementsystemResource()).getItem(id);
	}

	@Given("権限を削除します")
	public void givenDeletePermission() {
	}

	@When("管理システムID、権限ID $MngSysID $PermID を削除します")
	public void whenDeletePermission(@Named("MngSysID") String mngSysId,
			@Named("PermID") String permId) throws Exception {
		LinkedHashMap<String, String> k = new LinkedHashMap<String, String>();
		k.put(ElementName.MngSystemID, mngSysId);
		k.put(ElementName.PermID, permId);
		(new PermissionResource()).deleteItem(k);

	}

	@Test(expected = EntityExistsException.class)
	@Then("管理システムID、権限ID $MngSysID $PermID が存在しないこと")
	public void thenTheResultShouldNoPermission(
			@Named("MngSysID") String mngSysId, @Named("PermID") String permId)
			throws Exception {
		LinkedHashMap<String, String> k = new LinkedHashMap<String, String>();
		k.put(ElementName.MngSystemID, mngSysId);
		k.put(ElementName.PermID, permId);
		(new PermissionResource()).getItem(k);
	}

	@Given("保有権限を削除します")
	public void givenDeleteManagementSysUser() {
	}

	@When("システムアカウントID、管理システムID、権限ID $LoginID $MngSysID $PermID の権限を削除します")
	public void whenDeleteSysUser(@Named("LoginID") String loginId,
			@Named("MngSysID") String mngSysId, @Named("PermID") String permId)
			throws Exception {
		LinkedHashMap<String, String> k = new LinkedHashMap<String, String>();
		k.put(ElementName.LoginID, loginId);
		k.put(ElementName.MngSystemID, mngSysId);
		k.put(ElementName.PermID, permId);
		(new UserpermissionResource()).deleteItem(k);

	}

	@Test(expected = EntityExistsException.class)
	@Then("システムアカウントID、管理システムID、権限ID $LoginID $MngSysID $PermID が存在しないこと")
	public void thenTheResultShouldNoSysUser(@Named("LoginID") String loginId,
			@Named("MngSysID") String mngSysId, @Named("PermID") String permId)
			throws Exception {
		LinkedHashMap<String, String> k = new LinkedHashMap<String, String>();
		k.put(ElementName.LoginID, loginId);
		k.put(ElementName.MngSystemID, mngSysId);
		k.put(ElementName.PermID, permId);
		(new UserpermissionResource()).getItem(k);
	}
}
