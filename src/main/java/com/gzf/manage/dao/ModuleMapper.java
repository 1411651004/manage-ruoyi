package com.gzf.manage.dao;

import com.gzf.manage.entry.Module;

import java.util.HashMap;
import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(String moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> queryModuleList(Module module);

    List<HashMap<String, String>> queryModule();

    int checkModuleName(String moduleName);

    int checkModuleKey(String moduleKey);

    /**
     * 批量删除模块
     * @param moduleIds
     * @return
     */
    int deleteModuleList(List<String> moduleIds);
}