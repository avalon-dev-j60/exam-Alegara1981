<%-- 
    Document   : loginForm
    Created on : 22.06.2019, 14:25:30
    Author     : JAVA
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<fmt:setBundle basename="resources.labels"/>
<common:error/>

<form name="loginForm"
      action="${pageContext.servletContext.contextPath}/login"
      method="post">
    
    <p class="row gap-bottom">
        <input type="email"
               name="email"
               value="${param.email}"
               placeholder="<fmt:message key="label.email"/>"
               required>
    </p>
    
    <p class="row gap-bottom">
        <input type="password"
               name="password"
               placeholder="<fmt:message key="label.password"/>"
               required>
    </p>
    
    <p class="row gap-bottom">
        <a href="${pageContext.servletContext.contextPath}/register">
            <fmt:message key="label.registration.action"/>
        </a>
        <button class="pull-right">
            <fmt:message key="label.sign-in.title"/>
        </button>
    </p>
    
</form>
