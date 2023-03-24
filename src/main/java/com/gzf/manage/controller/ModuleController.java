//package com.gzf.manage.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.gzf.manage.annotation.Log;
//import com.gzf.manage.common.AjaxResult;
//import com.gzf.manage.entry.Module;
//import com.gzf.manage.entry.vo.ModuleVo;
//import com.gzf.manage.enums.BusinessType;
//import com.gzf.manage.exception.BaseException;
//import com.gzf.manage.service.IModuleService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
///**
// * @program: manage
// * @description: 模块控制层
// * @author: Gaozf
// * @create: 2021-05-29 16:44
// **/
//@RestController
//@RequestMapping("/module")
//@Api(tags = "模块功能")
//public class ModuleController {
//
//    @Resource
//    IModuleService moduleService;
//
//    @PostMapping("/queryModuleList")
//    @Log(title = "查询模块功能", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询模块")
//    public AjaxResult queryModuleList(@RequestBody Module module) {
//        return moduleService.queryModuleList(module);
//    }
//
//    @PostMapping("/insertAndUpdateModule")
//    @Log(title = "新增或编辑模块功能", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "新增或编辑模块")
//    public AjaxResult insertAndUpdateModule(@RequestBody Module module) {
//        return moduleService.insertAndUpdateModule(module);
//    }
//
//    @PostMapping("/checkModuleName")
//    @Log(title = "检验模块名称是否已存在", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "检验模块名称是否已存在")
//    public AjaxResult checkModuleName(@ApiParam(name = "moduleName", value = "模块名称")
//                                          @RequestBody ModuleVo moduleVo) {
//        return moduleService.checkModuleName(moduleVo.getModuleName());
//    }
//
//    @PostMapping("/checkModuleKey")
//    @Log(title = "检验模块Key是否已存在", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "检验模块Key是否已存在")
//    public AjaxResult checkModuleKey(@ApiParam(name = "moduleKey", value = "模块key")
//                                         @RequestBody ModuleVo moduleVo) {
//        return moduleService.checkModuleKey(moduleVo.getModuleKey());
//    }
//
//
//    @GetMapping("/queryModule")
//    @Log(title = "查询模块下拉框", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询模块下拉框")
//    public AjaxResult queryModule() {
//        return moduleService.queryModule();
//    }
//
//    @PostMapping("/deleteModuleList")
//    @Log(title = "批量删除模块", businessType = BusinessType.DELETE)
//    @ApiOperation(value = "批量删除模块")
//    public AjaxResult deleteModuleList(@ApiParam(name = "moduleIds", value = "模块id列表")
//                                           @RequestBody ModuleVo moduleVo) {
//        return Optional.ofNullable(moduleVo).map(x ->
//                moduleService.deleteModuleList(x.getModuleIds()))
//                .orElseThrow(() -> new BaseException("未选择模块"));
//    }
//
//    @GetMapping("/queryModuleById")
//    @Log(title = "查询单条模块", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询单条模块")
//    public AjaxResult queryModuleById(@ApiParam(name = "moduleId", value = "模块id")String moduleId) {
//        return moduleService.queryModuleById(moduleId);
//    }
//    @PostMapping("/deleteModule")
//    @Log(title = "删除模块", businessType = BusinessType.DELETE)
//    @ApiOperation(value = "删除模块")
//    public AjaxResult deleteModule(@ApiParam(name = "moduleId", value = "模块id")String moduleId) {
//        System.out.println(moduleId);
//        return moduleService.deleteModule(moduleId);
//    }
//
//}
