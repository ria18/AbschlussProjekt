<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manage Lizenz</title>

</head>
<body>
<div class="container">
	<div class="table-wrapper">
		 <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Verwaltung der <b>Lizenzen</b></h2>
							
					</div>
					<div class="col-sm-6">
						<a href="adminPage/newLizenz" class="btn btn-info" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Neue Lizenz erstellen </span></a>
										
					</div>
                </div>
            </div>
				
		
			<table class="table table-striped table-hover" id="mytable">

				<thead>
					<tr>
						<th>lizenzKey</th>
						<th>lizenzName</th>
						<th>Action</th>
					</tr>

			</thead>
				<tbody>
					<c:forEach var="lizenz" items="${listLizenz}">
						<tr>
							<td> ${lizenz.lizenzKey}</td>
							<td >${lizenz.lizenzName}</td>
							<td>
		                            <a href="adminPage/editLizenz?id=${lizenz.id}" id ="edit" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
		                            <a href="adminPage/deleteLizenz?id=${lizenz.id}" title="Delete" data-toggle="tooltip"
								data-confirm="Are you sure to delete this item?" id ="delete" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                        	</td>
						</tr>
						</c:forEach>
					</tbody>
				
			</table>
		</div>
		</div>
	
  		

</body>
</html>
