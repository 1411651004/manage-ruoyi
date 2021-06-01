package com.gzf.manage.dao;

import com.gzf.manage.entry.Module;

import java.util.HashMap;
import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Long moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Long moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> queryModuleList(Module module);

    List<HashMap<Long, String>> queryModule();

    int checkModuleName(String moduleName);
    
    int checkModuleKey(String moduleKey);
}