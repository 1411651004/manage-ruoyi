package com.gzf.manage.mapper;

import com.gzf.manage.entry.FileUpload;

import java.util.List;

public interface FileUploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);

    List<FileUpload> selectFiles(FileUpload record);

}