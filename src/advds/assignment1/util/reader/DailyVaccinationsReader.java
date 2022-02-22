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

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.mapper.JSONtoDailyVaccinationMapper;
import advds.assignment1.mapper.Mapper;

public class DailyVaccinationsReader implements DataSetReader<DailyVaccinationDTO>{
	private List<DailyVaccinationDTO> dailyVaccinations;

	public List<DailyVaccinationDTO> getDailyVaccinations() {
		return dailyVaccinations;
	}

	public void setDailyVaccinations(List<DailyVaccinationDTO> dailyVaccinations) {
		this.dailyVaccinations = dailyVaccinations;
	}

	public DailyVaccinationsReader(String json) throws JsonMappingException, JsonProcessingException {
		
		if(dailyVaccinations == null) {
			dailyVaccinations = new ArrayList<DailyVaccinationDTO>();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		Iterator<JsonNode> iterator = jsonNode.get("features").elements();
		Mapper mapper = new JSONtoDailyVaccinationMapper();
		while(iterator.hasNext()) {
			dailyVaccinations.add((DailyVaccinationDTO)mapper.map(iterator.next().get("properties")));
		}

	}

	@Override
	public String toString() {
		return "DataSetReader [dailyVaccinations=" + dailyVaccinations + "]";
	}

	@Override
	public List<DailyVaccinationDTO> getData() {
		return getDailyVaccinations();
	}
	
	
}
