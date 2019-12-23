package com.jkoss.framejui.system.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.common.vo.DwzPageBean;
import com.jkoss.common.vo.ZtreeBean;
import com.jkoss.framejui.system.entity.Permission;
import com.jkoss.framejui.system.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.jkoss.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2019-11-14
 */
@Controller
@RequestMapping("/system/permission")
public class PermissionController extends BaseController {


	@Autowired
	private IPermissionService iPermissionService;
	
	@RequestMapping("/list")
	public String list(DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByAsc("level","sort");
		List<Permission> permissions = iPermissionService.list(queryWrapper);
		//将原有数据类型转换成ztreebean
		if (!CommonUtil.isBlank(permissions)){
			ArrayList<ZtreeBean> ztreeBeans = new ArrayList<>();
			for (Permission permission : permissions) {
				ZtreeBean ztreeBean = new ZtreeBean();
				ztreeBean.setId(permission.getId());
				ztreeBean.setPId(permission.getPid());
				ztreeBean.setName(permission.getName());
				//节点是否为父节点。有子节点则设置为 true，否则为 false
				ztreeBean.setIsParent(CommonUtil.isBlank(permission.getPid()));
				//设置open为true就是让这个树展开
				ztreeBean.setOpen(true);
				ztreeBeans.add(ztreeBean);
			}
			map.put("ztreeBeans", JSON.toJSONString(ztreeBeans));
		}else {
			map.put("ztreeBeans","[]");
		}
		return "system/permission/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(String id,ModelMap map,HttpServletRequest request, HttpServletResponse response) {
		if (!CommonUtil.isBlank(id)){
			//把父亲节点对象带到页面
			map.put("ppermission",iPermissionService.getById(id));
		}
		return "system/permission/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Permission permission, HttpServletRequest request, HttpServletResponse response) {
		if (CommonUtil.isBlank(permission.getPid())){
			//没有父亲节点，等级为0
			permission.setLevel(new BigDecimal(0));
		}
		if (iPermissionService.save(permission)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Permission permission = iPermissionService.getById(id);
		if (!CommonUtil.isBlank(permission.getPid())){
			map.put("ppermission",iPermissionService.getById(permission.getPid()));
		}
		map.put("record", permission);
		return "system/permission/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Permission permission, HttpServletRequest request, HttpServletResponse response) {

		if (iPermissionService.updateById(permission)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String id, HttpServletRequest request, HttpServletResponse response) {
		if (iPermissionService.removeChildsById(id)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	

}

