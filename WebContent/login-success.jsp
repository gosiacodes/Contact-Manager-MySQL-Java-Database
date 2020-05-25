<%@page import="mvc.bean.aBean"%>

<p>You are successfully logged in!</p>

<%
aBean bean=(aBean)request.getAttribute("bean");
out.print("Welcome, " + bean.getName());
%>