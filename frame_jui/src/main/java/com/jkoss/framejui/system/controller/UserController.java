package com.jkoss.framejui.system.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jkoss.common.constant.Constant;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.common.util.CryptoUtils;
import com.jkoss.framejui.system.entity.Role;
import com.jkoss.framejui.system.service.IRoleService;
import com.jkoss.framejui.system.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jkoss.base.controller.BaseController;
import com.jkoss.common.vo.DwzPageBean;
import com.jkoss.framejui.system.entity.User;
import com.jkoss.framejui.system.service.IUserService;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author chair
 * @since 2019-11-11
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/list")
    public String list(String name,Integer sex,DwzPageBean dwzPageBean, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        //加入查询条件
        QueryWrapper<UserVo> voQueryWrapper = new QueryWrapper<>();
        if (!CommonUtil.isBlank(name)){
            voQueryWrapper.like("u.name",name);
            //将查询的条件回显到查询框
            dwzPageBean.getCountResultMap().put("name",name);
        }
        if (!CommonUtil.isBlank(sex)){
            voQueryWrapper.like("u.sex",sex);
            dwzPageBean.getCountResultMap().put("sex",sex);
        }
        // DwzPageBean 接收前端分页信息对象
        //这是要进行多表查询，所以要建立一个新的pageVo方法，不仅要传入分页对象，还要传入查询对象
        //因为这是多表查询，结果多出来一个字段，所以要创建一个userVo对象来存数据，用这个对象来返回。
        IPage resultPage = iUserService.pageVo(dwzPageBean.toPage(),voQueryWrapper);
        map.put("dwzPageBean", dwzPageBean.toDwzPageBean(resultPage));

        return "system/user/list";
    }

    @RequestMapping("/toInsert")
    public String toInsert(HttpServletRequest request, HttpServletResponse response) {
        return "system/user/edit";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Object insert(User user, HttpServletRequest request, HttpServletResponse response) {
        //判断用户是否重复
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", user.getName()).or().eq("phone", user.getPhone());
        User tmp = iUserService.getOne(userQueryWrapper);
        if (!CommonUtil.isBlank(tmp)) {
            return ajaxError("用户名或者手机号重复了");
        }
        //设置加密盐
        user.setPwd(CryptoUtils.encodeMD5(Constant.PWD_SALT + user.getPwd()));

        if (iUserService.save(user)) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        map.put("record", iUserService.getById(id));
        return "system/user/edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(User user, HttpServletRequest request, HttpServletResponse response) {
        if (iUserService.updateById(user)) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String[] id, HttpServletRequest request, HttpServletResponse response) {
        if (iUserService.removeByIds(Arrays.asList(id))) {
            return ajaxSuccess();
        } else {
            return ajaxError();
        }
    }

    @RequestMapping("/toUpdateRole")
    public String toUpdateRole(String id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<Role>();
        roleQueryWrapper.orderByDesc("crtm");
        map.put("roles", iRoleService.list(roleQueryWrapper));
        //把更新到那个用户带到页面
        map.put("user", iUserService.getById(id));
        return "system/user/editRole";
    }
    @RequestMapping("/updateRole")
    @ResponseBody
    public Object updateRole(String id, String rid, ModelMap map, HttpServletRequest request, HttpServletResponse response){
        UpdateWrapper<User> roleUpdateWrapper = new UpdateWrapper<>();
        roleUpdateWrapper.set("rid",rid);
        roleUpdateWrapper.eq("id",id);
        if (iUserService.update(roleUpdateWrapper)){
            return ajaxSuccess();
        }else {
            return ajaxError();
        }
    }


}
