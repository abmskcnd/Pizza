<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>My Pizza</title>
<link rel="shortcut icon" href="../resources/trangchu/img/logo2.jpg">
  <!-- Bootstrap core CSS -->
  <link href="../resources/trangchu/css/bootstrap.min.css" rel="stylesheet">
  <link href="../resources/trangchu/css/bootstrap.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="../resources/trangchu/css/style.css" rel="stylesheet">
<style>
button{
  position: relative;
}
.abs{
  position: absolute  ;
  top: -10px; 
  right: -10px;
  font-size: 13px;
  background-color: blue;
  padding: 1px 5px;
  font-weight: bold;
  /* text-align: center; */
  /* border: 1px solid */
  border-radius: 50%;
}
</style>
</head>

<body>
<%@include file="../../common/trangchu/header.jsp"%>

  <!-- Page Content -->
  <div class="container mt-0">
   
    <div id="myCarousel" class="carousel slide">
    
    <!-- Indicators -->
    <ul class="carousel-indicators">
      <li class="item1 active"></li>
      <li class="item2"></li>
      <li class="item3"></li>
    </ul>
    
    <!-- The slideshow -->
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="../resources/trangchu/img/1.jpg" alt="" width="1100px" height="500px">
      </div>
      <div class="carousel-item">
        <img src="../resources/trangchu/img/2.jpg" alt="" width="1100px" height="500px">
      </div>
      <div class="carousel-item">
        <img src="../resources/trangchu/img/3.jpg" alt="" width="1100px" height="500px">
      </div>
    </div>
    
    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#myCarousel">
      <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#myCarousel">
      <span class="carousel-control-next-icon"></span>
    </a>
  </div>
  </div>
  <!-- /.container -->
  <div class="row w-100 p-0 m-0">
  	<div class="col-6 p-0 m-0 design"><img src="../resources/trangchu/img/4.png" width="760px" height="400px">
 		<div class="text-white center">
  		<h1>THỰC ĐƠN</h1> 
  		</div>
  		 <a class="btn bg-info text-white custom" href="home/index.htm">Xem Thêm</a>
  	</div>
  	<div class="col-6 p-0 m-0 design"><img src="../resources/trangchu/img/5.png" width="780px" height="400px">
  	
  		<div class="text-white center">
  		<h1>KHUYẾN MÃI</h1> 
  		</div>
  		<a class="btn bg-info text-white custom" href="home/index.htm">Xem Thêm</a>
  	</div>
  </div>
  <!-- Footer -->
<%@include file="../../common/trangchu/footer.jsp"%>

  <!-- Bootstrap core JavaScript -->
  <script src="../resources/trangchu/js/jquery.min.js"></script>
  <script src="../resources/trangchu/js/bootstrap.bundle.min.js"></script>
  <script src="../resources/trangchu/js/test.js"></script>
</body>

</html>
