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
<jsp:include page="${ctx}/views/common/temp_user.jsp"/>
<section class="alert">
    <div class="green">
        <p>你好 <a href="#">${sessionScope.user.mochaUserName}</a>, 下面是你可以参与测评的评测专案，请选择并点击<a href="#">开始评测</a>完成测评。</p>
    </div>
</section>
<section class="content">
    <c:forEach items="${evaluationList}" var="evaluation">
        <section class="widget small" style="margin-left: 10px;,margin-top: 20px;">
            <header>
            </header>
            <div class="content no-padding">
                <img src="${evaluation.picURL}" alt="..."
                     style="width: 400px;height: 200px;margin-top: 10px;margin-left: 10px;">
                <div style="float: right;margin-top: 40px;margin-right: 100px;">
                    <p><h5><strong>评测开始时间：${evaluation.startDate}</strong></h5></p>
                    <br/><br/>
                    <p><h5><strong>评测结束时间：${evaluation.endDate}</strong></h5></p>
                </div>
                <br/>
                <div style="margin-left: 10px;margin-top: 20px;">
                    <strong><h4>评测标题:${evaluation.title}</h4></strong>
                </div>
                <br/>
                <p style="margin-left: 250px;"><a href="${ctx}/case/begin/${evaluation.id}/${evaluation.productId}">
                    <button style="width: 250px;height: 37px;" type="button" class="btn btn-success">开始评测
                    </button>
                </a></p>
            </div>
        </section>
    </c:forEach>
</section>
<c:if test="${!empty message}">
    alert(${message});
</c:if>
</body>
</html>