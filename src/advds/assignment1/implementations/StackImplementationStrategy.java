/*
 * 
 */
package advds.assignment1.implementations;

import java.util.List;
import java.util.Stack;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.util.reader.DailyVaccinationsReader;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Class StackImplementationStrategy.
 */
public class StackImplementationStrategy implements ImplementationStrategy<DailyVaccinationDTO> {
	
	/** The stack. */
	private Stack<DailyVaccinationDTO> stack;

	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyVaccinationDTO> reader) {
		this.stack = new Stack<DailyVaccinationDTO>();
		List<DailyVaccinationDTO> data = ((DailyVaccinationsReader)reader).getData();
		for(DailyVaccinationDTO item: data) {
			stack.push(item);
		}
		
	}

	/**
	 * Search.
	 *
	 * @param key the key
	 * @return the daily vaccination DTO
	 */
	@Override
	public DailyVaccinationDTO search(String key) {
		return null;
	}

	/**
	 * Gets the stack.
	 *
	 * @return the stack
	 */
	public Stack<DailyVaccinationDTO> getStack() {
		return stack;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "StackImplementationStrategy [stack=" + stack + "]";
	}

	@Override
	public DailyVaccinationDTO getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyVaccinationDTO getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalDose1Count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalDose2Count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCumulativeDose1Count(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCumulativeDose2Count(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonthlyVaccineCountDose1(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonthlyVaccineCountDose2(String key) {
		// TODO Auto-generated method stub
		return 0;
	}



}
