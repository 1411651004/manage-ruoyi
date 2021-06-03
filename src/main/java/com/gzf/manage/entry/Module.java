package com.gzf.manage.entry;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gzf.manage.utils.JsonLongSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Module extends BaseEntry{
    /*模块id*/
    //@JsonSerialize(using = JsonLongSerializer.class )
    private String moduleId;
    /*模块key*/
    private String moduleKey;
    /*模块名称*/
    private String moduleName;
    /*模块创建人*/
    private String moduleCreater;
    /*创建时间*/
    private String createTime;
    /*更新时间*/
    private String updateTime;
    /*更新人*/
    private String moduleUpdater;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey == null ? null : moduleKey.trim();
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getModuleCreater() {
        return moduleCreater;
    }

    public void setModuleCreater(String moduleCreater) {
        this.moduleCreater = moduleCreater == null ? null : moduleCreater.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getModuleUpdater() {
        return moduleUpdater;
    }

    public void setModuleUpdater(String moduleUpdater) {
        this.moduleUpdater = moduleUpdater == null ? null : moduleUpdater.trim();
    }
}