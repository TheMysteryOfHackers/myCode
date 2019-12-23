<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${applicationScope.basepath}${requestScope.record ==null ?'/system/dictionary/insert' :'/system/dictionary/update' }" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<!-- 关闭窗口 -->
			<input type="hidden" name="callbackType" value="closeCurrent" />
			<!-- 隐藏表单 -->
			<c:if test="${requestScope.record !=null}">
				<input type="hidden" name="id" value="${requestScope.record.id}" />
			</c:if>
			<p>
				<label>键</label> <input name="dkey" class="required" maxlength="50" type="text" value="${requestScope.record.dkey}" ${requestScope.record !=null ? 'readonly':''} />
			</p>
			<p>
				<label>值</label> <input name="dvalue" class="required" maxlength="500" type="text" value="${requestScope.record.dvalue}" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
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
