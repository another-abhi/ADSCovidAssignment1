/*
 * 
 */
package advds.assignment1.dto;

import java.time.LocalDate;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class DailyVaccinationDTO.
 */
public class DailyVaccinationDTO extends VaccinationDTO {

	/** The date. */
	private LocalDate date;
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date);
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
		DailyVaccinationDTO other = (DailyVaccinationDTO) obj;
		return Objects.equals(date, other.date);
	}
	
	/**
	 * Instantiates a new daily vaccination DTO.
	 *
	 * @param date  the date
	 * @param dose1 the dose 1
	 * @param dose2 the dose 2
	 */
	public DailyVaccinationDTO(LocalDate date, int dose1, int dose2) {
		super(dose1, dose2);
		this.date = date;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "DailyVaccinationDTO [date=" + date + ", dose1=" + getDose1() + ", dose2=" + getDose2() + "]";
	}
	
	
}
