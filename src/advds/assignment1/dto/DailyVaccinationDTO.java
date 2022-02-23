package advds.assignment1.dto;

import java.time.LocalDate;
import java.util.Objects;

public class DailyVaccinationDTO extends VaccinationDTO {

	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
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
	
	public DailyVaccinationDTO(LocalDate date, int dose1, int dose2) {
		super(dose1, dose2);
		this.date = date;
	}
	@Override
	public String toString() {
		return "DailyVaccinationDTO [date=" + date + ", dose1=" + getDose1() + ", dose2=" + getDose2() + "]";
	}
	
	
}
