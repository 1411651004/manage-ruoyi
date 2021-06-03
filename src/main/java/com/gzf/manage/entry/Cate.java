package com.gzf.manage.entry;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gzf.manage.utils.JsonLongSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Cate extends BaseEntry{
    /*栏目id*/
    //@JsonSerialize(using = JsonLongSerializer.class )
    private String cateId;
    /*模块id*/
    private String moduleId;
    /*栏目key*/
    private String cateKey;
    /*栏目名称*/
    private String cateName;
    /*栏目路由*/
    private String cateUrl;
    /*栏目描述*/
    private String cateDesc;
    /*栏目图标*/
    private String cateIcon;
    /*是否含有内容*/
    private Integer isFilled;

    private String updateTime;

    private String cateCreater;

    private String createTime;

    private String cateUpdater;

}