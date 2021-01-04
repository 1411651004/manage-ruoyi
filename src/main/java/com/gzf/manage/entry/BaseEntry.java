package com.gzf.manage.entry;

import lombok.Data;

@Data
public class BaseEntry {
    /**
     * 页码
     */
    private int pageIndex = 0;
    /**
     * 条数
     */
    private int pageSize = 10;
}
