package advds.assignment1.mapper;

import com.fasterxml.jackson.databind.JsonNode;

public interface Mapper<T> {

	T map(JsonNode json);
}
