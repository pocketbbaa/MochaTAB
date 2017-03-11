<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="robots" content=""/>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="${ctx}/css/style.css" media="all"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap-datetimepicker.css">
    <link href="http://hovertree.com/texiao/bootstrap/4/css/city-picker.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/create_style.css">
</head>
<body>
<div class="testing">
    <header class="main">
        <h1><strong>TAB BackServer</strong></h1>
    </header>
    <section class="user">
        <div class="profile-img">
            <p><img src="${ctx}/images/uiface2.png" alt="" height="40" width="40"/> 欢迎回来 ${sessionScope.user.username}
            </p>
        </div>
        <div class="buttons">
            <button class="ico-font">&#9206;</button>
            <span class="button blue"><a href="${ctx}/edit/exit">安全退出</a></span>
        </div>
    </section>
</div>
<nav style="height: auto">
    <ul>
        <li>
            <a href="${ctx}/product/list"><span class="icon">&#128196;</span> 商品资料库</a>
        </li>
        <li>
            <a href="${ctx}/case/list"><span class="icon">&#128196;</span> 市调专案</a>
        </li>
        <li>
            <a href="../../report_check.jsp"><span class="icon">&#59160;</span> 评测报告审核 </a>
        </li>
        <li>
            <a href="${ctx}/user/list"><span class="icon">&#128101;</span> 用户管理</a>
        </li>

        <c:if test="${sessionScope.user.role == 1}">
            <li><a href="${ctx}/edit/list"><span class="icon">&#128101;</span> 管理员管理 </a>
            </li>
        </c:if>
    </ul>
</nav>
<style type="text/css">
    .hide {
        display: none !important;
    }

    textarea {
        resize: none !important;
    }

    .custom-delete {
        width: 100px;
        margin-bottom: 25px;
        margin-left: 20px;
    }
</style>
<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" action="${ctx}/case/add/create" method="post">
                    <div class="content no-padding timeline">
                        <div class="tl-post">
                            <span class="icon">&#59185;</span>
                            <a href="#"><p style="width: 50%;"><img src="${product.picURL}" alt="...">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span class="time">商品价格:${product.price}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品功能:${product.function}</span>
                            </p></a>
                        </div>
                    </div>
                    <input style="display: none" value="${product.id}" name="productId">
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="title" class="col-sm-2 control-label">市调标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="title"
                                   placeholder="市调标题"
                                   style="width: 250px;" name="title">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="standard" class="col-sm-2 control-label">市调评测规格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="standard"
                                   placeholder="市调评测规格"
                                   style="width: 250px;" name="standard">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="amount" class="col-sm-2 control-label">招募理想人数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="amount"
                                   placeholder="招募理想人数"
                                   style="width: 250px;" name="amount">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="duration" class="col-sm-2 control-label">市调评测周期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="duration"
                                   placeholder="市调评测周期"
                                   style="width: 250px;" name="duration">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="duration" class="col-sm-2 control-label">市调评测开始时间</label>
                        <div class="col-sm-10">
                            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                                   placeholder="市调评测开始时间" name="startDate">
                            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
                            <span class="glyphicon glyphicon-ok info-reminder"></span>
                            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="duration" class="col-sm-2 control-label">市调评测结束时间</label>
                        <div class="col-sm-10">
                            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                                   placeholder="市调评测结束时间" name="endDate">
                            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
                            <span class="glyphicon glyphicon-ok info-reminder"></span>
                            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="duration" class="col-sm-2 control-label">市调公布日期</label>
                        <div class="col-sm-10">
                            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                                   placeholder="市调公布日期" name="showDate">
                            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
                            <span class="glyphicon glyphicon-ok info-reminder"></span>
                            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="visible" class="col-sm-2 control-label">市調報告代碼</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="visible"
                                   placeholder="市調報告代碼"
                                   style="width: 250px;" name="visible">
                        </div>
                    </div>
                    <br/>
                    <span class="info-label" style="font-weight: bold;"><h3><strong>评测小题目,请添加3-8题</strong></h3></span>
                    <br/>
                    <div class="form-group hide q-template" style="margin-top: 10px;margin-bottom: 15px;">
                        <label for="duration" class="col-sm-2 control-label">题目描述</label>
                        <div class="col-sm-10">
                            <textarea style="width: 500px;display: inline-block;" class="form-control" rows="2" name="question"
                                      placeholder="在这里输入你的问题...不要输入'#'特殊字符!"></textarea>
                            <button type="button" class="btn btn-warning custom-delete">删除</button>
                        </div>
                    </div>

                    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 20px;">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button style="width:200px;" type="button" class="btn btn-primary" id="addSubject">
                                添加评测题目题目
                            </button>
                        </div>
                    </div>
                    <br/> <br/> <br/> <br/>
                    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 10px;">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button style="width:400px;" type="submit" class="btn btn-success">立即创建</button>
                        </div>
                    </div>
                    <c:if test="${!empty message}">
                        <div class="form-group" style="height: 45px; margin-top: 10px;">
                            <div class="col-sm-offset-2 col-sm-10">
                                <p style="color: #ac2925">${message}</p>
                            </div>
                        </div>
                    </c:if>
                </form>

            </div>
        </div>
    </section>
</div>

<script src="https://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.js"></script>
<script src="${ctx}/js/jquery.tablesorter.min.js"></script>
<script src="${ctx}/js/custom.js"></script>
<script src="${ctx}/js/city-picker.data.js"></script>
<script src="${ctx}/js/city-picker.js"></script>
<script type="text/javascript">
    $(function () {
        //日期选择
        $(".form_datetime").datetimepicker({
            minView: "month",
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            todayBtn: 1,
            autoclose: 1,
        });

        //城市选择
        $("#city-picker1").citypicker();


        //添加题目
        $('#addSubject').on('click', function () {
            var insertTarget = $('#bottom-btn-wrap');
            $('.q-template').clone(true).removeClass('hide').removeClass('q-template').insertBefore(insertTarget);

        })

        //删除题目
        $('.custom-delete').on('click', function () {
            $(this).parents('div.form-group').remove();
        })
    })
</script>
</body>
</html>