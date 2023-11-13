package com.example.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZhangGuoxiang
 * @date {2023/11/10} {11:48}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussPost {

    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;

}
