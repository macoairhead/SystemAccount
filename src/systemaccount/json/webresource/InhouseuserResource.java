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
import systemaccount.exception.RelationCheckException;
import systemaccount.itemcheck.InhouseuserItemCheck;
import systemaccount.model.Inhouseuser;
import systemaccount.relationcheck.UnitRelationCheck;
import systemaccount.service.CreateInhouseuser;
import systemaccount.service.DeleteInhouseuser;
import systemaccount.service.InhouseuserInfo;
import systemaccount.service.UpdateInhouseuser;

@Path("User")
public class InhouseuserResource extends BaseResource {
	@Context
	private UriInfo context;

	public InhouseuserResource() {
		super(ElementName.UserID);
	}

	@Override
	@GET
	@Path("Inhouseuser")
	@Produces(MediaType.APPLICATION_JSON)
	public Inhouseuser getItem(@QueryParam(ElementName.UserID) String userId)
			throws Exception {

		try {
			this.check(userId);
			return new InhouseuserInfo(this.key)
					.getInhouseuserInfoByUserId(userId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Inhouseusers")
	public List<Inhouseuser> getList() throws Exception {
		try {
			return new InhouseuserInfo(this.key).getInhouseuserInfoList();
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("UnitMembers")
	public List<Inhouseuser> getListByUnitId(
			@QueryParam(ElementName.UnitID) String unitId) throws Exception {
		try {
			return new InhouseuserInfo(this.key)
					.getInhouseuserInfoByUnitId(unitId);
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
	@Path("CreateInhouseuser")
	public void createItem(LinkedHashMap<String, String> input)
			throws Exception {

		try {
			this.check(input.get(this.key));
			this.relationCheck(input.get(ElementName.UnitID));
			CreateInhouseuser create = new CreateInhouseuser(this.key);
			create.createInhouseuser(input);
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
	@Path("UpdateInhouseuser")
	public void updateItem(ArrayList<LinkedHashMap<String, String>> input)
			throws Exception {
		try {
			LinkedHashMap<String, String> key = input.get(0);
			LinkedHashMap<String, String> detail = input.get(1);
			this.check(key.get(this.key));
			UpdateInhouseuser update = new UpdateInhouseuser(this.key);
			update.updateInhouseuser(key, detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("DeleteInhouseuser")
	public void deleteItem(String userId) throws Exception {
		try {
			this.check(userId);
			new DeleteInhouseuser(this.key).deleteInhouseuser(userId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	void check(String param) throws WebApplicationException {

		InhouseuserItemCheck itemCheck = new InhouseuserItemCheck();
		if (itemCheck.isEmpty(param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (itemCheck.maxLen((String) param)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}
	}

	void relationCheck(String param) throws WebApplicationException {
		UnitRelationCheck relationCheck = new UnitRelationCheck();
		if (relationCheck.exsistForeignKey(param)) {
			throw new RelationCheckException(Response.Status.BAD_REQUEST,
					"所属がへん");
		}

	}
}
