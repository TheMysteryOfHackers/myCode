package com.jkoss.framejui.system.service;

import com.jkoss.framejui.system.entity.Organization;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * ??֯???? 服务类
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
public interface IOrganizationService extends IService<Organization> {
    //移除子节点
    boolean removeChildsById(String id);
    //获取所有的子节点
    List getAllChilds(List<Organization> list, String id);
}
