package advds.assignment1.dto;

public abstract class VaccinationDTO {
	
	
	private int dose1;
	private int dose2;
	
	
	public VaccinationDTO(int dose1, int dose2) {
		super();
		this.dose1 = dose1;
		this.dose2 = dose2;
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

}
