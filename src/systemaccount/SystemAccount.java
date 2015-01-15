package systemaccount;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import systemaccount.model.Inhouseuser;

@WebServlet("/SystemAccount")
@Resource(name = "jdbc/MARIA_JDBC")
public class SystemAccount extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SystemAccount() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();

		out.write("<html>");
		out.write("<head>");
		out.write("<title>JDBCサンプル</title>");
		out.write("</head>");
		out.write("<body>");

		out.write("<table border='1'>");
		out.write("<tr>");
		out.write("<td>UserID</td>");
		out.write("<td>UserNameFirst</td>");
		out.write("<td>UserNameLast</td>");
		out.write("<td>Unit</td>");
		out.write("<td>IsValid</td>");
		out.write("</tr>");

		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("SystemAccount");
			EntityManager em = emf.createEntityManager();
			Inhouseuser ihu = em.find(Inhouseuser.class, "1000");

			// List<Inhouseuser> results = query.getResultList();

			// debug
			// System.out.println(Inhouseuser.toString());
			out.write("<tr>");
			out.write("<td>" + ihu.getUserID().toString() + "</td>");
			out.write("<td>" + ihu.getUserNameFirst() + "</td>");
			out.write("<td>" + ihu.getUserNameLast() + "</td>");
			out.write("<td>" + ihu.getUnit().getUnitName() + "</td>");
			out.write("<td>" + ihu.getIsValid() + "</td>");
			out.write("</tr>");

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");

	}
}
