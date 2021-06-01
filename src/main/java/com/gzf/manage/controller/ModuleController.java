package com.gzf.manage.controller;

import com.gzf.manage.annotation.Log;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.Module;
import com.gzf.manage.enums.BusinessType;
import com.gzf.manage.service.IModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: manage
 * @description: 模块控制层
 * @author: Gaozf
 * @create: 2021-05-29 16:44
 **/
@RestController
@RequestMapping("/module")
@Api(tags = "模块功能")
public class ModuleController {

    @Resource
    IModuleService moduleService;

    @PostMapping("/queryModuleList")
    @Log(title = "查询模块功能", businessType = BusinessType.OTHER)
    @ApiOperation(value = "查询模块")
    public AjaxResult queryModuleList(@RequestBody Module module) {
        return moduleService.queryModuleList(module);
    }

    @PostMapping("/insertAndUpdateModule")
    @Log(title = "新增或编辑模块功能", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "新增或编辑模块")
    public AjaxResult insertAndUpdateModule(@RequestBody Module module) {
        return moduleService.insertAndUpdateModule(module);
    }

    @GetMapping("/checkModuleName")
    @Log(title = "检验模块名称是否已存在", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "检验模块名称是否已存在")
    public AjaxResult checkModuleName(String moduleName) {
        return moduleService.checkModuleName(moduleName);
    }

    @GetMapping("/checkModuleKey")
    @Log(title = "检验模块Key是否已存在", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "检验模块Key是否已存在")
    public AjaxResult checkModuleKey(String moduleKey) {
        return moduleService.checkModuleKey(moduleKey);
    }


    @GetMapping("/queryModule")
    @Log(title = "查询模块下拉框", businessType = BusinessType.OTHER)
    @ApiOperation(value = "查询模块下拉框")
    public AjaxResult queryModule() {
        return moduleService.queryModule();
    }

    @PostMapping("/deleteModule")
    @Log(title = "删除模块", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除模块")
    public AjaxResult deleteModule(Long moduleId) {
        //throw new BaseException("ceshi");
        return moduleService.deleteModule(moduleId);
    }

    @PostMapping("/deleteModuleList")
    @Log(title = "批量删除模块", businessType = BusinessType.DELETE)
    @ApiOperation(value = "批量删除模块")
    public AjaxResult deleteModuleList(@RequestBody List<Long> moduleIds) {
        return moduleService.deleteModuleList(moduleIds);
    }

    @GetMapping("/queryModuleById")
    @Log(title = "查询单条模块", businessType = BusinessType.OTHER)
    @ApiOperation(value = "查询单条模块")
    public AjaxResult queryModuleById(Long moduleId) {
        return moduleService.queryModuleById(moduleId);
    }

}
