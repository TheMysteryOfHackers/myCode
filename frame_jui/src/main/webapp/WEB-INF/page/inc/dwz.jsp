<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="${applicationScope.basepath }/statics/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${applicationScope.basepath }/statics/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${applicationScope.basepath }/statics/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print" />
<link href="${applicationScope.basepath }/statics/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${applicationScope.basepath }/statics/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="screen" />
<!-- 自定义css -->
<link rel="stylesheet" href="${applicationScope.basepath }/statics/custom/css/core.css" type="text/css">
<link rel="stylesheet" href="${applicationScope.basepath }/statics/wangEditor-3.1.1/release/wangEditor.css" type="text/css">
<!--[if IE]>
<link href="${applicationScope.basepath }/statics/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 9]>
<script src="${applicationScope.basepath }/statics/dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="${applicationScope.basepath }/statics/dwz/js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/xheditor/xheditor-1.2.2.min.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/raphael.js"></script>
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/g.raphael.js"></script>
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/g.bar.js"></script>
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/g.line.js"></script>
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/g.pie.js"></script>
<script type="text/javascript" src="${applicationScope.basepath }/statics/dwz/chart/g.dot.js"></script>

<script src="${applicationScope.basepath }/statics/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.print.js" type="text/javascript"></script>
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.file.js" type="text/javascript"></script>

<!--
<script src="${applicationScope.basepath }/statics/dwz/bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="${applicationScope.basepath }/statics/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="${applicationScope.basepath }/statics/ueditor-1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${applicationScope.basepath }/statics/ueditor-1.4.3.3/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${applicationScope.basepath }/statics/ueditor-1.4.3.3/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	$(function() {
		DWZ.init("${applicationScope.basepath }/statics/dwz/dwz.frag.xml", {
			loginUrl : "toLogin",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "${applicationScope.basepath }/statics/dwz/themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>