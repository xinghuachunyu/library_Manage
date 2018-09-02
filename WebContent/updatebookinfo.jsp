<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改图书</title>
<link rel="stylesheet" type="text/css" href="">
  <style type="text/css">
  *{padding:0;margin:0;font-size:14px;}
	.container{
		width:1000px;
		margin:50px auto;
	}
	td{padding:10px;}
  </style>
</head>
<body>
<%
String id=request.getParameter("id");
%>
<table width="100%" border="1">
  <tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
  </tr>
  <tr>
    <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
    <td width="85%" >
<h1>添加图书</h1>
	<hr>
	<div class="container">
	<form method="post" action="bookServletCL?id=<%=id %>&flag=updatebookinfo">
	<table>
	<tr>
	<td align="right" style="width:100px">图书ID：</td>
			<td style="padding-left:80px;"><%=id %></td>
	</tr>
		<tr>
			<td align="right" style="width:100px">条&nbsp形&nbsp码：</td>
			<td style="padding-left:80px;"><input type="text" name="barcode"size="20"/></td>
		</tr>
		<tr>
			<td align="right">图书名称：</td>
			<td style="padding-left:80px;"><input type="text" name="bookname"size="50"/></td>
		</tr>
		<tr>
			<td align="right">作者：</td>
			<td style="padding-left:80px;"><input type="text" name="author"size="40"/></td>
		</tr>
		<tr>
			<td align="right">译者：</td>
			<td style="padding-left:80px;"><input type="text" name="translate"size="40"/></td>
		</tr>
		<tr>
			<td align="right" >出版社ID(ISBN)：</td>
			<td  style="padding-left:80px;"><input type="text" name="publish" /></td>
		</tr>
		<tr>
			<td align="right">价格：</td>
			<td style="padding-left:80px;"><input type="text" name="price" size="20"/>（元）</td>
		</tr>
		<tr>
			<td align="right">页码：</td>
			<td style="padding-left:80px;"><input type="text"  name="page"size="20"/></td>
		</tr>
		<tr>
		<td colspan="2"align="center"><input type="submit" name="submit" value="确定"></td>
		</tr>
	</table>
	</form>
  </div>
	
	</td>
	</tr>
	<tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>