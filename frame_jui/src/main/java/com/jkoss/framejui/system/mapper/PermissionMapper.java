package com.jkoss.framejui.system.mapper;

import com.jkoss.framejui.system.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2019-11-14
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectByUid(@Param("uid") String uid);
}
