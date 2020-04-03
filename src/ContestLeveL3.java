import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class ContestLeveL3 {

	public static void main(String[] args) throws Exception{
		final String inputFile ="C:\\Users\\Pablo\\Desktop\\level3_5.in";
		final String outputFile ="C:\\Users\\Pablo\\Desktop\\level3.out";
		
		File archivo = new File (inputFile);
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		
		List<ECEFCoordinates> coordinates = new LinkedList<ECEFCoordinates>();
		int size = 0;
		String input = "";
		String[] chart;
		
		
		if((input=br.readLine()) != null ) {
			size = Integer.valueOf(input);
		}
		for(int i = 1; i<= size; i++) {
			input = br.readLine();
			chart = input.split(",");
			coordinates.add(new ECEFCoordinates(
					Double.valueOf(chart[0]),
					Double.valueOf(chart[1]),
					Double.valueOf(chart[2])
					));
		}
		
		br.close();
		
		
		File output = new File(outputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));

		for(ECEFCoordinates coor : coordinates) {
			writer.write(coor.getOutput());
			writer.write("\n");
		}
		
		writer.close();
		
	}
}
