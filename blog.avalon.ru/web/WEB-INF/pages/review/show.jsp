<%-- 
    Document   : view
    Created on : 06.07.2019, 17:46:07
    Author     : alegara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="common" tagdir="/WEB-INF/tags/common/" %>

<common:layout>
    <jsp:attribute name="title">
${review.title}
    
    </jsp:attribute>
    <jsp:body>
        <h2>
            ${review.title}
            
        </h2>
       ${review.content}
    </jsp:body>
    
    
</common:layout>
    

