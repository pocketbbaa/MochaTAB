<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link href="date/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<jsp:include page="temp_manager.jsp"/>

<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" action="managers.jsp">
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="1" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="1" placeholder="姓名" style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="2" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="2" placeholder="登陆账号，纯字母组成"
                                   style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="4" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="4" placeholder="4-6位数字或字母"
                                   style="width: 200px;">
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
<script type="text/javascript" src="date/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="date/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>