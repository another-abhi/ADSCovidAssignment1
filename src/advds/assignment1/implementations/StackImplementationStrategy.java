package advds.assignment1.implementations;

import java.util.List;
import java.util.Stack;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.util.reader.DailyVaccinationsReader;
import advds.assignment1.util.reader.DataSetReader;

public class StackImplementationStrategy implements ImplementationStrategy<DailyVaccinationDTO> {
	
	private Stack<DailyVaccinationDTO> stack;

	@Override
	public void loadData(DataSetReader<DailyVaccinationDTO> reader) {
		this.stack = new Stack<DailyVaccinationDTO>();
		List<DailyVaccinationDTO> data = ((DailyVaccinationsReader)reader).getData();
		for(DailyVaccinationDTO item: data) {
			stack.push(item);
		}
		
	}

	@Override
	public DailyVaccinationDTO search(String key) {
		return null;
	}

	public Stack<DailyVaccinationDTO> getStack() {
		return stack;
	}

	@Override
	public String toString() {
		return "StackImplementationStrategy [stack=" + stack + "]";
	}


}
