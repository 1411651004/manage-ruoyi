package com.gzf.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzf.manage.common.AjaxResult;
import com.gzf.manage.common.Constants;
import com.gzf.manage.dao.CateMapper;
import com.gzf.manage.entry.Cate;
import com.gzf.manage.exception.BaseException;
import com.gzf.manage.service.ICateService;
import com.gzf.manage.utils.DateUtils;
import com.gzf.manage.utils.snowflake.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @program: manage
 * @description: 栏目服务层
 * @author: Gaozf
 * @create: 2021-06-01 09:43
 **/
@Service
public class CateServiceImpl implements ICateService {

    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

    @Resource
    CateMapper cateMapper;

    @Override
    public AjaxResult queryCateList(Cate cate) {
        PageHelper.startPage(cate.getPageIndex(), cate.getPageSize());
        List<Cate> cates = cateMapper.queryCateList(cate);
        PageInfo pageInfo = new PageInfo(cates);
        return AjaxResult.success(pageInfo);
    }

    @Override
    public AjaxResult queryCateById(String cateId) {
        return AjaxResult.success(cateMapper.selectByPrimaryKey(cateId));
    }

    @Override
    public AjaxResult insertAndUpdateCate(Cate cate) {
        if (null == cate.getCateId() || "".equals(cate.getCateId())) {
            //新增
            checkCateName(cate.getCateName());
            checkCateKey(cate.getCateKey());
            cate.setCateId(idWorker.nextId());
            cate.setCreateTime(DateUtils.getTime());
            cateMapper.insertSelective(cate);
            return AjaxResult.success(Constants.INSERT_SUCCESS);
        } else {
            //编辑
            checkCateName(cate.getCateName());
            checkCateKey(cate.getCateKey());
            cate.setUpdateTime(DateUtils.getTime());
            cateMapper.updateByPrimaryKeySelective(cate);
            return AjaxResult.success(Constants.UPDATE_SUCCESS);
        }
    }

    @Override
    public AjaxResult deleteCate(String cateId) {
        cateMapper.deleteByPrimaryKey(cateId);
        return AjaxResult.success(Constants.DELETE_SUCCESS);
    }

    @Override
    public AjaxResult queryCate() {
        return AjaxResult.success(cateMapper.queryCate());
    }

    @Override
    public AjaxResult queryCateByModuleId(String moduleId) {
        return AjaxResult.success(Optional.ofNullable(moduleId).map(x -> cateMapper.queryCateByModuleId(x))
                .orElse(cateMapper.queryCate()));
    }

    @Override
    public AjaxResult checkCateName(String cateName) {
        int num = Optional.ofNullable(cateName).map(x -> cateMapper.checkCateName(x))
                .orElseThrow(() -> new BaseException(Constants.CATE_NAME_NOTNULL));
        if (num > 0) {
            throw new BaseException(Constants.CATE_NAME_EXIST);
        }
        return AjaxResult.success();
    }

    @Override
    public AjaxResult checkCateKey(String cateKey) {
        int num = Optional.ofNullable(cateKey).map(x -> cateMapper.checkCateKey(x))
                .orElseThrow(() -> new BaseException(Constants.CATE_KEY_NOTNULL));
        if (num > 0) {
            throw new BaseException(Constants.CATE_KEY_EXIST);
        }
        return AjaxResult.success();
    }

    public AjaxResult deleteCateByModuleId(String moduleId) {
        cateMapper.deleteCateByModuleId(moduleId);
        return AjaxResult.success(Constants.DELETE_SUCCESS);
    }
}
