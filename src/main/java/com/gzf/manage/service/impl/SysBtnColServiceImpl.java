package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.annotation.Log;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.mapper.SysBtnColMapper;
import com.gzf.manage.entry.SysBtnCol;
import com.gzf.manage.enums.BusinessType;
import com.gzf.manage.exception.BaseException;
import com.gzf.manage.service.ISysBtnColService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysBtnColServiceImpl implements ISysBtnColService {

    @Resource
    private SysBtnColMapper sysBtnColMapper;

    /**
     * 查询列表
     * @param sysBtnCol
     * @return
     */
    @Override
    @Log(title = "系统按钮颜色",businessType = BusinessType.OTHER)
    public AjaxResult querySysBtnCol(SysBtnCol sysBtnCol) {
        PageHelper.startPage(sysBtnCol.getPageIndex(), sysBtnCol.getPageSize());
        List<SysBtnCol> sysBtnCols = sysBtnColMapper.queryList(sysBtnCol);
        PageInfo pageInfo = new PageInfo(sysBtnCols);
        AjaxResult ajaxResult = AjaxResult.success();
        List<String> title = new ArrayList();
        title.add("系统名称");
        title.add("按钮名称");
        title.add("按钮大小");
        title.add("按钮图标");
        title.add("背景颜色");
        title.add("触发事件");
        title.add("说明");
        title.add("链接");
        ajaxResult.put("title", title);
        ajaxResult.put("list",pageInfo);
        return ajaxResult;
    }

    @Override
    @Log(title = "系统按钮颜色",businessType = BusinessType.OTHER)
    public AjaxResult querySysBtnColById(Integer id) {
        SysBtnCol sysBtnCols = sysBtnColMapper.queryById(id);
        System.out.println(sysBtnCols.toString());
        AjaxResult ajaxResult = AjaxResult.success(sysBtnCols);
        List<String> title = new ArrayList();
        title.add("系统名称");
        title.add("按钮名称");
        title.add("按钮大小");
        title.add("按钮图标");
        title.add("背景颜色");
        title.add("触发事件");
        title.add("说明");
        title.add("链接");
        ajaxResult.put("title", title);

        return ajaxResult;
    }

    @Override
    public AjaxResult insertAndUpdateSysBtnCol(SysBtnCol sysBtnCol) {
        if (null == sysBtnCol.getId()) {
            //新增
            sysBtnColMapper.insertSelective(sysBtnCol);
        } else {
            //编辑
            sysBtnColMapper.updateSelective(sysBtnCol);
        }
        return AjaxResult.success();
    }

    @Override
    public AjaxResult deleteById(Integer id) {
        if (null == id) {
            throw new BaseException("id不能为空");
        }
        sysBtnColMapper.deleteById(id);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult querySysName() {
        return AjaxResult.success(sysBtnColMapper.querySysName());
    }

    /**
     * 查询按钮名称下拉框
     * @return
     */
    @Override
    public AjaxResult queryBtnName() {
        return AjaxResult.success(sysBtnColMapper.queryBtnName());
    }


}
