package advds.assignment1.evaluators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.implementations.ArrayDequeueImplementationStrategy;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.implementations.LinkedDequeueImplementationStrategy;
import advds.assignment1.implementations.QueueImplementationStrategy;
import advds.assignment1.util.reader.DailyVaccinationsReader;

public abstract class Evaluation {


	 private static final ArrayList<ImplementationStrategy<DailyCasesDTO>> implementations =new ArrayList<ImplementationStrategy<DailyCasesDTO>>();
	 protected static final int MAX_SIZE = 18876;
	 protected static final int INC_VALUE = 100;
	 protected static final long INIT_VALUE = 100l;
	 static {

		//implementations.add(new StackImplementationStrategy());
		 implementations.add(new QueueImplementationStrategy());
		 implementations.add(new ArrayDequeueImplementationStrategy());
		 implementations.add(new LinkedDequeueImplementationStrategy());
	 }
	/**
	 * @return the implementations
	 */
	public static ArrayList<ImplementationStrategy<DailyCasesDTO>> getImplementations() {
		return implementations;
	}
	
	public static DailyVaccinationsReader getReader(Long size) throws IOException {
		 String response = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/covidData.json")));
		 DailyVaccinationsReader dr = new DailyVaccinationsReader(response,size);
		 return dr;
	}
}
