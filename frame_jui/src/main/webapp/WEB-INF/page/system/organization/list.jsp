<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/inc/taglib.jsp"%>
<!-- 引用ztree 的css -->
<link rel="stylesheet" href="${applicationScope.basepath}/statics/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<div class="pageHeader">
	<form id="pagerForm" onsubmit="return navTabSearch(this);" action="${applicationScope.basepath }/system/organization/list" method="post">
		<!-- 分页表单参数 -->
		<%@include file="/WEB-INF/page/inc/pageForm.jsp"%>
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td></td>
				</tr>
			</table>
			<div class="subBar">
				<!-- <ul>
                        <li><div class="buttonActive">
                                        <div class="buttonContent">
                                                <button type="submit">查询</button>
                                        </div>
                                </div></li>
                </ul> -->
			</div>
		</div>
	</form>
</div>
<div class="pageContent j-resizeGrid">
	<!-- 按钮 -->
	<div class="panelBar">
		<ul class="toolBar">
			<!-- 局部刷新 在a标签添加属性  target="ajax" 和添加 rel="所要刷新的位置"-->
			<li><a id="toInsert" class="add" mask="true" href="" rel="permissionBox"><span>添加</span></a></li>
			<li><a id="toUpdate" class="edit" mask="true" href="" rel="update"><span>修改</span></a></li>
			<li><a id="delect" class="delete" mask="true" href=""><span>删除</span></a></li>
		</ul>
	</div>
	<!-- 左布局 -->
	<div style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; background: #fff">
		<!-- <ul class="tree treeFolder"> -->
		<ul layoutH="100" id="permissionTree" class="ztree"></ul>
	</div>
	<!-- 右布局 -->
	<div id="organizationBox" class="unitBox" style="margin-left: 246px;"></div>
</div>
<script type="text/javascript" src="${applicationScope.basepath}/statics/ztree/js/jquery.ztree.core.js"></script>
<SCRIPT type="text/javascript">

	var id=null;
	var level=null;
	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		},
		/* 添加这个属性，就可以通过点击左边的的树的节点，就会获取一些信息*/
		callback:{
			onClick:function(event, treeId, treeNode, clickFlag){
				//点击后赋值给pid
				id=treeNode.id;//其实这里的pid就是选中项的id
				level=treeNode.level;
				//console.log(id);
				//console.log(level)
			}
		}
	};

	var zNodes = ${requestScope.ztreeBeans};

	//ztree初始化  ztree 设置参数
	$.fn.zTree.init($("#permissionTree"), setting, zNodes);

	$("#toInsert").click(function(){
		if (level>1){
			alertMsg.error('节点级别不能超过3！');
			$("#organizationBox").empty();
			return false;
		}
		if (id){
			//添加子节点
			$("#organizationBox").loadUrl('${applicationScope.basepath}/system/organization/toInsert?id='+id,null,null);
		}else{
			$("#organizationBox").loadUrl('${applicationScope.basepath}/system/organization/toInsert', null, null);
		}
		return false;
	});
	$("#toUpdate").click(function(){
		if (id){
			$("#organizationBox").loadUrl('${applicationScope.basepath}/system/organization/toUpdate?id='+id,null,null);
		}else{
			alertMsg.error('请选择您要更改的选项！');
			$("#organizationBox").empty();
			return false;
		}

		return false;
	});
	$("#delect").click(function(){
		if (id){
		    ajaxTodo("${applicationScope.basepath}/system/organization/delete?id="+id);
		}else{
			alertMsg.error('请选者您要删除的选项！');
			$("#organizationBox").empty();
			return false;
		}
		return false;
	});
</SCRIPT>