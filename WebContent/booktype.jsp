<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书类型管理</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
<script type="text/javascript"></script>
  <script>

  </script>
</head>
<body>
<%
ArrayList booktypeal=(ArrayList)request.getAttribute("booktypeal");
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
<h1>图书类型设置</h1>
	<hr>
	<table cellspacing="0" class="center">
		<tr >
			<td colspan="4" align="right"><a href="addbooktype.jsp">添加图书类型</a><td>
		</tr>
		<tr bgcolor="#ffcc66">
			<td align="center" width="300" class="border">图书类型名称</td>
			<td align="center" width="300" class="border">可借天数</td>
			<td align="center" width="100" class="border">修改</td>
			<td align="center" width="100" class="border">删除</td>
		</tr>
		<%
		for(int i=0;i<booktypeal.size();i++)
		{
			bookBean bk=(bookBean)booktypeal.get(i);
			%>
			<tr >
			<td align="center" width="100" class="border"><%=bk.getTypename() %></td>
			<td align="center" width="100" class="border"><%=bk.getDays() %></td>
			<td align="center" width="50" class="border"><a href="updatebooktype.jsp?id=<%=bk.getId() %>">修改</a></td>
			<td align="center" width="50" class="border"><a href="bookServletCL?id=<%=bk.getId() %>&flag=deletbooktype">删除</a></td>
			</tr>
			<%
		}
		%>
	</table>
	</td>
	</tr>
	<tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>