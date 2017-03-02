<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link href="date/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>
<body>
<jsp:include page="views/common/temp_user.jsp"/>

<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" action="login_user.jsp">
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="1" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="1" placeholder="姓名" style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="2" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="2" placeholder="昵称"
                                   style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="3" class="col-sm-2 control-label">生日</label>
                        <div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy"
                             data-link-field="dtp_input2" data-link-format="yyyy-mm-dd" style="width: 300px;">
                            <input class="form-control" size="10" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="3" value=""/><br/>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="4" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="4" placeholder="F:女 M:男"
                                   style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="5" class="col-sm-2 control-label">是否结婚</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="5" placeholder="Y:是 N:否"
                                   style="width: 200px;">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="6" class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="6" placeholder="学生"
                                   style="width: 200px;">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">立即注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<script type="text/javascript" src="date/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="date/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });

</script>
</body>
</html>