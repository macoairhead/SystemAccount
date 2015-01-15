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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import systemaccount.elementList.ElementName;
import systemaccount.exception.ItemCheckException;
import systemaccount.exception.RelationCheckException;
import systemaccount.itemcheck.ManagementsystemItemCheck;
import systemaccount.itemcheck.PermissionItemCheck;
import systemaccount.itemcheck.UserpermissionItemCheck;
import systemaccount.model.Userpermission;
import systemaccount.model.UserpermissionPK;
import systemaccount.relationcheck.InhouseuserRelationCheck;
import systemaccount.relationcheck.ManagementsystemRelationCheck;
import systemaccount.service.CreateUserpermission;
import systemaccount.service.DeleteUserpermission;
import systemaccount.service.UpdateUserpermission;
import systemaccount.service.UserpermissionInfo;

@Path("Userpermission")
public class UserpermissionResource extends BaseResource {

	private UserpermissionPK pk;

	public UserpermissionResource() {
		super(new ArrayList(3));
		this.keys.add(0, ElementName.LoginID);
		this.keys.add(1, ElementName.MngSystemID);
		this.keys.add(2, ElementName.PermID);
	}

	@Override
	public Object getItem(String obj) throws Exception {
		return null;
	}

	@GET
	@Path("Userpermission")
	@Produces(MediaType.APPLICATION_JSON)
	public Userpermission getItem(LinkedHashMap<String, String> input)
			throws Exception {

		try {
			this.check(input);
			return new UserpermissionInfo(this.keys)
					.getUserpermissionByPK(input);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Systemuserbinds")
	public List<Userpermission> getList() throws Exception {
		try {
			return new UserpermissionInfo(this.keys)
					.getUserpermissionInfoList();
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("MngSystemUserpermissions")
	public List<Userpermission> getListByMngSysId(
			@QueryParam(ElementName.MngSystemID) String mngSysId)
			throws Exception {
		try {
			return new UserpermissionInfo(this.keys)
					.getUserpermissionInfoListByMngSysID(mngSysId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Systemuserpermissions")
	public List<Userpermission> getListBySysUserId(
			@QueryParam("sysUserId") String sysUsrId) throws Exception {
		try {
			return new UserpermissionInfo(this.keys)
					.getUserpermissionInfoListBySysUsrID(sysUsrId);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("PermissionUserpermissions")
	public List<Userpermission> getListByPermId(
			@QueryParam("permId") String permId) throws Exception {
		try {
			return new UserpermissionInfo(this.keys)
					.getUserpermissionInfoListByPermID(permId);
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
	@Path("CreateUserpermission")
	public void createItem(LinkedHashMap<String, String> input)
			throws Exception {

		try {
			this.check(input);
			this.relationCheck(input);
			CreateUserpermission create = new CreateUserpermission(this.keys);
			create.createUserpermission(input);
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
	@Path("UpdateUserpermission")
	public void updateItem(ArrayList<LinkedHashMap<String, String>> input)
			throws Exception {
		try {
			LinkedHashMap<String, String> key = input.get(0);
			LinkedHashMap<String, String> detail = input.get(1);
			this.check(key);
			UpdateUserpermission update = new UpdateUserpermission(this.keys);
			update.updateUserpermission(key, detail);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}

	@Override
	public void deleteItem(String str) throws Exception {
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("DeleteUserpermission")
	public void deleteItem(LinkedHashMap<String, String> input)
			throws Exception {
		try {
			this.check(input);
			new DeleteUserpermission(this.keys).deleteUserpermission(input);
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}

	}

	@Override
	void check(String obj) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	void check(LinkedHashMap<String, String> param)
			throws WebApplicationException {

		String loginId = param.get(this.keys.get(0));
		String mngSysId = param.get(this.keys.get(1));
		String permId = param.get(this.keys.get(2));
		ManagementsystemItemCheck mngSysItemCheck = new ManagementsystemItemCheck();
		if (mngSysItemCheck.isEmpty(mngSysId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}
		if (mngSysItemCheck.maxLen(mngSysId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}

		UserpermissionItemCheck sysUsrItemCheck = new UserpermissionItemCheck();
		if (sysUsrItemCheck.isEmpty(loginId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (sysUsrItemCheck.maxLen(loginId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}

		PermissionItemCheck permItemCheck = new PermissionItemCheck();
		if (permItemCheck.isEmpty(permId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "からっぽ");
		}

		if (permItemCheck.maxLen(permId)) {
			throw new ItemCheckException(Response.Status.BAD_REQUEST, "桁が違う");
		}

	}

	void relationCheck(LinkedHashMap<String, String> input)
			throws WebApplicationException {
		ManagementsystemRelationCheck mngSysRelationCheck = new ManagementsystemRelationCheck();
		InhouseuserRelationCheck userRelationCheck = new InhouseuserRelationCheck();
		if (mngSysRelationCheck.exsistForeignKey(input.get(this.keys.get(1)))) {
			throw new RelationCheckException(Response.Status.BAD_REQUEST,
					"システムがへん");
		}
		if (userRelationCheck.exsistForeignKey(input.get(ElementName.UserID))) {
			throw new RelationCheckException(Response.Status.BAD_REQUEST,
					"ユーザがへん");
		}

	}

}
