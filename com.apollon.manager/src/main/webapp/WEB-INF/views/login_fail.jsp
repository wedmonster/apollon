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
 margin: -200px 0 0 -200px;
 border: 0px inset #ddd; 
}
p{
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
			<h4>Login failed.</h4>			
			<table border="0" >				
				<tr align="center">
					<td>
						<p>You might insert invalid id or password.</p>
						<p>Please Try again!</p>
					</td>
				</tr>
				<tr align="center">				
					<td>
						<input type="button" value="Back" style="width:80px;" onClick="javascript:history.back(-1)"/>
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