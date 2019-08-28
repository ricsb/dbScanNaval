package boliu.dbscansd;
/**
 * Trajectory Point class
 * @author Bo Liu
 *
 */
public class TrajectoryPoint {
	
	private String mmsi;				//mmsi, the id of the vessel
	private long timestamp;				//second of UTC time stamp
	//the following protected variables are to be inherited by GV
	protected double longitude;			//longitude
	protected double latitude;			//latitude
	protected double SOG;				//speed
	protected double COG;				//course over ground
	//the following two are useful during the clustering process
	private boolean isVisited;			//whether the point has been visited
	private boolean isCorePoint;		//whether the point is a core trajectory point
	
	public TrajectoryPoint() {		
		this.isVisited = false; 		//initialize all the points unvisited
	}	
	public String getMmsi() {
		return mmsi;
	}
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getSOG() {
		return SOG;
	}
	public void setSOG(double sOG) {
		SOG = sOG;
	}
	public double getCOG() {
		return COG;
	}
	public void setCOG(double cOG) {
		COG = cOG;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public boolean isCorePoint() {
		return isCorePoint;
	}
	public void setCorePoint(boolean isCorePoint) {
		this.isCorePoint = isCorePoint;
	}

}
