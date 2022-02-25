package advds.assignment1.evaluators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.implementations.ArrayDequeueImplementationStrategy;
import advds.assignment1.implementations.ArrayQueueImplementationStrategy;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.implementations.LinkedDequeueImplementationStrategy;
import advds.assignment1.implementations.LinkedQueueImplementationStrategy;
import advds.assignment1.util.reader.DailyCovidCasesReader;

public abstract class Evaluation {


	 private static final ArrayList<ImplementationStrategy<DailyCasesDTO>> implementations =new ArrayList<ImplementationStrategy<DailyCasesDTO>>();
	 protected static final int MAX_SIZE = 18000;
	 protected static final int INC_VALUE = 500;
	 protected static final int INIT_VALUE = 100;
	 static {

		//implementations.add(new StackImplementationStrategy());
		 implementations.add(new ArrayQueueImplementationStrategy());
		 implementations.add(new LinkedQueueImplementationStrategy());
		 implementations.add(new ArrayDequeueImplementationStrategy());
		 implementations.add(new LinkedDequeueImplementationStrategy());
	 }
	/**
	 * @return the implementations
	 */
	public static ArrayList<ImplementationStrategy<DailyCasesDTO>> getImplementations() {
		return implementations;
	}
	
	public static DailyCovidCasesReader getReader(int size) throws IOException {
		 String response = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/covidData.json")));
		 DailyCovidCasesReader dr = new DailyCovidCasesReader(response,size);
		 return dr;
	}
}
