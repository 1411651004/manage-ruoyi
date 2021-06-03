package com.gzf.manage.dao;

import com.gzf.manage.entry.Cate;

import java.util.List;

public interface CateMapper {
    int deleteByPrimaryKey(String cateId);

    int insert(Cate record);

    int insertSelective(Cate record);

    Cate selectByPrimaryKey(String cateId);

    int updateByPrimaryKeySelective(Cate record);

    int updateByPrimaryKey(Cate record);

    List<Cate> queryCateList(Cate cate);

    /**
     * 查询所有栏目下拉框列表
     * @return
     */
    List<Cate> queryCate();
    /**
     * 根据模块id查询所属栏目下拉框列表
     * @return
     */
    List<Cate> queryCateByModuleId(String moduleId);

    int deleteCateByModuleId(String moduleId);

    int checkCateName(String cateName);

    int checkCateKey(String cateKey);

}