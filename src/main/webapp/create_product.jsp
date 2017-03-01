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
<jsp:include page="temp_manager.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <h1><strong>创建商品资料库：</strong></h1>
        <br/>
        <br/>
        <h1>填写商品基本资料 </h1>
    </section>
    <div style="margin-left: 80%;margin-top: 10px;"><a href="home_manger.jsp">
        <button style="width: 159px;height: 37px;" type="button" class="btn btn-success">创建</button>
    </a></div>
</div>
</body>
</html>