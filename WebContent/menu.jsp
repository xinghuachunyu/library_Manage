<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css" > 
</head>
<body >
<table width="100%" border="1" class="color">
  <tr>
   <UL>
<LI><A id="current" href="index.jsp">首页<p>HOME</p></A>
</LI>
<LI>系统设置<p>XI TONG GUAN LI</p>
<UL>
  <LI><A href="libraryServletCL">图书馆信息</A></LI>
  <LI><A href="managerServletCL?flag=manageset">管理员设置</A></LI>
</UL>
</LI>
<LI>图书管理<p>TU SHU GUAN LI</p>
<UL>
  <LI><A href="bookServletCL?flag=setbooktype">图书类型管理</A></LI>
   <LI><A href="bookServletCL?flag=setbookinfo">图书档案管理</A></LI>
</UL>
</LI>
<LI>图书借还<p>TU SHU JIE HUAN</p>
<UL>
  <LI><A href="readerServletCL?type=toJsp">图书借阅</A></LI>
   <LI><A href="borrowContine.jsp">图书续借或归还</A></LI>
</UL>
</LI>
<LI>系统查询<p>XING TONGCHA XUN</p>
<UL>
  <LI><A href="selectbookborrow.jsp">图书借阅查询或借阅到期提醒</A></LI>
</UL>
</LI>
<LI><A  href="readerServletCL?type=toQuit">退出系统<p>TUI CHU</p></A>
</LI>
</UL>

  </tr>
</table>
</body>
</html>