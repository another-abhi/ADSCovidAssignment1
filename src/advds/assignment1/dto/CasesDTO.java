/*
 * 
 */
package advds.assignment1.dto;


/**
 * The Class CasesDTO.
 */
public abstract class CasesDTO {
	
	
	private String county;
	
	private int cases;

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public CasesDTO(String county, int cases) {
		super();
		this.county = county;
		this.cases = cases;
	}

	@Override
	public String toString() {
		return "CasesDTO [county=" + county + ", cases=" + cases + "]";
	}
	
	
	


}
