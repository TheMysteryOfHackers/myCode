<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/inc/taglib.jsp" %>
<div class="pageHeader">
    <form id="pagerForm" onsubmit="return navTabSearch(this);" action="${applicationScope.basepath}/system/user/list"
          method="post">
        <!-- 分页表单参数 -->
        <%@include file="/WEB-INF/page/inc/pageForm.jsp" %>
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td><label style="width: 40px;">姓名&nbsp;&nbsp;:</label><input name="name"
                                                                                  value="${requestScope.dwzPageBean.countResultMap.name }">
                    </td>
                    <td><label style="width: 40px;">性别&nbsp;&nbsp;:</label>
                        <select class="combox" name="sex">
                            <option value="">请选择</option>
                            <option value="1" ${requestScope.dwzPageBean.countResultMap.sex== 1 ? 'selected' : '' }>男
                            </option>
                            <option value="2" ${requestScope.dwzPageBean.countResultMap.sex== 2 ? 'selected' : '' }>女
                            </option>
                        </select></td>
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
            <li><a class="add" href="${applicationScope.basepath}/system/user/toInsert" rel="insert" target="dialog"
                   mask="true"><span>添加</span></a></li>
            <li><a class="delete" href="${applicationScope.basepath}/system/user/delete" rel="id" target="selectedTodo"
                   title="确定要删除吗？" warn="请最小选择一条记录" mask="true"><span>批量删除</span></a></li>
        </ul>
    </div>
    <table class="table" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="22"><input type="checkbox" group="id" class="checkboxCtrl"></th>
            <th>姓名</th>
            <th>角色</th>
            <th>密码</th>
            <th>性别</th>
            <th>生日</th>
            <th>手机</th>
            <th>邮件</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${requestScope.dwzPageBean != null &&  requestScope.dwzPageBean.recordList != null }">
            <c:forEach var="record" items="${requestScope.dwzPageBean.recordList}" varStatus="status">
                <tr>
                    <td><input name="id" value="${record.id}" type="checkbox"></td>
                    <td>${record.name}</td>
                    <td>${record.rname}</td>
                    <td>${record.pwd}</td>
                    <td>${record.sex == 1  ? '男' : '女' }</td>
                    <td>${record.birth}</td>
                    <td>${record.phone}</td>
                    <td>${record.email}</td>
                    <td><a class="editBtn" href="${applicationScope.basepath}/system/user/toUpdate?id=${record.id}"
                           rel="update" target="dialog" mask="true"><span>修改</span></a>
                        <a class="deleteBtn" href="${applicationScope.basepath}/system/user/delete?id=${record.id}"
                           target="ajaxTodo" title="确定要删除吗？" mask="true"><span>删除</span></a>
                        <a class="editBtn" href="${applicationScope.basepath}/system/user/toUpdateRole?id=${record.id}"
                           rel="update" target="dialog" mask="true"><span>分配角色</span></a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <!-- 分页条 -->
    <%@include file="/WEB-INF/page/inc/pageBar.jsp" %>
</div>