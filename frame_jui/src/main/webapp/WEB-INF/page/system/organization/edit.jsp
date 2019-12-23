<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/inc/taglib.jsp" %>
<div class="pageContent">
    <form method="post"
          action="${applicationScope.basepath}${requestScope.record ==null ?'/system/organization/insert' :'/system/organization/update' }"
          class="pageForm required-validate" onsubmit=" return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="57">
            <%-- 新增 --%>
            <c:if test="${requestScope.record == null  }">
                <c:if test="${requestScope.porganization !=null }">
                    <dl class="nowrap">
                        <dt>父组织名称：</dt>
                        <dd>
                            <input value="${requestScope.porganization.name }" readonly/>
                        </dd>
                    </dl>
                    <input type="hidden" name="pid" value="${requestScope.porganization.id}">
                    <input type="hidden" name="level" value="${requestScope.porganization.level+1 }">
                </c:if>
            </c:if>
            <%--  更新 --%>
            <c:if test="${requestScope.record != null  }">
                <c:if test="${requestScope.porganization !=null }">
                    <dl class="nowrap">
                        <dt>父组织名称：</dt>
                        <dd>
                            <input value="${requestScope.porganization.name }" readonly/>
                        </dd>
                    </dl>
                </c:if>
                <input type="hidden" name="id" value="${requestScope.record.id}">
            </c:if>
            <dl class="nowrap">
                <dt>组织名称：</dt>
                <dd>
                    <input name="name" value="${requestScope.record.name }" type="text" size="30" class="required"
                           maxlength="50"/>
                </dd>
            </dl>
            <dl class="nowrap">
                <dt>排序：</dt>
                <dd>
                    <input name="sort" value="${requestScope.record.sort }" type="text" size="30" class="required"
                           maxlength="10"/>
                </dd>
            </dl>
            <dl class="nowrap">
                <dt>备注：</dt>
                <dd>
                    <textarea cols="45" rows="5" name="remarks">${requestScope.record.remarks }</textarea>
                </dd>
            </dl>
            <div class="divider"></div>
            <ul>
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
                            <button type="button" id="bt_close" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
<script type="text/javascript">
    $("#bt_close").click(function(){
        $("#organizationBox").empty();
    })
</script>
