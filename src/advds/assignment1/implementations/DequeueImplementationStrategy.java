/*
 * 
 */
package advds.assignment1.implementations;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.List;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.util.DateComparator;
import advds.assignment1.util.reader.DailyVaccinationsReader;
import advds.assignment1.util.reader.DataSetReader;

// 
/**
 * The Class DequeueImplementationStrategy.
 */
public class DequeueImplementationStrategy implements ImplementationStrategy<DailyVaccinationDTO> {

	/** The deque. */
	private ArrayDeque<DailyVaccinationDTO> deque = new ArrayDeque<DailyVaccinationDTO>(); 
	
	/**
	 * Load the data from the reader and populates to the deque in sorted order using comparater.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyVaccinationDTO> reader) {
		this.deque = new ArrayDeque<DailyVaccinationDTO>();
		DateComparator comparator = new DateComparator();
		List<DailyVaccinationDTO> data = ((DailyVaccinationsReader)reader).getData();
		for(DailyVaccinationDTO item: data) {
			if(deque.isEmpty()) {
				deque.add(item);
			}else {
				//sorting the deque as it is being loaded 
				if(comparator.compare(item, deque.peekFirst())<0) {
					deque.addFirst(item);
				}else if(comparator.compare(deque.peekLast(),item)<0){
					deque.addLast(item);
				}else {
					ArrayDeque<DailyVaccinationDTO> tempDeque = new ArrayDeque<DailyVaccinationDTO>();
					DailyVaccinationDTO current = deque.peekFirst();
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
	 * Search.
	 *
	 * @param key the date for which details are to be fetched.
	 * @return the daily vaccination DTO
	 */
	@Override
	public DailyVaccinationDTO search(String key) {
		while(!deque.isEmpty()) {
			DailyVaccinationDTO current = deque.removeFirst();
			if(current.getDate().isEqual(LocalDate.parse(key))) {
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
		return "DequeueImplementationStrategy [deque=" + deque + "]";
	}

	/**
	 * Gets the latest date details available.
	 *
	 * @return the latest
	 */
	@Override
	public DailyVaccinationDTO getLatest() {
		return deque.getLast();
	}

	/**
	 * Gets the first date details available.
	 *
	 * @return the first
	 */
	@Override
	public DailyVaccinationDTO getFirst() {
		return deque.getFirst();
	}

	/**
	 * Gets the total dose 1 count.
	 *
	 * @return the total dose 1 count
	 */
	@Override
	public int getTotalDose1Count() {
		return getCumulativeDose1Count(this.getLatest().getDate().toString());
	}

	/**
	 * Gets the total dose 2 count.
	 *
	 * @return the total dose 2 count
	 */
	@Override
	public int getTotalDose2Count() {
		return getCumulativeDose2Count(this.getLatest().getDate().toString());
	}

	/**
	 * Gets the cumulative dose 1 count.
	 *
	 * @param key the date for which cumulative count is to be found
	 * @return the cumulative dose 1 count
	 */
	@Override
	public int getCumulativeDose1Count(String key) {
		int count = 0;
		LocalDate date = LocalDate.parse(key);
		while(!deque.isEmpty()) {
			DailyVaccinationDTO current = deque.removeFirst();
			if(current.getDate().isBefore(date)) {
				count += current.getDose1();
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * Gets the cumulative dose 2 count.
	 *
	 * @param key the date for which cumulative count is to be found
	 * @return the cumulative dose 2 count
	 */
	@Override
	public int getCumulativeDose2Count(String key) {
		int count =0;
		LocalDate date = LocalDate.parse(key);
		while(!deque.isEmpty()) {
			DailyVaccinationDTO current = deque.removeFirst();
			if(current.getDate().isBefore(date)) {
				count += current.getDose2();
			}else {
				break;
			}
		}
		return count;
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
