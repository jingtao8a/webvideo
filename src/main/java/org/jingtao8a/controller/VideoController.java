package org.jingtao8a.controller;

import org.jingtao8a.model.Dir;
import org.jingtao8a.model.Result;
import org.jingtao8a.util.DirectoryStructure;
import org.jingtao8a.util.FFmpegHLSConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.URLDecoder;


@Controller
public class VideoController {
//     "D:/video/"
    private static String mp4VideoRootPath = "G:/honor20/";
    private static String m3u8VideoRootPath = "D:/webvideo/src/main/webapp/video/"; // fixed

    private static Dir rootDir;
    @RequestMapping(value="/video", method= RequestMethod.GET)
    @ResponseBody
    public Result getVideo(@RequestParam("videoPath") String videoPath) {// dir1/vid.mp4
        videoPath = URLDecoder.decode(videoPath);
        System.out.println(videoPath);
        String mp4VideoPath = mp4VideoRootPath + videoPath;
        // 输出的分片文件存放目录
        String segmentPath = m3u8VideoRootPath + videoPath.substring(0, videoPath.length() - 4);
        String m3u8VideoPath = segmentPath + segmentPath.substring(segmentPath.lastIndexOf("/")) + ".m3u8";
        File m3u8File= new File(m3u8VideoPath);
        File m3u8ParentFile = m3u8File.getParentFile();
        if (!m3u8File.exists()) {
            if (m3u8ParentFile != null && !m3u8ParentFile.exists()) {
                m3u8ParentFile.mkdirs();
            }
            FFmpegHLSConverter.execute(mp4VideoPath, m3u8VideoPath);
        }
        String path = m3u8VideoPath.replace(m3u8VideoRootPath, "/video/");
        System.out.println(path);
        Result res = new Result(200, "getVideom3u8Link");
        res.setExtentPack(path);
        return res;
    }

    @RequestMapping(value="/videoDirectoryStructrue", method=RequestMethod.GET)
    @ResponseBody
    public Result getVideoDirectoryStructure() {
        Result res = new Result(200, "getVideoDirectoryStructure");
        if (rootDir == null) {
            rootDir = DirectoryStructure.getDirectoryStrucure(mp4VideoRootPath);
        }
        res.setExtentPack(rootDir.getChildren());
        return res;
    }
}
