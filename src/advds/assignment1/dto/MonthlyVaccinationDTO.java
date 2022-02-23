/*
 * 
 */
package advds.assignment1.dto;


import java.time.YearMonth;
import java.util.Objects;

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
	
	
	public YearMonth getYearMonth() {
		return yearMonth;
	}
	
	public void setYearMonth(YearMonth yearMonth) {
		this.yearMonth = yearMonth;
	}

	@Override
	public String toString() {
		return "MonthlyVaccinationDTO [yearMonth=" + yearMonth + ", dose1=" + getDose1() + ", dose2=" + getDose2() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(yearMonth);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyVaccinationDTO other = (MonthlyVaccinationDTO) obj;
		return Objects.equals(yearMonth, other.yearMonth);
	}
}
