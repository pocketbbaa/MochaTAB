<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link href="${ctx}/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="${ctx}/views/common/temp_user.jsp"/>
<section class="alert">
    <div class="green">
        <p>你好 <a href="#">${sessionScope.user.mochaUserName}</a>, 请仔细填写下面评测题目，并公平公正进行评分。</p>
    </div>
</section>
<section class="content">
    <!-- 商品（图片、名称、功能、注意、价格、适用肌肤） -->
    <div class="media">
        <div class="media-left">
            <a href="#">
                <img class="media-object" src="${product.picUrl}" alt="..." style="width: 400px;height: 200px;">
            </a>
        </div>
        <div class="media-body" style="margin-left: 40px;">
            <h4 class="media-heading">&nbsp;</h4>
            <h4 class="media-heading">&nbsp;</h4>
            <h4 class="media-heading">商品名称：${product.name}</h4>
            <h4 class="media-heading">适用肌肤：${product.skinName}</h4>
            <h4 class="media-heading">商品功能：${product.function}</h4>
            <h4 class="media-heading">注意事项：${product.attention}</h4>
        </div>
    </div>
    <br/><br/><br/>
    <!-- 评价(很好、好、普通、差、很差) -->
    <form class="form-horizontal" enctype="multipart/form-data" action="${ctx}/case/report" method="post">

        <input id="productID" style="display: none" name="productID" value="${product.id}"/>
        <input id="userID" style="display: none" name="userID" value="${sessionScope.user.id}"/>
        <input id="evaluationID" style="display: none" name="evaluationID" value="${evaluation.id}"/>
        <section class="alert-info" style="width: 100%">
            <div class="form-group" style="height: 45px; margin-top: 10px;">
                <label class="col-sm-2 control-label"><h4><strong style="color: #15a589">请对该商品进行评价:</strong></h4>
                </label>
                <div class="col-sm-10" style="width: 250px;">
                    <select class="form-control customed-select" style="border-color: #e3e3e3" name="evaluate">
                        <option value="1">很好</option>
                        <option value="2">好</option>
                        <option value="3">普通</option>
                        <option value="4">差</option>
                        <option value="5">很差</option>
                    </select>
                </div>
            </div>
        </section>
        <br/><br/><br/>

        <!-- 题目 -->
        <section class="widget">
            <header>
                <p><strong style="color: #e6e6e6">请认真完成下面题目:</strong></p>
            </header>
            <div class="content no-padding timeline">
                <c:forEach items="${questions}" var="question">
                    <div class="tl-post comments">
                        <span class="icon">&#59168;</span>
                        <p style="width: 95%;">
                            <strong>${question.des}</strong><br/>
                            <input style="display: none" value="${question.id}" name="questionIDs">
                            <strong style="color: #15a589">请对该问题功能进行打分:</strong>&nbsp;&nbsp;<input
                                style="width: 130px;height: 15px;" type="text" name="score" value="50"><br/>
                            <input id="input_${question.id}" name="picUrl_${question.id}" type="file" multiple
                                   class="file-loading"><br/>
                            <span style="width: 100%;" class="reply"><input type="text" value="在这里回答上面问题..."
                                                                            name="answers"/></span>
                        </p>
                    </div>
                </c:forEach>
            </div>
        </section>

        <!-- 心得 -->
        <section class="widget">
            <header>
                <p><strong style="color: #e6e6e6">请完成下面评测心得:</strong></p>
            </header>
            <div class="content">
                <div class="content">
                    <div class="field-wrap">
                        <strong>"请填写你的使用心得..."</strong><br/>
                    </div>
                    <br/>
                    <div class="field-wrap wysiwyg-wrap">
                        <textarea class="post" rows="8" name="experience"></textarea>
                    </div>
                    <br/>
                    <div class="field-wrap">
                        <strong>"请上传试用图片,最多4张"</strong><br/>
                    </div>

                    <div class="form-group" style="width: 300px;height: 100px; float: left;margin-left: 20px;">
                        <input id="file-1" type="file" class="file"
                               name="file_ex_1">
                    </div>
                    <div class="form-group" style="width: 300px;height: 100px; float: left;margin-left: 20px;">
                        <input id="file-2" type="file" class="file"
                               name="file_ex_2">
                    </div>
                    <div class="form-group" style="width: 300px;height: 100px; float: left;margin-left: 20px;">
                        <input id="file-3" type="file" class="file"
                               name="file_ex_3">
                    </div>
                    <div class="form-group" style="width: 300px;height: 100px; float: left;margin-left: 20px;">
                        <input id="file-4" type="file" class="file"
                               name="file_ex_4">
                    </div>

                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>
            </div>
        </section>

        <br/>
        <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 10px;">
            <div class="col-sm-offset-2 col-sm-10">
                <button style="width:600px;" type="submit" class="btn btn-success">提交报告</button>
            </div>
        </div>
    </form>
</section>


<script src="${ctx}/js/fileinput.js" type="text/javascript"></script>
<script src="${ctx}/js/fileinput_locale_zh.js" type="text/javascript"></script>
<script type="text/javascript">

    $(document).on('ready', function () {
        $(".file-loading").fileinput({
            showCaption: false,
            allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
            msgFilesTooMany: 4,
            showUpload: false //是否显示上传按钮
        });
    });

    $(".file").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "${ctx}/file/upload", //上传的地址
        allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
        maxFileSize: 100,
        maxFilesNum: 10,
        enctype: 'multipart/form-data',
        showUpload: false, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        msgFilesTooMany: 10,
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    });

    //    // 文件上传框
    //    $("#file-1").each(function () {
    //        var imageurl = $(this).attr("value");
    //
    //        if (imageurl) {
    //            var op = $.extend({
    //                        initialPreview: [ // 预览图片的设置
    //                            "<img src='" + imageurl + "' class='file-preview-image' style='width:300px;'>"]
    //                    },
    //                    {
    //                        language: 'zh', //设置语言
    //                        uploadUrl: "#", //上传的地址
    //                        allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
    //                        maxFileSize: 100,
    //                        maxFilesNum: 10,
    //                        enctype: 'multipart/form-data',
    //                        showUpload: false, //是否显示上传按钮
    //                        showCaption: false,//是否显示标题
    //                        browseClass: "btn btn-primary", //按钮样式
    //                        msgFilesTooMany: 10,
    //                    }
    //            );
    //
    //            $(this).fileinput(op);
    //        } else {
    //            $(this).fileinput({
    //                language: 'zh', //设置语言
    //                uploadUrl: "#", //上传的地址
    //                allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
    //                maxFileSize: 100,
    //                maxFilesNum: 10,
    //                enctype: 'multipart/form-data',
    //                showUpload: false, //是否显示上传按钮
    //                showCaption: false,//是否显示标题
    //                browseClass: "btn btn-primary", //按钮样式
    //                msgFilesTooMany: 10,
    //            });
    //        }
    //    });

</script>
</body>
</html>