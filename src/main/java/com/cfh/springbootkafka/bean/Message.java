package com.cfh.springbootkafka.bean;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Message
 * @Description:
 * @Author: bughua
 * @CreateDate: 2019/9/26 13:48
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
