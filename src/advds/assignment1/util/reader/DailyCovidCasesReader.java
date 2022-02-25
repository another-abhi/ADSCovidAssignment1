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
import advds.assignment1.mapper.JSONtoDailyCovidCasesMapper;
import advds.assignment1.mapper.Mapper;

// TODO: Auto-generated Javadoc
/**
 * The Class DailyVaccinationsReader.
 */
public class DailyCovidCasesReader implements DataSetReader<DailyCasesDTO>{
	
	/** The daily vaccinations. */
	private List<DailyCasesDTO> dailyCases;
	
	/** The reader size. */
	private int readerSize;
	
	/**
	 * Gets the reader size.
	 *
	 * @return the reader size
	 */
	public int getReaderSize() {
		return readerSize;
	}

	/**
	 * Sets the reader size.
	 *
	 * @param readerSize the new reader size
	 */
	public void setReaderSize(int readerSize) {
		this.readerSize = readerSize;
	}

	/**
	 * Gets the daily vaccinations.
	 *
	 * @return the daily vaccinations
	 */
	public List<DailyCasesDTO> getDailyVaccinations() {
		return dailyCases;
	}

	/**
	 * Sets the daily vaccinations.
	 *
	 * @param dailyVaccinations the new daily vaccinations
	 */
	public void setDailyVaccinations(List<DailyCasesDTO> dailyVaccinations) {
		this.dailyCases = dailyVaccinations;
	}

	/**
	 * Instantiates a new daily covid cases reader.
	 *
	 * @param json the json
	 * @param size the size
	 * @throws JsonMappingException    the json mapping exception
	 * @throws JsonProcessingException the json processing exception
	 */
	public DailyCovidCasesReader(String json, int size) throws JsonMappingException, JsonProcessingException {
		
		if(dailyCases == null) {
			dailyCases = new ArrayList<DailyCasesDTO>();
		}
		setReaderSize(size);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		Iterator<JsonNode> iterator = jsonNode.get("features").elements();
		Mapper<DailyCasesDTO> mapper = new JSONtoDailyCovidCasesMapper();
		Long count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyCases.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		
		System.out.println("Reader size: "+dailyCases.size());
			
	}
	/**
	 * Instantiates a new daily vaccinations reader.
	 *
	 * @param json the json
	 * @throws JsonMappingException    the json mapping exception
	 * @throws JsonProcessingException the json processing exception
	 */
	public DailyCovidCasesReader(String json) throws JsonMappingException, JsonProcessingException {
		
		this(json,18000);

	}
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DataSetReader [dailyVaccinations=" + dailyCases + "]";
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	@Override
	public List<DailyCasesDTO> getData() {
		return getDailyVaccinations().subList(0, readerSize);
	}
	
	/**
	 * Gets the random record.
	 *
	 * @return the random record
	 */
	public DailyCasesDTO getRandomRecord() {
		return dailyCases.get((int) (Math.random()%dailyCases.size()));
	}
	
	
}
