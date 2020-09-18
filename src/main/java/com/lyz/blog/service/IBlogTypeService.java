package com.lyz.blog.service;

import com.lyz.blog.common.bean.entity.BlogType;

import java.util.List;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/9/4 17:58
 */
public interface IBlogTypeService {

    /**
     * 查询博客的所有类型
     * @return
     */
    List<BlogType> selectByAll();
}
