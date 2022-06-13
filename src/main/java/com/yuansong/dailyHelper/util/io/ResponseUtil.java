package com.yuansong.dailyHelper.util.io;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ResponseUtil {

    public static void setResponseDownloadExcel(HttpServletResponse response, String fileName, XSSFWorkbook book) throws IOException {
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition","attachment;filename="
                + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");

        OutputStream os = response.getOutputStream();
        book.write(os);
        os.flush();
        os.close();
    }

}
