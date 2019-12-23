package com.jkoss.framejui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.framejui.system.entity.Permission;
import com.jkoss.framejui.system.mapper.PermissionMapper;
import com.jkoss.framejui.system.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2019-11-14
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Override
    public boolean removeChildsById(String id) {
        List<Permission> organizations = new ArrayList();
        organizations.add(this.getById(id));
        organizations = this.getAllChilds(organizations, id);
        if (!CommonUtil.isBlank(organizations)) {
            int result = 0;
            for (Permission organization : organizations) {
                result += baseMapper.deleteById(organization.getId());
            }
            return SqlHelper.retBool(result);
        }
        return true;
    }
    @Override
    // 递归获取所有子级节点
    public List getAllChilds(List<Permission> list, String id) {
        QueryWrapper<Permission> wrapper = new QueryWrapper();
        wrapper.eq("pid", id);
        List<Permission> childs = this.list(wrapper);
        if (!CommonUtil.isBlank(childs)) {
            list.addAll(childs);
            for (Permission organization : childs) {
                getAllChilds(list, organization.getId());
            }
        }
        return list;
    }

    @Override
    public List<Permission> listByUid(String uid) {
        return baseMapper.selectByUid(uid);
    }
}
