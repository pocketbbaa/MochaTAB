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

    <div class="content no-padding timeline">
        <div class="tl-post">
            <a href="#"><p style="width: 50%;"><img src="${product.picUrl}" style="width: 200px;height: 100px;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span class="time">商品价格:${product.price}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品功能:${product.skinName}</span>
            </p></a>
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="title" class="col-sm-2 control-label">市调标题</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="title"
                   placeholder="${evaluation.title}"
                   style="width: 250px;" name="title">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="standard" class="col-sm-2 control-label">市调评测规格</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="standard"
                   placeholder="${evaluation.standard}"
                   style="width: 250px;" name="standard">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="amount" class="col-sm-2 control-label">招募理想人数</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="amount"
                   placeholder="${evaluation.amount}"
                   style="width: 250px;" name="amount">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="duration" class="col-sm-2 control-label">市调评测周期</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="duration"
                   placeholder="${evaluation.duration}"
                   style="width: 250px;" name="duration">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="duration" class="col-sm-2 control-label">市调评测开始时间</label>
        <div class="col-sm-10">
            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                   placeholder="${evaluation.startDate}" name="startDate">
            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
            <span class="glyphicon glyphicon-ok info-reminder"></span>
            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="duration" class="col-sm-2 control-label">市调评测结束时间</label>
        <div class="col-sm-10">
            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                   placeholder="${evaluation.endDate}" name="endDate">
            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
            <span class="glyphicon glyphicon-ok info-reminder"></span>
            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="duration" class="col-sm-2 control-label">市调公布日期</label>
        <div class="col-sm-10">
            <input style="width: 250px;" type="text" size="16" class="form_datetime" readonly
                   placeholder="${evaluation.showDate}" name="showDate">
            <span class="glyphicon glyphicon-flag info-reminder hide"></span>
            <span class="glyphicon glyphicon-ok info-reminder"></span>
            <span class="glyphicon glyphicon-remove info-reminder hide"></span>
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="visible" class="col-sm-2 control-label">市調報告代碼</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="visible"
                   placeholder="${evaluation.visible}"
                   style="width: 250px;" name="visible">
        </div>
    </div>
    <br/>
    <span class="info-label" style="font-weight: bold;"><h3><strong>评测题目:</strong></h3></span>
    <br/>

    <c:forEach items="${questions}" var="question">
        <div class="form-group q-template" style="margin-top: 10px;margin-bottom: 15px;">
            <label for="duration" class="col-sm-2 control-label">题目描述</label>
            <div class="col-sm-10">
                            <textarea style="width: 500px;display: inline-block;" class="form-control" rows="2"
                                      name="question"
                                      placeholder="${question.des}"></textarea>
            </div>
        </div>
    </c:forEach>

    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 180px;">
        <div class="col-sm-offset-2 col-sm-10">
            <button style="width:300px;" type="submit" class="btn btn-success">立即分配</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button style="width:300px;" type="submit" class="btn btn-success">修改确认</button>
        </div>
    </div>
</div>
<div style="float: right;margin-top: -830px; width: 44%">

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="resAmount" class="col-sm-2 control-label">回复心得数</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="resAmount"
                   placeholder="${evaluation.resAmount}"
                   style="width: 250px;" name="resAmount">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="votePercent" class="col-sm-2 control-label">投票率</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="votePercent"
                   placeholder="50%"
                   style="width: 250px;" name="votePercent">
        </div>
    </div>

    <div class="form-group" style="height: 45px; margin-top: 10px;">
        <label for="totalGrade" class="col-sm-2 control-label">滿意度總分</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="totalGrade"
                   placeholder="85"
                   style="width: 250px;" name="totalGrade">
        </div>
    </div>

    <!-- 占比图 -->
    <div style="width:600px;height:200px;">
        <div class="content">
            <div class="pie graph-area">

            </div>
        </div>
    </div>

</div>
<script src="${ctx}/js/flot.js"></script>
<script src="${ctx}/js/flot-pie.js"></script>
<script type="text/javascript">
    $(document).ready(init);
    function init() {
        // Pie chart
        var data = [
            {label: "满意度为很好的人数", data: 50, color: "orange"},
            {label: "满意度为好的人数", data: 40, color: "#9bc747"},
            {label: "满意度为普通的人数", data: 10, color: "#208ed3"},
            {label: "满意度为差的人数", data: 10, color: "#208ed4"},
            {label: "满意度为很差的人数", data: 10, color: "#208ed7"}
        ];

        $.plot($(".pie"), data, {
            series: {
                pie: {
                    innerRadius: 0.5,
                    show: true
                }
            }
        });
    }
</script>
</body>
</html>