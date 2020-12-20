<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"></link>
  <style type="text/css">
    form{
      margin: 5px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 400px;
      display: block;
    }
    
    fieldset div{
      margin: 5px 0;
    }
    
    legend {
  		padding: 1em;
  	}
	
    label{
      float: left;
      width: 100px;
    }
    
    #content div input{
      width: 200px;
    }
    
    fieldset.buttons{
      border: solid 1px #ffffff;
      text-align: center;
      display:block;
      margin-top: 20px;
    }
  	
  </style>
  <title>会员注册</title>
</head>
<body>
<div id="container">
  <c:import url="/header"></c:import>
  <div id="content">
    <form name="form" action="${pageContext.request.contextPath }/member/regist" method="post" onsubmit=" return isNull(this)">
      <fieldset>
        <legend>登录信息[必选]</legend>
        <div>
          <label for="username">用户名</label>
          <input type="text" name="username" id="username" />
        </div>
        <div>
          <label for="password">密码</label>
          <input type="password" name="pwd" id="password" />
        </div>
        <div>
          <label for="repassword">重复密码</label>
          <input type="password" name="repassword" id="repassword" />
        </div>
      </fieldset>
      <fieldset>
        <legend>联系信息[可选]</legend>
        <div>
          <label for="name">联系人</label>
          <input type="text" name="name" id="name"/>
        </div>
        <div>
          <label for="phone">联系电话</label>
          <input type="text" name="phone" id="phone"/>
        </div>
        <div>
          <label for="email">电子邮件</label>
          <input type="text" name="email" id="email"/>
        </div>
      </fieldset>
      <fieldset class="buttons">
        <input type="submit" value="注册" />
      </fieldset>
    </form>
    <p style="color: red">${e.message }</p>
  </div>
  <hr />
  <c:import url="/footer"></c:import>
</div>
<script type="text/javascript">
  function isNull(form) {

    if(form.username.value=='') {
      alert('用户名不能为空！');
      form.username.focus();
      return false;
    }
    if(form.password.value=='') {
      alert('密码不能为空！');
      form.password.focus();
      return false;
    }
    if(form.repassword.value!=form.password.value) {
      alert('两次密码不一致，请重新输入！');
      form.repassword.focus();
      return false;
    }

  }


</script>
</body>
</html>