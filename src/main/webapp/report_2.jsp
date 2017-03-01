<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
</head>
<body>
<jsp:include page="temp_user.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <h1><strong>报告第二步：</strong></h1>
        <br/>
        <br/>
        <h2>測試員填寫心得並評分</h2>
        <h2>评分（小题目）</h2>
    </section>
    <div style="margin-left: 80%;margin-top: 10px;"><a href="home_user.jsp">
        <button style="width: 159px;height: 37px;" type="button" class="btn btn-success">提交报告</button>
    </a></div>
</div>
</body>
</html>