<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <link href="../../css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="../common/temp_manager.jsp"/>

<div style="width: 100%;margin-left: 210px;">
    <section class="widget">
        <div class="content">
            <div style="margin-left: 20%">
                <form class="form-horizontal" enctype="multipart/form-data" action="${ctx}/product/add" method="post">

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="name" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name"
                                   placeholder="商品名称"
                                   style="width: 250px;" name="name">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="price" class="col-sm-2 control-label">商品价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="price"
                                   placeholder="商品价格"
                                   style="width: 250px;" name="price">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="capacity" class="col-sm-2 control-label">商品容量</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="capacity"
                                   placeholder="单位ml"
                                   style="width: 250px;" name="capacity">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="quality" class="col-sm-2 control-label">商品质地</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="quality"
                                   placeholder="商品质地"
                                   style="width: 250px;" name="quality">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="element" class="col-sm-2 control-label">商品成分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="element"
                                   placeholder="商品成分"
                                   style="width: 250px;" name="element">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="function" class="col-sm-2 control-label">商品功能</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="function"
                                   placeholder="商品功能"
                                   style="width: 250px;" name="function">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="userWay" class="col-sm-2 control-label">商品使用方法</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userWay"
                                   placeholder="商品使用方法"
                                   style="width: 250px;" name="userWay">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="attention" class="col-sm-2 control-label">商品注意事项</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="attention"
                                   placeholder="商品注意事项"
                                   style="width: 250px;" name="attention">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="channel" class="col-sm-2 control-label">商品通路</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="channel"
                                   placeholder="專櫃/通路等"
                                   style="width: 250px;" name="channel">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">商品适合肌肤</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="suitSkin">
                                <option value="1">干性</option>
                                <option value="2">中性</option>
                                <option value="3">油性</option>
                                <option value="4">混合性</option>
                                <option value="5">敏感性</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="topicNum" class="col-sm-2 control-label">商品相关话题数</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="topicNum"
                                   placeholder="商品相关话题数"
                                   style="width: 250px;" name="topicNum">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="series" class="col-sm-2 control-label">商品系列</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="series"
                                   placeholder="商品系列"
                                   style="width: 250px;" name="series">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">商品是否上市</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="ismarket">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="brandId" class="col-sm-2 control-label">品牌编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="brandId"
                                   placeholder="品牌编号"
                                   style="width: 250px;" name="brandId">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="webUrl" class="col-sm-2 control-label">官方或網頁連結</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="webUrl"
                                   placeholder="官方或網頁連結"
                                   style="width: 250px;" name="webUrl">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="num" class="col-sm-2 control-label">衛妝廣字編號</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="num"
                                   placeholder="衛妝廣字編號"
                                   style="width: 250px;" name="num">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="informationStatus" class="col-sm-2 control-label">资料状态</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="informationStatus"
                                   placeholder="资料状态"
                                   style="width: 250px;" name="informationStatus">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label for="producersStatus" class="col-sm-2 control-label">产商公布状态</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="producersStatus"
                                   placeholder="产商公布状态"
                                   style="width: 250px;" name="producersStatus">
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">商品是否显示于前台</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="productShow">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">商品功能是否显示于前台</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="functionShow">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 45px; margin-top: 10px;">
                        <label class="col-sm-2 control-label">商品成分是否显示于前台</label>
                        <div class="col-sm-10" style="width: 250px;">
                            <select class="form-control customed-select" style="border-color: #e3e3e3" name="elementShow">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group" style="height: 60px; margin-top: 10px;">
                        <label for="file-1" class="col-sm-2 control-label">上传商品图片</label>
                        <div class="col-sm-10" style="width: 500px;height: 200px;">
                            <input id="file-1" type="file" class="file" style="width: 500px;height: 200px;" name="file" >
                        </div>
                    </div>

                    <br/> <br/> <br/> <br/>
                    <div class="form-group" id="bottom-btn-wrap" style="height: 45px; margin-top: 290px;">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button style="width:600px;" type="submit" class="btn btn-success">立即创建</button>
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
<script src="../../js/fileinput.js" type="text/javascript"></script>
<script src="../../js/fileinput_locale_zh.js" type="text/javascript"></script>
<script type="text/javascript">
    $("#file-1").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    });

</script>
</body>
</html>