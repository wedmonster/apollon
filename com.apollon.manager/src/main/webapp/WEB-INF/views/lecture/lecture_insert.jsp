<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subject Management System</title>

<style type="text/css">
body {
 height: 100%; /* body와 html의 높이를 100% 로 지정 */
 margin: 0;
 padding: 0;
}
div#center{
 width: 400px; /* 폭이나 높이가 일정해야 합니다. */
 height: 400px; /* 폭이나 높이가 일정해야 합니다. */
 position: absolute;
 top: 50%; /* 화면의 중앙에 위치 */
 left: 50%; /* 화면의 중앙에 위치 */
 margin: -200px 0 0 -200px; /* 높이의 절반과 너비의 절반 만큼 margin 을 이용하여 조절 해 줌 */
 border: 0px inset #ddd; 
}
a{
 font-size: 10pt;
}
font{
 font-size: 10pt;
}
</style>

</head>
<body>
	
	<div id="center" align="center">
	<br/><br/><br/><br/>
	
		<div align="center" style="border:1px solid #ddd">
			<br/>
			<br/>
			<div><h4>Insert Lecture Information.</h4></div>
			<form name="lecture_form" method="post" action="join.do">	
				<table border="0">
					<tr>
						<td><font>Lecture date</font></td>
						<td>					
							<input type="text" value="select lecture date" name="user" style="width:210px;"/>
						</td>
					</tr>
					<tr>
						<td><font>Range(Chapter)</font></td>
						<td>
							<input type="text" value="start" name="user_password" style="width:100px;"/>						
							<input type="text" value="end" name="user_password" style="width:100px;"/>
						</td>
					</tr>
					<tr>
						<td><font>Range(Page)</font></td>
						<td>
							<input type="text" value="start" name="user_password" style="width:100px;"/>
							<input type="text" value="end" name="user_password" style="width:100px;"/>						
						</td>
					</tr>				
					<tr align="center">
						<td colspan="2">					
						<input type="button" value="Back" style="width:80px;"  onClick="javascript:history.back(-1)"/>
						<input type="submit" value="Insert" style="width:80px;" />
						</td>					
					</tr>
				</table>
			</form>					
			<br/>
			<br/>
		</div>
	</div>
</body>
</html>