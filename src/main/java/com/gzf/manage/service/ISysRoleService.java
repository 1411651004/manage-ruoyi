package com.gzf.manage.service;

import java.util.Set;

/**
 * 角色业务层
 */
public interface ISysRoleService {
    /**
     * 根据用户ID查询角色权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    Set<String> selectRolePermissionByUserId(Long userId);
}
