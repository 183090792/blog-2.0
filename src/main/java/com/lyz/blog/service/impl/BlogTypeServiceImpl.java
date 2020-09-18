package com.lyz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyz.blog.common.bean.entity.BlogType;
import com.lyz.blog.mapper.BlogTypeMapper;
import com.lyz.blog.service.IBlogTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/9/4 18:04
 */
@Slf4j
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements IBlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;
    /**
     * 查询博客的所有类型
     * @return
     */
    @Override
    public List<BlogType> selectByAll() {
        QueryWrapper<BlogType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("create_time");
        return blogTypeMapper.selectList(queryWrapper);
    }
}
