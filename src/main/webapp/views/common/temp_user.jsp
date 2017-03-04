<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/26
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="temp.jsp"/>
    <div class="testing">
        <header class="main">
            <h1><strong>TAB BackServer</strong></h1>
        </header>
        <section class="user">
            <div class="profile-img">
                <p><img src="${sessionScope.user.mochaUserPic}" alt="" height="40" width="40"/> 欢迎回来 ${sessionScope.user.mochaUserName}</p>
            </div>
            <div class="buttons">
                <button class="ico-font">&#9206;</button>
                <span class="button blue"><a href="${ctx}/user/exit">安全退出</a></span>
            </div>
        </section>
    </div>
    <nav>
        <ul>
            <li>
                <a href="../../report_1.jsp"><span class="icon">&#127748;</span> 评测报告 </a>
            </li>
            <li><a href="../../create_user.html"><span class="icon">&#128101;</span> 个人中心 </a></li>
        </ul>
    </nav>
</head>
<body>

</body>
</html>
