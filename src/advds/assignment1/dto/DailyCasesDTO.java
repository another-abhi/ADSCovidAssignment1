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
public class DailyCasesDTO extends CasesDTO {

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
		DailyCasesDTO other = (DailyCasesDTO) obj;
		return Objects.equals(date, other.date);
	}



	@Override
	public String toString() {
		return "DailyCasesDTO [date=" + date + ", toString()=" + super.toString() + "]";
	}

	public DailyCasesDTO(String county, int cases, LocalDate date) {
		super(county, cases);
		this.date = date;
	}
	
}
