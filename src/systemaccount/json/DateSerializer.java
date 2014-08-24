package systemaccount.json;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class DateSerializer extends JsonSerializer<Object> {
	@Override
	public void serialize(Object value, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String formatDate = df.format(value);
		gen.writeString(formatDate);

	}

}
