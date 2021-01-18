package com.gzf.manage.controller;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.common.Constants;
import com.gzf.manage.config.GzfConfig;
import com.gzf.manage.config.ServerConfig;
import com.gzf.manage.entry.FileUpload;
import com.gzf.manage.service.IFileUploadService;
import com.gzf.manage.utils.FileUploadUtils;
import com.gzf.manage.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: manage
 * @description: 文件上传下载
 * @author: Gaozf
 * @create: 2020-12-28 20:36
 **/
@Slf4j
@RestController
public class FileController {
    @Value("${gzf.profile}")
    private String uploadPath;

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private IFileUploadService fileUploadService;
    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ApiOperation(value = "文件上传")
    public AjaxResult uploadFile(@RequestParam("file") MultipartFile file,
                                 @RequestParam("fileRealName") String fileRealName) {
        try {
            // 上传文件路径
            String filePath = GzfConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileResultName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileResultName;
            //文件路径+实际文件名
            int start = Constants.RESOURCE_PREFIX.length() + 1;
            String suffix = StringUtils.substring(fileResultName, start);
            String filePathName = GzfConfig.getProfile() + suffix;
            //将fileName、fileUrl、filePath存入数据库
            FileUpload fileUpload = new FileUpload(fileRealName, url, filePathName);
            AjaxResult ajax = fileUploadService.insertFileList(fileUpload);
            //ajax.put("fileResultName", fileResultName);
            ajax.put("fileRealName", fileRealName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            log.info("异常原因：{}", e);
            return AjaxResult.error(e.getMessage());
        }
    }
    @PostMapping("/queryFiles")
    @ApiOperation(value = "分页文件查询")
    public AjaxResult queryFiles(FileUpload fileUpload) {
        return fileUploadService.queryFileList(fileUpload);
    }

}
