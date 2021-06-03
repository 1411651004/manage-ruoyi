package com.gzf.manage.controller;

import com.gzf.manage.annotation.Log;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysOperLog;
import com.gzf.manage.enums.BusinessType;
import com.gzf.manage.service.ISysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProgramName: manage
 * @ClassName: OperLogController
 * @description: 系统操作日志控制层
 * @author: Gaozf
 * @Date: 2021/1/18 14:49
 **/
@RestController
@RequestMapping("/operlog")
@Api(tags = "查询操作日志")
public class SysOperLogController {

    @Autowired
    ISysOperLogService sysOperLogService;

    @GetMapping("/queryOperLogList")
    @ApiOperation(value = "查询系统操作日志列表")
    public AjaxResult queryOperLogList(SysOperLog operLog) {
        return sysOperLogService.selectOperLogList(operLog);
    }

    @PostMapping("/removeOperLog")
    @ApiOperation(value = "批量删除系统操作日志")
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    public AjaxResult removeOperLog(Long[] operIds) {
        int row = sysOperLogService.deleteOperLogByIds(operIds);
        return row > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/cleanOperLog")
    @ApiOperation(value = "清空系统操作日志")
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    public AjaxResult cleanOperLog() {
        sysOperLogService.cleanOperLog();
        return AjaxResult.success();
    }
}
