package com.lyz.blog.common.bean.response;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @author intellif
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("blog")
public class BlogResponse {

  private Integer blogId;
  private String title;
  private Integer userId;
  private Timestamp createTime;
  private Timestamp updateTime;
  private String content;
  private String label;
  private String classify;
  private Integer status;
  private Integer typeId;

}
