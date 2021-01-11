package com.gzf.manage.controller;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysBtnCol;
import com.gzf.manage.service.SysBtnColService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统按钮颜色控制层
 */
@RestController
public class SysBtnColController {

    @Resource
    private SysBtnColService sysBtnColService;

    @GetMapping("/querySysBtnCol")
    @ApiOperation(value = "查询系统按钮颜色")
    @ApiImplicitParam(name = "sysBtnCol", value = "系统按钮颜色实体", dataType = "SysBtnCol")
    public AjaxResult querySysBtnCol(SysBtnCol sysBtnCol) {
        return sysBtnColService.querySysBtnCol(sysBtnCol);
    }

    @PostMapping("/insertAndUpdateSysBtnCol")
    @ApiOperation(value = "插入和编辑系统按钮颜色")
    public AjaxResult insertAndUpdateSysBtnCol(@RequestBody SysBtnCol sysBtnCol) {
        return sysBtnColService.insertAndUpdateSysBtnCol(sysBtnCol);
    }

    @PostMapping("/deleteSysBtnColById")
    @ApiOperation(value = "根据id删除系统按钮颜色")
    public AjaxResult deleteSysBtnColById(Integer id) {
        return sysBtnColService.deleteById(id);
    }

    @GetMapping("/querySysName")
    @ApiOperation(value = "查询系统名称下拉框")
    public AjaxResult querySysName() {
        return sysBtnColService.querySysName();
    }

    @GetMapping("/queryBtnName")
    @ApiOperation(value = "查询按钮名称下拉框")
    public AjaxResult queryBtnName() {
        return sysBtnColService.queryBtnName();
    }
}
