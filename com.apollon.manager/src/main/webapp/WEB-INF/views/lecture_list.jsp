<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subject Management System</title>

<style type="text/css">
*{
 font-family: arial;
}
a, p, pre{
 font-size: 10pt;
}
</style>

</head>
<body style="line-height: 100%;">
<h1><c:out value="${s_name}" /></h1>
<hr/>
<p>lecture information > <a href="lecture.insert">insert</a> </p>
<hr/>
<h2>Lecture information</h2>
<c:forEach items="${result}" var="results">
	<hr/>	
    <p><a name="<c:out value="${results.lecture.l_id}" />"><b><c:out value="${results.lecture.lecture_date}" /></b> <a href="">modify</a></a></p>
    <div style="padding-left: 10px;">	    
	    <p>Chapter : <c:out value="${results.lecture.title_range_start}" /> ~ <c:out value="${results.lecture.title_range_finish}" />
	    &nbsp;&nbsp;&nbsp; 
	    Page : <c:out value="${results.lecture.page_range_start}" /> ~ <c:out value="${results.lecture.page_range_finish}" /></p>	  
	    <p>Note :</p>
	    <p>Homeworks which are made by today. <a href="">insert</a></p>
	    <ul>
	    <c:forEach items="${results.newHomework}" var="newHomes">
	    	<li><a href='homework.list#<c:out value="${newHomes.h_id }"/>'>[D : <c:out value="${newHomes.deadline_date }"/>] <c:out value="${newHomes.homework_content }"/></a></li>
	    </c:forEach>
	    </ul>
	    <p>Homeworks that today is deadline.</p>
	    <ul>
	    <c:forEach items="${results.handInHomework}" var="handHome">
	    	<li><a href='homework.list#<c:out value="${handHome.h_id }"/>'>[<c:out value="${handHome.state }"/>][D : <c:out value="${handHome.deadline_date }"/>] <c:out value="${handHome.homework_content }"/></a></li>
	    </c:forEach>
	    </ul>	    
	    <p align="right">written by <c:out value="${results.lecture.write_date}" /></p>
    </div>
</c:forEach>

</body>
</html>