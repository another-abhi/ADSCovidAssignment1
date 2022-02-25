package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import advds.assignment1.dataStructures.ArrayQueue;
import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DailyCasesComparator;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayQueueImplementationStrategy.
 */
public class ArrayQueueImplementationStrategy implements ImplementationStrategy<DailyCasesDTO>{

	/** The Queue. */
	private ArrayQueue<DailyCasesDTO> arrayQueueDS = new ArrayQueue<DailyCasesDTO>(20000); 
	
	
	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.arrayQueueDS = new ArrayQueue<DailyCasesDTO>(20000);

		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			arrayQueueDS.enqueue(dailyVaccinationDTO);
		}
		System.out.println("Records inserted into Array-Queue: "+ arrayQueueDS.size());
	}

	/**
	 * Search.
	 *
	 * @param key1 the key 1
	 * @param key2 the key 2
	 * @return the daily cases DTO
	 */
	@Override
	public DailyCasesDTO search(String date, String county) {
		
		 while(!arrayQueueDS.isEmpty()){
		        DailyCasesDTO element = arrayQueueDS.dequeue();
		        
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
		// TODO Auto-generated method stub
		
		sort();

		// loop the delete queue functionality until the last added element is reached.
	    while(arrayQueueDS.size() > 1)
	    {
	        return arrayQueueDS.dequeue();
	    }
	
		return arrayQueueDS.dequeue();
	}

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	@Override
	public DailyCasesDTO getFirst() {
		// TODO Auto-generated method stub

		sort();
		return arrayQueueDS.dequeue();
	}

	/**
	 * Sort.
	 */
	@Override
	public void sort() {
		ArrayList<DailyCasesDTO> temp = new ArrayList<>();
		Comparator<DailyCasesDTO> casesComparator = new DailyCasesComparator();
		
	    while(!arrayQueueDS.isEmpty())
	    {
	    	temp.add(arrayQueueDS.dequeue());
	    }
	    
	    temp.sort(casesComparator);
	    
	    for (DailyCasesDTO d : temp) {
	        arrayQueueDS.enqueue(d);
	    }
	}

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return arrayQueueDS.size();
	}

	
}
