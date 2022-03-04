package com.neo4j.demo.controller;

import com.neo4j.demo.util.UpLoadUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(value = "服务器接受图片", tags = "保存到指定位置进行dHash比对")
@CrossOrigin
public class UpLoadController {

    @PostMapping(value = "/upload")
    // @RequestParam中的file名应与前端的值保持一致
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        // replaceAll 用来替换windows中的\\ 为 /
        System.out.println("访问");
        return UpLoadUtil.upload(multipartFile).replaceAll("\\\\", "/");
    }

}