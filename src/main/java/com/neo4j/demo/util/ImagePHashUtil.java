package com.neo4j.demo.util;

import com.neo4j.demo.service.ImagePHash;

import java.io.File;
import java.util.*;

import static com.neo4j.demo.util.PhotoUtil.listImg;

public class ImagePHashUtil {

    Map<String, String> paintList = new LinkedHashMap<>();

    public String ImagePHashCompare(File canPic) throws Exception {
        paintList.put("蒙娜丽莎", "/Users/fengyuhe/Desktop/大创/img/srcPic/蒙娜丽莎");
        paintList.put("最后的晚餐", "/Users/fengyuhe/Desktop/大创/img/srcPic/最后的晚餐");

        Set<String> keySet = paintList.keySet();
        String minKey = "";
        Double minSetA = 9999999.0;
        for (String datasetKey : keySet) {
            String datasetPath = paintList.get(datasetKey);
            File[] files = listImg(datasetPath);
            double minX = 9999999;
            for (File pic : files) {
                ImagePHash imagePHash = new ImagePHash();
                minX = imagePHash.distance(canPic, pic) > minX ? minX : imagePHash.distance(canPic, pic);
            }
            System.out.println(minSetA + "+" + minX);
            if (minSetA > minX) {
                minSetA = minX;
                minKey = datasetKey;
            }
        }
        System.out.println(minKey);
        return paintList.get(minKey);
    }
}
