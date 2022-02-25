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
	private int readerSize;
	public int getReaderSize() {
		return readerSize;
	}

	public void setReaderSize(int readerSize) {
		this.readerSize = readerSize;
	}

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

	public DailyVaccinationsReader(String json, int size) throws JsonMappingException, JsonProcessingException {
		
		if(dailyVaccinations == null) {
			dailyVaccinations = new ArrayList<DailyCasesDTO>();
		}
		setReaderSize(size);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		Iterator<JsonNode> iterator = jsonNode.get("features").elements();
		Mapper<DailyCasesDTO> mapper = new JSONtoDailyVaccinationMapper();
		Long count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		
		//2
		jsonNode = objectMapper.readTree(json);
		iterator = jsonNode.get("features").elements();
		mapper = new JSONtoDailyVaccinationMapper();
		count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		
		//3
		jsonNode = objectMapper.readTree(json);
		iterator = jsonNode.get("features").elements();
		mapper = new JSONtoDailyVaccinationMapper();
		count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		
		//4
		jsonNode = objectMapper.readTree(json);
		iterator = jsonNode.get("features").elements();
		mapper = new JSONtoDailyVaccinationMapper();
		count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		

		//5
		jsonNode = objectMapper.readTree(json);
		iterator = jsonNode.get("features").elements();
		mapper = new JSONtoDailyVaccinationMapper();
		count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		
		//6
		jsonNode = objectMapper.readTree(json);
		iterator = jsonNode.get("features").elements();
		mapper = new JSONtoDailyVaccinationMapper();
		count = 0l;
		while(iterator.hasNext() && count < size) {
			dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
			count++;
		}
		//7
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//8
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//9
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//10
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//11
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//12
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//13
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//14
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//15
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				//2
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//3
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//4
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				

				//5
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}
				
				//6
				jsonNode = objectMapper.readTree(json);
				iterator = jsonNode.get("features").elements();
				mapper = new JSONtoDailyVaccinationMapper();
				count = 0l;
				while(iterator.hasNext() && count < size) {
					dailyVaccinations.add((DailyCasesDTO)mapper.map(iterator.next().get("properties")));
					count++;
				}

		System.out.println("Reader size: "+dailyVaccinations.size());
			
	}
	/**
	 * Instantiates a new daily vaccinations reader.
	 *
	 * @param json the json
	 * @throws JsonMappingException    the json mapping exception
	 * @throws JsonProcessingException the json processing exception
	 */
	public DailyVaccinationsReader(String json) throws JsonMappingException, JsonProcessingException {
		
		this(json,Integer.MAX_VALUE);

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
		return getDailyVaccinations().subList(0, readerSize);
	}
	
	
}
