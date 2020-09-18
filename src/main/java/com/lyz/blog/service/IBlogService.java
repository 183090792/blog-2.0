package com.lyz.blog.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyz.blog.common.bean.entity.Blog;
import com.lyz.blog.common.bean.entity.BlogType;
import com.lyz.blog.common.bean.request.BlogRequest;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    /**
     * 新增博客
     * @param blog
     * @return
     */
    boolean insert(Blog blog);

    /**
     * 修改博客
     * @param blog
     * @return
     */
    boolean updateById(Blog blog);


    /**
     * 查询所有博客
     * @return
     * @param blogRequest
     */
    IPage<Blog> selectAll(BlogRequest blogRequest);

    /**
     * 根据ID查询博客
     * @return
     */
    Blog selectById(Long blogId);

    /**
     * 根据部分标题内容模糊查询博客
     * @return
     */
    IPage<Blog> selectByLike(BlogRequest blogRequest);
}
