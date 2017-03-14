<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="robots" content=""/>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="${ctx}/css/style.css" media="all"/>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/css/ie.css" media="all"/><![endif]-->
    <link rel="stylesheet" href="${ctx}/css/lt-ie-9.css" media="all"/><![endif]-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.1.1/jquery-confirm.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap-datetimepicker.css">
    <link href="http://hovertree.com/texiao/bootstrap/4/css/city-picker.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/css/create_style.css">
</head>
<body>

<script src="https://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.1.1/jquery-confirm.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.js"></script>
<script src="${ctx}/js/jquery.tablesorter.min.js"></script>
<script src="${ctx}/js/custom.js"></script>
<script src="${ctx}/js/city-picker.data.js"></script>
<script src="${ctx}/js/city-picker.js"></script>
<script type="text/javascript">
    <c:if test="${!empty message}">
    $.alert({
        title: '消息:',
        content: "${message}"
    });
    </c:if>
</script>
</body>
</html>
