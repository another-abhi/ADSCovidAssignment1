/*
 * 
 */
package advds.assignment1.util;

import java.util.Comparator;

import advds.assignment1.dto.DailyVaccinationDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DateComparator.
 */
public class DateComparator implements Comparator<DailyVaccinationDTO> {

	/**
	 * Compare.
	 *
	 * @param d1 the d 1
	 * @param d2 the d 2
	 * @return the int
	 */
	@Override
	public int compare(DailyVaccinationDTO d1, DailyVaccinationDTO d2) {
		// TODO Auto-generated method stub
		return d1.getDate().compareTo(d2.getDate());
	}

}
