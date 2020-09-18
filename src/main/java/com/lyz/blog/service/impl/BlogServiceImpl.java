package com.lyz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyz.blog.common.bean.entity.Blog;
import com.lyz.blog.common.bean.request.BlogRequest;
import com.lyz.blog.mapper.BlogMapper;
import com.lyz.blog.service.IBlogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;

@Slf4j
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;


    /**
     * 新增博客
     * @param blog
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean insert(Blog blog) {
        try {
            blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
            blog.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            blogMapper.insert(blog);
            return true;
        } catch (Exception e) {
            log.error("新增博客失败,博客主题为===========>{},异常信息为==============>{}",blog.getContent(),e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean updateById(Blog blog) {
        try {
            blog.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            int result = blogMapper.updateById(blog);
            if(result>0){
                return true;
            }
        } catch (Exception e) {
            log.error("修改博客失败,博客ID为===========>{},异常信息为==============>{}",blog.getBlogId(),e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return false;
    }



    /**
     * 查询所有博客
     * @return
     * @param blogRequest
     */
    @Override
    public IPage<Blog> selectByPage(BlogRequest blogRequest) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(blogRequest.getTitle())){
            queryWrapper.like("title",blogRequest.getTitle());
        }
        queryWrapper.orderByDesc("create_time");
        Page<Blog> blogPage = new Page<>(blogRequest.getCurrentPage(), blogRequest.getPageSize());
        Page<Blog> page = blogMapper.selectPage(blogPage, queryWrapper);
        return page;
    }

    /**
     * 根据ID查询博客
     * @return
     */
    @Override
    public Blog selectById(Long blogId) {
        return blogMapper.selectById(blogId);
    }

}
