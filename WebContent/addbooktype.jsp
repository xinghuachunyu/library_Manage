<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加图书类型</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<table width="100%" border="1">
  <tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
  </tr>
  <tr>
    <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
    <td width="85%" >
    <h1>添加图书类型</h1>
	<hr>
	<form method="post" action="bookServletCL?flag=addbooktype">
	<table class="border">
	<tr class="border">
	   <td bgcolor="#ffcc66">图书类型</td>
	   <td><input type="text" name="typename" /></td>
	</tr>
	<tr>
	   <td bgcolor="#ffcc66">可借天数</td>
		<td>
		<select name="">
		<option style="width: 50px;" selected>30天</option>
		</select>	
		</td>
	</tr>
	<tr>
	    <td colspan="2"><input type="submit" name="submit" value="确定"></td>
	</tr>
	</table>
	</form>
    </td>
	</tr>
	<tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>