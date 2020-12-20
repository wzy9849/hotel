<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"></link>
    <style type="text/css">

        form{
            margin: 10px 0;
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
    <title>会员中心</title>
</head>
<body>
<div id="container">
    <c:import url="/header"></c:import>
    <div id="content" style="width:98%;position:relative">
        <c:import url="/submenu"></c:import>
        <div class="subcontent">
            <form action="${pageContext.request.contextPath}/member/edit" method="post">
                <fieldset>
                    <legend>联系信息</legend>
                    <div>
                        <label for="name">联系人</label>
                        <input type="hidden" name="id" value="${member.id}"/>
                        <input type="text" name="name" id="name" value="${member.name}"/>
                    </div>
                    <div>
                        <label for="phone">联系电话</label>
                        <input type="text" name="phone" id="phone" value="${member.phone}"/>
                    </div>
                    <div>
                        <label for="email">电子邮件</label>
                        <input type="text" name="email" id="email" value="${member.email}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <input type="submit" value="保存" />
                </fieldset>
            </form>
        </div>
    </div>
    <hr />
    <c:import url="/footer"></c:import>
</div>
</body>
</html>
