<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Neue Lizenz erstellen </title>

    <!-- Main css -->
    <link href="${css}/form.css" rel="stylesheet"> 
    <link href="${css}/style.css" rel="stylesheet"> 
</head>
    <div class="main">
	
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form:form class="signup-form" id="lizenzForm" action="saveLizenz" method="post" modelAttribute="lizenz">
                        <h2 class="form-title">New Lizenz erstellen</h2>
                        <form:hidden path="id"/>
                      
                         <div class="form-group">
                            <form:input path="lizenzName" class="form-input" placeholder="LizenzName"/>
                        <form:errors path="lizenzName" cssClass="help-block" element="em" />
                        </div>
              
                         <div class="form-group">
                            <form:input path="lizenzKey" class="form-input" placeholder="LizenzKey"/>
                           <form:errors path="lizenzKey" cssClass="help-block" element="em"/>	
                        </div>
                      
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Speichen"/>
                        </div>
                  
                    </form:form>
                   
                </div>
            </div>
        </section>

    </div>
