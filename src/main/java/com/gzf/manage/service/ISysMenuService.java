package com.gzf.manage.service;

import java.util.Set;

/**
 * 菜单 业务层
 */
public interface ISysMenuService {
    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    Set<String> selectMenuPermsByUserId(Long userId);
}
