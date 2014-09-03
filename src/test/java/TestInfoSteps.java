package test.java;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import systemaccount.json.webresource.InhouseuserResource;
import systemaccount.json.webresource.ManagementsystemResource;
import systemaccount.json.webresource.UnitResource;
import systemaccount.model.Inhouseuser;
import systemaccount.model.Managementsystem;
import systemaccount.model.Unit;

public class TestInfoSteps {
	public TestInfoSteps() {

	}

	private Inhouseuser inhusr;
	private Unit unit;
	private Managementsystem mngSys;

	@Given("社員を表示します")
	public void givenShowInhouseuser() {
	}

	@When("ユーザID $UserID を表示します")
	public void whenShowUserID(@Named("UserID") String id) throws Exception {
		inhusr = (new InhouseuserResource()).getItem(id);

	}

	@Then("以下が表示されていること $table")
	public void thenTheResultShouldEqualToTheUser(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(inhusr.getUserID(),
					is(new BigInteger(row.get("UserID"))));
			assertThat(inhusr.getUserNameFirst(), is(row.get("UserNameFirst")));
			assertThat(inhusr.getUserNameLast(), is(row.get("UserNameLast")));
		}

	}

	@Given("部署を表示します")
	public void givenShowUnit() {
	}

	@When("部署ID $UnitID を表示します")
	public void whenShowUnitID(@Named("UnitID") String id) throws Exception {
		unit = (new UnitResource()).getItem(id);

	}

	@Then("以下の部署が表示されていること $table")
	public void thenTheResultShouldEqualToTheUnit(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(unit.getUnitID(),
					is(Integer.parseInt(row.get("UnitID"))));
			assertThat(unit.getUnitName(), is(row.get("UnitName")));
		}

	}

	@Given("管理システムを表示します")
	public void givenShowManagementSystem() {
	}

	@When("管理システムID $ManagementSystemID を表示します")
	public void whenShowManagementSystemID(
			@Named("ManagementSystemID") String id) throws Exception {
		mngSys = (new ManagementsystemResource()).getItem(id);

	}

	@Then("以下の管理システムが表示されていること $table")
	public void thenTheResultShouldEqualToTheManagementSystem(
			ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			assertThat(mngSys.getManagementSystemID(),
					is(Integer.parseInt(row.get("ManagementSystemID"))));
			assertThat(mngSys.getManagementSystemName(),
					is(row.get("ManagementSystemName")));
		}

	}
}
