import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {

	private Integer id;
	private String start;
	private String destination;
	private Integer takeoff;
	private List<ECEFCoordinates> coordinates;
	
	public Flight(String start, String destination, Integer takeoff) {
		this.start = start;
		this.destination = destination;
	}
	

	public Flight(Integer id, String start, String destination, Integer takeoff, List<ECEFCoordinates> coordinates) {
		super();
		this.id = id;
		this.start = start;
		this.destination = destination;
		this.takeoff = takeoff;
		this.coordinates = coordinates;
	}


	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getTakeoff() {
		return takeoff;
	}


	public void setTakeoff(Integer takeoff) {
		this.takeoff = takeoff;
	}


	public List<ECEFCoordinates> getCoordinates() {
		return coordinates;
	}


	public void setCoordinates(List<ECEFCoordinates> coordinates) {
		this.coordinates = coordinates;
	}
	
	public String getOutput(Integer timestamp) {
		Integer offset = timestamp - takeoff;
		List<ECEFCoordinates> sortedList = (ArrayList<ECEFCoordinates>) coordinates.stream()
                .sorted(Comparator.comparing(ECEFCoordinates::getTimestampOffset))
                .collect(Collectors.toList()); 

		for(int i = 0; i< sortedList.size() ; i++) {
			
			ECEFCoordinates ecef = sortedList.get(i);
			if(ecef.getTimestampOffset().equals(offset)) {
				return ecef.getLat() + " " + ecef.getLon() + " " + ecef.getAltitude();
			}else if(ecef.getTimestampOffset() > offset) {
				ECEFCoordinates prev = sortedList.get(i-1);
				return interpolate(
						prev.getTimestampOffset(),prev.getLat(),ecef.getTimestampOffset(),ecef.getLat(), offset) 
						+ " " + interpolate(
								prev.getTimestampOffset(),prev.getLon(),ecef.getTimestampOffset(),ecef.getLon(), offset) 
						+ " " + interpolate(
								prev.getTimestampOffset(),prev.getAltitude(),ecef.getTimestampOffset(),ecef.getAltitude(), offset) ;

			}

		}
		
		
		return "";
	}
	
	public String interpolate(int x0, double y0, int x1, double y1, int xp) {
		return (y0 + ((y1-y0)/(x1-x0)) * (xp - x0)) +"";
	}
}
