<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/inc/taglib.jsp" %>
<div class="pageContent">
    <form method="post" action="${applicationScope.basepath}/system/user/updateRole" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <!-- 关闭窗口 -->
            <input type="hidden" name="callbackType" value="closeCurrent"/>
            <input type="hidden" name="id" value="${requestScope.user.id }">
            <p>
                <label>角色</label> <select name="rid" class="required">
                <option value="">请选择</option>
                <c:forEach items="${requestScope.roles }" var="role">
                    <option value="${role.id }" ${role.id==requestScope.user.rid ? 'selected' : '' }>${role.name }</option>
                </c:forEach>
            </select>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
