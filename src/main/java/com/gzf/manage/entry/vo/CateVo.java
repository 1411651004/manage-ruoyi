package com.gzf.manage.entry.vo;

import lombok.Data;

/**
 * @program: manage
 * @description: 栏目接收参数
 * @author: Gaozf
 * @create: 2021-06-01 18:05
 **/
@Data
public class CateVo {
    private String cateId;
    /*模块id*/
    private String moduleId;
    /*栏目key*/
    private String cateKey;
    /*栏目名称*/
    private String cateName;
}
