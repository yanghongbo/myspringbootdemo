package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private String phone;
    private Integer sex;
}
