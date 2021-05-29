package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.dao.SysLogininforMapper;
import com.gzf.manage.entry.SysLogininfor;
import com.gzf.manage.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProgramName: manage
 * @ClassName: SysLogininforServiceImpl
 * @description: 系统访问记录service
 * @author: Gaozf
 * @Date: 2021/1/19 15:15
 **/
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {

    @Autowired
    SysLogininforMapper logininforMapper;

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        logininforMapper.insert(logininfor);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public AjaxResult selectLogininforList(SysLogininfor logininfor) {
        PageHelper.startPage(logininfor.getPageIndex(), logininfor.getPageSize());
        List<SysLogininfor> logininfors = logininforMapper.selectLogininforList(logininfor);
        PageInfo pageInfo = new PageInfo(logininfors);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return
     */
    @Override
    public int deleteLogininforByIds(Long[] infoIds) {
        return logininforMapper.deleteLogininforByIds(infoIds);
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLogininfor() {
        logininforMapper.cleanLogininfor();
    }

}
