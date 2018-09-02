<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加管理员</title>
<script language="javascript">
<!--
function check(form){

      if(form.name.value=="")
      {                            
    	  //判断管理员名称是否为空
           alert("请输入管理员名称!");
           form.name.focus();
           return false;
      }

      if(form.pwd.value=="")
      {                      //判断管理员密码是否为空

      alert("请输入管理员密码!");
      form.pwd.focus();
      return false;

      }
      if(form.pwd.value!=form.pwd1.value)
      {                 
    	  //判断两次输入的密码是否一致
          alert("您两次输入的管理员密码不一致，请重新输入!");
          form.pwd1.focus();
          return false;

    }

}
-->
</script>

</head>
<body>
<table width="100%" border="1">
<tr>
    <td colspan="2" align="center">
<jsp:include flush="true" page="banner.jsp"></jsp:include>
</td>
</tr>
<tr  bgcolor="#e3F4F7">
   <td width="15%" align="center" class="color"><jsp:include flush="true" page="menu.jsp"></jsp:include></td>
   <td width="85%" align="center">
   <h1>添加管理员</h1>
   <hr>
<form name="form" method="post" action="managerServletCL?flag=addmanager" onSubmit="return check(form)">
		<table border="1">
			<tr>
				<td>管理员名称：</td>
				<td><input type="text" name="name" id="user" /></td>
			</tr>
			<tr>
				<td>管理员密码：</td>
				<td><input type="password" name="pwd" id="pass" /></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="pwd1" id="pass1" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
				<td><input type="reset" value="重写" /></td>
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