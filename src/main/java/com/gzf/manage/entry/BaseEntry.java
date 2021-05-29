package com.gzf.manage.entry;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntry implements Serializable {
    /**
     * 页码
     */
    private int pageIndex = 0;
    /**
     * 条数
     */
    private int pageSize = 10;
}
