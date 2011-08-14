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
a, p{
 font-size: 10pt;
}
</style>

</head>
<body  style="line-height: 70%;">
<h1><c:out value="${s_name}" /></h1>
<hr/> 
<p>subject > <a href="">modify</a>  <a href="">delete</a> </p>
<hr/>
<h2>Subject information</h2>
<div style="padding-left: 10px;">
	<hr/>
	<p>subject information > <a href="">insert</a> <a href="">modify</a>  <a href="">delete</a> </p>
	<hr/>
	<p>Term : <c:out value="${term}"/>&nbsp;&nbsp;&nbsp; File Tag : <c:out value="${extra.file_tag}"/></p>
	<p>Professor's name :  <c:out value="${extra.prof_name}"/></p>
	<p>Professor's cell number :  <c:out value="${extra.prof_phone_number}"/></p>
	<p>Professor's e-mail :  <a href="email://<c:out value="${extra.prof_email}"/>"><c:out value="${extra.prof_email}"/></a></p>
	<p>Subject homepage :  <a href="http://<c:out value="${extra.homepage}"/>"><c:out value="${extra.homepage}"/></a></p>
	<p align="right">written by <c:out value="${extra.write_date}" /></p>
</div>
<hr/>



<h2>Latest Lecture Information <a href="lecture.list">more</a></h2> 
<hr/>
<p>lecture information > <a href="">insert</a> </p>
<hr/>

<h2>Latest Homework Information <a href="homework.list">more</a></h2> 
<hr/>
<p>homework information > <a href="">insert</a> </p>
<hr/>

<h2>Latest Test Information <a href="test.list">more</a></h2>
<hr/>
<p>test information > <a href="">insert</a> </p>
<hr/>

</body>
</html>