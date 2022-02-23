/*
 * 
 */
package advds.assignment1.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class VaccinationDTO.
 */
public abstract class VaccinationDTO {
	
	
	/** The dose 1. */
	private int dose1;
	
	/** The dose 2. */
	private int dose2;
	
	
	/**
	 * Instantiates a new vaccination DTO.
	 *
	 * @param dose1 the dose 1
	 * @param dose2 the dose 2
	 */
	public VaccinationDTO(int dose1, int dose2) {
		super();
		this.dose1 = dose1;
		this.dose2 = dose2;
	}
	
	/**
	 * Gets the dose 1.
	 *
	 * @return the dose 1
	 */
	public int getDose1() {
		return dose1;
	}
	
	/**
	 * Sets the dose 1.
	 *
	 * @param dose1 the new dose 1
	 */
	public void setDose1(int dose1) {
		this.dose1 = dose1;
	}
	
	/**
	 * Gets the dose 2.
	 *
	 * @return the dose 2
	 */
	public int getDose2() {
		return dose2;
	}
	
	/**
	 * Sets the dose 2.
	 *
	 * @param dose2 the new dose 2
	 */
	public void setDose2(int dose2) {
		this.dose2 = dose2;
	}

}
