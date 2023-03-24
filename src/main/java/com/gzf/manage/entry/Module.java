package com.gzf.manage.entry;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gzf.manage.utils.JsonLongSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Module{
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

}