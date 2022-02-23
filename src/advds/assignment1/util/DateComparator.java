package advds.assignment1.util;

import java.util.Comparator;

import advds.assignment1.dto.DailyVaccinationDTO;

public class DateComparator implements Comparator<DailyVaccinationDTO> {

	@Override
	public int compare(DailyVaccinationDTO d1, DailyVaccinationDTO d2) {
		// TODO Auto-generated method stub
		return d1.getDate().compareTo(d2.getDate());
	}

}
