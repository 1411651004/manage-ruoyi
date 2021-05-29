package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysBtnCol;

public interface ISysBtnColService {

    /**
     * 查询系统按钮颜色列表
     *
     * @return
     */
    AjaxResult querySysBtnCol(SysBtnCol sysBtnCol);

    /**
     * 根据id查询系统按钮颜色
     * @param id
     * @return
     */
    AjaxResult querySysBtnColById(Integer id);

    /**
     * 插入和修改
     * @param sysBtnCol
     * @return
     */
    AjaxResult insertAndUpdateSysBtnCol(SysBtnCol sysBtnCol);

    /**
     * 删除
     * @param id
     * @return
     */
    AjaxResult deleteById(Integer id);

    /**
     * 查询系统下拉框
     * @return
     */
    AjaxResult querySysName();

    /**
     * 查询按钮名称下拉框
     * @return
     */
    AjaxResult queryBtnName();
}
