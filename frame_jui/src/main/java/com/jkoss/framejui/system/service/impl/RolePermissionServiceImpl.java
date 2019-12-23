package com.jkoss.framejui.system.service.impl;

import com.jkoss.common.util.CommonUtil;
import com.jkoss.framejui.system.entity.RolePermission;
import com.jkoss.framejui.system.mapper.RolePermissionMapper;
import com.jkoss.framejui.system.service.IRolePermissionService;

import net.sf.jsqlparser.util.deparser.UpdateDeParser;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限中间表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2019-11-15
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

	@Override
	public boolean updatePidByRid(String rid, String[] pid) {
		//把该角色的权限全部删除，然后在重新写入，，因为你不知道用户详细更改了那个权限，只能全部删除后再重新写入。
		UpdateWrapper<RolePermission> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("rid",rid);
		baseMapper.delete(updateWrapper);

		if (!CommonUtil.isBlank(pid)){
			ArrayList<RolePermission> rolePermissions = new ArrayList<>();
			for (String pidStr : pid) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRid(rid);
				rolePermission.setPid(pidStr);
				rolePermissions.add(rolePermission);
			}
			this.saveBatch(rolePermissions);
		}
		return true;
	}

	@Override
	public List<String> listPidByRid(String id) {
		return baseMapper.listPidByRid(id);
	}

}
