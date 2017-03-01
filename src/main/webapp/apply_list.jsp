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
        <div class="content">
            <table id="myTable" border="0" width="100">
                <thead>
                <tr>
                    <th class="avatar">用户信息</th>
                    <th>市调信息</th>
                    <th>申请时间</th>
                    <th>是否通过</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr>
                <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr> <tr>
                    <td class="avatar"><img src="images/uiface1.png" alt="" height="40" width="40"/> John Doe</td>
                    <td>j.doe@mtsite.com</td>
                    <td>12/03/2013</td>
                    <td><a href="#" class="btn btn-primary" role="button">不通过</a>&nbsp;&nbsp;<a href="#" class="btn btn-primary" role="button">通过</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>
</div>
</body>
</html>