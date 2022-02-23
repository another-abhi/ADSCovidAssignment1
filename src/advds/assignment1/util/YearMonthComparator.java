package advds.assignment1.util;

import java.util.Comparator;
import advds.assignment1.dto.MonthlyVaccinationDTO;

public class YearMonthComparator implements Comparator<MonthlyVaccinationDTO>{

	@Override
	public int compare(MonthlyVaccinationDTO o1, MonthlyVaccinationDTO o2) {
		// TODO Auto-generated method stub
		return o1.getYearMonth().compareTo(o2.getYearMonth());
	}

}
