package systemaccount.json.provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JsonMapMessageBodyReader implements
		MessageBodyReader<LinkedHashMap<String, String>> {

	private static ObjectMapper mapper = new ObjectMapper();

	public JsonMapMessageBodyReader() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// TODO 自動生成されたメソッド・スタブ
		return type == LinkedHashMap.class;
	}

	@Override
	public LinkedHashMap<String, String> readFrom(
			Class<LinkedHashMap<String, String>> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO 自動生成されたメソッド・スタブ
		LinkedHashMap<String, String> map = mapper.readValue(entityStream,
				new TypeReference<LinkedHashMap<String, String>>() {
				});
		return map;
	}

}
