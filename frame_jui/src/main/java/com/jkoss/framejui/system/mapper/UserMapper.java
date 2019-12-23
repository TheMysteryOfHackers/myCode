package com.jkoss.framejui.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jkoss.framejui.system.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jkoss.framejui.system.entity.User;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author chair
 * @since 2019-11-11
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserVo> selectVoByPage(IPage toPage,@Param(Constants.WRAPPER) Wrapper queryWrapper);
}
