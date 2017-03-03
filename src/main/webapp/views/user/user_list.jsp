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
        <a href="${ctx}/views/user/add_user.jsp">
            <button style="width: 159px;height: 37px;" type="button" class="btn btn-success">加入新用户</button>
        </a>
    </a></div>
    <section class="widget">
        <div class="content" style="width: 90%;">
            <table id="myTable" border="0" width="100">
                <thead>
                <tr>
                    <th class="avatar">用户抹茶ID</th>
                    <th>抹茶用户名</th>
                    <th>登陆账号</th>
                    <th>登陆密码</th>
                    <th>加入时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td class="avatar"><img src="${user.mochaUserPic}" alt="" height="40"
                                                width="40"/>${user.mochaID}</td>
                        <td>${user.mochaUserName}</td>
                        <td>${user.tabUserName}</td>
                        <td>${user.tabPassWord}</td>
                        <td>${user.createTime}</td>
                        <td><a href="${ctx}/user/delete/${user.id}" class="btn btn-primary" role="button">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>
</body>
</html>