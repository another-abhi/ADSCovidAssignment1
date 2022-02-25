package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import advds.assignment1.dataStructures.ArrayStack;
import advds.assignment1.dataStructures.LinkedStack;
import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DailyCasesComparator;
import advds.assignment1.util.reader.DataSetReader;

public class LinkedStackImplementationStrategy implements ImplementationStrategy<DailyCasesDTO>{

	/** The stack DS */
	private LinkedStack<DailyCasesDTO> linkedStack = new LinkedStack<DailyCasesDTO>(); 
	
	/**
	 * Load the data from the reader
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.linkedStack = new LinkedStack<DailyCasesDTO>();

		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			linkedStack.push(dailyVaccinationDTO);
		}
		System.out.println("Records inserted into Array-Stack: "+ linkedStack.size());
		
	}

	@Override
	public DailyCasesDTO search(String date, String county) {
		while(!linkedStack.isEmpty()){
		    DailyCasesDTO element = linkedStack.pop();
		    
		    if(element.getCounty().equals(county)) {
		    
		    	if(element.getDate().isEqual(LocalDate.parse(date))) {
		    		return element;
		    	}
		    }
		}
		return null;
	}

	@Override
	public DailyCasesDTO getLatest() {
		sort();
		return linkedStack.pop();
	}

	@Override
	public DailyCasesDTO getFirst() {
		sort();
		
		// loop the delete queue functionality until the last added element is reached.
	    while(linkedStack.size() > 1)
	    {
	    	linkedStack.pop();
	    }
	
		return linkedStack.pop();
	}

	/**
	 * Sorting the stack
	 */
	@Override
	public void sort() {
		ArrayList<DailyCasesDTO> temp = new ArrayList<>();
		Comparator<DailyCasesDTO> casesComparator = new DailyCasesComparator();
		
	    while(!linkedStack.isEmpty())
	    {
	    	temp.add(linkedStack.pop());
	    }
	    
	    temp.sort(casesComparator);
	    
	    for (DailyCasesDTO d : temp) {
	    	linkedStack.push(d);
	    }
	}

	@Override
	public int size() {
		return linkedStack.size();
	}

}
