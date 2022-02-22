package advds.assignment1.implementations;

import advds.assignment1.util.reader.DataSetReader;

public interface ImplementationStrategy<T> {
	
	void loadData(DataSetReader<T> reader);
	T search(String key);
}
