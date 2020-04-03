
public class ECEFCoordinates {

	private Integer timestampOffset;
	private double lat;
	private double lon;
	private double altitude;
	
	public ECEFCoordinates(double lat, double lon, double altitude) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.altitude = altitude;
	}

	
	public ECEFCoordinates(int timestampOffset, double lat, double lon, double altitude) {
		super();
		this.timestampOffset = timestampOffset;
		this.lat = lat;
		this.lon = lon;
		this.altitude = altitude;
	}


	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	
	public Integer getTimestampOffset() {
		return timestampOffset;
	}

	public void setTimestampOffset(int timestampOffset) {
		this.timestampOffset = timestampOffset;
	}


	public String getOutput() {
		final double radius = 6371000;
		double x = (radius + altitude) * Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(lon));
		double y = (radius + altitude) * Math.cos(Math.toRadians(lat)) * Math.sin(Math.toRadians(lon));
		double z = ((radius + altitude)) * Math.sin(Math.toRadians(lat));
		return x + " " + y + " " + z;
	}

}
