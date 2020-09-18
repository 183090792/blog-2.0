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
@TableName("user_info")
public class UserInfo {

  private Integer userId;
  private String userName;
  private String password;
  private String phone;
  private Timestamp createTime;
  private Timestamp updateTime;
  private String modifier;
  private String token;

}
