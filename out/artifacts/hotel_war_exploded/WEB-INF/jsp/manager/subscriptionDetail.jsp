<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
    <script type="text/javascript" src="../js/calendar.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"></link>
    <style type="text/css">
        div.heading{
            border-bottom:solid 1px #000000;
            border-top:solid 1px #ffffff;
            margin-bottom:10px;
        }

        div.heading p{
            padding:0;
            margin-bottom:10px;
            text-align:center;
        }

        div.submit{
            text-align:center;
            margin-top: 15px;
            border: solid 1px #ffffff;
        }

        fieldset{
            position:relative;
            width:450px;
            margin:auto;
            margin-top:20px;
        }

        fieldset select{
            width:120px;
        }

        fieldset input{
            width:120px;
        }

        div.row{
            position: relative;
            padding:8px 0;
            margin-bottom:10px;
        }

        div.column1{
            width:25%;
            position:relative;
            float: left;
            margin: 0;
        }

        div.column2{
            width:25%;
            margin: 0;
            float:left;
        }

        div.column3{
            width:25%;
            margin: 0;
            float:left;
        }

        div.column4{
            margin-left:675px;
            width:180px;
        }

        .column_1{
            float:left;
        }

        .column_2{
            margin-left:50px;
            width:150px;
        }

        .column_2 span{
            border-bottom: dashed 1px #000000;
        }

        table{
            margin:auto;
            margin-top:20px;
            width:700px;
            border-collapse:collapse;
        }

        th,td{
            border:solid 1px #000000;
            padding:6px 1px;
        }

        .index{
            width: 50px;
            text-align:center;
        }

        .category{
            text-align:center;
        }

        .date{
            text-align:center;
        }

        .opt{
            text-align:center;
        }

        td div{
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .text{
            width:390px;
        }

    </style>
    <title>查询明细信息</title>
</head>
<body>
<div id="container">
    <c:import url="/manager/managerHeader"></c:import>
    <div id="content" style="border:solid 1px #ffffff;width:90%;margin:auto;padding-top:10px">
        <form action="${pageContext.request.contextPath}/managers/saveUserOrder">
            <div class="heading">
                <p>订单基本信息</p>
            </div>
            <div style="display: none"><input name="id" value="${ManagerQueryDetails[0].id}"></div>
            <div class="row">
                <div class="column1">
                    <div class="column_1">
                        <span>订单号:</span>
                    </div>
                    <div class="column_2">
                        <span>${ManagerQueryDetails[0].no}</span>
                    </div>
                </div>

                <div class="column2">
                    <div class="column_1">
                        <span>创建时间:</span>
                    </div>
                    <div class="column_2">
              <span>
                <fmt:formatDate value="${ManagerQueryDetails[0].cretime}" pattern="yyyy-MM-dd hh:mm" />
              </span>
                    </div>
                </div>

                <div class="column3">
                    <div class="column_1">
                        <span>会员名:</span>
                    </div>
                    <div class="column_2">
                        <span>${ManagerQueryDetails[0].member.name}</span>
                    </div>
                </div>

                <div class="column4">
                    <div class="column_1">
                        <span>状态:</span>
                    </div>
                    <div class="column_2">
                        <select name="status" id="status" >
                            <c:if test="${ManagerQueryDetails[0].status == '1'}">
                                <option value="1" selected="selected" >待确认</option>
                                <option value="2">已确认</option>
                                <option value="3">已取消</option>
                            </c:if>
                            <c:if test="${ManagerQueryDetails[0].status == 2}">
                                <option value="1">待确认</option>
                                <option value="2" selected="selected">已确认</option>
                                <option value="3">已取消</option>
                            </c:if>
                            <c:if test="${ManagerQueryDetails[0].status == 3}">
                                <option value="1">待确认</option>
                                <option value="2" selected="selected">已取消</option>
                                <option value="3">已取消</option>
                            </c:if>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column1">
                    <div class="column_1">
                        <span>联系人:</span>
                    </div>
                    <div class="column_2">
                        <span>${ManagerQueryDetails[0].linkman}</span>
                    </div>
                </div>

                <div class="column2">
                    <div class="column_1">
                        <span>联系电话:</span>
                    </div>
                    <div class="column_2">
                        <span>${ManagerQueryDetails[0].phone}</span>
                    </div>
                </div>

                <div class="column3">
                    <div class="column_1">
                        <span>电子邮件:</span>
                    </div>
                    <div class="column_2">
                        <span>${ManagerQueryDetails[0].email}</span>
                    </div>
                </div>
                <div class="column4">
                    <span>&nbsp;</span>
                </div>
            </div>

            <div class="row">
                <label for="remark">备注</label>
                <input type="text" class="text" name="remark" id="remark" value="${ManagerQueryDetails[0].remark}"/>
                <input type="submit" value="保存" />
            </div>
        </form>
        <div class="heading">
            <p>订单明细信息</p>
        </div>
        <table>
            <colgroup>
                <col class="category" />
                <col class="no" />
                <col />
                <col />
                <col span="2" class="date" />
                <col class="opt" />
            </colgroup>
            <tr>
                <th>房间类型</th>
                <th>房间号</th>
                <th>预定方式</th>
                <th>单价</th>
                <th>入住日期</th>
                <th>退房日期</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${ManagerQueryDetails[0].subscriptionDtls}" var="subscription_dtl" >
                <tr>
                    <td>
                        <div>
                            <c:if test="${subscription_dtl.rooms[0].cid == 1}">
                                单人间
                            </c:if>
                            <c:if test="${subscription_dtl.rooms[0].cid == 2}">
                                双人间
                            </c:if>
                            <c:if test="${subscription_dtl.rooms[0].cid == 3}">
                                豪华间
                            </c:if>
                        </div>
                    </td>
                    <td><div>${subscription_dtl.rooms[0].no}</div></td>
                    <td>
                        <div>
                            <c:if test="${subscription_dtl.residetype == 1}" >
                                单个床位
                            </c:if>
                            <c:if test="${subscription_dtl.residetype == 2}" >
                                整个房间
                            </c:if>
                        </div>
                    </td>
                    <td><div>${subscription_dtl.price}</div></td>
                    <td><fmt:formatDate value="${subscription_dtl.sdate}" pattern="yyyy-MM-dd" /></td>
                    <td><fmt:formatDate value="${subscription_dtl.edate}" pattern="yyyy-MM-dd" /></td>
                    <td>
                        <div>
                            <a href="${pageContext.request.contextPath}/ManagerQueryDetail/deleteResideRoom?id=${subscription_dtl.id}&no=${ManagerQueryDetails[0].no}" onclick="return confirm('真的要删除该预定细信息吗？')">删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="submit">
            <input type="button" value="返回" onclick="location='${pageContext.request.contextPath}/subscription/manager/managerQueryOrder?categoryId=${managerQueryVo.categoryId}&subscriptionStatus=${managerQueryVo.subscriptionStatus}&sdate=${managerQueryVo.sdate}&edate=${managerQueryVo.edate}&no=${managerQueryVo.no}&username=${managerQueryVo.username}'"/>
        </div>
    </div>
    <c:import url="/footer"></c:import>
</div>
</body>
</html>