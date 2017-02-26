<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <title>Retina Dashboard</title>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="robots" content=""/>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="css/style.css" media="all"/>
    <!--[if IE]>
    <link rel="stylesheet" href="css/ie.css" media="all"/><![endif]-->
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="css/lt-ie-9.css" media="all"/><![endif]-->
</head>
<body>
<div class="testing">
    <header class="main">
        <h1><strong>TAB BackServer</strong></h1>
    </header>
    <section class="user">
        <div class="profile-img">
            <p><img src="images/uiface2.png" alt="" height="40" width="40"/> 欢迎回来 XXX</p>
        </div>
        <div class="buttons">
            <button class="ico-font">&#9206;</button>
            <span class="button blue"><a href="index.jsp">安全退出</a></span>
        </div>
    </section>
</div>
<nav>
    <ul>
        <li class="section"><a href="index.jsp"><span class="icon">&#128711;</span> 申请评测</a></li>
        <li>
            <a href="pages-table.html"><span class="icon">&#128196;</span> 创建评测</a>
            <ul class="submenu">
                <li><a href="page-new.html">Create page</a></li>
                <li><a href="page-timeline.html">View pages</a></li>
            </ul>
        </li>
        <li>
            <a href="files.html"><span class="icon">&#127748;</span> 评测报告 <span class="pip">7</span></a>
            <ul class="submenu">
                <li><a href="files-upload.html">Upload file</a></li>
                <li><a href="files.html">View files</a></li>
            </ul>
        </li>
        <li>
            <a href="blog-timeline.html"><span class="icon">&#59160;</span> 评测报告审核 </a>
            <ul class="submenu">
                <li><a href="blog-new.html">已通过评测列表</a></li>
                <li><a href="blog-table.html">未通过列表</a></li>
                <li><a href="comments-timeline.html">已提交评测报告</a></li>
            </ul>
        </li>
        <li><a href="users.html"><span class="icon">&#128101;</span> 个人中心 </a></li>
        <li>
            <a href="ui-elements.html"><span class="icon">&#9881;</span> 管理员管理 </a>
            <ul class="submenu">
                <li><a href="icon-fonts.html">添加管理员</a></li>
                <li><a href="icon-fonts.html">删除管理员</a></li>
            </ul>
        </li>
    </ul>
</nav>
<section class="content">
    <section class="widget">
        <header>
            <span class="icon">&#128200;</span>
            <hgroup>
                <h1>Website Statistics</h1>
                <h2>An insiders view</h2>
            </hgroup>
            <aside>
                <button class="left-btn">&#59229;</button>
                <button class="right-btn">&#59230;</button>
            </aside>
        </header>
        <div class="content cycle">
            <div id="flot-example-2" class="graph-area"></div>
            <div id="flot-example-1" class="graph-area"></div>
        </div>
        </div>
    </section>

    <div class="widget-container">
        <section class="widget small">
            <header>
                <span class="icon">&#59168;</span>
                <hgroup>
                    <h1>Latest comments</h1>
                    <h2>What they're saying</h2>
                </hgroup>
                <aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox"/></li>
							<li><label>Option b</label><input type="checkbox" checked="checked"/></li>
							<li><label>Option c</label><input type="checkbox"/></li>
						</ul>
					</span>
                </aside>
            </header>
            <div class="content no-padding timeline">
                <div class="tl-post comments">
                    <span class="icon">&#59168;</span>
                    <p>
                        <a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam
                        nonummy.
                        <span class="reply"><input type="text" value="Respond to comment..."/></span>
                    </p>
                </div>
                <div class="tl-post comments">
                    <span class="icon">&#59168;</span>
                    <p>
                        <a href="#">John Doe says:</a> Lorem ipsum dolor sit amet, consecteteur adipiscing elit sed diam
                        nonummy.
                        <span class="reply"><input type="text" value="Respond to comment..."/></span>
                    </p>
                </div>
                <span class="show-more"><a href="#">More</a></span>
            </div>
        </section>

        <section class="widget 	small">
            <header>
                <span class="icon">&#128319;</span>
                <hgroup>
                    <h1>Quick Post</h1>
                    <h2>Speed things up</h2>
                </hgroup>
                <aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox"/></li>
							<li><label>Option b</label><input type="checkbox" checked="checked"/></li>
							<li><label>Option c</label><input type="checkbox"/></li>
						</ul>
					</span>
                </aside>
            </header>
            <div class="content">
                <div class="field-wrap">
                    <input type="text" value="Title"/>
                </div>
                <div class="field-wrap">
                    <textarea id="quick_post" rows="5"></textarea>
                </div>
                <button type="submit" class="green">Post</button>
                <button type="submit" class="">Preview</button>
            </div>
        </section>
    </div>

    <div class="widget-container">
        <section class="widget small">
            <header>
                <span class="icon">&#128318;</span>
                <hgroup>
                    <h1>Website figures</h1>
                    <h2>Facts &amp; figures</h2>
                </hgroup>
                <aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox"/></li>
							<li><label>Option b</label><input type="checkbox" checked="checked"/></li>
							<li><label>Option c</label><input type="checkbox"/></li>
						</ul>
					</span>
                </aside>
            </header>
            <div class="content">
                <section class="stats-wrapper">
                    <div class="stats">
                        <p><span>64</span></p>
                        <p>Pages</p>
                    </div>
                    <div class="stats">
                        <p><span>362</span></p>
                        <p>Comments</p>
                    </div>
                </section>
                <section class="stats-wrapper">
                    <div class="stats">
                        <p><span>7</span></p>
                        <p>Users</p>
                    </div>
                    <div class="stats">
                        <p><span>927</span></p>
                        <p>Assets</p>
                    </div>
                </section>
            </div>
        </section>

        <section class="widget small">
            <header>
                <span class="icon">&#128363;</span>
                <hgroup>
                    <h1>Timeline</h1>
                    <h2>Insiders news</h2>
                </hgroup>
                <aside>
					<span>
						<a href="#">&#9881;</a>
						<ul class="settings-dd">
							<li><label>Option a</label><input type="checkbox"/></li>
							<li><label>Option b</label><input type="checkbox" checked="checked"/></li>
							<li><label>Option c</label><input type="checkbox"/></li>
						</ul>
					</span>
                </aside>
            </header>
            <div class="content no-padding timeline">
                <div class="tl-post">
                    <span class="icon">&#128206;</span>
                    <p><a href="#">John Doe</a> attached an image to a blog post.</p>
                </div>
                <div class="tl-post">
                    <span class="icon">&#59172;</span>
                    <p><a href="#">John Doe</a> added his location.</p>
                </div>
                <div class="tl-post">
                    <span class="icon">&#59170;</span>
                    <p><a href="#">John Doe</a> edited his profile.</p>
                </div>
                <div class="tl-post">
                    <span class="icon">&#9993;</span>
                    <p><a href="#">John Doe</a> has sent you private message.</p>
                </div>
                <div class="pie graph-area"></div>
            </div>
        </section>

    </div>
    <div class="widget-container">
        <div style="height:80px">
            Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> - More Templates <a
                href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
        </div>
    </div>
</section>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script src="js/jquery.wysiwyg.js"></script>
<script src="js/custom.js"></script>
<script src="js/cycle.js"></script>
<script src="js/jquery.checkbox.min.js"></script>
<script src="js/flot.js"></script>
<script src="js/flot.resize.js"></script>
<script src="js/flot-time.js"></script>
<script src="js/flot-pie.js"></script>
<script src="js/flot-graphs.js"></script>
<script src="js/cycle.js"></script>
<script src="js/jquery.tablesorter.min.js"></script>
<script type="text/javascript">
    // Feature slider for graphs
    $('.cycle').cycle({
        fx: "scrollHorz",
        timeout: 0,
        slideResize: 0,
        prev: '.left-btn',
        next: '.right-btn'
    });
</script>
</body>
</html>