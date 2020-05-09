<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
  <link href="../resources/trangchu/css/dathang.css" rel="stylesheet">
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
	a.list-group-item{
	text-decoration: none;
	transition: 0.2s;
		color:black;
	} 	
	a.list-group-item:hover{
	transform: scale(1.1);
	color:white;
	background-color: #262626;
	}
</style>
</head>

<body>
<%@include file="../../common/trangchu/header.jsp"%>
 <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4 text-dark ">Thực Đơn</h1>
        <div class="list-group">
          <a href="" class="list-group-item ">Thực Đơn Đặc Biệt</a>
          <a href="" class="list-group-item">Ưu Đãi Mỗi Ngày</a>
          <a href="" class="list-group-item">Pizza</a>
          <a href="../user/miy.htm" class="list-group-item">Mì Ý & Cơm</a>
          <a href="" class="list-group-item">Khai Vị</a>
          <a href="" class="list-group-item">Thức Uống</a>

        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="../public/pizza/1.png" alt="First slide"  >
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="../public/pizza/2.png" alt="Second slide"  >
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="../public/pizza/3.png" alt="Third slide" >
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
	
        <div class="row">
           
		<c:forEach var="l" items="${list}">
		<div class="col-lg-4 col-md-6 mb-4">
     		
       	
       	
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="../load/pizza/${l.hinh}" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <p><b>${l.name}</b></p>   	
                </h4>
                <h5>
                	
                
                   <div class="markshow" id="${l.getId_pizza()}price">
                   	${l.getKichthuoc().get(0).getGia()}
                   </div>

 				
				</h5>
                <p class="card-text">${l.detail}</p>
              </div>
              <div class="card-footer">
             
     				          
               
                <div class="dropdown">
             <select class="browser-default custom-select" name="kichthuoc" id="${l.getId_pizza()}">
          		<c:forEach var="u" items="${l.getKichthuoc()}">
          		<option pizzaSize="${s.getId_kichthuoc()}" value="${l.getId_pizza()}${u.getId_kichthuoc()}" >${u.getTenkc()}</option>
          		 
            	</c:forEach>
    			</select>
    			<c:forEach var="s" items="${l.getKichthuoc()}">
  				 <div class="d-none mark "  id="${l.getId_pizza()}${s.getId_kichthuoc()}">${s.getGia()}</div>
  				</c:forEach>
            </div>
         
            <button role="order" class="btn btn-danger mt-2" pizza-id="${l.getId_pizza()}">Đặt Hàng</button>
            
              </div>
            </div>
         
 			</div>
          </c:forEach> 
         
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <!-- Footer -->
<%@include file="../../common/trangchu/footer.jsp"%>

  <!-- Bootstrap core JavaScript -->
  <script src="../resources/trangchu/js/jquery.min.js"></script>
  <script src="../resources/trangchu/js/bootstrap.bundle.min.js"></script>
  <script src="../resources/trangchu/js/test.js"></script>
     <script>
                $(function(){
                  $('select').on('click', function() {
                    var id = $(this).prop('id');
                    var val = $(this).val();
                    var gia = $('#' + val).text();
                    console.log(val)
					
                    $('#' + id + 'price').text(gia);
                })
                  let soluong = 0;
                  $("button[role='order']").click(function(){
                    let idPizza = $(this).attr("pizza-id");
                    let size = $($($(this).parent().children()[0]).children()[0]).val() % 10;
                    $.ajax({
                    	type:"POST",
                    	url:"./pizza.htm",
                    	data:{
                    		idPizza: idPizza,
                    		size: size
                    	},
                    	success: function(d){
                    		console.log(d);
                    		soluong++;
                    		$("#soluonghang").text(soluong);
                    	}
                    })
                  })
                })
                
      </script>
</body>

</html>