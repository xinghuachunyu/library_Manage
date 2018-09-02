<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*,librarymodel.*,libraryservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书馆信息</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<%
ArrayList libraryal=(ArrayList)request.getSession().getAttribute("libraryal");
libraryBean lb=(libraryBean)libraryal.get(0);
%>
<table width="100%" border="1">
  <tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
  </tr>
   <tr>
    <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
    <td width="85%">
    <h1>图书馆信息</h1>
    <hr>
<table width="100%" border="0" class="abc">
  <tr>
    <td align="center"><span class="color">图书馆名称：</span></td>
    <td align="center"><%=lb.getLibraryname() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">馆长：</span></td>
    <td align="center"><%=lb.getCurator() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">联系电话：</span></td>
    <td align="center"><%=lb.getTel() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">联系地址：</span></td>
    <td align="center"><%=lb.getAddress() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">电子邮件：</span></td>
    <td align="center"><%=lb.getEmail() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">网址：</span></td>
    <td align="center"><%=lb.getUrl() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">创建日期：</span></td>
    <td align="center"><%=lb.getCreateDate() %></td>
  </tr>
  <tr>
    <td align="center"><span class="color">图书馆简介：</span></td>
    <td align="center"><%=lb.getIntroduce() %></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><form id="form1" name="form1" method="post" action="index.jsp">
      
      <span class="color">
      <input type="submit" name="submit" id="submit" value="返 回" />
      </span>
    </form></td>
  </tr>
</table>
</td>
</tr>
<tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
</table>
</body>
</html>