//package com.gzf.manage.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.gzf.manage.annotation.Log;
//import com.gzf.manage.common.AjaxResult;
//import com.gzf.manage.entry.Cate;
//import com.gzf.manage.entry.Module;
//import com.gzf.manage.entry.vo.CateVo;
//import com.gzf.manage.enums.BusinessType;
//import com.gzf.manage.exception.BaseException;
//import com.gzf.manage.service.ICateService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Optional;
//
///**
// * @program: manage
// * @description: 栏目模块
// * @author: Gaozf
// * @create: 2021-06-01 09:35
// **/
//@RestController
//@RequestMapping("/cate")
//@Api(tags = "栏目功能")
//public class CateController {
//
//    @Resource
//    ICateService cateService;
//
//    @PostMapping("/queryCateList")
//    @Log(title = "查询栏目功能", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询栏目")
//    public AjaxResult queryCateList(@RequestBody Cate cate) {
//        return cateService.queryCateList(cate);
//    }
//
//    @PostMapping("/insertAndUpdateCate")
//    @Log(title = "新增或编辑栏目功能", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "新增或编辑栏目")
//    public AjaxResult insertAndUpdateCate(@RequestBody Cate cate) {
//        return cateService.insertAndUpdateCate(cate);
//    }
//
//    @PostMapping("/checkCateName")
//    @Log(title = "检验栏目名称是否已存在", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "检验栏目名称是否已存在")
//    public AjaxResult checkCateName(@ApiParam(name = "cateName", value = "栏目名称")
//                                    @RequestBody CateVo cateVo) {
//        return cateService.checkCateName(cateVo.getCateName());
//    }
//
//    @PostMapping("/checkCateKey")
//    @Log(title = "检验栏目Key是否已存在", businessType = BusinessType.UPDATE)
//    @ApiOperation(value = "检验栏目Key是否已存在")
//    public AjaxResult checkCateKey(@ApiParam(name = "cateKey", value = "栏目key")
//                                   @RequestBody CateVo cateVo) {
//        return cateService.checkCateKey(cateVo.getCateKey());
//    }
//
//    @GetMapping("/queryCate")
//    @Log(title = "查询所有栏目下拉框", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询所有栏目下拉框")
//    public AjaxResult queryCate() {
//        return cateService.queryCate();
//    }
//
//    @PostMapping("/queryCateByModuleId")
//    @Log(title = "根据模块id查询所属栏目下拉框", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "根据模块id查询所属栏目下拉框")
//    public AjaxResult queryCateByModuleId(@ApiParam(name = "moduleId", value = "模块id")
//                                          @RequestBody CateVo cateVo) {
//        return cateService.queryCateByModuleId(cateVo.getModuleId());
//    }
//
//    @PostMapping("/deleteCate")
//    @Log(title = "删除栏目", businessType = BusinessType.DELETE)
//    @ApiOperation(value = "删除栏目")
//    public AjaxResult deleteCate(@ApiParam(name = "cateId", value = "栏目id")
//                                 @RequestBody CateVo cateVo) {
//        return cateService.deleteCate(cateVo.getCateId());
//
//    }
//
//    @GetMapping("/queryCateById")
//    @Log(title = "查询单条栏目", businessType = BusinessType.OTHER)
//    @ApiOperation(value = "查询单条栏目")
//    public AjaxResult queryCateById(String moduleId) {
//        return cateService.queryCateById(moduleId);
//    }
//}
