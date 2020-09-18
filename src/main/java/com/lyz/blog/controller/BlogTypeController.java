package com.lyz.blog.controller;

import com.lyz.blog.common.bean.entity.BlogType;
import com.lyz.blog.common.constant.GlobalConstant;
import com.lyz.blog.common.utils.wrapper.ResponseMsgBean;
import com.lyz.blog.service.IBlogTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/9/4 17:58
 */
@Slf4j
@RequestMapping("/blogType")
@RestController
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    /**
     * 查询博客的所有类型
     * @return
     */
    @RequestMapping(value = "/selectByAll",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String selectByAll(){
        List<BlogType> blogTypeList = blogTypeService.selectByAll();
        if(blogTypeList!=null && blogTypeList.size()>0){
            return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003,blogTypeList);
        }
        return ResponseMsgBean.getMsgJson(GlobalConstant.RESULT_CODE_8003,GlobalConstant.RESULT_MSG_8003);
    }
}
