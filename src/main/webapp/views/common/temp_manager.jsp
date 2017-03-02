<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <jsp:include page="temp.jsp"/>
    <div class="testing">
        <header class="main">
            <h1><strong>TAB BackServer</strong></h1>
        </header>
        <section class="user">
            <div class="profile-img">
                <p><img src="../../images/uiface2.png" alt="" height="40" width="40"/> 欢迎回来 ${sessionScope.manager.username}</p>
            </div>
            <div class="buttons">
                <button class="ico-font">&#9206;</button>
                <span class="button blue"><a href="../../index.jsp">安全退出</a></span>
            </div>
        </section>
    </div>
    <nav style="height: auto">
        <ul>
            <li>
                <a href="../../create_product.jsp"><span class="icon">&#128196;</span> 创建商品资料</a>
            </li>
            <li>
                <a href="../../create_case.jsp"><span class="icon">&#128196;</span> 创建市调专案</a>
            </li>
            <li>
                <a href="../../report_check.jsp"><span class="icon">&#59160;</span> 评测报告审核 </a>
            </li>
            <li>
                <a href="../../user_list.jsp"><span class="icon">&#128101;</span> 用户管理</a>
            </li>

            <c:if test="${sessionScope.manager.role == 1}">
                <li><a href="${ctx}/edit/list"><span class="icon">&#128101;</span> 管理员管理 </a>
                </li>
            </c:if>
        </ul>
    </nav>
</head>
<body>

</body>
</html>