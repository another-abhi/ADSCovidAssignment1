/*
 * 
 */
package advds.assignment1.implementations;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.dto.MonthlyVaccinationDTO;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Interface ImplementationStrategy.
 *
 * @param <T> the generic type
 */
public interface ImplementationStrategy<T> {
	
	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	void loadData(DataSetReader<T> reader);
	
	/**
	 * Search.
	 *
	 * @param key the key
	 * @return the t
	 */
	T search(String key);
	
	/**
	 * Gets the latest.
	 *
	 * @return the latest
	 */
	public T getLatest();
	
	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public T getFirst();
	
	/**
	 * Gets the total dose 1 count.
	 *
	 * @return the total dose 1 count
	 */
	public int getTotalDose1Count();
	
	/**
	 * Gets the total dose 2 count.
	 *
	 * @return the total dose 2 count
	 */
	public int getTotalDose2Count();
	
	/**
	 * Gets the cumulative dose 1 count.
	 *
	 * @param key the key
	 * @return the cumulative dose 1 count
	 */
	public int getCumulativeDose1Count(String key);
	
	/**
	 * Gets the cumulative dose 2 count.
	 *
	 * @param key the key
	 * @return the cumulative dose 2 count
	 */
	public int getCumulativeDose2Count(String key);
	
	/**
	 * Gets the monthly vaccine count dose 1.
	 *
	 * @param key the key
	 * @return the monthly vaccine count dose 1 and -1 if no data is available
	 */
	public int getMonthlyVaccineCountDose1(String key);
	
	/**
	 * Gets the monthly vaccine count dose 2.
	 *
	 * @param key the key
	 * @return the monthly vaccine count dose 2, and -1 if no data is available
	 */
	public int getMonthlyVaccineCountDose2(String key);
	
}
