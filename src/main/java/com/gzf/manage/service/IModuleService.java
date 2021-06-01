package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.Module;

public interface IModuleService {
    /**
     * 查询模块
     * @param module
     * @return
     */
    AjaxResult queryModuleList(Module module);

    /**
     * 根据id查询模块
     * @param moduleId
     * @return
     */
    AjaxResult queryModuleById(Long moduleId);

    /**
     * 新增或修改模块
     * @param module
     * @return
     */
    AjaxResult insertAndUpdateModule(Module module);

    /**
     * 根据id删除模块
     * @param moduleId
     * @return
     */
    AjaxResult deleteModule(Long moduleId);
    /**
     * 查询模块下拉框
     * @return
     */
    AjaxResult queryModule();

    /**
     * 校验模块名称是否存在
     * @param moduleName
     * @return
     */
    AjaxResult checkModuleName(String moduleName);
    /**
     * 校验模块key是否存在
     * @param moduleKey
     * @return
     */
    AjaxResult checkModuleKey(String moduleKey);
}
