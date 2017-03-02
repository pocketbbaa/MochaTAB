<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link rel="stylesheet" href="../../css/style.css" media="all"/>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/ie.css" media="all"/><![endif]-->
    <link rel="stylesheet" href="../../css/lt-ie-9.css" media="all"/><![endif]-->
</head>
<body>
<jsp:include page="../common/temp_manager.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <div style="margin-left: 80%;margin-top: 10px;"><a href="${ctx}/views/edit/add_manager.jsp"><button style="width: 159px;height: 37px;" type="button" class="btn btn-success">添加新管理员</button></a></div>
    <section class="widget">
        <div class="content">
            <table id="myTable" border="0" width="100">
                <thead>
                <tr>
                    <th class="avatar">用户名</th>
                    <th>登陆密码</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${managerList}" var="manager">
                    <tr>
                        <td class="avatar"><img src="../../images/uiface1.png" alt="" height="40" width="40"/>${manager.username}</td>
                        <td>${manager.password}</td>
                        <td>${manager.createTime}</td>
                        <td><a href="/edit/delete/${manager.id}" class="btn btn-primary" role="button">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>

<script src="../../js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script src="../../js/jquery.wysiwyg.js"></script>
<script src="../../js/jquery.checkbox.min.js"></script>
<script src="../../js/jquery.tablesorter.min.js"></script>
<script src="../../js/custom.js"></script>
<script src="../../js/cycle.js"></script>
</body>
</html>