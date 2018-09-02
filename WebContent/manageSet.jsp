<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员设置</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" >
</head>
<body>
<%
ArrayList al=(ArrayList)request.getSession().getAttribute("al1");
String username=(String)request.getSession().getAttribute("username");
out.print("username=?"+username);
if (username==null)
{                  
	//验证用户是否登录,防止非法登陆
	response.sendRedirect("login.jsp");               //重定向网页到login.jsp页
}
int sysset=0;                                //定义保存系统设置权限的变量
int readerset=0;                              //定义保存读者管理权限的变量
int bookset=0;                                //定义保存图书管理权限的变量
int borrowback=0;                             //定义保存图书借还权限的变量
int sysquery=0;                               //获得系统查询权限
%>

<table width="100%" border="1">
<tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
</tr>

  <tr  bgcolor="#e3F4F7">
   <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
<td width="85%">
<a href="addMagener.jsp" class="color">添加管理员</a>
<hr>
   <table width="91%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
   <tr>
    <td width="26%" align="center">管理员名称</td>
    <td width="12%"align="center">系统设置</td>
    <td width="12%"align="center">读者管理</td>
    <td width="12%"align="center">图书管理</td>
    <td width="11%"align="center">图书借还</td>
    <td width="11%"align="center">系统查询</td>
    <td width="8%"align="center">权限设置</td>
    <td width="8%"align="center">删除</td>
    </tr>
    <%
for(int i=0;i<al.size();i++)
  {
	 managerBean mb=(managerBean)al.get(i);
	 %>
 <tr>
 <td align="center"><%=mb.getName() %></td> 
<td align="center"><input name="checkbox" type="checkbox" class="color" value="checkbox" disabled="disabled" <%if(mb.getSysset()!=0){out.println("checked");}%>></td>
<td align="center"><input name="checkbox" type="checkbox" class="color" value="checkbox" disabled="disabled" <%if(mb.getReaderset()!=0){out.println("checked");}%>></td>
<td align="center"><input name="checkbox" type="checkbox" class="color" value="checkbox" disabled="disabled" <%if(mb.getBookset()!=0){out.println("checked");}%>></td>
<td align="center"><input name="checkbox" type="checkbox" class="color" value="checkbox" disabled="disabled" <%if(mb.getBorrowback()!=0){out.println("checked");}%>></td>
<td align="center"><input name="checkbox" type="checkbox" class="color" value="checkbox" disabled="disabled" <%if(mb.getSysquery()!=0){out.println("checked");}%>></td>
<td align="center"> <%if(!mb.getName().equals(username)){ %><a href="managerServletCL?id=<%=mb.getId() %>&flag=setprivilege" class="color">权限设置</a><%}else{%>&nbsp;<%}%> </td>
<td align="center"> <%if(!mb.getName().equals(username)){ %><a href="managerServletCL?id=<%=mb.getId() %>&flag=delet" class="color">删除</a><%}else{%>&nbsp;<%}%> </td>
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