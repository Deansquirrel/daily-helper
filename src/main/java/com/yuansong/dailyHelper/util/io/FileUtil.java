package com.yuansong.dailyHelper.util.io;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static String lastTimeStr = "";

    public static String getCurrPath(){
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            logger.warn(ExceptionTool.getStackTrace(e));
            path = new File("");
        }
        if(!path.exists()) path = new File("");
        return path.getAbsolutePath();
    }

    public static void createNewFile(String path) {
        File file = new File(path);
        File fileParent = file.getParentFile();
        if(!fileParent.exists()) {
            boolean flag = fileParent.mkdirs();
            if(!flag) {
                logger.warn("创建文件路径失败，" + path);
            }
        }
    }

    public static void saveXSSFWorkbook(String fileName,XSSFWorkbook f) throws IOException {
        String path = getCurrPath() + "/export";
        String fullPath = path + "/" + fileName;
        createNewFile(fullPath);
        try (FileOutputStream fs = new FileOutputStream(fullPath)) {
            f.write(fs);
            fs.flush();
        }
    }

    public synchronized static String getNextStr() {
        String s = getStr();
        if(!s.equals(lastTimeStr)) {
            lastTimeStr = s;
            return s;
        }
        long t = System.currentTimeMillis();
        long u = System.currentTimeMillis();
        while(t-u<1000) {
            t = System.currentTimeMillis();
        }
        return getStr();
    }

    private static String getStr() {
        return DateTool.GetDateTimeStr()
                .replace(" ","")
                .replace(":","")
                .replace("-","");
    }
}
