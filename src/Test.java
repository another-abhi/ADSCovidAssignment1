/*
 * 
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.implementations.ArrayDequeueImplementationStrategy;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.implementations.LinkedDequeueImplementationStrategy;
import advds.assignment1.util.reader.DailyCovidCasesReader;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String args[]) throws IOException {
		 String response = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/covidData.json")));

		 DailyCovidCasesReader dr = new DailyCovidCasesReader(response);
		 
		 ArrayList<ImplementationStrategy<DailyCasesDTO>> implementations =new ArrayList<ImplementationStrategy<DailyCasesDTO>>();
		 //implementations.add(new StackImplementationStrategy());
		 implementations.add(new ArrayDequeueImplementationStrategy());
		 implementations.add(new LinkedDequeueImplementationStrategy());
		 ArrayList<ArrayList<Long>> evaluationMetrics = new ArrayList<ArrayList<Long>>();
		 evaluationMetrics.add(new ArrayList<Long>());
		 evaluationMetrics.add(new ArrayList<Long>());
		 evaluationMetrics.add(new ArrayList<Long>());
		 int counter = 0;
		 for(ImplementationStrategy<DailyCasesDTO> implementation : implementations) {
			System.out.println("--------------------------------");
			int i = 0;
			long startTime = 0;
			long endTime = 0;
			long elapsed = 0;
			startTime = System.currentTimeMillis();
			implementation.loadData(dr);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			evaluationMetrics.get(counter).add(elapsed);
			startTime = System.currentTimeMillis();
			System.out.println("search: "+ implementation.search("2022-01-19","Dublin"));
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			evaluationMetrics.get(counter).add(elapsed);
			implementation.loadData(dr);
			startTime = System.currentTimeMillis();
			System.out.println(implementation.getLatest());
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			evaluationMetrics.get(counter).add(elapsed);
			implementation.loadData(dr);
			startTime = System.currentTimeMillis();
			System.out.println(implementation.getFirst());
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			evaluationMetrics.get(counter).add(elapsed);

						
			counter++;
		 }
		 System.out.println("----------------------------");
		 for(List<Long> list : evaluationMetrics) {
			 System.out.println("Metrics");
			 System.out.println("----------------------------");
			 for(Long l: list) {
				 System.out.print(l+",");
			 }
			 System.out.println();
			 System.out.println("----------------------------");
		 }
	 }
}
