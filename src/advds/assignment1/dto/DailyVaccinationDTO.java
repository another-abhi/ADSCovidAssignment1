package advds.assignment1.dto;

import java.time.LocalDate;
import java.util.Objects;

public class DailyVaccinationDTO {

	private LocalDate date;
	private int dose1;
	private int dose2;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getDose1() {
		return dose1;
	}
	public void setDose1(int dose1) {
		this.dose1 = dose1;
	}
	public int getDose2() {
		return dose2;
	}
	public void setDose2(int dose2) {
		this.dose2 = dose2;
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
		super();
		this.date = date;
		this.dose1 = dose1;
		this.dose2 = dose2;
	}
	@Override
	public String toString() {
		return "DailyVaccinationDTO [date=" + date + ", dose1=" + dose1 + ", dose2=" + dose2 + "]";
	}
	
	
}
