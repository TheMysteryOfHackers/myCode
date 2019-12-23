package com.jkoss.framejui.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.common.vo.DwzPageBean;
import com.jkoss.framejui.system.entity.Dictionary;
import com.jkoss.framejui.system.service.IDictionaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.jkoss.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * <p>
 * ?????ֵ 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
@Controller
@RequestMapping("/system/dictionary")
public class DictionaryController extends BaseController {


	@Autowired
	private IDictionaryService iDictionaryService;

	/*
	* @RequiresPermissions("/system/dictionary/list")
	* 这个注解，就是让有这个权限标识的用户去访问这个方法，
	* 没有这个权限标识的用户是不能方法问这个方法的。
	* 这个使用二级和三级的URL来做权限标识，这个权限标识每个企业都是不同的
	* */
	@RequestMapping("/list")
	@RequiresPermissions("/system/dictionary/list")
	public String list(String dkey,String dvalue,DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		//加入查询条件
		QueryWrapper<Dictionary> dictionaryQueryWrapper = new QueryWrapper<>();
		if (!CommonUtil.isBlank(dkey)){
			dictionaryQueryWrapper.like("dkey",dkey);
			//这是回显到前台的输入框
			dwzPageBean.getCountResultMap().put("dkey",dkey);
		}
		if (!CommonUtil.isBlank(dvalue)){
			dictionaryQueryWrapper.like("dvalue",dvalue);
			dwzPageBean.getCountResultMap().put("dvalue",dvalue);
		}
		IPage resultPage = iDictionaryService.page(dwzPageBean.toPage(),dictionaryQueryWrapper);
		map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
		return "system/dictionary/list";
	}

	@RequestMapping("/toInsert")
	@RequiresPermissions("/system/dictionary/toInsert")
	public String toInsert(HttpServletRequest request, HttpServletResponse response) {
		return "system/dictionary/edit";
	}

	/*
	* 这里问什么加上@RequiresPermissions("/system/dictionary/toInsert")
	* 而不是@RequiresPermissions("/system/dictionary/insert")这个注解呢？
	* 因为你连去插入的权限都没有，那你还有插入的权限吗？
	* */
	@RequestMapping("/insert")
	@RequiresPermissions("/system/dictionary/toInsert")
	@ResponseBody
	public Object insert(Dictionary dictionary, HttpServletRequest request, HttpServletResponse response) {
		QueryWrapper<Dictionary> queryWrapper=new QueryWrapper();
		queryWrapper.eq("dkey",dictionary.getDkey());
		Dictionary dictionary1 = iDictionaryService.getOne(queryWrapper);
		if(!CommonUtil.isBlank(dictionary1)){
			return ajaxError("key值重复了");
		}
		if (iDictionaryService.save(dictionary)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}

	}

	@RequestMapping("/toUpdate")
	@RequiresPermissions("/system/dictionary/toUpdate")
	public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		map.put("record", iDictionaryService.getById(id));
		return "system/dictionary/edit";
	}

	@RequestMapping("/update")
	@RequiresPermissions("/system/dictionary/toUpdate")
	@ResponseBody
	public Object update(Dictionary dictionary, HttpServletRequest request, HttpServletResponse response) {
		if (iDictionaryService.updateById(dictionary)) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}

	@RequestMapping("/delete")
	@RequiresPermissions("/system/dictionary/delete")
	@ResponseBody
	public Object delete(String[] id, HttpServletRequest request, HttpServletResponse response) {
		if (iDictionaryService.removeByIds(Arrays.asList(id))) {
			return ajaxSuccess();
		} else {
			return ajaxError();
		}
	}
	

}

