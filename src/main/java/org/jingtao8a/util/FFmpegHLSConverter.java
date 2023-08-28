package org.jingtao8a.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FFmpegHLSConverter {
    public static void execute(String inputFilePath, String outputFilePath) {
        try {

            // 执行FFmpeg命令将MP4分片为M3U8
            ProcessBuilder ffmpegBuilder = new ProcessBuilder(
                    "ffmpeg",
                    "-i", inputFilePath,
                    "-c:v", "copy",
                    "-c:a", "copy",
                    "-f", "hls",
                    "-hls_playlist_type", "vod",
                    "-hls_time", "2", // 分片时长（秒)
//                    "-hls_segment_filename", outputFilePath.substring(0, outputFilePath.lastIndexOf("/")) + "/output%03d.ts", // 分片文件名格式
                    outputFilePath
            );

            // 设置输出流，将FFmpeg的输出打印到控制台
            ffmpegBuilder.redirectErrorStream(true);

            // 启动FFmpeg进程并等待其完成
            Process ffmpegProcess = ffmpegBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(ffmpegProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            ffmpegProcess.waitFor();

            System.out.println("MP4文件已成功分片为M3U8格式。");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
