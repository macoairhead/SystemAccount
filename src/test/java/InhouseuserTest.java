package test.java;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import systemaccount.model.Inhouseuser;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class InhouseuserTest extends JerseyTest {

	public InhouseuserTest() throws Exception {
		super("systemaccount.json");
	}

	@Test
	public void testJSON() throws Exception {
		WebResource webResource = resource();
		String json = webResource.path("User/Inhouseuser?userId=1000")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		// JacksonでJSONをパース
		ObjectMapper mapper = new ObjectMapper();
		Inhouseuser ihu = mapper.readValue(json, Inhouseuser.class);
		System.out.println(ihu);
		assertEquals("JSON太郎", ihu.getUserID().toString());
	}
}
