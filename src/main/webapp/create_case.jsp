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
<jsp:include page="views/common/temp_manager.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
       <h1><strong>创建第一步：</strong></h1>
        <br/>
        <br/>
        <h2>為此市調專案建立基本資料（商品种类、商品功能、商品部位），招募條件(人数、年龄……)&設定小題目&測試週期</h2>
    </section>
    <div style="margin-left: 80%;margin-top: 10px;"><a href="views/edit/home_manger.jsp"><button style="width: 159px;height: 37px;" type="button" class="btn btn-success">创建完成</button></a></div>
</div>
</body>
</html>