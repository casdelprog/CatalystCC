import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Contest {

	public static void main(String[] args) throws Exception {
		
		final String inputFile ="C:\\Users\\Pablo\\Desktop\\level2_5.in";
		final String outputFile ="C:\\Users\\Pablo\\Desktop\\level2.out";
		
		File archivo = new File (inputFile);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		List<FlightChart> charts = new ArrayList<FlightChart>();
		int size = 0;
		String input = "";
		String[] chart;
		
		Map<Flight, Integer> filteredMap = new LinkedHashMap<Flight,Integer>();
		
		if((input=br.readLine()) != null ) {
			size = Integer.valueOf(input);
		}
		for(int i = 1; i<= size; i++) {
			input = br.readLine();
			chart = input.split(",");
			charts.add(new FlightChart(
					Integer.valueOf(chart[0]),
					Float.valueOf(chart[1]),
					Float.valueOf(chart[2]),
					Float.valueOf(chart[3]),
					chart[4],
					chart[5],
					Integer.valueOf(chart[6])
					));
		}
		
		br.close();
				
		List<FlightChart> sortedList = (ArrayList<FlightChart>) charts.stream()
                .sorted(Comparator.comparing(FlightChart::getStart)
                                  .thenComparing(FlightChart::getDestination)
                                  .thenComparing(FlightChart::getTakeoff))
                .collect(Collectors.toList()); 
		
        List<FlightChart> filteredList = new LinkedList<>();
        
        for(FlightChart fc : sortedList) {
        	if(!filteredList.contains(fc)) {
        		filteredList.add(fc);
        	}
        }
        
        for(FlightChart fc: filteredList) {
        	Flight sf = new Flight(fc.getStart(), fc.getDestination(), fc.getTakeoff());
        	int count = 1;
        	if(filteredMap.containsKey(sf)) {
        		count = filteredMap.get(sf);
        		count++;			
        	}
        	filteredMap.put(sf, count);
        }

		File output = new File(outputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		for(Map.Entry<Flight, Integer> entry : filteredMap.entrySet()) {
			Flight f = entry.getKey();
			writer.write(f.getStart() +" "+ f.getDestination() +" "+ entry.getValue());
			writer.write("\n");
		}
		
		
		writer.close();
		
//		Collections.sort(charts, FlightChart.Comparators.TIMESTAMP);
//		writer.write(charts.get(0).timestamp + " " + charts.get(size - 1 ).timestamp);
//		writer.write("\n");
//		
//		Collections.sort(charts, FlightChart.Comparators.LAT);
//		writer.write(charts.get(0).lat + " " + charts.get(size - 1 ).lat);
//		writer.write("\n");
//		
//		Collections.sort(charts, FlightChart.Comparators.LON);
//		writer.write(charts.get(0).lon + " " + charts.get(size - 1 ).lon);
//		writer.write("\n");
//		
//		Collections.sort(charts, FlightChart.Comparators.ALTITUDE);
//		writer.write(" " + charts.get(size - 1 ).altitude);
		
//		writer.close();
		
	}
	
	static void printFlightCharts( ArrayList<FlightChart> charts) {
		for(FlightChart fc : charts) {
			System.out.println(fc);
		}
		
		System.out.println("*--------------------------*");
	}
	
	
}
