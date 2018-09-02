<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java"
	import="java.util.*,bookmodel.*,managermodel.*,managerservlet.*,bookservlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-size: 14px;
}

.container {
	width: 1000px;
	margin: 50px auto;
}

.top {
	width: 980px;
	padding: 10px;
	margin-bottom: 20px;
	background-color: #ffcc00;
}

.check1 {
	margin-left: 60px;
	padding: 5px;
}

.check2 {
	margin-left: 60px;
	padding: 5px;
}

.border {
	border: 1px solid #ffff66;
}

.tborder {
	border: 1px solid white;
	height: 40px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书续借</title>
</head>
<body>
	<%
		ArrayList borrowinformational = (ArrayList) request.getAttribute("borrowinformational");
		String barcode = (String) request.getAttribute("barcode");
	%>
	<table width="100%" border="1">
		<tr>
			<td colspan="2" align="center"><jsp:include flush="true"
					page="banner.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td width="15%" align="center" class="color"><jsp:include
					flush="true" page="menu.jsp"></jsp:include></td>
			<td width="85%">
				<H1>图书续借</H1>
				<div class="container">
					<div class="top">
						<div class="check1">
							<form action="bookServletCL">
								<input type="hidden" name="flag" value="borrowcontinue" />
								请选择查询依据：&nbsp; <select name="">
									<option style="width: 50px;">读者条形码</option>
									<option style="width: 50px;">读者名称</option>
								</select> <input type="text" name="barcode" size="60"
									value="<%=barcode%>" /> <input type="submit" value="查 询" />
							</form>
						</div>
					</div>
					<div class="bottom">
						<table style="border-collapse: collapse;">
							<tr style="background-color: #ffcc66;" class="tborder"
								align="center">
								<td style="width: 120px;">读者条形码</td>
								<td style="width: 250px;">读者名称</td>
								<td style="width: 120px;">图书条形码</td>
								<td style="width: 120px;">图书名称</td>
								<td style="width: 120px;">借阅时间</td>
								<td style="width: 120px;">应还时间</td>
								<td style="width: 150px;">是否归还</td>
								<td style="width: 150px;">续借</td>
								<td style="width: 150px;">归还</td>
							</tr>
							<%
								if (borrowinformational != null) {
									for (int i = 0; i < borrowinformational.size(); i++) {
										bookBean bb = (bookBean) borrowinformational.get(i);
							%>
							<tr style="background-color: white;" class="tborder"
								align="center">
								<td style="width: 120px;" class="border"><%=bb.getReadBarcode()%></td>
								<td style="width: 120px;" class="border"><%=bb.getReadName()%></td>
								<td style="width: 120px;" class="border"><%=bb.getBarcode()%></td>
								<td style="width: 250px;" class="border"><%=bb.getBookname()%></td>
								<td style="width: 120px;" class="border"><%=bb.getBorrowTime()%></td>
								<td style="width: 120px;" class="border"><%=bb.getBackTime()%></td>
								<td style="width: 150px;" class="border"><%=bb.getIfback()%></td>
								<td style="width: 150px;" class="border"><a
									href="bookServletCL?readerid=<%=bb.getId()%>&bookid=<%=bb.getBookid()%>&flag=changeday">续借</a></td>
									<td style="width: 150px;"class="border"><a href="bookServletCL?readerid=<%=bb.getId()%>&bookid=<%=bb.getBookid()%>&flag=backbook">归还</a></td>
							</tr>
							<%
								}
								}
							%>
						</table>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><jsp:include flush="true"
					page="copyright.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>