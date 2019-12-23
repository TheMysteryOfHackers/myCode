<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/inc/taglib.jsp" %>
<div class="pageContent">
    <form method="post"
          action="${applicationScope.basepath}${requestScope.record ==null ?'/system/user/insert' :'/system/user/update' }"
          class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <!-- 关闭窗口 -->
            <input type="hidden" name="callbackType" value="closeCurrent"/>
            <!-- 隐藏表单 -->
            <c:if test="${requestScope.record !=null}">
                <input type="hidden" name="id" value="${requestScope.record.id}"/>
            </c:if>
            <%--  <p>
                  <label>角色id</label> <input name="rid" class="required" maxlength="32" type="text"
                                             value="${requestScope.record.rid}"/>
              </p>
              <p>
                  <label>组织机构id</label> <input name="ogid" class="required" maxlength="32" type="text"
                                               value="${requestScope.record.ogid}"/>
              </p>--%>
            <p>
                <label>姓名</label> <input name="name" class="required" ${requestScope.record!=null ? 'readonly' :''}
                                         maxlength="50" type="text"
                                         value="${requestScope.record.name}"/>
            </p>
            <p>
                <label>密码</label> <input name="pwd" class="required" maxlength="50" type="text"
                                         value="${requestScope.record.pwd}"/>
            </p>
            <p>
                <label>性别</label>
                <select class="combox" name="sex">
                    <option value="">请选择</option>
                    <option value="1" ${requestScope.record.sex == 1 ? 'selected' : ''  }>男</option>
                    <option value="2" ${requestScope.record.sex == 2 ? 'selected' : ''  }>女</option>
                </select>
            </p>
            <p>
                <label>生日</label> <input name="birth" class="date textInput readonly" readonly="true" maxlength="20"
                                         maxlength="20" type="text"
                                         value="${requestScope.record.birth}"/><a class="inputDateButton"
                                                                                  href="javascript:;">选择</a>
            </p>
            <p>
                <label>手机</label> <input name="phone" class="required"  ${requestScope.record!=null ? 'readonly' :''}
                                         maxlength="11" type="text"
                                         value="${requestScope.record.phone}"/>
            </p>
            <p>
                <label>邮件</label> <input name="email" class="required" maxlength="500" type="text"
                                         value="${requestScope.record.email}"/>
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
