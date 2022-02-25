/*
 * 
 */
package advds.assignment1.util.reader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.mapper.JSONtoDailyVaccinationMapper;
import advds.assignment1.mapper.Mapper;

// TODO: Auto-generated Javadoc
/**
 * The Class DailyVaccinationsReader.
 */
public class DailyVaccinationsReader implements DataSetReader<DailyCasesDTO>{
	
	/** The daily vaccinations. */
	private List<DailyCasesDTO> dailyVaccinations;

	/**
	 * Gets the daily vaccinations.
	 *
	 * @return the daily vaccinations
	 */
	public List<DailyCasesDTO> getDailyVaccinations() {
		return dailyVaccinations;
	}

	/**
	 * Sets the daily vaccinations.
	 *
	 * @param dailyVaccinations the new daily vaccinations
	 */
	public void setDailyVaccinations(List<DailyCasesDTO> dailyVaccinations) {
		this.dailyVaccinations = dailyVaccinations;
	}

	public DailyVaccinationsReader(String json, Long size) throws JsonMappingException, JsonProcessingException {
		
		if(dailyVaccinations == null) {
			dailyVaccinations = new ArrayList<DailyCasesDTO>();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		Iterator<JsonNode> iterator = jsonNode.get("features").elements();
		Mapper<DailyCasesDTO> mapper = new JSONtoDailyVaccinationMapper();
		Long count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}

	}
	/**
	 * Instantiates a new daily vaccinations reader.
	 *
	 * @param json the json
	 * @throws JsonMappingException    the json mapping exception
	 * @throws JsonProcessingException the json processing exception
	 */
	public DailyVaccinationsReader(String json) throws JsonMappingException, JsonProcessingException {
		
		this(json,Long.MAX_VALUE);

	}
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DataSetReader [dailyVaccinations=" + dailyVaccinations + "]";
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public List<DailyCasesDTO> getData() {
		return getDailyVaccinations();
	}
	
	
}
