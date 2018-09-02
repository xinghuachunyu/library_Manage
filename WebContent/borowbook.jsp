<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page language="java"
	import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*,bookservlet.*,readermodel.*,readerservlet.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书借阅</title>
<link rel="stylesheet" type="text/css" href="">
  <style type="text/css">
	*{
		margin:0;
		padding:0;
		font-size:14px;
	}
	.left{
		float:left;
	}
	.clear{
		clear:both;
	}
	.container{
		margin:50px auto;
		border:2px solid #ffcc66;
		width:1000px;
		padding:5px;
	}
	.jy-yz{
		border:1px solid #ffcc66;
		width:988px;
		padding:5px;
	}
	.first{
	    border-bottom:2px solid #ffcc66;
		padding:5px;
		width:800px
		
	}
	.socend{
		padding:5px;
	}
	.text{
		padding:5px;
		width:300px;
	}
	.jy-js{
		width:988px;
		height:30px;
	}
	.jy-cx{
		padding:5px;
		background-color:#ffff99;
	}
	.border{
		border:1px solid #ffff66;
	}
	.tborder{border:1px solid white;}
	.color {
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 9pt;
	background-color:gray;
}
  </style>
</head>
<body>
<%
ArrayList readerborrowal=(ArrayList)request.getAttribute("readerborrowal"); 
String barcode=(String)request.getAttribute("barcode");

ArrayList bookborrowal=(ArrayList)request.getAttribute("bookborrowal");
int readerID=0;
String operator=null;
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
<div class="container">
	<div class="jy-yz">
		<div class="first"> 
		<form method="post" action="readerServletCL">
		<input type="hidden"name="type" value="toReader">
			<div class="left" style="width:150px;height:20px;"><p style="color:#cc6600;">读者验证</p></div>
			<div class="left" style="width:400px;height:20px;">读者条形码:&nbsp;&nbsp;<input type="text" name="barcode" size="30" value="${barcode}"/></div>
			<div class="left" style="height:20px;">
			<input type="submit" name="submit1"  style="width:40px;height:22px;font-size:12px;" value="确定"/></div>
			<div class="clear"></div>	
			</form>				
		</div>
		<%
		if(readerborrowal!=null)
		{
		   for(int i=0;i<readerborrowal.size();i++)
		    {
			readerBean rb=(readerBean)readerborrowal.get(i);
			%>
			<div>
				<div class="socend">
			 	<div class="text left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input type="text" name="name" value="<%=rb.getName() %>"/></div>
				<div class="text left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input type="text" name="sex" value="<%=rb.getSex() %>"/></div>
				<div class="text left">读者类型:&nbsp;<input type="text" name="vocation" value="<%=rb.getVocation() %>"/></div>
				<div class="text left">证件类型:&nbsp;<input type="text" name="papertype" value="<%=rb.getPaperType() %>"/></div>
				<div class="text left">证件号码:&nbsp;<input type="text" name="paperNo" value="<%=rb.getPaperNO() %>"/></div>
			 	<div class="clear">
			 	<%
			 	 readerID=rb.getId();
			 	 operator=rb.getOperator();
			 	%>
				</div>
			</div>
			<%
		}
		}
			%>
		
	</div>
	<div class="jy-cx">
		<div class="jy-bg">
			<table style="border-collapse:collapse;">
				<tr style="background-color:#ffcc66;" class="tborder" align="center">
					<td style="width:300px;">图书名称</td>
					<td style="width:120px;">借阅时间</td>
					<td style="width:150px;">应还时间</td>
					<td style="width:150px;">出版社</td>
					<td style="width:150px;">书签</td>
					<td style="width:150px;">定价（元）</td>
					<td style="width:150px;">借阅</td>
				</tr>
				
				<%
				if(bookborrowal!=null)
				{
				for(int i=0;i<bookborrowal.size();i++) 
				{
					bookBean bb=(bookBean)bookborrowal.get(i);
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					Date date=new Date();
					%>
					<tr style="background-color:white;" class="tborder" align="center">
					<td style="width:300px;" class="border"><%=bb.getBookname() %></td>
					<td style="width:120px;" class="border"><%=df.format(new Date(date.getTime()))%></td>
					<td style="width:150px;" class="border"><%= df.format(new Date(date.getTime()+(long)30*24*60*60*1000))%></td>
					<td style="width:150px;" class="border"><%=bb.getISBN() %></td>
					<td style="width:150px;" class="border"><%=bb.getName() %></td>
					<td style="width:150px;" class="border" ><%=bb.getPrice() %></td>
					<td style="width:150px;"><a href="readerServletCL?readerID=<%=readerID %>&bookID=<%=bb.getId()%>&operator=<%=operator %>&type=toBorrow">借阅</a></td>
				</tr> 		
					<%
				}
				}
				%>
			</table>
		</div>
	</div>
  </div>
  </div>
</td>
</tr>
 <tr>
    <td colspan="2" align="center"><jsp:include flush="true" page="copyright.jsp"></jsp:include></td>
  </tr>
  </table>
</body>
</html>