package com.example.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZhangGuoxiang
 * @date {2023/11/10} {10:55}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
