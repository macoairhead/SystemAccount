package systemaccount;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import systemaccount.model.Inhouseuser;
import systemaccount.service.InhouseuserInfo;

@Path("json")
@RequestScoped
@Resource(name = "jdbc/MARIA_JDBC")
public class SystemAccountJson {

	public SystemAccountJson() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Path("Sample")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Inhouseuser getJson(@QueryParam("userId") String userId)
			throws Exception {

		try {
			Inhouseuser ihu = new InhouseuserInfo("userId")
					.getInhouseuserInfoByUserId(userId);
			return ihu;
		} catch (Exception e) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}
}
