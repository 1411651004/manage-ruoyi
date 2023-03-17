package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.Module;

import java.util.List;

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
    AjaxResult queryModuleById(String moduleId);

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
    AjaxResult deleteModule(String moduleId);

    /**
     * 批量删除模块
     * @param moduleIds
     * @return
     */
    AjaxResult deleteModuleList(List<String> moduleIds);
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
