
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${css}/style.css" rel="stylesheet">
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2> Alle Verfügbare <b>Lizenzen</b></h2>
					</div>
					<div class="col-sm-6">
						<a href="download" class="btn btn-info"><i class="fas fa-arrow-circle-down"></i> <span>Lizenz Herunterladen</span></a>
										
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover" id ="mytable">
                <thead>
                    <tr>
						<th class="col-md-1"> </th>
						 <th class="col-md-2"> LizenzKey </th>
                        <th class="col-md-3"> LizenzName </th>
                       
                    </tr>
                </thead>
                 <tbody>	
				<c:forEach var="lizenz" items="${listLizenz}" varStatus="itr">				
					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox" name="chechBoxName" value="">
								<label for="checkbox"></label>
							</span>
						</td>
						<td>${lizenz.lizenzKey}</td>
                        <td>${lizenz.lizenzName}</td>
                    </tr> 
					</c:forEach>
                </tbody>
            </table>
			
        </div>
    </div>
