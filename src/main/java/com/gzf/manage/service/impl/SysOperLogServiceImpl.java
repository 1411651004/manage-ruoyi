package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.dao.SysOperLogMapper;
import com.gzf.manage.entry.SysOperLog;
import com.gzf.manage.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProgramName: manage
 * @ClassName: SysOperLogServiceImpl
 * @description: 操作日志服务层
 * @author: Gaozf
 * @Date: 2021/1/18 14:16
 **/
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {

    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * 新增操作日志
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperlog(SysOperLog operLog) {
        operLogMapper.insertSelective(operLog);
    }
    /**
     * 查询系统操作日志集合
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public AjaxResult selectOperLogList(SysOperLog operLog) {
        PageHelper.startPage(operLog.getPageIndex(), operLog.getPageSize());
        List<SysOperLog> operLogs = operLogMapper.selectOperLogList(operLog);
        PageInfo pageInfo = new PageInfo(operLogs);
        return AjaxResult.success(pageInfo);
    }
    /**
     * 批量删除系统操作日志
     * @param operIds 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    public int deleteOperLogByIds(Long[] operIds) {
        return operLogMapper.deleteOperLogByIds(operIds);
    }
    /**
     * 查询操作日志详细
     * @param operId 操作ID
     * @return 操作日志对象
     */
    @Override
    public SysOperLog selectOperLogById(Long operId) {
        return operLogMapper.selectByPrimaryKey(operId);
    }
    /**
     * 清空操作日志
     */
    @Override
    public void cleanOperLog() {
        operLogMapper.cleanOperLog();
    }
}
