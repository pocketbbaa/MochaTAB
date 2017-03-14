<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link rel="stylesheet" href="${ctx}/css/style.css" media="all"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap-datetimepicker.css">
    <link href="http://hovertree.com/texiao/bootstrap/4/css/city-picker.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/css/create_style.css">
</head>
<body>
<jsp:include page="${ctx}/views/common/temp_user.jsp"/>

<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" enctype="multipart/form-data" action="${ctx}/user/data" method="post">

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="name" class="col-sm-2 control-label">真实姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name"
                                   placeholder="真实姓名"
                                   style="width: 250px;" name="name">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">年龄范围</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #953b39" name="ageScope">
                                <option value="1">18以下</option>
                                <option value="2">18-25</option>
                                <option value="3">26-35</option>
                                <option value="4">36-45</option>
                                <option value="5">45以上</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="phone" class="col-sm-2 control-label">电话号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone"
                                   placeholder="电话号码"
                                   style="width: 250px;" name="phone">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="postCode" class="col-sm-2 control-label">邮编</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="postCode"
                                   placeholder="邮编"
                                   style="width: 250px;" name="postCode">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="address" class="col-sm-2 control-label">详细住址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address"
                                   placeholder="详细住址"
                                   style="width: 250px;" name="address">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #0f7864" name="six">
                                <option value="0">女</option>
                                <option value="1">男</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="birthday" class="col-sm-2 control-label">生日</label>
                        <div class="col-sm-10">
                            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                                   placeholder="生日" name="birthday" id="birthday">
                            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
                            <span class="glyphicon glyphicon-ok info-reminder"></span>
                            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">身体肌肤</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #953b39" name="bodySkin">
                                <option value="1">干性</option>
                                <option value="2">中性</option>
                                <option value="3">油性</option>
                                <option value="4">混合性</option>
                                <option value="5">敏感性</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">居住城市</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <div style="position: relative;">
                                <input class="city-picker-input" readonly type="text" data-toggle="city-picker"
                                       placeholder="请选择省/市" data-level="city" data-simple="true" name="city">
                            </div>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="email" class="col-sm-2 control-label">邮件地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email"
                                   placeholder="邮件地址"
                                   style="width: 250px;" name="email">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">是否公开邮件</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #47a447" name="bodySkin">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">发质</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #953b39" name="hairSkin">
                                <option value="1">干性</option>
                                <option value="2">中性</option>
                                <option value="3">油性</option>
                                <option value="4">混合性</option>
                                <option value="5">敏感性</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">脸部肌肤</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #953b39" name="faceSkin">
                                <option value="1">干性</option>
                                <option value="2">中性</option>
                                <option value="3">油性</option>
                                <option value="4">混合性</option>
                                <option value="5">敏感性</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">整体肤质</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #953b39" name="wholeSkin">
                                <option value="1">干性</option>
                                <option value="2">中性</option>
                                <option value="3">油性</option>
                                <option value="4">混合性</option>
                                <option value="5">敏感性</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="faceDescribe" class="col-sm-2 control-label">脸部肌肤描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="faceDescribe"
                                   placeholder="商品功能"
                                   style="width: 250px;" name="faceDescribe">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">是否结婚</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="married">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">是否有子女</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3"
                                    name="haveChildren">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="height" class="col-sm-2 control-label">身高</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="height"
                                   placeholder="cm"
                                   style="width: 250px;" name="height">
                        </div>
                    </div>
                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="weight" class="col-sm-2 control-label">体重</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="weight"
                                   placeholder="g"
                                   style="width: 250px;" name="weight">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">工作</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="wholeSkin">
                                <option value="1">农林牧渔业</option>
                                <option value="2">制造业（不含资讯电脑业）</option>
                                <option value="3">咨询工业</option>
                                <option value="4">咨询服务业</option>
                                <option value="5">营造业</option>
                                <option value="6">商业</option>
                                <option value="7">运输业</option>
                                <option value="8">通信业</option>
                                <option value="9">金融保险及不动产服务业</option>
                                <option value="10">社会服务业</option>
                                <option value="11">大众传播广告业</option>
                                <option value="12">个人服务业</option>
                                <option value="13">工商服务业</option>
                                <option value="14">公共行政业（公务人员）</option>
                                <option value="15">军人</option>
                                <option value="16">大学老师</option>
                                <option value="17">中小学教师</option>
                                <option value="18">家管</option>
                                <option value="19">学生</option>
                                <option value="20">退休</option>
                                <option value="21">待业中</option>
                                <option value="22">其他</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="remark"
                                   placeholder="邮件地址"
                                   style="width: 250px;" name="remark">
                        </div>
                    </div>

                    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 100px;margin-right: 50%">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button style="width:600px;" type="submit" class="btn btn-success">保存</button>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </section>
</div>
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

    })
</script>
</body>
</html>