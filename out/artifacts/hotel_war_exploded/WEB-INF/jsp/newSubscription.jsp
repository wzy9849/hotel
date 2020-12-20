<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"></link>

  <style type="text/css">
    form{
      margin: 15px 0;
    }

    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;
      width: 400px;
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

    fieldset div input{
      width: 200px;
    }

    fieldset.buttons{
      border: solid 1px #ffffff;
      text-align: center;
      display:block;
      margin-top: 20px;
    }

  </style>
  <title>新建订单</title>
</head>
<body>
<div id="container">
  <c:import url="/header"></c:import>
  <div id="content">
    <c:import url="/submenu"></c:import>
    <div class="subcontent">
      <form id="fm" action="${pageContext.request.contextPath }/subscription/create" method="post" name="form" onsubmit="return isNull(this)">
        <fieldset>
          <legend>联系人信息</legend>
          <div>
            <label for="linkman">联系人</label>
            <input type="text" name="linkman" id="linkman"/>
            <div style="color: red;" id="linkmanMsg"></div>
          </div>
          <div>
            <label for="phone">联系电话</label>
            <input type="text" name="phone" id="phone"/>
            <div style="color: red;" id="phoneMsg"></div>
          </div>
          <div>
            <label for="email">电子邮件</label>
            <input type="text" name="email" id="email"/>
            <div style="color: red;" id="emailMsg"></div>
          </div>
        </fieldset>
        <fieldset class="buttons">
          <input type="submit" value="创建" />
        </fieldset>
      </form>
    </div>
  </div>
  <hr />
  <c:import url="/footer"></c:import>
</div>
<script type="text/javascript">
  function isNull(form) {
    if(form.linkman.value=='') {
      alert('联系人不能为空！');
      form.linkman.focus();
      document.getElementById("linkmanMsg").textContent="联系人不能为空！";
      return false;
    }
    if(form.phone.value=='') {
      alert('电话不能为空！');
      form.phone.focus();
      document.getElementById("phoneMsg").textContent="电话不能为空！";
      return false;
    }
    if(form.email.value=='') {
      alert('邮箱不能为空！');
      form.email.focus();
      document.getElementById("emailMsg").textContent="邮箱不能为空！";
      return false;
    }

  }
</script>
</body>
</html>
