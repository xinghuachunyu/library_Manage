<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书馆管理系统首页</title>
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
    <td width="85%" ><jsp:include flush="true" page="main.jsp"></jsp:include></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>