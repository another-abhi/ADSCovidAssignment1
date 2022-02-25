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
public class MonthlyVaccinationDTO extends CasesDTO{
	
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
	
	
	/**
	 * Gets the year month.
	 *
	 * @return the year month
	 */
	public YearMonth getYearMonth() {
		return yearMonth;
	}
	
	/**
	 * Sets the year month.
	 *
	 * @param yearMonth the new year month
	 */
	public void setYearMonth(YearMonth yearMonth) {
		this.yearMonth = yearMonth;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "MonthlyVaccinationDTO [yearMonth=" + yearMonth + ", dose1=" + getDose1() + ", dose2=" + getDose2() + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(yearMonth);
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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
