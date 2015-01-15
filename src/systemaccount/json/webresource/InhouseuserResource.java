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
import javax.ws.rs.core.UriInfo;

import systemaccount.constantitem.ElementName;
import systemaccount.constantitem.EventID;
import systemaccount.constantitem.QueryParamValue;
import systemaccount.itemcheck.InhouseuserItemCheck;
import systemaccount.model.Assignment;
import systemaccount.model.Inhouseuser;
import systemaccount.relationcheck.UnitRelationCheck;
import systemaccount.service.CreateAssignment;
import systemaccount.service.CreateAssignmentchangelog;
import systemaccount.service.CreateInhouseuser;
import systemaccount.service.CreateInhouseuserchangelog;
import systemaccount.service.DeleteInhouseuser;
import systemaccount.service.InhouseuserInfo;
import systemaccount.service.UpdateInhouseuser;
import systemaccount.util.MapSerializer;

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
	public Inhouseuser getItem(@QueryParam(QueryParamValue.UserID) String userId)
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
			@QueryParam(QueryParamValue.UnitID) String unitId) throws Exception {
		try {
			return new InhouseuserInfo(this.key)
					.getInhouseuserInfoByUnitId(unitId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("AssingmentList")
	public List<Assignment> getAssingnmentList() throws Exception {
		try {
			return new InhouseuserInfo(this.key)
					.getInhouseuserInfoAssignmentList();
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("ResignedList")
	public List<Assignment> getResignedList() throws Exception {
		try {
			return new InhouseuserInfo(this.key)
					.getInhouseuserInfoResignedList();
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
			LinkedHashMap<ElementName, String> param = (new MapSerializer()).serialize(input);
			this.check(param.get(this.key));
			this.relationCheck(param.get(ElementName.UnitID));
			CreateInhouseuser create = new CreateInhouseuser(this.key);
			create.createInhouseuser(param);
			CreateAssignment createAssignment = new CreateAssignment();
			createAssignment.createAssignment(param);
			CreateInhouseuserchangelog createihuChnlog = new CreateInhouseuserchangelog();
			createihuChnlog.createInhouseuserchangelog(param);
			CreateAssignmentchangelog createasiChnlog = new CreateAssignmentchangelog();
			createasiChnlog.createAssignmentchangelog(param);
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
			LinkedHashMap<ElementName, String> key = (new MapSerializer()).serialize(input.get(0));
			LinkedHashMap<ElementName, String> detail = (new MapSerializer()).serialize(input.get(1));
			this.check(key.get(this.key));
			UpdateInhouseuser update = new UpdateInhouseuser(this.key);
			update.updateInhouseuser(key, detail);
			InhouseuserInfo info = new InhouseuserInfo(this.key);
			Inhouseuser ihu = info.getInhouseuserInfoByUserId(key.get(this.key));
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put(ElementName.UserID.name(), ihu.getUserID().toString());
			map.put(ElementName.UserNameFirst.name(), ihu.getUserNameFirst());
			map.put(ElementName.UserNameLast.name(), ihu.getUserNameLast());
			map.put(ElementName.UnitID.name(), "0");
			map.put(ElementName.UnitName.name(), "");
			map.put(ElementName.AssignmentEventID.name(), Integer.toString(EventID.Renaming.getIDValue()));

			CreateAssignment createAssignment = new CreateAssignment();
			createAssignment.createAssignment(detail);
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
			LinkedHashMap<ElementName, String> detail = new LinkedHashMap<ElementName, String>();
			Inhouseuser ihu = (new InhouseuserInfo(ElementName.UserID)).getInhouseuserInfoByUserId(userId);
			detail.put(ElementName.UserID, ihu.getUserID().toString());
			detail.put(ElementName.UserNameFirst, ihu.getUserNameFirst());
			detail.put(ElementName.UserNameLast, ihu.getUserNameLast());
			detail.put(ElementName.AssignmentEventID, EventID.Resigned.toString());
			new DeleteInhouseuser(this.key).deleteInhouseuser(userId);
			CreateAssignment createAssignment = new CreateAssignment();
			createAssignment.createAssignment(detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	void check(String param) throws WebApplicationException {

		InhouseuserItemCheck itemCheck = new InhouseuserItemCheck();
		itemCheck.isEmpty(param);
		itemCheck.maxLen((String) param);
	}

	void relationCheck(String param) throws WebApplicationException {
		UnitRelationCheck relationCheck = new UnitRelationCheck();
		relationCheck.exsistForeignKey(param);


	}
}
