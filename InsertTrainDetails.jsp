<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Train details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function sendData() {
	  	var trainNo = document.getElementById("trainNo").value;
	    var trainName = document.getElementById("trainName").value;
	    var trainSeats = document.getElementById("trainSeats").value;
	    var data = {
	        "trainNo": trainNo,
	        "trainName": trainName,
	        "trainSeats": trainSeats
	    };

	    $.ajax({
	        type: "POST",
	        url: "https://vignesh-dot-internship-full.uc.r.appspot.com/train",
	        data: JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    });	   
	    window.location.replace("https://vignesh-dot-internship-full.uc.r.appspot.com/train"); 

    } 
 </script>
</head>
<body>
<h1>Insert Train Details</h1><br><br>
<label>Train No : </label>
<input type='text' name='trainNo' id='trainNo' /><br><br>
<label>Train Name : </label>
<input type='text' name='trainName'  id='trainName'/><br><br>
<label>Train Seats : </label> 
<input type='text' name='trainSeats' id='trainSeats'/><br><br>
<input type='button' value='submit' onclick='sendData()'/>
</body>
</html>