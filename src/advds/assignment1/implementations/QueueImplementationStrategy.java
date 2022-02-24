/*
 * 
 */
package advds.assignment1.implementations;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.dto.MonthlyVaccinationDTO;
import advds.assignment1.util.DateComparator;
import advds.assignment1.util.YearMonthComparator;
import advds.assignment1.util.reader.DataSetReader;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueImplementationStrategy.
 */
public class QueueImplementationStrategy implements ImplementationStrategy<DailyCasesDTO> {

	/**
	 * Instantiates a new queue implementation strategy.
	 */

	Comparator<DailyCasesDTO> dateComparator;
	private PriorityQueue<DailyCasesDTO> queueData;
	
	Comparator<MonthlyVaccinationDTO> yearMonthComparator;
	private PriorityQueue<MonthlyVaccinationDTO> monthlyVaccineData;
	
	public QueueImplementationStrategy() {
		super();
		this.dateComparator = new DateComparator();
		this.queueData = new PriorityQueue<>(10,dateComparator);
		
		this.yearMonthComparator = new YearMonthComparator();
		this.monthlyVaccineData = new PriorityQueue<>(10,yearMonthComparator); 
	}

	/**
	 * Load data.
	 *
	 * @param reader the reader
	 */
	@Override
	public void loadData(DataSetReader<DailyCasesDTO> reader) {
		// Loads JSON Parsed data set into a priority queue
		this.queueData = new PriorityQueue<>(10,dateComparator);
		this.monthlyVaccineData = new PriorityQueue<>(10,yearMonthComparator); 
		
		for (DailyCasesDTO dailyVaccinationDTO : reader.getData()) {
			queueData.add(dailyVaccinationDTO);
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
		// TODO Auto-generated method stub
	    while(!queueData.isEmpty()){
	        DailyCasesDTO element = queueData.poll();
	        
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
	public Queue<DailyCasesDTO> getQueueData() {
		return queueData;
	}
	
	/**
	 * Gets the monthly vaccine data.
	 *
	 * @return the monthly vaccine data
	 */
	public PriorityQueue<MonthlyVaccinationDTO> getMonthlyVaccineData() {
		return monthlyVaccineData;
	}
	

	@Override
	public DailyCasesDTO getLatest() {
		// TODO Auto-generated method stub

	    while(queueData.size() > 1)
	    {
	        queueData.poll();
	    }

	    return queueData.poll();
	}

	@Override
	public DailyCasesDTO getFirst() {
		// TODO Auto-generated method stub
		return queueData.poll();
	}

//	@Override
//	public int getTotalDose1Count() {
//		// TODO Auto-generated method stub
//		return getTotalVaccineByDate( null).getDose1();
//	}
//
//	@Override
//	public int getTotalDose2Count() {
//		// TODO Auto-generated method stub
//		return getTotalVaccineByDate(null).getDose2();
//	}
//
//	@Override
//	public int getCumulativeDose1Count(String key) {
//		// TODO Auto-generated method stub
//		return getTotalVaccineByDate(key).getDose1();
//	}
//
//	@Override
//	public int getCumulativeDose2Count(String key) {
//		// TODO Auto-generated method stub
//		return getTotalVaccineByDate(key).getDose2();
//		}
//	
//	
//	/**
//	 * Gets the total vaccines rolled out for either dose1 or dose2 till a date 'date'.
//	 *
//	 * @param doseType the dose type
//	 * @param date the date
//	 * @return the total vaccine by dose date
//	 */
//	private DailyCasesDTO getTotalVaccineByDate(String date) {
//		
//		DailyCasesDTO totalVaccineCount=new DailyCasesDTO(null, 0, 0);
//		LocalDate endDate;
//		
//		if(date==null) { // if null, sets endDate to system time stamp
//			endDate = LocalDate.now();	
//		}
//		else {
//			endDate = LocalDate.parse(date);
//		}
//		
//		while(!queueData.isEmpty()) {
//			
//			if(queueData.peek().getDate().isAfter(endDate)) {
//				break;
//			}
//			
//			DailyCasesDTO element = queueData.poll();
//			
//			totalVaccineCount.setDose1(totalVaccineCount.getDose1()+ element.getDose1());
//			totalVaccineCount.setDose2(totalVaccineCount.getDose2()+ element.getDose2());
//			
//		}
//		
//		return totalVaccineCount;
//	}
//	
//	
//	public void monthlyVaccineStats() {
//		// Aggregates daily vaccination count to monthly figures
//		
//		if(queueData.isEmpty()) {
//			return;
//		}
//		
//	
//		YearMonth currMonth;
//		LocalDate currMonthEndDate = null;
//		MonthlyVaccinationDTO monthVaccineCount;
//		DailyCasesDTO totalVaccineCount;
//		
//		while(!queueData.isEmpty()) {
//			
//			DailyCasesDTO element = queueData.peek();
//			currMonth= YearMonth.from(element.getDate());
//			currMonthEndDate = currMonth.atEndOfMonth();
//			
//			totalVaccineCount= getTotalVaccineByDate(currMonthEndDate.toString());
//			
//			monthVaccineCount= 
//					new MonthlyVaccinationDTO(totalVaccineCount.getDose1(), totalVaccineCount.getDose2(), currMonth);
//			
//			monthlyVaccineData.add(monthVaccineCount);
//	
//		}
//		
//	}

	@Override
	public String toString() {
		return "QueueImplementationStrategy [dateComparator=" + dateComparator + ", queueData=" + queueData
				+ ", yearMonthComparator=" + yearMonthComparator + ", monthlyVaccineData=" + monthlyVaccineData + "]";
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	
//	public MonthlyVaccinationDTO getMonthlyVaccine(String key) {
//		
//		if(monthlyVaccineData.isEmpty()) { // builds the priority queue only if its empty
//			monthlyVaccineStats();	
//		}
//		// TODO Auto-generated method stub
//	    while(!monthlyVaccineData.isEmpty()){
//	        MonthlyVaccinationDTO element = monthlyVaccineData.poll();
//	        
//	        if(element.getYearMonth().equals(YearMonth.parse(key))) {
//	        	return element;
//	        }
//	    }
//	    
//		return null;
//	}
//
//	
//	@Override
//	public int getMonthlyVaccineCountDose1(String key) {
//		MonthlyVaccinationDTO monthlyData = getMonthlyVaccine(key);
//		if(monthlyData==null) {
//			return -1;
//		}
//		return monthlyData.getDose1();
//	}
//	
//
//	@Override
//	public int getMonthlyVaccineCountDose2(String key) {
//		MonthlyVaccinationDTO monthlyData = getMonthlyVaccine(key);
//		if(monthlyData==null) {
//			return -1;
//		}
//		return monthlyData.getDose2();
//	}
	
	
	
}
