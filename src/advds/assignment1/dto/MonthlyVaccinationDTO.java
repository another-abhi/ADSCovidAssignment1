package advds.assignment1.dto;


import java.time.YearMonth;

public class MonthlyVaccinationDTO extends VaccinationDTO{
	
	YearMonth yearMonth;

	public MonthlyVaccinationDTO(int dose1, int dose2, YearMonth yearMonth) {
		super(dose1, dose2);
		this.yearMonth = yearMonth;
	}
	

}
