package trains;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Train extends HttpServlet {

	private static final long serialVersionUID = 1L;
	List<TrainDetails> trainDetailsList = new ArrayList<TrainDetails>();
	List<BookingDetails> bookingDetailsList = new ArrayList<>();

	int id = 100;
	String bookingId = "BKTRN";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/train")) {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String trainNo = jsonObject.getString("trainNo");
				String trainName = jsonObject.getString("trainName");
				int trainSeats = jsonObject.getInt("trainSeats");
				TrainDetails trainDetails = new TrainDetails(trainNo, trainName, trainSeats);
				trainDetailsList.add(trainDetails);
			} catch (Exception e) {
				System.out.print(e);
			}
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().println("Train details added successfully.");
		} else if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/booking")) {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String trainNo = jsonObject.getString("trainNo");
				String passengerName = jsonObject.getString("passengerName");
				int passengerSeats = jsonObject.getInt("passengerSeats");
				BookingDetails bookingDetails = new BookingDetails(trainNo, bookingId + id++, passengerName,
						passengerSeats);
				bookingDetailsList.add(bookingDetails);
				for (TrainDetails trainsList : trainDetailsList) {
					if (trainsList.getTrainNo().equals(trainNo)) {
						int a = trainsList.getTrainSeats();
						trainsList.setTrainSeats(a - passengerSeats);
					}
				}
			} catch (Exception e) {
				System.out.print(e + "catch");
			}
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().println("Booking successfully.");

		} else if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/DeleteTrainDetails")) {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String deleteTrainNo = jsonObject.getString("deleteTrainNo");
				for (TrainDetails trains : trainDetailsList) {
					if (trains.getTrainNo().equals(deleteTrainNo)) {
						trainDetailsList.remove(trains);
					}
				}

			} catch (Exception e) {
				System.out.print(e + "catch");
			}
		}else if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/UpdateTrainDetails")) {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String updateTrainNo = jsonObject.getString("updateTrainNo");
				for (TrainDetails trains : trainDetailsList) {
					if (trains.getTrainNo().equals(updateTrainNo)) {
						String UpdateTrainName = jsonObject.getString("UpdateTrainName");
						int updateTrainSeats = jsonObject.getInt("updateTrainSeats");
						trains.setTrainName(UpdateTrainName);
						trains.setTrainSeats(updateTrainSeats);
					} else {
						System.out.print("train not available");
					}
				}
			} catch (Exception e) {
				System.out.print(e);
			}
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().println("Update Train details added successfully.");
		}
		else {
			System.out.print("Something error");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/train")) {
			String trainNumber = request.getParameter("train");
			if (trainNumber == null) {
				response.setContentType("application/json");
				response.getWriter().println(trainDetailsList);
			} else {
				boolean isTrainFound = false;
				for (TrainDetails train : trainDetailsList) {
					if (train.getTrainNo().equals(trainNumber)) {
						isTrainFound = true;
						response.setContentType("application/json");
						response.getWriter().println(train.toString());
						break;
					}
				}
				if (isTrainFound == false) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "Train not found");
				}
			}

		} else if (url.equals("https://vignesh-dot-internship-full.uc.r.appspot.com/booking")) {
			String bookingId = request.getParameter("bookingId");
			if (bookingId == null) {
				response.setContentType("application/json");
				response.getWriter().println(bookingDetailsList.toString());
			} else {
				boolean isTrainFound = false;
				for (BookingDetails booking : bookingDetailsList) {
					if (booking.getBookingId().equals(bookingId)) {
						isTrainFound = true;
						response.setContentType("application/json");
						response.getWriter().println(booking.toString());
						break;
					}
				}
				if (isTrainFound == false) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "Booking not found");
				}
			}
		} else {
			System.out.print("Something error");
		}
	}
		

}

