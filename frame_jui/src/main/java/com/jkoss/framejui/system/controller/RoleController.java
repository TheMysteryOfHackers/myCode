package com.jkoss.framejui.system.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jkoss.base.controller.BaseController;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.common.vo.DwzPageBean;
import com.jkoss.common.vo.ZtreeBean;
import com.jkoss.framejui.system.entity.Permission;
import com.jkoss.framejui.system.entity.Role;
import com.jkoss.framejui.system.service.IPermissionService;
import com.jkoss.framejui.system.service.IRolePermissionService;
import com.jkoss.framejui.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * ??ɫ 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {


    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IPermissionService iPermissionService;
    @Autowired
    private IRolePermissionService iRolePermissionService;

    @RequestMapping("/list")
    public String list(DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        IPage resultPage = iRoleService.page(dwzPageBean.toPage());
        map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));
        return "system/role/list";
    }

    @RequestMapping("/toInsert")
    public String toInsert(HttpServletRequest request, HttpServletResponse response) {
        return "system/role/edit";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(Role role, HttpServletRequest request, HttpServletResponse response) {
        if (iRoleService.save(role)) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }

    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        map.put("record", iRoleService.getById(id));
        return "system/role/edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(Role role, HttpServletRequest request, HttpServletResponse response) {
        if (iRoleService.updateById(role)) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String[] id, HttpServletRequest request, HttpServletResponse response) {
        if (iRoleService.removeByIds(Arrays.asList(id))) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }
    }

    /*
     * 给角色分配权限
     * */
    @RequestMapping("/toUpdateRolePermission")
    public String toUpdateRolePermission(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        //这是将角色的权限回显到前台
        //根据角色id查找权限id,其实传递过来的id就是角色id
        List<String> pids=iRolePermissionService.listPidByRid(id);
        //角色id
        map.put("rid", id);

        //找到所有权限
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        List<Permission> permissions = iPermissionService.list();
        if (!CommonUtil.isBlank(permissions)) {
            ArrayList<ZtreeBean> ztreeBeans = new ArrayList<>();
            for (Permission permission : permissions) {
                ZtreeBean ztreeBean = new ZtreeBean();
                ztreeBean.setId(permission.getId());
                ztreeBean.setPId(permission.getPid());
                ztreeBean.setName(permission.getName());
                ztreeBean.setIsParent(CommonUtil.isBlank(permission.getPid()));
                ztreeBean.setOpen(true);
                if (!CommonUtil.isBlank(pids)){
                    ztreeBean.setChecked(pids.contains(permission.getId()));
                }
                ztreeBeans.add(ztreeBean);
            }
            map.put("ztreeBeans", JSON.toJSONString(ztreeBeans));
        } else {
            map.put("ztreeBeans", "[]");
        }
        return "system/role/editRolePermission";
    }

    /*
    * 更新角色权限
    * */
    @RequestMapping("/updateRolePermission")
    @ResponseBody
    public Object updateRolePermission(String rid, String[] pid, HttpServletRequest request, HttpServletResponse response) {
        if (iRolePermissionService.updatePidByRid(rid,pid)){
            return ajaxSuccess();
        }else{
            return ajaxError();
        }
    }


}

