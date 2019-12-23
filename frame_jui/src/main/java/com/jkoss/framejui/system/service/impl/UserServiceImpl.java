package com.jkoss.framejui.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jkoss.framejui.system.entity.User;
import com.jkoss.framejui.system.mapper.UserMapper;
import com.jkoss.framejui.system.service.IUserService;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author chair
 * @since 2019-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage pageVo(IPage toPage, Wrapper queryWrapper) {
        return baseMapper.selectVoByPage(toPage,queryWrapper);
    }
}
