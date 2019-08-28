package boliu.dbscansd;
import boliu.dbscansd.TrajectoryPoint;
/**
 * Gravity Vector class, it includes longitude, latitude, sog, cog and median distance
 * @author Bo Liu
 */
public class GravityVector extends TrajectoryPoint{
	
	private double medianDistance;	
	
	public double getMedianDistance() {
		return medianDistance;
	}

	public void setMedianDistance(double medianDistance) {
		this.medianDistance = medianDistance;
	}

	public GravityVector(double longitude, double latitude, double COG, double SOG, double medianDistance) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.COG = COG;
		this.SOG = SOG;
		this.medianDistance = medianDistance;
		
	}

}
