<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#"><img src="../resources/trangchu/img/logo2.jpg" width="32px"/>PIZZA DELICOUS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
	<c:if test="${sessionScope.kt=='yes'}">
                 <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${sessionScope.dangnhap}
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Quản Lí</a>
                <a class="dropdown-item" href="#">Hoạt Động Khác</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="../test/dangxuat.htm">Log Out</a>
              </div>
            </li>
     </c:if>  
    <c:if test="${sessionScope.kt!='yes'}">
                    <li class="nav-item m-1">
            <button type="button" class="btn btn-secondary" ><a class="text-white" >Đăng Nhập</a></button>
          </li>
          <li class="nav-item m-1">
            <button type="button" class="btn btn-secondary"><a class="text-white">Tạo Tài Khoản</a></button>
          </li>
   </c:if>
         <li class="nav-item active m-1">           
               
                <button type="button" class="btn btn-danger"><a class="text-white">Giỏ Hàng<img src="../resources/trangchu/img/smart-cart.png" alt="cart" width="20px"/></a>
                 <div id="soluonghang" class="abs text-white">0</div>
                </button>
                
              </li>		

                </ul>
            </div>
        </div>
    </nav>