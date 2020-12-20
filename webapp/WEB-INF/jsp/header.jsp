<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="header">
	<ul>
		<li><a href="#">帮助</a>
		</li>
	</ul>
</div>
<div id="menu">
	<ul>
		<li><a href="${pageContext.request.contextPath }/">首页</a>
		</li>
		<li><a href="${pageContext.request.contextPath }/room/findAllCategories">设施与价格</a>
		</li>
		<li><a href="${pageContext.request.contextPath }/subscription/center">会员中心</a>
		</li>
		<%
			if (session.getAttribute("member")!=null){
				%>
		<li style="alignment: right">欢迎${pageContext.session.getAttribute("member").username}</li>
		<li style="alignment: right"><a href="${pageContext.request.contextPath}/member/memberExit">注销</a></li>
		<%
			}
		%>

	</ul>
</div>