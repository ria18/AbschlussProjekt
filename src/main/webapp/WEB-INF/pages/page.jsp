<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="images" value="/resources/images" />
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Table Link  -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/fontawesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- Custom style -->

<link href="${css}/style.css" rel="stylesheet">

<title> Lizenz Generator ${title}</title>
	
<!-- Java-script -->
 <script>
	    <!-- to know wich navbar is active  -->
	    window.menu='${title}';
	    
	    </script>


</head>
<body>

	<div class="se-pre-con"></div>
	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./navbar.jsp"%>


		<!-- Page Content: Loading the home content -->
		<c:if test="${userClickAdminPage == true}">
			<%@include file="adminPage.jsp"%>
		</c:if>

		<!-- Load only when user clicks product -->
 		<c:if test="${userClickHome == true}">
			<%@include file="product.jsp"%>
		</c:if> 
		
		<c:if test="${userClickHome == false}">
			<%@include file="LizenzForm.jsp"%>
		</c:if> 
		

	</div>

	<!-- Self coded javascript -->
	<script src="${js}/myapp.js"></script>
	
	<script src="${js}/jquery/jquery.validate.js"></script>
	<script src="${js}/jquery/jquery.validate.min.js"></script>
	
	

</body>
</html>