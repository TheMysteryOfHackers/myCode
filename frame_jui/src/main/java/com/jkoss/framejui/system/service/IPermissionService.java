package com.jkoss.framejui.system.service;

import com.jkoss.framejui.system.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author zzx
 * @since 2019-11-14
 */
public interface IPermissionService extends IService<Permission> {
    //移除子节点
    boolean removeChildsById(String id);
    //获取所有的子节点
    List getAllChilds(List<Permission> list, String id);

    List<Permission> listByUid(String uid);
}
