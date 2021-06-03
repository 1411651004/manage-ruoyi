package com.gzf.manage.entry.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: manage
 * @description: 模块vo
 * @author: Gaozf
 * @create: 2021-06-01 18:17
 **/
@Data
public class ModuleVo {
    private String moduleId;
    /*模块key*/
    private String moduleKey;
    /*模块名称*/
    private String moduleName;

    private List<String> moduleIds;
}
