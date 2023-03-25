<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Train details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function sendupdateData() {
	  	var updateTrainNo = document.getElementById("updateTrainNo").value;
	    var UpdateTrainName = document.getElementById("UpdateTrainName").value;
	    var updateTrainSeats = document.getElementById("updateTrainSeats").value;
	    var data = {
	        "updateTrainNo": updateTrainNo,
	        "UpdateTrainName": UpdateTrainName,
	        "updateTrainSeats": updateTrainSeats
	    };

	    $.ajax({
	        type: "POST",
	        url: "https://vignesh-dot-internship-full.uc.r.appspot.com/UpdateTrainDetails",
	        data: JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    });	   
	    window.location.replace("https://vignesh-dot-internship-full.uc.r.appspot.com/train"); 

    } 
 </script>
</head>
<body>
<h1>Update Train Details</h1><br><br>
<label>Train No : </label>
<input type='text' name=updateTrainNo id='updateTrainNo' /><br><br>
<label>Train Name : </label>
<input type='text' name='UpdateTrainName'  id='UpdateTrainName'/><br><br>
<label>Train Seats : </label> 
<input type='text' name='updateTrainSeats' id='updateTrainSeats'/><br><br>
<input type='button' value='submit' onclick='sendupdateData()'/>
</body>
</html>