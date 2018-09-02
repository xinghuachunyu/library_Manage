<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<%
ArrayList al=(ArrayList)request.getSession().getAttribute("al");
%>
<h1>图书借阅排行榜</h1>
<hr>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
  <tr align="center">
    <td class="color">排名</td>
    <td class="color">图书条形码</td>
    <td class="color">图书名称</td>
    <td class="color">图书类型</td>
    <td class="color">书架</td>
    <td class="color">出版社</td>
    <td class="color">作者</td>
    <td class="color">定价（元）</td>
    <td class="color">借阅次数</td>
  </tr>
  <%
  for(int i=0;i<al.size();i++)
  {
	  bookBean bb=(bookBean)al.get(i);
	  %>
	  <tr align="center">
    <td><%=i+1 %></td>
    <td><%=bb.getBarcode()%></td>
    <td><%=bb.getBookname() %></td>
    <td><%=bb.getTypename() %></td>
    <td><%=bb.getName() %></td>
    <td><%=bb.getISBN() %></td>
    <td><%=bb.getAuthor() %></td>
    <td><%=bb.getPrice() %></td>
    <td><%=bb.getBorrowNum()%></td>
  </tr>
	  <%
  }
  %>
</table>
</body>
</html>