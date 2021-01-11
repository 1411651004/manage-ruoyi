package com.gzf.manage.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FileUpload extends BaseEntry{
    private Integer id;

    private String fileName;

    private String fileUrl;

    private String filePath;

    public FileUpload() {
    }

    public FileUpload(String fileName, String fileUrl, String filePath) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.filePath = filePath;
    }
}