<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book The Train</title>
<title>Insert Train details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function bookTrain() {
	var trainNo = document.getElementById("trainNoBooking").value;
    var passengerName = document.getElementById("passengerName").value;
    var passengerSeats = document.getElementById("passengerSeats").value;
    var data = {
        "trainNo": trainNo,
        "passengerName": passengerName,
        "passengerSeats": passengerSeats
    };

    $.ajax({
        type: "POST",
        url: "https://vignesh-dot-internship-full.uc.r.appspot.com/booking",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    });
    window.location.replace("https://vignesh-dot-internship-full.uc.r.appspot.com/booking"); 
  
    }
</script>
</head>
<body>
<h1>Train Booking</h1>
<label>Train No : </label>
<input type='text' name='trainNoBooking' id='trainNoBooking' /><br><br>
 <label>Passenger Name : </label>
<input type='text' name='passengerName' id='passengerName' /><br><br>
 <label>Seat : </label>
<input type='text' name='passengerSeats' id='passengerSeats' /><br><br>
<input type='button' value='submit' onclick='bookTrain()'/><br><br><br>
</body>
</html>