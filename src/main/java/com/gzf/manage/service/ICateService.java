package com.gzf.manage.service;

import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.entry.Cate;

/**
 * @program: manage
 * @description: 栏目接口层
 * @author: Gaozf
 * @create: 2021-06-01 09:42
 **/
public interface ICateService {
    /**
     * 查询栏目列表
     * @param cate
     * @return
     */
    AjaxResult queryCateList(Cate cate);

    /**
     * 查询栏目单条
     * @param cateId
     * @return
     */
    AjaxResult queryCateById(String cateId);

    /**
     * 新增和更新栏目
     * @param cate
     * @return
     */
    AjaxResult insertAndUpdateCate(Cate cate);

    /**
     * 删除栏目
     * @param cateId
     * @return
     */
    AjaxResult deleteCate(String cateId);

    /**
     * 查询栏目下拉框
     * @return
     */
    AjaxResult queryCate();

    /**
     * 根据模块id查询所属栏目下拉框
     * @param moduleId
     * @return
     */
    AjaxResult queryCateByModuleId(String moduleId);

    /**
     * 校验栏目名称是否存在
     * @param cateName
     * @return
     */
    AjaxResult checkCateName(String cateName);

    /**
     * 校验栏目key是否存在
     * @param cateKey
     * @return
     */
    AjaxResult checkCateKey(String cateKey);

    //根据模块id删除栏目
    AjaxResult deleteCateByModuleId(String moduleId);
}
