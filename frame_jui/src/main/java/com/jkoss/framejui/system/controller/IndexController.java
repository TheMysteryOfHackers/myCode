package com.jkoss.framejui.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jkoss.common.util.CryptoUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jkoss.base.controller.BaseController;
import com.jkoss.common.constant.Constant;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.framejui.system.entity.User;
import com.jkoss.framejui.system.service.IUserService;

/**
 * 主页 前端控制器
 * 
 * @Author chair
 * @Version 1.0,2018 年9月23日
 * @See
 * @Since com.jkoss.mengal.system.controller
 * @Description :TODO
 */
@Controller()
@RequestMapping("/")
public class IndexController extends BaseController {

	@Autowired
	private IUserService iUserService;

	/**
	 * 去主页
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping("/toLogout")
	public String toLogout(HttpServletRequest request, HttpServletResponse response){
		return "logoutConfirm";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		return "redirect:/";
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping("/login")
	public String login(String lgnName, String pwd, ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 条件
		// UpdateWrapper<T>
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		queryWrapper.eq("name", lgnName);
		System.out.println("----"+CryptoUtils.encodeMD5(Constant.PWD_SALT+"123456"));
		// queryWrapper.ne(column, val)
		User user = iUserService.getOne(queryWrapper);
		if (CommonUtil.isBlank(user)) {
			map.put("msg", "用户不存在");
			return "login";
		} else {
			if (CommonUtil.isEquals(user.getPwd(), CryptoUtils.encodeMD5(Constant.PWD_SALT+pwd))) {
				// 登录成功
				// 更新登录时间和登录ip
				user.setLogintime(CommonUtil.date6());
				user.setLoginip(getAddr());
				iUserService.updateById(user);
				request.getSession().setAttribute(Constant.SESSION_USER_KEY, user);
				return "redirect:/toIndex";
			} else {
				map.put("msg", "密码错误");
				return "login";
			}
		}
	}*/
	@RequestMapping("/login")
	public String login(String lgnName, String pwd, ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		pwd=CryptoUtils.encodeMD5(Constant.PWD_SALT+pwd);
		System.out.println(pwd);
		//构造登录参数
		UsernamePasswordToken token = new UsernamePasswordToken(lgnName, pwd);

		try {
			//交给Realm类处理
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException uae) {
			map.put("msg", "未知用户");
			return "forward:/";
		} catch (IncorrectCredentialsException ice) {
			map.put("msg", "密码错误");
			return "forward:/";
		} catch (AuthenticationException ae) {
			// unexpected condition? error?
			map.put("msg", "服务器繁忙");
			return "forward:/";
		}

		return "redirect:/toIndex";
	}

	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("props", System.getProperties());
		return "index";
	}

}
