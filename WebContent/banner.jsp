<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body>
<%

String username=(String)request.getSession().getAttribute("username");

if (username==null )
{                  
	//验证用户是否登录,防止非法登陆
	response.sendRedirect("login.jsp");               //重定向网页到login.jsp页
	}

%>
<table width="100%" border="1" class="abc">
  <tr>
    <td width="91%" height="146" align="center"><img src="images/logo.jpg" width="100%" height="140" /></td>
    <td width="9%" align="center"bgcolor="#66FFFF" ><p class="abc">&nbsp;</p>
      <p>当前登录用户：<%=username %></p>
    <p class="abc">&nbsp;</p></td>
  </tr>
</table>
</body>
</html>