/*
 * 
 */
package advds.assignment1.mapper;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;

import advds.assignment1.dto.DailyVaccinationDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONtoDailyVaccinationMapper.
 */
public class JSONtoDailyVaccinationMapper implements Mapper<DailyVaccinationDTO>{

	/**
	 * Map.
	 *
	 * @param json the json
	 * @return the daily vaccination DTO
	 */
	@Override
	public DailyVaccinationDTO map(JsonNode json) {
		
	
		String date = json.get("VaccinationDate").asText().split("T")[0];
		LocalDate localDate = LocalDate.parse(date);
		
		int dose1 = json.get("Dose1").asInt();
		int dose2 = json.get("Dose2").asInt();
		
		return new DailyVaccinationDTO(localDate, dose1, dose2);
	}
}
