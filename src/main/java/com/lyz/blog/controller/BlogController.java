package com.lyz.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyz.blog.common.bean.entity.Blog;
import com.lyz.blog.common.bean.request.BlogRequest;
import com.lyz.blog.common.constant.GlobalConstant;
import com.lyz.blog.common.utils.JwtTokenUtil;
import com.lyz.blog.common.utils.wrapper.ResponseMsgBean;
import com.lyz.blog.service.IBlogService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtTokenUtil tokenUtil;

    /**
     * 新增博客
     * @param blog
     * @return
     */
    @RequestMapping(value = "/insert",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String insert(@NonNull @RequestBody Blog blog){
        if(StringUtils.isEmpty(blog) || StringUtils.isEmpty(blog.getTitle()) || StringUtils.isEmpty(blog.getContent())){
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7002,GlobalConstant.RESULT_MSG_7002);
        }
        boolean result = blogService.insert(blog);
        if(result){
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8001,GlobalConstant.RESULT_MSG_8001);
        }
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7001,GlobalConstant.RESULT_MSG_7001);
    }

    /**
     * 修改博客
     * @param blog
     * @return
     */
    @RequestMapping(value = "/updateById",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String updateById(@RequestBody Blog blog){
        boolean result = blogService.updateById(blog);
        if(result){
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8002, GlobalConstant.RESULT_MSG_8002);
        }
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_7003,GlobalConstant.RESULT_MSG_7003);
    }
    /**
     * 查询所有博客
     * @return
     */
    @RequestMapping(value = "/selectByPage",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String selectByPage( BlogRequest blogRequest){
        IPage<Blog> pageInfo =  blogService.selectByPage(blogRequest);
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003,pageInfo);
    }

    /**
     * 根据ID查询博客
     * @return
     */
    @RequestMapping(value = "/selectById",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String selectById(@RequestParam("blogId") Long blogId){
        Blog blog =  blogService.selectById(blogId);
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003,blog);
    }




}
