package com.lyz.blog.common.bean.entity;


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
public class BlogType {

  private Integer typeId;
  private String typeName;
  private Timestamp createTime;
  private Timestamp updateTime;

}
