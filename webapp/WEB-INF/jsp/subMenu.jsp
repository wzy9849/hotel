<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="submenu">
    <ul>
        <li><a href="${pageContext.request.contextPath}/subscription/center">客房预订</a></li>
        <li><a href="${pageContext.request.contextPath}/subscription/history">历史订单</a></li>
        <li><a href="${pageContext.request.contextPath}/member/editMember">修改信息</a></li>
        <li><a href="${pageContext.request.contextPath}/member/editPassword">修改密码</a></li>
        <li><a href="${pageContext.request.contextPath}/member/memberExit">退出系统</a></li>
    </ul>
</div>