import java.util.Comparator;

public class FlightChart {
	private Integer timestamp;
	private Float lat;
	private Float lon;
	private Float altitude;
	private String start;
	private String destination;
	private Integer takeoff;
	

	public FlightChart(Integer timestamp, Float lat, Float lon, Float altitude, String start, String destination,
			Integer takeoff) {
		super();
		this.timestamp = timestamp;
		this.lat = lat;
		this.lon = lon;
		this.altitude = altitude;
		this.start = start;
		this.destination = destination;
		this.takeoff = takeoff;
	}

	@Override
	public String toString() {
		return "FlightChart [timestamp=" + timestamp + ", lat=" + lat + ", lon=" + lon + ", altitude=" + altitude + "]";
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public Float getAltitude() {
		return altitude;
	}

	public void setAltitude(Float altitude) {
		this.altitude = altitude;
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

	public Integer getTakeoff() {
		return takeoff;
	}

	public void setTakeoff(Integer takeoff) {
		this.takeoff = takeoff;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((takeoff == null) ? 0 : takeoff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightChart other = (FlightChart) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (takeoff == null) {
			if (other.takeoff != null)
				return false;
		} else if (!takeoff.equals(other.takeoff))
			return false;
		return true;
	}



	public static class Comparators {
	    public static final Comparator<FlightChart> TIMESTAMP = (FlightChart o1, FlightChart o2) -> o1.timestamp.compareTo(o2.timestamp);
	    public static final Comparator<FlightChart> LAT = (FlightChart o1, FlightChart o2) ->  o1.lat.compareTo(o2.lat);
	    public static final Comparator<FlightChart> LON = (FlightChart o1, FlightChart o2) ->  o1.lon.compareTo(o2.lon);
	    public static final Comparator<FlightChart> ALTITUDE = (FlightChart o1, FlightChart o2) ->  o1.altitude.compareTo(o2.altitude);
	    public static final Comparator<FlightChart> START = (FlightChart o1, FlightChart o2) ->  o1.start.compareTo(o2.start);
	}
	
}
