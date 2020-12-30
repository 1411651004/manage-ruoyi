package com.gzf.manage.controller;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.config.GzfConfig;
import com.gzf.manage.config.ServerConfig;
import com.gzf.manage.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: manage
 * @description: 文件上传下载
 * @author: Gaozf
 * @create: 2020-12-28 20:36
 **/
@RestController
public class FileController {
    @Value("${gzf.profile}")
    private String uploadPath;

    @Autowired
    private ServerConfig serverConfig;
    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file,String fileRealName) {
        try {
            // 上传文件路径
            String filePath = GzfConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileResultName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileResultName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileResultName", fileResultName);
            ajax.put("fileRealName", fileRealName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
