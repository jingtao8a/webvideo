package org.jingtao8a.controller;

import org.jingtao8a.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadFile(@RequestParam("file") CommonsMultipartFile commonsMultipartFile) {
        File file = new File("D:/webvideo/src/main/webapp/upload/" + commonsMultipartFile.getOriginalFilename());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            commonsMultipartFile.transferTo(file);
        } catch (IOException e) {
            return new Result(500, "file upload fail");
        }
        Result res = new Result(200, "file upload success");
        res.setExtentPack("/upload/" + commonsMultipartFile.getOriginalFilename());
        return res;
    }

}
