package com.jkoss.framejui.system.service;

import com.jkoss.framejui.system.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限中间表 服务类
 * </p>
 *
 * @author chair
 * @since 2019-11-15
 */
public interface IRolePermissionService extends IService<RolePermission> {

	boolean updatePidByRid(String rid, String[] pid);

    List<String> listPidByRid(String id);
}
