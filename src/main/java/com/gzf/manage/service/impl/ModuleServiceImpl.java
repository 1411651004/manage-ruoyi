package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.common.Constants;
import com.gzf.manage.dao.ModuleMapper;
import com.gzf.manage.entry.Module;
import com.gzf.manage.exception.BaseException;
import com.gzf.manage.service.ICateService;
import com.gzf.manage.service.IModuleService;
import com.gzf.manage.utils.DateUtils;
import com.gzf.manage.utils.snowflake.SnowflakeIdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @program: manage
 * @description: 模块服务层
 * @author: Gaozf
 * @create: 2021-05-29 16:49
 **/
@Service
public class ModuleServiceImpl implements IModuleService {

    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @Resource
    ModuleMapper moduleMapper;
    @Resource
    ICateService cateService;

    @Override
    public AjaxResult queryModuleList(Module module) {
        PageHelper.startPage(module.getPageIndex(), module.getPageSize());
        List<Module> modules = moduleMapper.queryModuleList(module);
        PageInfo pageInfo = new PageInfo(modules);
        return AjaxResult.success(pageInfo);
    }

    @Override
    public AjaxResult queryModuleById(Long moduleId) {
        return AjaxResult.success(moduleMapper.selectByPrimaryKey(moduleId));
    }

    @Override
    public AjaxResult insertAndUpdateModule(Module module) {
        if (null == module.getModuleId() || "".equals(module.getModuleId())) {
            //新增
            //校验模块名称不能重复
            checkModuleName(module.getModuleName());
            //校验模块key不能重复
            checkModuleKey(module.getModuleKey());
            module.setModuleId(idWorker.nextId());
            String time = DateUtils.getTime();
            module.setCreateTime(time);
            moduleMapper.insertSelective(module);
            return AjaxResult.success(Constants.INSERT_SUCCESS);
        } else {
            //编辑
            //校验模块名称不能重复
            checkModuleName(module.getModuleName());
            //校验模块key不能重复
            checkModuleKey(module.getModuleKey());
            String time = DateUtils.getTime();
            module.setUpdateTime(time);
            moduleMapper.updateByPrimaryKeySelective(module);
            return AjaxResult.success(Constants.UPDATE_SUCCESS);
        }

    }

    public AjaxResult checkModuleName(String moduleName) {
        int num = Optional.ofNullable(moduleName).map(x -> moduleMapper.checkModuleName(x))
                .orElseThrow(() -> new BaseException(Constants.MODULE_NAME_NOTNULL));
        if (num > 0) {
            throw new BaseException(Constants.MODULE_NAME_EXIST);
        }
        return AjaxResult.success();
    }

    @Override
    public AjaxResult checkModuleKey(String moduleKey) {
        int num = Optional.ofNullable(moduleKey).map(x -> moduleMapper.checkModuleKey(x))
                .orElseThrow(() -> new BaseException(Constants.MODULE_KEY_NOTNULL));
        if (num > 0) {
            throw new BaseException(Constants.MODULE_KEY_EXIST);
        }
        return AjaxResult.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AjaxResult deleteModule(Long moduleId) {
        //1、删除模块下的栏目
        cateService.deleteCateByModuleId(moduleId);
        //2、删除模块
        moduleMapper.deleteByPrimaryKey(moduleId);
        return AjaxResult.success(Constants.DELETE_SUCCESS);
    }

    @Override
    public AjaxResult queryModule() {
        return AjaxResult.success(moduleMapper.queryModule());
    }
}
