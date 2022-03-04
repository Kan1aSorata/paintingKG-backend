package com.neo4j.demo.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UpLoadUtil {

    /**
     * 上传文件
     *
     * @param multipartFile
     * @return 文件存储路径
     */
    public static String upload(MultipartFile multipartFile) throws Exception {

        // 文件存储位置，文件的目录要存在才行，可以先创建文件目录，然后进行存储
        String filePath = "/Users/fengyuhe/Desktop/大创/img/canPic/" + multipartFile.getOriginalFilename();
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 文件存储
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImagePHashUtil imagePHashUtil = new ImagePHashUtil();
        System.out.println(imagePHashUtil.ImagePHashCompare(file) + "!");
        return file.getAbsolutePath();
    }
}

