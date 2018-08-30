package com.tp.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by hongjian.chen on 2018/8/24.
 */

@Controller
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/upload/") + file.getOriginalFilename();
        System.out.println("path=" + path);
        String result = "success";
        try {
            FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
        } catch (IOException e) {
            result = "failed";
        }
        return result;
    }
}
