<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/inc/taglib.jsp" %>
<div class="pageHeader">
    <form id="pagerForm" onsubmit="return navTabSearch(this);"
          action="${applicationScope.basepath}/system/dictionary/list" method="post">
        <!-- 分页表单参数 -->
        <%@include file="/WEB-INF/page/inc/pageForm.jsp" %>
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td><label style="width: 40px;">键&nbsp;&nbsp;:</label><input name="dkey"
                                                                                 value="${requestScope.dwzPageBean.countResultMap.dkey }">
                    </td>
                    <td><label style="width: 40px;">值&nbsp;&nbsp;:</label><input name="dvalue"
                                                                                 value="${requestScope.dwzPageBean.countResultMap.dvalue }">
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">查询</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <%-- 这是动态按钮，判断这个按钮需要怎么样的权限才显示 --%>
            <shiro:hasPermission name="/system/dictionary/toInsert">
                <li><a class="add" href="${applicationScope.basepath}/system/dictionary/toInsert" rel="insert"
                       target="dialog" mask="true"><span>添加</span></a></li>
            </shiro:hasPermission>

            <li><a class="delete" href="${applicationScope.basepath}/system/dictionary/delete" rel="id"
                   target="selectedTodo" title="确定要删除吗？" warn="请最小选择一条记录" mask="true"><span>批量删除</span></a></li>

        </ul>
    </div>
    <table class="table" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="22"><input type="checkbox" group="id" class="checkboxCtrl"></th>
            <th orderField="dkey"
                <c:if test="${requestScope.dwzPageBean.countResultMap.orderField == 'dkey'}">class="${requestScope.dwzPageBean.countResultMap.orderDirection}"</c:if>>
                键
            </th>
            <th orderField="dvalue"
                <c:if test="${requestScope.dwzPageBean.countResultMap.orderField == 'dvalue'}">class="${requestScope.dwzPageBean.countResultMap.orderDirection}"</c:if>>
                值
            </th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:if test="${requestScope.dwzPageBean != null &&  requestScope.dwzPageBean.recordList != null }">
            <c:forEach var="record" items="${requestScope.dwzPageBean.recordList}" varStatus="status">
                <tr>
                    <td><input name="id" value="${record.id}" type="checkbox"></td>
                    <td>${record.dkey}</td>
                    <td>${record.dvalue}</td>
                    <td><a title="编辑" target="dialog"
                           href="${applicationScope.basepath}/system/dictionary/toUpdate?id=${record.id}"
                           class="editBtn" mask="true"><span>编辑</span></a> <a title="确定要删除吗？" mask="true"
                                                                              target="ajaxTodo"
                                                                              href="${applicationScope.basepath}/system/dictionary/delete?id=${record.id}"
                                                                              class="deleteBtn"
                                                                              mask="true"><span>删除</span></a></td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>
    <!-- 分页条 -->
    <%@include file="/WEB-INF/page/inc/pageBar.jsp" %>
</div>