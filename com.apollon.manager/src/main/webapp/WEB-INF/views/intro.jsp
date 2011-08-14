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
</style>

</head>
<body>
	
	<div id="center" align="center">
	<br/><br/><br/><br/>
	<div><h4>Welcome to the Subject Management System!</h4></div>
		<div align="center" style="border:1px solid #ddd">
			<br/>
			<br/>
			<form name="login_form" method="post" action="login.do">	
			<table border="0">
				<tr>
					<td colspan="2">
						<input type="text" value="Input your ID" name="user" style="width:200px;"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" value="password" name="user_password" style="width:110px;"/>
					</td>
					<td>
						<input type="submit" value="login" style="width:80px;"/>
					</td>
				</tr>
			</table>
			</form>
			<br/>
			<a href="join">join us</a>
			<br/>
			<br/>
		</div>
	</div>
</body>
</html>