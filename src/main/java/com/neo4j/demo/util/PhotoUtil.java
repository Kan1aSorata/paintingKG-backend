package com.neo4j.demo.util;

import java.io.File;

public class PhotoUtil {
    public static File[] listImg(String path) {
        File[] output = new File[101];
        File file1 = new File(path);
        if (file1.exists()) {
            File[] files = file1.listFiles();
            int i = 0;
            assert files != null;
            for (File file2 : files) {
                if (file2.getName().contains("jpg")) {
                    output[i++] = file2;
                }
            }
        }
        return output;
    }
}
