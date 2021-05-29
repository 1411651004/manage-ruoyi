package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysLogininfor;

import java.util.List;

/**
 * @ProgramName: manage
 * @ClassName: ISysLogininforService
 * @description:
 * @author: Gaozf
 * @Date: 2021/1/19 15:14
 **/
public interface ISysLogininforService {
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    AjaxResult selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return
     */
    int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    void cleanLogininfor();
}
