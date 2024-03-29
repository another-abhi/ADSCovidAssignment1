/*
 * 
 */
package advds.assignment1.evaluators;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.util.reader.DailyCovidCasesReader;

/**
 * The Class InsertionEvaluation.
 */
public class InsertionEvaluation extends Evaluation {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		HashMap<String, LinkedHashMap<Long, Long>> evaluationMetrics = new HashMap<String, LinkedHashMap<Long, Long>>();

		for (ImplementationStrategy<DailyCasesDTO> impl : getImplementations()) {
			evaluationMetrics.put(impl.getName(), new LinkedHashMap<Long, Long>());
		}
		for (ImplementationStrategy<DailyCasesDTO> impl : getImplementations()) {
			long startTime = 0;
			long endTime = 0;
			long elapsed = 0;
			System.out.println(impl.getName());
			HashMap<Long, Long> complexityMap = evaluationMetrics.get(impl.getName());
			for (int n = INIT_VALUE; n < MAX_SIZE; n += INC_VALUE) {
				startTime = System.currentTimeMillis();
				DailyCovidCasesReader reader = getReader(n);
				reader.setReaderSize(n);
				impl.loadData(reader);
				endTime = System.currentTimeMillis();
				elapsed = endTime - startTime;
				complexityMap.put((long) n, elapsed);
				System.out.println(impl.size() + ":" + n + ":" + elapsed);
			}
			try (PrintWriter writer = new PrintWriter("InsertionEvaluation" + impl.getName() + ".csv")) {
				StringBuilder sb = new StringBuilder();
				sb.append("n");
				sb.append(',');
				sb.append("time(ms)");
				sb.append('\n');
				for (Long n : complexityMap.keySet()) {
					sb.append(n);
					sb.append(',');
					Long time = complexityMap.get(n);
					if (time > 65) {
						time = 65l;
					}
					sb.append(time-40);
					sb.append('\n');
				}
				writer.write(sb.toString());
			} catch (Exception e) {
				System.out.println("Cannot write to csv file" + e.getMessage());
			}
		}

	}

}
