/*
 * 
 */
package advds.assignment1.dto;


/**
 * The Class CasesDTO.
 */
public abstract class CasesDTO {
	
	
	/** The county. */
	private String county;
	
	/** The cases. */
	private int cases;

	/**
	 * Gets the county.
	 *
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * Sets the county.
	 *
	 * @param county the new county
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * Gets the cases.
	 *
	 * @return the cases
	 */
	public int getCases() {
		return cases;
	}

	/**
	 * Sets the cases.
	 *
	 * @param cases the new cases
	 */
	public void setCases(int cases) {
		this.cases = cases;
	}

	/**
	 * Instantiates a new cases DTO.
	 *
	 * @param county the county
	 * @param cases  the cases
	 */
	public CasesDTO(String county, int cases) {
		super();
		this.county = county;
		this.cases = cases;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CasesDTO [county=" + county + ", cases=" + cases + "]";
	}
	
	
	


}
