<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"></link>
  <style type="text/css">

    table{
      margin:auto;
      margin-top:0;
      border-collapse:collapse;
      width: 90%;
    }

    caption{
      padding: 20px 0;
    }

    th,td{
      border:solid 1px #000000;
    }

    th{
      padding:6px 1px;
    }

    td{
      padding:8px 1px;
    }

    td div{
      text-align: center;
    }

    .date{
      width: 50px;
      text-align:center;
    }

    #content div.button{
      text-align:center;
      padding-top:15px;
    }

    #content p{
      margin: 20px 0;
      text-indent: 2em;
      line-height: 1.5em;
    }
  </style>
  <title>会员中心</title>
</head>
<body>
<div id="container">
  <c:import url="/header"></c:import>
  <div id="content" style="width:98%;position:relative">
    <c:import url="/submenu"></c:import>
    <div class="subcontent">
      <table align="center">
        <caption>历史预定信息</caption>
        <colgroup>
          <col class="datetime" />
          <col class="no" />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <tr>
          <th>创建时间</th>
          <th>订单号</th>
          <th>联系人</th>
          <th>联系电话</th>
          <th>电子邮件</th>
          <th>状态</th>
        </tr>

        <c:if test="${fn:length(subscriptions)!=0}">

          <c:forEach items="${subscriptions}" var="s">
            <tr>
              <td><div><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${s.cretime}"/></div></td>
              <td><div><a href="${pageContext.request.contextPath}/subscriptionDtl/subscriptionView?id=${s.id}&linkman=${s.linkman}">${s.no}</a></div></td>
              <td><div>${s.linkman}</div></td>
              <td>${s.phone}</td>
              <td>${s.email}</td>
              <td><div>
                <c:if test="${s.status == 3}">已取消</c:if>
                <c:if test="${s.status == 1}">未确认</c:if>
                <c:if test="${s.status == 2}">已确认</c:if>
              </div></td>
            </tr>
          </c:forEach>
        </c:if>


        <c:if test="${fn:length(subscriptions)==0}">
          <tr>
            <td colspan="6">暂时没有订单</td>
          </tr>
        </c:if>
      </table>
    </div>

  </div>
  <hr />
  <c:import url="/footer"></c:import>
</div>

</body>
</html>
