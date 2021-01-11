package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.FileUpload;

/**
 * @ProgramName: manage
 * @ClassName: FileUploadService
 * @description: 文件上传的接口
 * @author: Gaozf
 * @Date: 2021/1/7 15:44
 **/
public interface FileUploadService {

    AjaxResult queryFileList(FileUpload file);

    AjaxResult insertFileList(FileUpload file);
}
