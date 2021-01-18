package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.common.Constants;
import com.gzf.manage.dao.FileUploadMapper;
import com.gzf.manage.entry.FileUpload;
import com.gzf.manage.exception.BaseException;
import com.gzf.manage.service.IFileUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProgramName: manage
 * @ClassName: FileUploadServiceImpl
 * @description: 文件上传的服务层实现类
 * @author: Gaozf
 * @Date: 2021/1/7 15:45
 **/
@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Resource
    FileUploadMapper fileUploadMapper;


    @Override
    public AjaxResult queryFileList(FileUpload file) {
        PageHelper.startPage(file.getPageIndex(), file.getPageSize());
        List<FileUpload> files = fileUploadMapper.selectFiles(file);
        PageInfo<FileUpload> pageInfo = new PageInfo<>(files);
        return AjaxResult.success(pageInfo);
    }

    @Override
    public AjaxResult insertFileList(FileUpload file) {
        int row = fileUploadMapper.insertSelective(file);
        if (row > 0) {
            return AjaxResult.success(Constants.UPLOAD_SUCCESS);
        }
        throw new BaseException(Constants.UPLOAD_ERROR);
    }
}
