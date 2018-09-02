<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*,bookservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>读者档案管理</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<%
ArrayList bookinfoal=(ArrayList)request.getAttribute("bookinfoal");
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
		<h1>图书档案管理</h1>
<hr>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr >
	<td colspan="9" align="right"><a href="addbookinfo.jsp">添加图书</a><td>
</tr>
  <tr align="center">
    <td bgcolor="#ffcc66">图书条形码</td>
    <td bgcolor="#ffcc66">图书名称</td>
    <td bgcolor="#ffcc66">书架</td>
    <td bgcolor="#ffcc66">出版社</td>
    <td bgcolor="#ffcc66">作者</td>
    <td bgcolor="#ffcc66">定价（元）</td>
    <td bgcolor="#ffcc66">修改</td>
     <td bgcolor="#ffcc66">删除</td>
  </tr>
  <%
  if(bookinfoal!=null)
  {
  for(int i=0;i<bookinfoal.size();i++)
  {
	  bookBean bb=(bookBean)bookinfoal.get(i);
	  %>
	  <tr align="center">
    <td class="border"><%=bb.getBarcode()%></td>
    <td class="border"><%=bb.getBookname() %></td>
    <td class="border"><%=bb.getName() %></td>
    <td class="border"><%=bb.getISBN() %></td>
    <td class="border"><%=bb.getAuthor() %></td>
    <td class="border"><%=bb.getPrice() %></td>
    <td class="border"><a href="updatebookinfo.jsp?id=<%=bb.getId()%>">修改</a></td>
     <td class="border"><a href="bookServletCL?id=<%=bb.getId()%>&flag=deletbookinfo">删除</a></td>
  </tr>
	  <%
  }
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