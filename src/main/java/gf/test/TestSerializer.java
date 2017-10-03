package gf.test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class TestSerializer extends JsonSerializer<TestObject> {

	@Override
	public void serialize(TestObject value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		jgen.writeStringField("a", value.getA());
		jgen.writeStringField("c", value.getC());
		jgen.writeEndObject();
	}
}