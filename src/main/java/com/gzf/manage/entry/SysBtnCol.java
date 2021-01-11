package com.gzf.manage.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysBtnCol extends BaseEntry{
    private Integer id;

    private String sysName;

    private String btnName;

    private String btnSize;

    private String btnLogo;

    private String backgroundColor;

    private String triggerEvent;

    private String notes;

    private String link;

}