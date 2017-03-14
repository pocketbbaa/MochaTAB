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
<jsp:include page="../common/temp_manager.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <div style="margin-left: 80%;margin-top: 10px;"><a href="#">
        <a href="${ctx}/case/product/list">
            <button style="width: 159px;height: 37px;" type="button" class="btn btn-success">添加新的市调专案</button>
        </a>
    </a></div>
    <section class="widget">
        <div class="content no-padding timeline">
            <c:forEach items="${evaluationList}" var="evaluation">
                <div class="tl-post">
                    <span class="icon">&#59185;</span>
                    <a href="${ctx}/case/${evaluation.id}/info"><p style="width: 80%;"><img style="width: 150px;height: 70px;" src="${evaluation.picURL}"
                                                                                            alt="...">
                        <span class="time" style="color: darkolivegreen">${evaluation.title}</span>
                        <span class="time">开始时间：${evaluation.startDate}</span>
                        <span class="time">结束时间${evaluation.endDate}</span>
                        <span class="time">专案创建时间：${evaluation.createTime}</span>
                    </p></a>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>