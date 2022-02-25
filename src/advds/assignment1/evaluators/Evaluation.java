/*
 * 
 */
package advds.assignment1.evaluators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import advds.assignment1.dto.DailyCasesDTO;
import advds.assignment1.implementations.ArrayDequeueImplementationStrategy;
import advds.assignment1.implementations.ArrayQueueImplementationStrategy;
import advds.assignment1.implementations.ArrayStackImplementationStrategy;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.implementations.LinkedDequeueImplementationStrategy;
import advds.assignment1.implementations.LinkedQueueImplementationStrategy;
import advds.assignment1.implementations.LinkedStackImplementationStrategy;
import advds.assignment1.util.reader.DailyCovidCasesReader;

/**
 * The Class Evaluation.
 */
public abstract class Evaluation {


	 /** The Constant implementations. */
 	private static final ArrayList<ImplementationStrategy<DailyCasesDTO>> implementations =new ArrayList<ImplementationStrategy<DailyCasesDTO>>();
	 
 	/** The Constant MAX_SIZE. */
 	protected static final int MAX_SIZE = 18000;
	 
 	/** The Constant INC_VALUE. */
 	protected static final int INC_VALUE = 50;
	 
 	/** The Constant INIT_VALUE. */
 	protected static final int INIT_VALUE = 100;
	 static {

		 implementations.add(new ArrayStackImplementationStrategy());
		 implementations.add(new LinkedStackImplementationStrategy());
		 implementations.add(new ArrayQueueImplementationStrategy());
		 implementations.add(new LinkedQueueImplementationStrategy());
		 implementations.add(new ArrayDequeueImplementationStrategy());
		 implementations.add(new LinkedDequeueImplementationStrategy());
	 }
	
	/**
	 * Gets the implementations.
	 *
	 * @return the implementations
	 */
	public static ArrayList<ImplementationStrategy<DailyCasesDTO>> getImplementations() {
		return implementations;
	}
	
	/**
	 * Gets the reader.
	 *
	 * @param size the size
	 * @return the reader
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static DailyCovidCasesReader getReader(int size) throws IOException {
		 String response = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/covidData.json")));
		 DailyCovidCasesReader dr = new DailyCovidCasesReader(response,size);
		 return dr;
	}
}
