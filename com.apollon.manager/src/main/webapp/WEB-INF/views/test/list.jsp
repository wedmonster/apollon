<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- test.list test/list.jsp -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subject Management System</title>

<style type="text/css">
*{
 font-family: arial;
}
a, p, pre, li{
 font-size: 10pt;
}
</style>

</head>
<body style="line-height: 120%;">
<h1><c:out value="${s_name}" /></h1>
<hr/>
<p>test information > <a href="">insert</a> </p>
<hr/>
<h2>Test information</h2>
<hr/>
<h3>Remained tests </h3>
<div style="padding-left: 10px;">
	<ul>
		<c:forEach items="${remained}" var="remaineds">
			<li>[T : <c:out value="${remaineds.take_test_date}"/>] <c:out value="${remaineds.type}"/></li>
		</c:forEach>
	</ul>
</div>
<c:forEach items="${test}" var="tests">
	<hr/>
	<p><a name="<c:out value="${tests.t_id}"/>"></a><b><c:out value="${tests.write_date }" /></b> <a href="">modify</a> <a href="">delete</a></p>
	<div style="padding-left: 10px;">
		<p>Type : <c:out value="${tests.type}"/></p>
		<p>Test Day : <c:out value="${tests.take_test_date}"/></p>
		<p>Range</p>
		<ul>		
			<li>Chapter : <c:out value="${tests.title_range_start}"/> ~ <c:out value="${tests.title_range_finish }"/></li>
			<li>Page : <c:out value="${tests.page_range_start}"/> ~ <c:out value="${tests.page_range_finish}"/></li>
		</ul>
		<p>State : <c:out value="${tests.isdone}"/></p>
		<p>Notice</p>
		<textarea style="width:400px;height:60px;"> <c:out value="${tests.notice }"/> </textarea>
		 <p align="right">written by <c:out value="${tests.write_date}" /></p>
	</div>
</c:forEach>
<hr/>
</body>
</html>