package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

import advds.assignment1.dataStructures.ArrayQueue;
import advds.assignment1.dataStructures.ArrayStack;
import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DailyCasesComparator;
import advds.assignment1.util.reader.DataSetReader;

public class ArrayStackImplementationStrategy implements ImplementationStrategy<DailyCasesDTO>{
	
	/** The stack DS */
	private ArrayStack<DailyCasesDTO> arrayStack = new ArrayStack<DailyCasesDTO>(); 
	
	/**
	 * Load the data from the reader
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.arrayStack = new ArrayStack<DailyCasesDTO>(56*19000);

		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			arrayStack.push(dailyVaccinationDTO);
		}
		System.out.println("Records inserted into Array-Stack: "+ arrayStack.size());
		
	}

	@Override
	public DailyCasesDTO search(String date, String county) {
		while(!arrayStack.isEmpty()){
		    DailyCasesDTO element = arrayStack.pop();
		    
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
		return arrayStack.pop();
	}

	@Override
	public DailyCasesDTO getFirst() {
		sort();
		
		// loop the delete queue functionality until the last added element is reached.
	    while(arrayStack.size() > 1)
	    {
	        arrayStack.pop();
	    }
	
		return arrayStack.pop();
	}

	/**
	 * Sorting the stack
	 */
	@Override
	public void sort() {
		ArrayList<DailyCasesDTO> temp = new ArrayList<>();
		Comparator<DailyCasesDTO> casesComparator = new DailyCasesComparator();
		
	    while(!arrayStack.isEmpty())
	    {
	    	temp.add(arrayStack.pop());
	    }
	    
	    temp.sort(casesComparator);
	    
	    for (DailyCasesDTO d : temp) {
	    	arrayStack.push(d);
	    }
	}

	@Override
	public int size() {
		return arrayStack.size();
	}

}
