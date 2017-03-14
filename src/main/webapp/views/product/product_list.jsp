<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="${ctx}/views/product/product_add.jsp">
            <button style="width: 159px;height: 37px;" type="button" class="btn btn-success">添加新商品</button>
        </a>
    </a></div>
    <section class="widget">
        <div class="content" style="width: 90%">
            <table id="myTable" border="0" width="90">
                <thead>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>商品适合肌肤</th>
                    <th>商品是否上市</th>
                    <th>加入此商品為愛用品的人數</th>
                    <th>最后编辑者</th>
                    <th>最后编辑时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td><img src="${product.picUrl}" alt="" height="50"
                                 width="100"/>${product.name}
                        </td>
                        <td>${product.price}</td>
                        <td>${product.skinName}</td>
                        <c:choose>
                            <c:when test="${product.ismarket == 1}">
                                <td>已上市</td>
                            </c:when>
                            <c:otherwise>
                                <td>未上市</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${product.likeNum}</td>
                        <td>${product.lastEditer}</td>
                        <td>${product.lastEditerTime}</td>
                        <td><a href="${ctx}/product/delete/${product.id}" class="btn btn-primary" role="button">删除</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </section>
</div>

</body>
</html>