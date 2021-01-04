package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.SysBtnCol;

public interface SysBtnColService {

    /**
     * 查询系统按钮颜色列表
     *
     * @return
     */
    AjaxResult querySysBtnCol(SysBtnCol sysBtnCol);

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
}
