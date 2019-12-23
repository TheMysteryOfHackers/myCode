<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/page/inc/taglib.jsp" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${applicationScope.dictionary.systemName}的权限管理系统</title>
    <jsp:include page="inc/dwz.jsp"/>
</head>
<body scroll="no">
<div id="layout">
    <div id="header">
        <!-- navMenu begin -->
        <div class="headerNav">
            <img alt="" src="${applicationScope.basepath }/statics/images/logo.png" height="50"/>
            <!-- <span style="font-size: 39px;color: white;">靖凯开源仓库管理系统</span> -->
            <ul class="nav">
                <li style="color: white;">欢迎您（${sessionScope.user.name}）！&nbsp;当前时间： <span id="time"></li>
                <li><a href="javascript:" style="color: black;">${userNo}</a></li>
                <%--<li><a href="${applicationScope.basepath }/system/teacher/toChangeInfo" target="dialog" mask="true" width="820" height="460" style="color: #fff;">帐号信息</a></li>--%>
                <shiro:hasAnyRoles name="学生,实训学生">
                    <li><a href="${applicationScope.basepath }/toChangePassword" target="dialog" mask="true" width="820"
                           height="460" style="color: #fff;">修改密码</a></li>
                </shiro:hasAnyRoles>
                <li><a href="${applicationScope.basepath }/toLogout" target="dialog" width="300" height="200"
                       mask="true" style="color: #fff;">退出</a></li>
            </ul>
            <ul class="themeList" id="themeList">
                <li theme="default">
                    <div class="selected">蓝色</div>
                </li>
                <li theme="green">
                    <div>绿色</div>
                </li>
                <li theme="purple">
                    <div>紫色</div>
                </li>
                <li theme="silver">
                    <div>银色</div>
                </li>
                <li theme="azure">
                    <div>天蓝</div>
                </li>
            </ul>
        </div>
        <!-- navMenu end -->
    </div>
    <div id="leftside">
        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse">
                    <div></div>
                </div>
            </div>
        </div>

        <div id="sidebar">
            <div class="toggleCollapse">
                <h2>主菜单</h2>
                <div>收缩</div>
            </div>
            <div class="accordion" fillSpace="sidebar">
                <c:forEach items="${sessionScope.menus}" var="menu1">
                    <c:if test="${menu1.level==0}">
                        <div class="accordionHeader">
                            <h2>
                                <span>Folder</span>${menu1.name}
                            </h2>
                        </div>
                        <div class="accordionContent">
                            <ul class="tree treeFolder">
                                <c:forEach items="${sessionScope.menus}" var="menu2">
                                    <%-- 判断是否是第二级的，还要判断第一级是谁 --%>
                                    <c:if test="${menu2.level==1 && menu1.id==menu2.pid}">
                                        <li><a href="${applicationScope.basepath}${menu2.url}" target="navTab"
                                               rel="${applicationScope.basepath}${menu2.url}" external="${menu2.type == 2 ? 'true' :'false' }"
                                               fresh="true">${menu2.name}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </c:forEach>


                <%--
                                <div class="accordionHeader">
                                    <h2>
                                        <span>Folder</span>系统管理
                                    </h2>
                                </div>
                                <div class="accordionContent">
                                    <ul class="tree treeFolder">
                                        <li><a href="${applicationScope.basepath}/system/user/list" target="navTab"
                                               rel="${applicationScope.basepath}/system/user/list" fresh="true">用户管理</a></li>
                                        <li><a href="${applicationScope.basepath}/system/role/list" target="navTab"
                                               rel="${applicationScope.basepath}/system/role/list" fresh="true">角色管理</a></li>
                                        <li><a href="${applicationScope.basepath}/system/dictionary/list" target="navTab"
                                               rel="${applicationScope.basepath}/system/dictionary/list" fresh="true">数字字典</a></li>
                                        <li><a href="${applicationScope.basepath}/system/organization/list" target="navTab"
                                               rel="${applicationScope.basepath}/system/organization/list" fresh="true">组织机构</a></li>
                                        <li><a href="${applicationScope.basepath}/system/permission/list" target="navTab"
                                               rel="${applicationScope.basepath}/system/permission/list" fresh="true">权限管理</a></li>
                                        <li><a href="${applicationScope.basepath}/druid" target="navTab"
                                               rel="${applicationScope.basepath}/druid" external="true">监控</a></li>
                                    </ul>
                                </div>
                --%>
            </div>
        </div>
    </div>
    <div id="container">
        <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent">
                    <ul class="navTab-tab">
                        <li tabid="main" class="main"><a href="javascript:;"><span><span
                                class="home_icon">主页</span></span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft">left</div>
                <div class="tabsRight">right</div>
                <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">主页</a></li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
                <div class="page unitBox">
                    <div class="pageFormContent" layoutH="0">
                        <fieldset>
                            <legend>登录信息</legend>
                            <div class="unit">
                                <p>
                                    <label>登录IP:</label>${sessionScope.user.loginip }
                                </p>
                                <p>
                                    <label>登录时间:</label> ${sessionScope.user.logintime }
                                </p>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>系统</legend>
                            <div class="unit">
                                <p>
                                    <label>操作系统:</label><%=System.getProperties().getProperty("os.name")%>
                                </p>
                                <p>
                                    <label>操作系统版本:</label><%=System.getProperties().getProperty("os.version")%>
                                </p>
                                <p>
                                    <label>JDK版本:</label><%=System.getProperties().getProperty("java.version")%>
                                </p>
                                <p>
                                    <label>处理器个数:</label>
                                    <%=Runtime.getRuntime().availableProcessors()%>
                                </p>
                                <p>
                                    <label>总内存:</label>
                                    <%=Runtime.getRuntime().totalMemory() / 1024 / 1024%>M
                                </p>
                                <p>
                                    <label>剩余内存:</label><%=Runtime.getRuntime().freeMemory() / 1024 / 1024%>M
                                </p>
                            </div>
                        </fieldset>
                    </div>

                </div>

            </div>
        </div>
    </div>

</div>

<div id="footer">Copyright &copy; 2019 zzx</div>

</body>
<script type="text/javascript">
    //未读信息     js代码结束
    //创建一个日期对象
    function show() {
        var d = new Date();
        //获取年份
        //var nian=d.getYear();//2016  //16
        var nian = d.getFullYear();//2016
        //获取月
        var yue = d.getMonth() + 1;//6   july 7月   0-11
        //获取星期几
        var xq = d.getDay();//5    0-6    0:星期天
        //获取几号
        var dd = d.getDate();//1    1-31
        //获取小时
        var h = d.getHours();// 16下午4点     24小时制
        //获取分钟
        var m = d.getMinutes();//31分
        //获取描述
        var s = d.getSeconds();//50秒
        document.getElementById("time").innerHTML = nian + "-" + yue + "-" + dd + " " + h + ":" + m + ":" + s;
    }

    setInterval("show()", 1000);
</script>
</html>