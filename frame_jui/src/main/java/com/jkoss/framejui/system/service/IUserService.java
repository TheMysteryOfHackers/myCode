package com.jkoss.framejui.system.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jkoss.framejui.system.entity.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author chair
 * @since 2019-11-11
 */
public interface IUserService extends IService<User> {

    IPage pageVo(IPage toPage,Wrapper queryWrapper);
}
