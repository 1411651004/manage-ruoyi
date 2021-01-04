package com.gzf.manage.controller;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysBtnCol;
import com.gzf.manage.service.SysBtnColService;
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
    public AjaxResult querySysBtnCol(SysBtnCol sysBtnCol) {
        return sysBtnColService.querySysBtnCol(sysBtnCol);
    }

    @PostMapping("/insertAndUpdateSysBtnCol")
    public AjaxResult insertAndUpdateSysBtnCol(@RequestBody SysBtnCol sysBtnCol) {
        return sysBtnColService.insertAndUpdateSysBtnCol(sysBtnCol);
    }

    @PostMapping("/deleteSysBtnColById")
    public AjaxResult deleteSysBtnColById(Integer id) {
        return sysBtnColService.deleteById(id);
    }

}
