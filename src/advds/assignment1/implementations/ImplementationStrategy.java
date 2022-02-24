/*
 * 
 */
package advds.assignment1.implementations;

import advds.assignment1.dto.DailyCasesDTO;
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
	T search(String key1, String key2);
	
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
	
	public void sort();
	
}
