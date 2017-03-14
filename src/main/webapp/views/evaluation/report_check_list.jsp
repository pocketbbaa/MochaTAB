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
<jsp:include page="${ctx}/views/common/temp_manager.jsp"/>
<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content no-padding timeline">
            <c:forEach items="${reportList}" var="report">
                <div class="tl-post">
                    <span class="icon">&#59185;</span>
                    <a href="${ctx}/report/info/${report.reportID}"><p style="width: 80%"><img style="width: 50px;height: 50px;" src="${report.mochaUserPic}">
                        <span class="time">${report.username}</span>
                        <span class="time" style="color: #942a25">${report.title} 评测报告</span>
                        <span class="time">提交时间： ${report.createTime}</span>
                    </p></a>
                </div>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>