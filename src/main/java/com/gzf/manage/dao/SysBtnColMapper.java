package com.gzf.manage.dao;

import com.gzf.manage.entry.SysBtnCol;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysBtnColMapper {
    int insert(SysBtnCol record);

    int insertSelective(SysBtnCol record);

    int updateSelective(SysBtnCol record);

    List<SysBtnCol> queryList(SysBtnCol sysBtnCol);

    SysBtnCol queryById(Integer id);

    /**
     * 查询系统名称下拉框
     * @return
     */
    List<String> querySysName();

    /**
     * 查询按钮名称下拉框
     * @return
     */
    List<String> queryBtnName();

    int deleteById(int id);

}