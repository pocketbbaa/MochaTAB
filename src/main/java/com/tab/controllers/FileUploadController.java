package com.tab.controllers;

import com.tab.utils.FileUploadUtil;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 * Created by Administrator on 2017/3/10 0010.
 */
@Path("/file")
public class FileUploadController {


    @Post("/upload")
    public String fileUpload(@Param("file") MultipartFile file) {

        System.out.println("file:" + file);
        byte[] bytes = null;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePath = FileUploadUtil.uploadImg(bytes, file.getOriginalFilename()); //文件上传
        System.out.println("filePath:" + filePath);

        return "@filePath";
    }

}
