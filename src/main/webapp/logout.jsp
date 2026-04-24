<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Page de secours - la deconnexion passe par le servlet /logout
    response.sendRedirect(request.getContextPath() + "/logout");
%>
