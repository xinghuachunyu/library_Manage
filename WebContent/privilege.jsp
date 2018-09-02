<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page language="java" import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限设置</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" >
<script type="text/javascript">
<!--
function close()
{
	window.close();
	}
	
-->
</script>
</head>
<body>
<%
ArrayList al=(ArrayList)request.getAttribute("al2");
managerBean mb=(managerBean)al.get(0);
String username=(String)request.getSession().getAttribute("username");

if (username==null )
{                  
	//验证用户是否登录,防止非法登陆
	response.sendRedirect("login.jsp");               //重定向网页到login.jsp页
	}
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
<h1>权限管理</h1>
<hr>
<form  method="post" action="managerServletCL?id=<%=mb.getId() %>&flag=changprivilege">
<table width="100%" border="0" class="backgd"  cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
  <tr align="center">
    <td class="color">管理员名称：<%=mb.getName() %></td>
  </tr>
  <tr>
    <td><table width="100%" border="0">
      <tr>
        <td rowspan="3" align="center" class="color">管理员所具有的权限：</td>
        <td align="center">
          <p>
            <span class="abc">
            <input name="checkbox1" type="checkbox" <%if(mb.getSysset()!=0){out.print("checked");} %> value="sysset" />
            
            系统设置
            </span></p>
        </td>
        <td align="center">
          <span class="abc">
          <input name="checkbox1" type="checkbox"  <%if(mb.getReaderset()!=0){out.print("checked");} %>  value="readerset"/>
          读者管理
          </span>
       </td>
        </tr>
      <tr>
        <td align="center">
          <span class="abc">
          <input name="checkbox1" type="checkbox"   <%if(mb.getBookset()!=0){out.print("checked");} %> value="bookset"/>
          图书管理
         </span>
        </td>
        <td align="center">
          <span class="abc">
          <input name="checkbox1" type="checkbox" <%if(mb.getBorrowback()!=0){out.print("checked");} %> value="borrowset"/>
          图书借还权限
          </span>
       </td>
        </tr>
      <tr>
        <td align="center">
          <span class="abc">
          <input name="checkbox1" type="checkbox"  <%if(mb.getSysquery()!=0){out.print("checked");} %> value="sysquery"/>
          系统查询权限
          </span>
        </td>
        <td align="center">&nbsp;</td>
      </tr>
    </table></td>
  <tr align="center">
    <td class="color">
      <input type="submit" value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" name="button1"  value="关  闭" Onclick="return close()"/>
   </td>
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