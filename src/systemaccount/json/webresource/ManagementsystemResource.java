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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.QueryParamValue;
import systemaccount.exception.ItemCheckException;
import systemaccount.itemcheck.ManagementsystemItemCheck;
import systemaccount.model.Managementsystem;
import systemaccount.service.CreateManagementsystem;
import systemaccount.service.DeleteManagementsystem;
import systemaccount.service.ManagementsystemInfo;
import systemaccount.service.UpdateManagementsystem;

@Path("Managementsystem")
public class ManagementsystemResource extends BaseResource {

	@Context
	private UriInfo context;

	public ManagementsystemResource() {
		super(ElementName.MngSystemID);
	}

	@Override
	@GET
	@Path("Managementsystem")
	@Produces(MediaType.APPLICATION_JSON)
	public Managementsystem getItem(
			@QueryParam(QueryParamValue.MngSystemID) String mngSysId)
			throws Exception {
		try {
			this.check(mngSysId);
			return new ManagementsystemInfo(this.key)
					.getManagementSystemInfoByManagementsystemId(mngSysId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Mamagementsystems")
	public List<Managementsystem> getList() throws Exception {
		try {
			return new ManagementsystemInfo(this.key)
					.getManagementsystemInfoList();
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
	@Path("CreateManagementsystem")
	public void createItem(LinkedHashMap<String, String> input)
			throws Exception {
		try {
			this.check(input.get(this.key));
			CreateManagementsystem create = new CreateManagementsystem(this.key);
			create.createManagementsystem(input);
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
	@Path("UpdateManagementsystem")
	public void updateItem(ArrayList<LinkedHashMap<String, String>> input)
			throws Exception {
		try {
			LinkedHashMap<String, String> key = input.get(0);
			LinkedHashMap<String, String> detail = input.get(1);

			this.check(key.get(this.key));
			UpdateManagementsystem update = new UpdateManagementsystem(this.key);
			update.updateManagementsystem(key, detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
		}
	}

	@Override
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("DeleteManagementsystem")
	public void deleteItem(String str) throws Exception {
		try {
			this.check(str);
			DeleteManagementsystem delete = new DeleteManagementsystem(this.key);
			delete.deleteManagementsystem(str);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	void check(String param) throws Exception {
		ManagementsystemItemCheck itemCheck = new ManagementsystemItemCheck();
		if (itemCheck.isEmpty(param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (itemCheck.maxLen(param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}

	}

}
