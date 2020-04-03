import java.util.List;

public class FlightHelper {

	public static Flight getFlightById(List<Flight> flights, Integer id) {		
		
		for(Flight f : flights) {
			if(f.getId().equals(id)) {
				return f;
			}
		}
		
		return null;
	}

	
	
}
