<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link href="../../date/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<jsp:include page="../common/temp_manager.jsp"/>

<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" action="${ctx}/user/add" method="post">

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="mochaUserID" class="col-sm-2 control-label">用户抹茶ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="mochaUserID"
                                   placeholder="输入用户的抹茶账号ID"
                                   style="width: 200px;" name="mochaUserID">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="username" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username"
                                   placeholder="登陆tab评测后台账号"
                                   style="width: 200px;" name="username">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="password"
                                   placeholder="登陆tab评测后台密码"
                                   style="width: 200px;" name="password">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">立即创建</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<script type="text/javascript" src="../../date/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="../../date/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>