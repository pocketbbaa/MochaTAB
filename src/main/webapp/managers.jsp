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
    <div style="margin-left: 80%;margin-top: 10px;"><a href="#"><button style="width: 159px;height: 37px;" type="button" class="btn btn-success">添加新管理员</button></a></div>
    <section class="widget">
        <div class="content">
            <table id="myTable" border="0" width="100">
                <thead>
                <tr>
                    <th class="avatar">Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Date</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface2.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>27/02/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface3.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>03/12/2012</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface4.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>31/12/2012</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>29/11/2012</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface2.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>********</td>
                    <td>09/01/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">删除</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>
</div>
</body>
</html>