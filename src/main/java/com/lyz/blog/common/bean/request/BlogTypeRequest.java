package com.lyz.blog.common.bean.request;


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
@TableName("blog_type")
public class BlogTypeRequest {

  private Integer typeId;
  private String typeName;
  private Timestamp createTime;
  private Timestamp updateTime;

  private Long currentPage=1L;
  private Long pageSize=10L;
}
