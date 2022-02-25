/*
 * 
 */
package advds.assignment1.util;

import java.util.Comparator;

import advds.assignment1.dto.DailyCasesDTO;

/**
 * The Class DailyCasesComparator.
 */
public class DailyCasesComparator  implements Comparator<DailyCasesDTO>{

	/**
	 * Compare.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	@Override
	public int compare(DailyCasesDTO o1, DailyCasesDTO o2) {
		int countyComparison = o1.getCounty().compareTo(o2.getCounty());
        if (countyComparison == 0) { 
        	// only if counties are equal go for next level of comparison using dates
        	return o1.getDate().compareTo(o2.getDate());
        }
        return countyComparison;
	}


}
