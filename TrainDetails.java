package trains;
public class TrainDetails {
	
	private String trainNo;
	private String trainName;
	private int trainSeats;
	
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getTrainSeats() {
		return trainSeats;
	}
	public void setTrainSeats(int trainSeats) {
		this.trainSeats = trainSeats;
	}
	
	public TrainDetails(String trainNo, String trainName, int trainSeats) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.trainSeats = trainSeats;
	}
	
	public String toString() {
		return String.format("traindetails{trainNo='%s',trainName='%s',trainSeats=%d}",
				trainNo,trainName,trainSeats);
	}
	

}
