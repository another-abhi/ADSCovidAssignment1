/*
 * 
 */
package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import advds.assignment1.dataStructures.LinkedQueue;
import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DailyCasesComparator;
import advds.assignment1.util.reader.DataSetReader;

/**
 * The Class LinkedQueueImplementationStrategy.
 */
public class LinkedQueueImplementationStrategy implements ImplementationStrategy<DailyCasesDTO>{

	/** The linked queue DS. */
	private LinkedQueue<DailyCasesDTO> linkedQueueDS = new LinkedQueue<DailyCasesDTO>(); 
	
	
	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.linkedQueueDS = new LinkedQueue<DailyCasesDTO>();

		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			linkedQueueDS.enqueue(dailyVaccinationDTO);
		}
		System.out.println("Records inserted into Linked-Queue: "+ linkedQueueDS.size());
		
	}

	/**
	 * Search.
	 *
	 * @param date   the date
	 * @param county the county
	 * @return the daily cases DTO
	 */
	@Override
	public DailyCasesDTO search(String date, String county) {
		while(!linkedQueueDS.isEmpty()){
	        DailyCasesDTO element = linkedQueueDS.dequeue();
	        
	        if(element.getCounty().equals(county)) {
	        
	        	if(element.getDate().isEqual(LocalDate.parse(date))) {
	        		return element;
	        	}
	        }
	    }
	    
		return null;
	}

	/**
	 * Gets the latest.
	 *
	 * @return the latest
	 */
	@Override
	public DailyCasesDTO getLatest() {
		sort();

		// loop the delete queue functionality until the last added element is reached.
	    while(linkedQueueDS.size() > 1)
	    {
	        linkedQueueDS.dequeue();
	    }
	
		return linkedQueueDS.dequeue();
	}

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	@Override
	public DailyCasesDTO getFirst() {
		sort();
		return linkedQueueDS.dequeue();
	}

	/**
	 * Sort.
	 */
	@Override
	public void sort() {
		ArrayList<DailyCasesDTO> temp = new ArrayList<>();
		Comparator<DailyCasesDTO> casesComparator = new DailyCasesComparator();
		
	    while(!linkedQueueDS.isEmpty())
	    {
	    	temp.add(linkedQueueDS.dequeue());
	    }
	    
	    temp.sort(casesComparator);
	    
	    for (DailyCasesDTO d : temp) {
	    	linkedQueueDS.enqueue(d);
	    }
		
	}

	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedQueueDS.size();
	}

}
