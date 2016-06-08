<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="R001/style/stars.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="R001/scripts/stars.js"></script>
	
</head>
<style>
span.stars, span.stars>* {
    display: inline-block;
    background: url(R001/images/stars.png) 0 -16px repeat-x;
    width: 80px;
    height: 16px;
}
span.stars>*{
    max-width:80px;
    background-position: 0 0;
}
</style>
<body>
<script>
$(function() {
    $('span.stars').stars();
});
</script>

<span class="stars">4.8618164</span>
<span class="stars">2.6545344</span>
<span class="stars">0.5355</span>
<span class="stars">8</span>
</body>
</html>