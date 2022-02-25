package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import advds.assignment1.dataStructures.LinkedQueue;
import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DailyCasesComparator;
import advds.assignment1.util.reader.DataSetReader;

public class LinkedQueueImplementationStrategy implements ImplementationStrategy<DailyCasesDTO>{

	private LinkedQueue<DailyCasesDTO> linkedQueueDS = new LinkedQueue<DailyCasesDTO>(); 
	
	
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.linkedQueueDS = new LinkedQueue<DailyCasesDTO>();

		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			linkedQueueDS.enqueue(dailyVaccinationDTO);
		}
		System.out.println("Records inserted into Array-Queue: "+ linkedQueueDS.size());
		
	}

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

	@Override
	public DailyCasesDTO getLatest() {
		sort();

		// loop the delete queue functionality until the last added element is reached.
	    while(linkedQueueDS.size() > 1)
	    {
	        return linkedQueueDS.dequeue();
	    }
	
		return linkedQueueDS.dequeue();
	}

	@Override
	public DailyCasesDTO getFirst() {
		sort();
		return linkedQueueDS.dequeue();
	}

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

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedQueueDS.size();
	}

}
