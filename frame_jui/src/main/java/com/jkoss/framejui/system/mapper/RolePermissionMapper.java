package com.jkoss.framejui.system.mapper;

import com.jkoss.framejui.system.entity.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色权限中间表 Mapper 接口
 * </p>
 *
 * @author chair
 * @since 2019-11-15
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    List<String> listPidByRid(@Param("rid") String rid);
}
