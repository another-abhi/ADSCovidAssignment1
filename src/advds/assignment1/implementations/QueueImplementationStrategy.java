package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.util.DateComparator;
import advds.assignment1.util.reader.DataSetReader;

public class QueueImplementationStrategy implements ImplementationStrategy<DailyVaccinationDTO> {

	Comparator<DailyVaccinationDTO> comparator;
	private PriorityQueue<DailyVaccinationDTO> queueData;
	
	public QueueImplementationStrategy() {
		super();
		this.comparator = new DateComparator();
		this.queueData = new PriorityQueue<>(10,comparator);
	}

	@Override
	public void loadData(DataSetReader<DailyVaccinationDTO> reader) {
		// TODO Auto-generated method stub
		
		for (DailyVaccinationDTO dailyVaccinationDTO : reader.getData()) {
			queueData.add(dailyVaccinationDTO);
		}
		
		System.out.println("peek: "+ queueData.peek().toString());
	}

	@Override
	public DailyVaccinationDTO search(String key) {
		// TODO Auto-generated method stub
		
		Iterator iterator = queueData.iterator();
	    while(iterator.hasNext()){
	        DailyVaccinationDTO element = (DailyVaccinationDTO) iterator.next();
	        
	        if(element.getDate().isEqual(LocalDate.parse(key))) {
	        	return element;
	        }
	    }
	    
		return null;
	}

	public Queue<DailyVaccinationDTO> getQueueData() {
		return queueData;
	}
	
	
	
	
}
