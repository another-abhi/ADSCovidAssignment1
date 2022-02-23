/*
 * 
 */
package advds.assignment1.mapper;

import com.fasterxml.jackson.databind.JsonNode;

// TODO: Auto-generated Javadoc
/**
 * The Interface Mapper.
 *
 * @param <T> the generic type
 */
public interface Mapper<T> {

	/**
	 * Map.
	 *
	 * @param json the json
	 * @return the t
	 */
	T map(JsonNode json);
}
