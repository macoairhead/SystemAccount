package systemaccount.json.webresource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import systemaccount.elementList.ElementName;
import systemaccount.exception.ItemCheckException;
import systemaccount.itemcheck.UnitItemCheck;
import systemaccount.model.Unit;
import systemaccount.service.CreateUnit;
import systemaccount.service.DeleteUnit;
import systemaccount.service.UnitInfo;
import systemaccount.service.UpdateUnit;

@Path("Unit")
public class UnitResource extends BaseResource {

	@Context
	private UriInfo context;

	public UnitResource() {
		super(ElementName.UnitID);
	}

	@Override
	@GET
	@Path("Unit")
	@Produces(MediaType.APPLICATION_JSON)
	public Unit getItem(@QueryParam(ElementName.UnitID) String unitId)
			throws Exception {
		try {
			this.check(unitId);
			return new UnitInfo(this.key).getUnitByUnitId(unitId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Units")
	public List<Unit> getList() throws Exception {
		try {
			return new UnitInfo(this.key).getUnitInfoList();
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("CreateUnit")
	public void createItem(LinkedHashMap<String, String> input)
			throws Exception {
		try {
			this.check(input.get(this.key));
			CreateUnit create = new CreateUnit(this.key);
			create.createUnit(input);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("UpdateUnit")
	public void updateItem(ArrayList<LinkedHashMap<String, String>> input)
			throws Exception {
		try {
			LinkedHashMap<String, String> key = input.get(0);
			LinkedHashMap<String, String> detail = input.get(1);
			this.check(key.get(this.key));
			UpdateUnit update = new UpdateUnit(this.key);
			update.updateUnit(key, detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
		}
	}

	@Override
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("DeleteUnit")
	public void deleteItem(String str) throws Exception {
		try {
			this.check(str);
			DeleteUnit delete = new DeleteUnit(this.key);
			delete.deleteUnit(str);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	void check(String param) throws WebApplicationException {
		UnitItemCheck itemCheck = new UnitItemCheck();
		if (itemCheck.isEmpty(param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (itemCheck.maxLen((String) param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}

	}

}
