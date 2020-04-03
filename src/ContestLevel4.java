import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContestLevel4 {
	public static void main(String[] args) throws Exception {
		
		
		final String flightFolder = "C:\\Users\\Pablo\\Desktop\\level4\\usedFlights";
		
		File folder = new File (flightFolder);
		final List<Flight> FLIGHTS = new ArrayList<Flight>();
		
	   for (final File fileEntry : folder.listFiles()) {
			FileReader fr = new FileReader (fileEntry);
			BufferedReader br = new BufferedReader(fr);
			int id = Integer.valueOf(fileEntry.getName().replace(".csv",""));
			String start = br.readLine(); 
			String dest = br.readLine();		
			Integer takeoffTimestamp = Integer.valueOf(br.readLine());
			int n = Integer.valueOf(br.readLine());
			List<ECEFCoordinates> list = new LinkedList<ECEFCoordinates>();
			for(int i = 1; i<=n; i++) {
				String line = "";
				line = br.readLine();
				String[] ecef = line.split(",");
				ECEFCoordinates e = new ECEFCoordinates(
						Integer.valueOf(ecef[0]), 
						Double.valueOf(ecef[1]), 
						Double.valueOf(ecef[2]),
						Double.valueOf(ecef[3]));
				list.add(e);
			}
			Flight f = new Flight(id, start, dest, takeoffTimestamp, list);
			FLIGHTS.add(f);
			br.close();		
	    }
		
		final String inputFile ="C:\\Users\\Pablo\\Desktop\\level4\\level4_5.in";
		final String outputFile ="C:\\Users\\Pablo\\Desktop\\level4\\level4.out";
		
		FileReader fr = new FileReader (inputFile);
		BufferedReader br = new BufferedReader(fr);
		
		int num = Integer.valueOf(br.readLine());
		
		File output = new File(outputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		
		for(int i = 1 ; i<= num; i++) {
			String[] flight_Timestamp = br.readLine().split(" ");
			Integer id = Integer.valueOf(flight_Timestamp[0]);
			Integer timestamp = Integer.valueOf(flight_Timestamp[1]);
			Flight f  = FlightHelper.getFlightById(FLIGHTS, id);
			//System.out.println(f.getOutput(timestamp));
			writer.write(f.getOutput(timestamp));
			writer.write("\n");
		}

		br.close();
		writer.close();
	}
	
	
}
