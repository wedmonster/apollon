<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- homework.list homework/list.jsp -->
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
<body style="line-height: 120%;">
<h1><c:out value="${s_name}" /></h1>
<hr/>
<p>homework information > <a href="">insert</a> </p>
<hr/>
<h2>Homework information</h2>
<hr/>
<h3>Today is </h3>
<div style="padding-left: 10px;">
	<hr/>
	DEADLINE
	<hr/>
	<ul>
	<c:forEach items="${deadLine}" var="deadLines">
		<li>[<c:out value="${deadLines.state}"/>][D : <c:out value="${deadLines.deadline_date}"/>] <c:out value="${deadLines.homework_content}"/></li>
	</c:forEach>
	</ul>
</div>
<c:forEach items="${homework}" var="homeworks">
	<hr/>
	<p><a name="<c:out value="${homeworks.h_id}"/>"></a><b><c:out value="${homeworks.formatted_write_date }" /></b> <a href="">modify</a> <a href="">delete</a></p>
	<div style="padding-left: 10px;">
		<p>Related lecture information : <a href='lecture.list#<c:out value="${homeworks.l_id }"/>'><c:out value="${homeworks.lecture_date }"/></a></p>
		<p>DeadLine : <c:out value="${homeworks.deadline_date }"/></p>
		<p>State : <c:out value="${homeworks.state}"/></p>
		<p>Description</p>
		<textarea style="width:400px; height:60px;"><c:out value="${homeworks.homework_content }"/></textarea>	
	</div>
	 <p align="right">written by <c:out value="${homeworks.write_date}" /></p>
</c:forEach>
<hr/>
<!-- 
<c:forEach items="${result}" var="results">
	<hr/>	
    <p><a name="<c:out value="${results.lecture.l_id}" />"><c:out value="${results.lecture.lecture_date}" /> <a href="">modify</a></a></p>
    <div style="padding-left: 10px;">	    
	    <p>Chapter : <c:out value="${results.lecture.title_range_start}" /> ~ <c:out value="${results.lecture.title_range_finish}" />
	    &nbsp;&nbsp;&nbsp; 
	    Page : <c:out value="${results.lecture.page_range_start}" /> ~ <c:out value="${results.lecture.page_range_finish}" /></p>	  
	    <p>Note :</p>
	    <p>Homeworks which are made by today. <a href="">insert</a></p>
	    <ul>
	    <c:forEach items="${results.newHomework}" var="newHomes">
	    	<li><pre>[<c:out value="${newHomes.deadline_date }"/>]	<c:out value="${newHomes.homework_content }"/></pre></li>
	    </c:forEach>
	    </ul>
	    <p>Homeworks that today is deadline.</p>
	    <ul>
	    <c:forEach items="${results.handInHomework}" var="handHome">
	    	<li><pre>[<c:out value="${handHome.state }"/>][<c:out value="${handHome.deadline_date }"/>]	<c:out value="${handHome.homework_content }"/></pre></li>
	    </c:forEach>
	    </ul>	    
	    <p align="right">written by <c:out value="${results.lecture.write_date}" /></p>
    </div>
</c:forEach> -->

</body>
</html>