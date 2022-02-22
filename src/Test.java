import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

import advds.assignment1.util.reader.DataSetReader;

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
			 

			 DataSetReader dr = new DataSetReader(response);
			 
			 System.out.println(dr);
		 }
		 


	}
}
