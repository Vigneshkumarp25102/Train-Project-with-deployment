package trains;
public class BookingDetails {
	private String trainNo;
	private String bookingId;
	private String passengerName;
	private int passengerSeats;
	
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerSeats() {
		return passengerSeats;
	}
	public void setPassengerSeats(int passengerSeats) {
		this.passengerSeats = passengerSeats;
	}
	
	public BookingDetails(String trainNo,String bookingId, String passengerName, int passengerSeats) {
		super();
		this.trainNo = trainNo;
		this.bookingId = bookingId;
		this.passengerName = passengerName;
		this.passengerSeats = passengerSeats;
	}
	
	public String toString() {
		return String.format("BookingDetails{trainNo='%s',bookingId='%s',passengerName='%s',passengerSeats=%d}",
				trainNo,bookingId,passengerName,passengerSeats);
	}

}
