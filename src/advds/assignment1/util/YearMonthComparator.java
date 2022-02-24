/*
 * 
 */
package advds.assignment1.util;

import java.util.Comparator;
import advds.assignment1.dto.MonthlyVaccinationDTO;

/**
 * The Class YearMonthComparator.
 */
public class YearMonthComparator implements Comparator<MonthlyVaccinationDTO>{

	/**
	 * Compare.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	@Override
	public int compare(MonthlyVaccinationDTO o1, MonthlyVaccinationDTO o2) {
		// TODO Auto-generated method stub
		return o1.getYearMonth().compareTo(o2.getYearMonth());
	}

}
