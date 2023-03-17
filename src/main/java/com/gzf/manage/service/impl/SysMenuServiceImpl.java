package com.gzf.manage.service.impl;

import com.gzf.manage.mapper.SysMenuMapper;
import com.gzf.manage.service.ISysMenuService;
import com.gzf.manage.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProgramName: manage
 * @ClassName: SysMenuServiceImpl
 * @description: 菜单-业务层
 * @author: Gaozf
 * @Date: 2022/4/2 15:55
 **/
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        List<String> perms = menuMapper.selectMenuPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
