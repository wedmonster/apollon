<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subject Management System</title>
<style type="text/css">
body {
 font-size: 10pt;
}
</style>
</head>
<body >
<p><a href="">Logout</a></p>
<p><a href="subject.main" target="_parent">Main</a></p>
<p><a href="">Insert new subject</a></p>
<p><a href="">Manage your terms</a></p>
<hr/>
<ul>
	<li>Terms</li>
		<ul>
			<c:forEach items="${result.terms}" var="terms">
			  <li><c:out value="${terms.term}" /> </li>
				  <ul>
				  <c:forEach items="${result.subjects}" var="subjects">
				    <c:if test="${subjects.t_id==terms.t_id}">
				    	<li><a href="<c:out value="${subjects.s_id}"/>/subject.summary" target="right">
				    	<c:out value="${subjects.title}" /> </a></li>
				    </c:if>  	
				  </c:forEach>
				  </ul>
			</c:forEach>	
		</ul>
		<hr/>
	<li>Character orders</li>
		<ul>
			<c:forEach items="${result.title}" var="titles">
			  <li><c:out value="${titles.title}"/></li>
			</c:forEach>
		</ul>
</ul>
</body>
</html>