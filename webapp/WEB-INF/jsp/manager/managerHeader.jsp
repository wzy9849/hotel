
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    <div id="header">
        <ul>
            <li>
                ${sessionScope.manager}
                <a href="${pageContext.request.contextPath}/managers/removeSession">退出</a></li>
        </ul>
    </div>
    <div id="menu">
        <ul>
            <li><a href="#">客房管理</a></li>
            <li><a href="#">会员管理</a></li>
            <li><a href="${pageContext.request.contextPath}/manager/subscriptionQuery">订单管理</a></li>
        </ul>
    </div>
</body>