<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.io.*,java.util.*,mysources.com.rishal.valueObjects.ValueVO"%>
<%@page language="java" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="R001/style/stars.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="R001/scripts/stars.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.jumbotron {
	padding: 0.5em 0.6em;
	h1
	{
	font-size
	:
	2em;
}

p {
	font-size: 1.2em;
	.
	btn
	{
	padding
	:
	0.5em;
}

}
}
.row.content {
	height: auto;
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 590px;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

.glyphicon-link:before {
	margin-right: 15px;
}

span.stars, span.stars span {
	display: block;
	background: url(R001/images/stars.png) 0 -16px repeat-x;
	width: 80px;
	height: 16px;
}

span.stars span {
	background-position: 0 0;
}

h2 {
	margin-top: 1px;
}
</style>
</head>
<body>
	<script>
$(function() {
    $('span.stars').stars();
});

$(document).ready(function() {
    $('#somebutton').click(function(event) {
            var textToSearch1 = $('#textToSearch').val();
            $.get('Search', {textToSearch : textToSearch1
            }, function(responseText) {
                    $('#somediv').text(responseText);
            });
    });
});
$(document).ready(function() {
    $('#rating').click(function(event) {
            var sortByRating = $('#rating').val();
            $.get('DataController', {rating : sortByRating
            });
    });
});

	
</script>
 
	<div class="jumbotron">
		<h2>Accolite's financial services</h2>
	</div>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">

				<h2>
					<medium>
					<span class="label label-primary"
						style="display: -webkit-box; width: 100%; border-radius: .65em;">
						<span class="glyphicon glyphicon-tasks" style="float: left"></span>Sort
						by
					</span></medium>
				</h2>

				<div class="radio" id="xyz">
					<label id="ratingLable"><input type="radio" name="optradio" id="rating" value="Rating" >Rating</label>
				</div>
				<div class="radio">
					<label><input type="radio" name="optradio">Link</label>
				</div>

				<br>
			</div>
			<div class="input-group" style="width: 30%">
				<input type="text" class="form-control" placeholder="Search (by tags)" id="textToSearch">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="somebutton">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
			<div id="somediv"></div>
			<br /> <br />

			
			<c:set var="item" value="${APPLICATION_DATA}" />
			<div class=".col-md-6">
				<img src=<c:out value="${item.image}"/> alt="xyz"
					class="img-thumbnail pull-xs-left"
					style="width: 200px; height: 200px;" /> <span
					style="width: 58%; float: right">
					<h2>
						<span class="label label-primary"
							style="display: block; text-align: center; width: 100%;"><c:out
								value="${item.name}" /></span>
					</h2> <span class="glyphicon glyphicon-tags"><p
							style="float: right;">
							&nbsp;
							<c:out value="${item.tags}" />
						</p> </span><br /> <c:set var="tempLink" value="${item.link}" /> <c:set
						value="${fn:split(tempLink,'/')}" var="separatorPosition" /> <span
					class="glyphicon glyphicon-link"></span><a href="  ${item.link}"><c:out
							value="${separatorPosition[fn:length(separatorPosition)-1]}"></c:out></a><br />
					<span class="glyphicon glyphicon-thumbs-up"></span> <span
					class="stars"><c:out value="${item.rating}" /></span>

				</span>
			</div>
			<br />
			<div class=".col-md-3">
				<a href="#" style="text-decoration: underline;">Description #</a>
			</div>
			<br />
			<div class=".col-md-4"
				style="border-style: solid; display: -webkit-box; border-radius: .35em;">
				<c:out value="${item.description}" />
			</div>
			<br> <br>

			<div id="pagination">
				<div class=".col-md-4">
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<c:forEach items="${COMPLETE_DATA}" var="item">
							<li><span style="display: inline"><a
									href="/PropertyGuru/DataController?<c:out value="${item.name}" />"
									style="text-align: center;"><c:out value="${item.name}" /></a></span>

							</li>
						</c:forEach>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>

		</div>
	</div>
</body>
</html>