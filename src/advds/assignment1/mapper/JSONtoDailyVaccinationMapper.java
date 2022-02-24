/*
 * 
 */
package advds.assignment1.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.databind.JsonNode;

import advds.assignment1.dto.DailyCasesDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONtoDailyVaccinationMapper.
 */
public class JSONtoDailyVaccinationMapper implements Mapper<DailyCasesDTO>{

	/**
	 * Map.
	 *
	 * @param json the json
	 * @return the daily vaccination DTO
	 */
	@Override
	public DailyCasesDTO map(JsonNode json) {
		
		String date = json.get("TimeStamp").asText().split("T")[0];
		LocalDate localDate = LocalDate.parse(date);
		int cases = json.get("ConfirmedCovidCases").asInt();
		String county = json.get("CountyName").asText();
		
		return new DailyCasesDTO(county, cases, localDate);
	}
}
