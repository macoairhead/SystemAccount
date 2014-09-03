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
import systemaccount.itemcheck.ManagementsystemItemCheck;
import systemaccount.itemcheck.PermissionItemCheck;
import systemaccount.model.Permission;
import systemaccount.relationcheck.ManagementsystemRelationCheck;
import systemaccount.service.CreatePermission;
import systemaccount.service.DeletePermisson;
import systemaccount.service.PermissionInfo;
import systemaccount.service.UpdatePermission;

@Path("Permission")
public class PermissionResource extends BaseResource {
	@Context
	private UriInfo context;

	public PermissionResource() {
		super(new ArrayList<String>(2));
		this.keys.add(0, ElementName.MngSystemID);
		this.keys.add(1, ElementName.PermID);
	}

	@Override
	public Object getItem(String param) {
		return null;

	}

	@GET
	@Path("Permission")
	@Produces(MediaType.APPLICATION_JSON)
	public Permission getItem(LinkedHashMap<String, String> input)
			throws Exception {

		try {
			this.check(input);
			return new PermissionInfo(this.keys)
					.getPermissionInfoByPermissionId(input);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Permissions")
	public List<Permission> getList() throws Exception {
		try {
			return new PermissionInfo(this.keys).getPermissionInfoList();
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("MngSysPermissions")
	public List<Permission> getListByMngSysId(
			@QueryParam(ElementName.MngSystemID) String mngSysId)
			throws Exception {
		try {
			return new PermissionInfo(this.keys)
					.getPermissionInfoByMngSysId(mngSysId);
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
	@Path("CreatePermission")
	public void createItem(LinkedHashMap<String, String> input)
			throws Exception {

		try {
			this.check(input.get(this.keys));
			this.relationCheck(input.get(this.keys.get(0)));
			CreatePermission create = new CreatePermission(this.keys);
			create.createPermission(input);
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
	@Path("UpdatePermission")
	public void updateItem(ArrayList<LinkedHashMap<String, String>> input)
			throws Exception {
		try {
			LinkedHashMap<String, String> key = input.get(0);
			LinkedHashMap<String, String> detail = input.get(1);
			this.check(key.get(this.key));
			UpdatePermission update = new UpdatePermission(this.keys);
			update.updatePermission(key, detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public void deleteItem(String param) {

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("DeletePermission")
	public void deleteItem(LinkedHashMap<String, String> param)
			throws Exception {
		try {
			this.check(param);
			new DeletePermisson(this.keys).deletePermission(param);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	void check(String param) {

	}

	void check(LinkedHashMap<String, String> param)
			throws WebApplicationException {
		ManagementsystemItemCheck mngSysItemCheck = new ManagementsystemItemCheck();

		PermissionItemCheck permItemCheck = new PermissionItemCheck();
		if (mngSysItemCheck.isEmpty(param.get(this.keys.get(0)))) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}
		if (mngSysItemCheck.maxLen(param.get(this.keys.get(0)))) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}
		if (permItemCheck.isEmpty(param.get(this.keys.get(1)))) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (permItemCheck.maxLen(param.get(this.keys.get(1)))) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}
	}

	void relationCheck(String param) throws WebApplicationException {
		ManagementsystemRelationCheck relationCheck = new ManagementsystemRelationCheck();
		if (relationCheck.exsistForeignKey(param)) {
			throw new RelationCheckException(Response.Status.BAD_REQUEST,
					"システムがへん");
		}

	}

}
