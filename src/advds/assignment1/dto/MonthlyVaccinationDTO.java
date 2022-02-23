/*
 * 
 */
package advds.assignment1.dto;


import java.time.YearMonth;

// TODO: Auto-generated Javadoc
/**
 * The Class MonthlyVaccinationDTO.
 */
public class MonthlyVaccinationDTO extends VaccinationDTO{
	
	/** The year month. */
	YearMonth yearMonth;

	/**
	 * Instantiates a new monthly vaccination DTO.
	 *
	 * @param dose1     the dose 1
	 * @param dose2     the dose 2
	 * @param yearMonth the year month
	 */
	public MonthlyVaccinationDTO(int dose1, int dose2, YearMonth yearMonth) {
		super(dose1, dose2);
		this.yearMonth = yearMonth;
	}
	

}
