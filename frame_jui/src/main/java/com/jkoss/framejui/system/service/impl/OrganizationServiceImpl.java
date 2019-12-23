package com.jkoss.framejui.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.jkoss.common.util.CommonUtil;
import com.jkoss.framejui.system.entity.Organization;
import com.jkoss.framejui.system.mapper.OrganizationMapper;
import com.jkoss.framejui.system.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ??֯???? 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2019-11-13
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {
    @Override
    public boolean removeChildsById(String id) {
        List<Organization> organizations = new ArrayList();
        organizations.add(this.getById(id));
        organizations = this.getAllChilds(organizations, id);
        if (!CommonUtil.isBlank(organizations)) {
            int result = 0;
            for (Organization organization : organizations) {
                result += baseMapper.deleteById(organization.getId());
            }
            return SqlHelper.retBool(result);
        }
        return true;
    }
    @Override
    // 递归获取所有子级节点
    public List getAllChilds(List<Organization> list, String id) {
        QueryWrapper<Organization> wrapper = new QueryWrapper();
        wrapper.eq("pid", id);
        List<Organization> childs = this.list(wrapper);
        if (!CommonUtil.isBlank(childs)) {
            list.addAll(childs);
            for (Organization organization : childs) {
                getAllChilds(list, organization.getId());
            }
        }
        return list;
    }
}
