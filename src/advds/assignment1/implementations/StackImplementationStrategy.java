/*
 * 
 */
package advds.assignment1.implementations;

import java.util.List;
import java.util.Stack;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.reader.DailyVaccinationsReader;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Class StackImplementationStrategy.
 */
public class StackImplementationStrategy implements ImplementationStrategy<DailyCasesDTO> {
	
	/** The stack. */
	private Stack<DailyCasesDTO> stack;

	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.stack = new Stack<DailyCasesDTO>();
		List<DailyCasesDTO> data = ((DailyVaccinationsReader)reader).getData();
		for(DailyCasesDTO item: data) {
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
	public DailyCasesDTO search(String key) {
		return null;
	}

	/**
	 * Gets the stack.
	 *
	 * @return the stack
	 */
	public Stack<DailyCasesDTO> getStack() {
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
	public DailyCasesDTO getLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyCasesDTO getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}




}
