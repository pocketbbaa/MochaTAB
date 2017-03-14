<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Document</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/details.css">
    <script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container opacity0">
    <div class="row row-middle">
        <div class="col-lg-12 col-md-12 .col-sm-12 col-xs-12">
            <p class="common-t">基本信息</p>
        </div>
    </div>
    <div class="row row-top">
        <div class="col-lg-5 col-md-5 .col-sm-5 col-xs-12 main-info">
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 main-info-img"><img src="${product.picUrl}">
                </div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 main-info-desc">
                    ${product.name}
                </div>
            </div>
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 row-p-l">商品功能:</div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 row-p-r">
                    ${product.function}
                </div>
            </div>
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 row-p-l">商品注意:</div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 row-p-r">
                    ${product.attention}
                </div>
            </div>
        </div>
        <div class="col-lg-1 col-md-1 .col-sm-1"></div>
        <div class="col-lg-5 col-md-5 .col-sm-5 col-xs-12 main-info">
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 main-info-img"><img
                        src="${user.mochaUserPic}">
                </div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 main-info-desc">
                    ${user.mochaUserName}
                </div>
            </div>
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 row-p-l">真实姓名:</div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 row-p-r">
                    ${userData.name}
                </div>
            </div>
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 row-p-l">性别:</div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 row-p-r">
                    <c:choose>
                        <c:when test="${userData.six == 1}">
                            男
                        </c:when>
                        <c:otherwise>
                            女
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="row main-info-1">
                <div class="col-lg-4 col-md-4 .col-sm-4 col-xs-4 row-p-l">居住城市:</div>
                <div class="col-lg-8 col-md-8 .col-sm-8 col-xs-8 row-p-r">
                    ${userData.city}
                </div>
            </div>
        </div>

    </div>
    <!--top ended-->

    <div class="row row-middle">
        <div class="col-lg-12 col-md-12 .col-sm-12 col-xs-12">
            <c:if test="${report.evaluate == 1}">
                <p>整体满意度评价：<span>很好</span></p>
            </c:if>
            <c:if test="${report.evaluate == 2}">
                <p>整体满意度评价：<span>好</span></p>
            </c:if>
            <c:if test="${report.evaluate == 3}">
                <p>整体满意度评价：<span>普通</span></p>
            </c:if>
            <c:if test="${report.evaluate == 4}">
                <p>整体满意度评价：<span>差</span></p>
            </c:if>
            <c:if test="${report.evaluate == 5}">
                <p>整体满意度评价：<span>很差</span></p>
            </c:if>
        </div>
    </div>
    <!--middle ended-->
    <c:forEach items="${qAnswerList}" var="qa">
        <div class="row row-sub-info">
            <div class="col-lg-2 col-md-3 col-sm-12 col-xs-12 h3">题目回答</div>
            <div class="col-lg-10 col-md-9 col-sm-12 col-xs-12 sub-info-q">
                <div class="row row-line">
                    <div class="col-lg-2 col-md-3 col-sm-5 col-xs-2 r-sub-title">题目名称:</div>
                    <div class="col-lg-10 col-md-9 col-sm-7 col-xs-10">${qa.questionDes}</div>
                </div>
                <div class="row row-line">
                    <div class="col-lg-2 col-md-3 col-sm-5 col-xs-2 r-sub-title">题目得分:</div>
                    <div class="col-lg-10 col-md-9 col-sm-7 col-xs-10">${qa.score}</div>
                </div>
                <div class="row row-line">
                    <div class="col-lg-2 col-md-3 col-sm-5 col-xs-2 r-sub-title">题目回答:</div>
                    <div class="col-lg-10 col-md-9 col-sm-7 col-xs-10">${qa.answerDes}</div>
                </div>
                <div class="row row-line">
                    <div class="col-lg-2 col-md-3 col-sm-5 col-xs-2 r-sub-title">图片:</div>
                    <div class="col-lg-10 col-md-9 col-sm-7 col-xs-10">
                        <div class="row row-p0">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 img-wrap"><img src="${qa.picUrls}"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <!--end-->

    <div class="row row-middle">
        <div class="col-lg-12 col-md-12 .col-sm-12 col-xs-12">
            <p>心得</p>
        </div>
    </div>
    <div class="row r-bt-info">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 r-bottom-d">
            <p class="p">${report.experience}</p>
        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="row">
                <c:forEach items="${feelPicUrl}" var="pic">
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 img-wrap">
                        <img style="width: 200px;height: 150px;" src="${pic}">
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 180px;">
        <div class="col-sm-offset-2 col-sm-10">
            <a href="${ctx}/report/pass/${report.id}">
                <button style="width:300px;" type="submit" class="btn btn-success">审核通过</button>
            </a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button style="width:300px;" class="btn btn-success" data-toggle="modal" data-target="#myModal">审核不通过
            </button>
        </div>
    </div>

</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${ctx}/report/noPass" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        请输入不通过原因:
                    </h4>
                </div>
                <div class="modal-body">
                    <input  name="reportID" value="${report.id}" style=display:none>
                    <input type="text" name="reason" style="width: 100%">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    /*使顶部两个框的高度一致*/
    window.onload = function () {
        var a = [];
        var oa = $('.main-info');
        oa.each(function (index, el) {
            var h = $(el).outerHeight();
            a.push(h);
        });

        if (a[0] >= a[1]) {
            oa.outerHeight(a[0]);
        } else {
            oa.outerHeight(a[1]);
        }

        $('.container').removeClass('opacity0')
    }

</script>
</html>