package com.gzf.manage.service.impl;

import com.gzf.manage.entry.SysRole;
import com.gzf.manage.mapper.SysRoleMapper;
import com.gzf.manage.service.ISysRoleService;
import com.gzf.manage.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProgramName: manage
 * @ClassName: SysRoleServiceImpl
 * @description: 角色业务层
 * @author: Gaozf
 * @Date: 2022/4/2 15:42
 **/
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}
