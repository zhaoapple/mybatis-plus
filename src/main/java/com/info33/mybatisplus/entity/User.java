package com.info33.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class User {
    private long id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
//    @JsonFormat(
//            pattern = "yyyy-MM-dd",
//            timezone = "GMT+8"
//    )
    @DateTimeFormat(pattern  = "yyyy-MM-dd")
    private String createTime;
    @TableField(exist = false)
    private String dateStr;
}
