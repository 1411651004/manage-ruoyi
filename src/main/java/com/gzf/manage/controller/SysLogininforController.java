package com.gzf.manage.controller;

import com.gzf.manage.annotation.Log;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysLogininfor;
import com.gzf.manage.enums.BusinessType;
import com.gzf.manage.service.ISysLogininforService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProgramName: manage
 * @ClassName: SysLogininforController
 * @description: 系统访问记录controller
 * @author: Gaozf
 * @Date: 2021/1/19 15:32
 **/
@RestController
@RequestMapping("/logininfor")
public class SysLogininforController {

    @Autowired
    ISysLogininforService logininforService;

    @GetMapping("/queryLogininforList")
    @ApiOperation(value = "查询系统登录访问记录列表")
    public AjaxResult queryLogininforList(SysLogininfor logininfor) {
        return logininforService.selectLogininforList(logininfor);
    }

    @PostMapping("/removeLogininfo")
    @ApiOperation(value = "批量删除系统登录访问记录")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    public AjaxResult removeLogininfo(Long[] infoIds) {
        return logininforService.deleteLogininforByIds(infoIds) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/cleanLogininfor")
    @ApiOperation(value = "清空系统登录访问记录")
    @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    public AjaxResult cleanLogininfor() {
        logininforService.cleanLogininfor();
        return AjaxResult.success();
    }


}
