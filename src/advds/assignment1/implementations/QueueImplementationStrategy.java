/*
 * 
 */
package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.util.DateComparator;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueImplementationStrategy.
 */
public class QueueImplementationStrategy implements ImplementationStrategy<DailyVaccinationDTO> {

	/** The comparator. */
	Comparator<DailyVaccinationDTO> comparator;
	
	/** The queue data. */
	private PriorityQueue<DailyVaccinationDTO> queueData;
	
	/**
	 * Instantiates a new queue implementation strategy.
	 */
	public QueueImplementationStrategy() {
		super();
		this.comparator = new DateComparator();
		this.queueData = new PriorityQueue<>(10,comparator);
	}

	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyVaccinationDTO> reader) {
		// TODO Auto-generated method stub
		
		for (DailyVaccinationDTO dailyVaccinationDTO : reader.getData()) {
			queueData.add(dailyVaccinationDTO);
		}
		
		System.out.println("peek: "+ queueData.peek().toString());
	}

	/**
	 * Search.
	 *
	 * @param key the key
	 * @return the daily vaccination DTO
	 */
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

	/**
	 * Gets the queue data.
	 *
	 * @return the queue data
	 */
	public Queue<DailyVaccinationDTO> getQueueData() {
		return queueData;
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
	
	
	
	
}
