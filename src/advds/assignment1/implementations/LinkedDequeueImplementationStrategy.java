/*
 * 
 */
package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.util.DateComparator;
import advds.assignment1.util.reader.DailyCovidCasesReader;
import advds.assignment1.util.reader.DataSetReader;

// 
/**
 * The Class DequeueImplementationStrategy.
 */
public class LinkedDequeueImplementationStrategy implements ImplementationStrategy<DailyCasesDTO> {

	/** The deque. */
	private LinkedBlockingDeque<DailyCasesDTO> deque = new LinkedBlockingDeque<DailyCasesDTO>(); 
	
	/**
	 * Load the data from the reader and populates to the deque in sorted order using comparater.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		this.deque = new LinkedBlockingDeque<DailyCasesDTO>();
		List<DailyCasesDTO> data = ((DailyCovidCasesReader)reader).getData();
		for(DailyCasesDTO item: data) {
			deque.add(item);
		}
	}

	/**
	 * Search.
	 *
	 * @param date   the date
	 * @param county the county
	 * @return the daily vaccination DTO
	 */
	@Override
	public DailyCasesDTO search(String date, String county) {
		while(!deque.isEmpty()) {
			DailyCasesDTO current = deque.removeFirst();
			if(current.getDate().isEqual(LocalDate.parse(date))&&current.getCounty().equals(county)) {
				deque.clear();
				return current;
			}
		}
		return null;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LinkedDequeueImplementationStrategy [deque=" + deque + "]";
	}

	/**
	 * Gets the latest date details available.
	 *
	 * @return the latest
	 */
	@Override
	public DailyCasesDTO getLatest() {
		sort();
		return deque.getLast();
	}

	/**
	 * Gets the first date details available.
	 *
	 * @return the first
	 */
	@Override
	public DailyCasesDTO getFirst() {
		sort();
		return deque.getFirst();
	}
	
	/**
	 * Sort.
	 */
	public void sort() {
		ArrayDeque<DailyCasesDTO> dequeCopy = new ArrayDeque<DailyCasesDTO>(deque); 
		deque.clear();
		DateComparator comparator = new DateComparator();
		while(!dequeCopy.isEmpty()) {
			DailyCasesDTO item = dequeCopy.poll();
			if(deque.isEmpty()) {
				deque.add(item);
			}else {
				//sorting the deque as it is being loaded 
				if(comparator.compare(item, deque.peekFirst())<0) {
					deque.addFirst(item);
				}else if(comparator.compare(deque.peekLast(),item)<0){
					deque.addLast(item);
				}else {
					ArrayDeque<DailyCasesDTO> tempDeque = new ArrayDeque<DailyCasesDTO>();
					DailyCasesDTO current = deque.peekFirst();
					while(current!=null && comparator.compare(item, current)>0) {
						tempDeque.push(deque.pollFirst());
						current = deque.peekFirst();
					}
					deque.addFirst(item);
					while(!tempDeque.isEmpty()) {
						deque.addFirst(tempDeque.pop());
					}
				}
			}
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
		return deque.size();
	}
	
}
