<%-- 
    Document   : create
    Created on : 06.07.2019, 16:59:24
    Author     : alegara
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<%@taglib prefix="review" tagdir="/WEB-INF/tags/review/" %>


<fmt:setBundle basename="resources.labels"/>

<common:layout>
    <jsp:attribute name="title">
        <fmt:message key="label.review.create"/>
       
    </jsp:attribute>
    <jsp:body>
        <h2>
            
            <fmt:message key="label.review.create"/>     
        
        </h2>
            <review:create/>
        
        
    </jsp:body>
    
    
    
</common:layout>
