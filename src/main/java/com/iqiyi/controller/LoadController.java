package com.iqiyi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/9 16:29
 */
public class LoadController {

    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public String upload(MultipartFile pic){
        //在服务器上创建一个新的文件

        //把Pic文件中数据写到新的文件中
    }
}