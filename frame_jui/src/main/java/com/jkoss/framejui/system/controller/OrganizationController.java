package com.jkoss.framejui.system.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.jkoss.base.controller.BaseController;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.common.vo.DwzPageBean;
import com.jkoss.common.vo.ZtreeBean;
import com.jkoss.framejui.system.entity.Organization;
import com.jkoss.framejui.system.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * ??֯???? 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
@Controller
@RequestMapping("/system/organization")
public class OrganizationController extends BaseController {


	@Autowired
	private IOrganizationService iOrganizationService;
	
	@RequestMapping("/list")
	public String list(DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByAsc("level","sort");
		List<Organization> list = iOrganizationService.list(queryWrapper);
		//把原有数据类型转换为ztreeBeans
		if (!CommonUtil.isBlank(list)){
			ArrayList<ZtreeBean> ztreeBeans = new ArrayList<>();
			for (Organization organization : list) {
				ZtreeBean ztreeBean = new ZtreeBean();
				ztreeBean.setId(organization.getId());
				ztreeBean.setPId(organization.getPid());
				ztreeBean.setName(organization.getName());
				ztreeBean.setIsParent(CommonUtil.isBlank(organization.getPid()));
				//设置open为true就是让这个树展开
				ztreeBean.setOpen(true);
				ztreeBeans.add(ztreeBean);
			}
			//将对象数据转成json数据传递到前端
			map.put("ztreeBeans", JSON.toJSONString(ztreeBeans));
		}else{
			map.put("ztreeBeans","[]");
		}
		return "system/organization/list";
	}

	@RequestMapping("/toInsert")
	public String toInsert(String id,ModelMap map,HttpServletRequest request, HttpServletResponse response) {
		//把有父亲节点
		//把父亲节点对象带到页面
		if (!CommonUtil.isBlank(id)){
			map.put("porganization",iOrganizationService.getById(id));
		}

		return "system/organization/edit";
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Organization organization, HttpServletRequest request, HttpServletResponse response) {
		//没有父亲节点，等级为0
		if (CommonUtil.isBlank(organization.getPid())){
			organization.setLevel(new BigDecimal(0));
		}
		if (iOrganizationService.save(organization)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Organization organization = iOrganizationService.getById(id);
		//获取选中的那个选项的父级的id，并判断是否为空，不为空就返回父级的对象
		if (CommonUtil.isBlank(organization.getPid())){
			map.put("porganization",iOrganizationService.getById(organization.getPid()));
		}
		map.put("record", organization);
		return "system/organization/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Organization organization, HttpServletRequest request, HttpServletResponse response) {
		if (iOrganizationService.updateById(organization)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String id, HttpServletRequest request, HttpServletResponse response) {

		if (iOrganizationService.removeChildsById(id)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	/**
	 * 删除子节点
	 *
	 * @param id
	 */
	/*public void delectChildNode(String id) {
		QueryWrapper<Organization> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("pid", id);
		//查找pid等于id的数据
		List<Organization> organizationList = iOrganizationService.list(queryWrapper);
		//删除pid等于id的数据
		iOrganizationService.remove(queryWrapper);
		//如果查到pid等于id的数据
		if (!CommonUtil.isBlank(organizationList)) {
			for (Organization organization : organizationList) {
				//递归查找和删除pid等于自己id的数据
				delectChildNode(organization.getId());
			}
		}
	}*/

}

