package com.gzf.manage.service.impl;

import com.gzf.manage.mapper.SysUserMapper;
import com.gzf.manage.entry.SysUser;
import com.gzf.manage.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProgramName: manage
 * @ClassName: SysUserServiceImpl
 * @description: 系统用户service
 * @author: Gaozf
 * @Date: 2021/1/11 16:56
 **/
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }
}
