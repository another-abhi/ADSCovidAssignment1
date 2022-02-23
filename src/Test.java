import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import advds.assignment1.dto.DailyVaccinationDTO;
import advds.assignment1.implementations.DequeueImplementationStrategy;
import advds.assignment1.implementations.ImplementationStrategy;
import advds.assignment1.implementations.QueueImplementationStrategy;
import advds.assignment1.implementations.StackImplementationStrategy;
import advds.assignment1.util.reader.DailyVaccinationsReader;

public class Test {
	public static void main(String args[]) throws IOException {
		 URL url = new URL("https://opendata.arcgis.com/datasets/a0e3a1c53ad8422faf00604ee08955db_0.geojson"); 
		 HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		 conn.setRequestMethod("GET");
		 conn.connect();
		 int responsecode = conn.getResponseCode();
		 if(responsecode != 200)
			 throw new RuntimeException("HttpResponseCode: " +responsecode);
		 else
		 {
			 String response = new String(url.openStream().readAllBytes(), StandardCharsets.UTF_8);
			 

			 DailyVaccinationsReader dr = new DailyVaccinationsReader(response);
			 
			 ArrayList<ImplementationStrategy<DailyVaccinationDTO>> implementations =new ArrayList<ImplementationStrategy<DailyVaccinationDTO>>();
			 //implementations.add(new StackImplementationStrategy());
			 implementations.add(new QueueImplementationStrategy());
			 //implementations.add(new DequeueImplementationStrategy());
			 
			 for(ImplementationStrategy<DailyVaccinationDTO> implementation : implementations) {
				 implementation.loadData(dr);
				 System.out.println(implementation);
				 
				 System.out.println("search: "+ implementation.search("2020-12-29").toString());
				 
			 }
			 System.out.println(dr);
		 }
		 


	}
}
