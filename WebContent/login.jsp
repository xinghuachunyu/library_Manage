<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
<script type="text/javascript">
<!--
function check(form){

    if (form.name.value==""){             //判断管理员名称是否为空

          alert("请输入管理员名称!");
		  form.name.focus();
		  return false;

    }

    if (form.pwd.value=="")
    {             
    	//判断密码是否为空
        alert("请输入密码!");
    	form.pwd.focus();
    	return false;
  }    
}
-->
</script>
</head>
<body background="images/big8.jpg">
<center>
<h1>用户登录</h1>
	<hr>
	<form name="form" method="post" action="managerServletCL?flag=login" onSubmit="return check(form)">
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="name" id="user" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd" id="pass" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" /></td>
				<td><input type="reset" value="重写" /></td>
			</tr>
		</table>
	
	</form>
	</center>
</body>
</html>