<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Train Details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function deleteTrain() {
	  var deleteTrainNo = document.getElementById("deleteTrainNo").value;
	 
	    var data = {
	        "deleteTrainNo": deleteTrainNo
	    };

	    $.ajax({
	        type: "POST",
	        url: "https://vignesh-dot-internship-full.uc.r.appspot.com/DeleteTrainDetails",
	        data: JSON.stringify(data),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    });	 
	    window.location.replace("https://vignesh-dot-internship-full.uc.r.appspot.com/train");
	    
    } 
 </script>
</head>
<body>
<h1>Delete Train Details</h1><br><br>
<label>Enter the train No : </label>
<input type="text" name="deleteTrainNo" id="deleteTrainNo"/><br>
<input type="button" value="Delete" onclick="deleteTrain()"/>
</body>
</html>