package com.gzf.manage.dao;

import com.gzf.manage.entry.SysLogininfor;

import java.util.List;

public interface SysLogininforMapper {
    int deleteByPrimaryKey(Long infoId);

    int insert(SysLogininfor record);

    int insertSelective(SysLogininfor record);

    SysLogininfor selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(SysLogininfor record);

    int updateByPrimaryKey(SysLogininfor record);

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    void cleanLogininfor();
}