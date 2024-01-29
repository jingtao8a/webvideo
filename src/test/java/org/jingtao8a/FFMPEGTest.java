package org.jingtao8a;

import org.junit.Test;

import java.io.*;

class FFmpegHLSConverter {
    public static void execute(String inputFilePath, String outputFilePath) {
        // 输出的分片文件存放目录
        String segmentPath = outputFilePath.substring(0, outputFilePath.length() - 4);

        try {
            // 创建分片存放目录
            new File(segmentPath).mkdirs();

            // 执行FFmpeg命令将MP4分片为M3U8
            ProcessBuilder ffmpegBuilder = new ProcessBuilder(
                    "ffmpeg",
                    "-i", inputFilePath,
                    "-c:v", "copy",
                    "-c:a", "copy",
                    "-f", "hls",
                    "-hls_playlist_type", "vod",
                    "-hls_time", "2", // 分片时长（秒)
                    "-hls_segment_filename", segmentPath + "/output%03d.ts", // 分片文件名格式
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

public class FFMPEGTest {

    @Test
    public void testFfmpeg() {
        FFmpegHLSConverter.execute("D:/video/directroy1/VID_20230109_132811.mp4", "D:/video/directroy1/VID_20230109_132811.m3u8");
    }
}
