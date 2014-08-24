package systemaccount.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class NumericSerializer extends JsonSerializer<Object> {
	@Override
	public void serialize(Object value, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		String formatNumber = value.toString();
		gen.writeString(formatNumber);

	}

}
