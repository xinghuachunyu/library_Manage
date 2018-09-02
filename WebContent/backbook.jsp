<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书归还</title>
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
		padding:10px;
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
	a{text-decoration:none;color:#cc9933;}
  </style>

</head>
<body>
<table width="100%" border="1">
  <tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
  </tr>
  <tr>
    <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
    <td width="85%" >
<h1 align="center">图书归还</h1>
  <div class="container">
	<div class="jy-yz">
		<div class="first">
			<div class="left" style="width:150px;height:20px;"><p style="color:#cc6600;">读者验证</p></div>
			<div class="left" style="width:400px;height:20px;">读者条形码:&nbsp&nbsp<input type="text" size="30"/></div>
			<div class="left" style="height:20px;"><input type="button" style="width:40px;height:22px;font-size:12px;" value="确定"/></div>
			<div class="clear"></div>
		</div>
		<div class="socend">
			<div class="text left">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input type="text" size="20"></div>
			<div class="text left">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input type="text" size="20"></div>
			<div class="text left">读者类型:&nbsp;<input type="text" size="20"></div>
			<div class="text left">证件类型:&nbsp;<input type="text" size="20"></div>
			<div class="text left">证件号码:&nbsp;<input type="text" size="20"></div>
			<div class="text left">可借数量:&nbsp;<input type="text" size="20"></div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="jy-cx">
		<!--<div class="jy-js">
			添加的依据：&nbsp;&nbsp;
			<label><input name="yiju" type="radio" value=""/>&nbsp;&nbsp;图书条形码</label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label><input name="yiju" type="radio" value=""/>&nbsp;&nbsp;图书名称</label>
			<input type="text" style="width:500px;height:22px;"/>
			<input type="button" value="确定"/>
			<input type="button" value="完成借阅"/>-->
		</div>
		<div class="jy-bg">
			<table style="border-collapse:collapse;">
				<tr style="background-color:#ffcc66;" class="tborder" align="center">
					<td style="width:250px;">图书名称</td>
					<td style="width:120px;">借阅时间</td>
					<td style="width:120px;">应还时间</td>
					<td style="width:120px;">出版社</td>
					<td style="width:120px;">书签</td>
					<td style="width:120px;">定价（元）</td>
					<td style="width:170px;">完成归还</td>
				</tr>
				<tr style="background-color:white;" class="tborder" align="center">
					<td style="width:250px;" class="border">JSP程序开发范例宝典</td>
					<td style="width:120px;" class="border">2007-11-26</td>
					<td style="width:120px;" class="border">2007-12-26</td>
					<td style="width:120px;" class="border">人民邮电出版社</td>
					<td style="width:120px;" class="border">左A-1</td>
					<td style="width:120px;" class="border" >89.0</td>
					<td style="width:170px;" class="border" ><a href="#">归还</a></td>
				</tr>
				<tr style="background-color:white;" class="tborder" align="center">
					<td style="width:250px;" class="border">JSP程序开发范例宝典</td>
					<td style="width:120px;" class="border">2007-11-26</td>
					<td style="width:120px;" class="border">2007-12-26</td>
					<td style="width:120px;" class="border">人民邮电出版社</td>
					<td style="width:120px;" class="border">左A-1</td>
					<td style="width:120px;" class="border" >89.0</td>
					<td style="width:170px;" class="border" ><a href="#">归还</a></td>
				</tr>
			</table>
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