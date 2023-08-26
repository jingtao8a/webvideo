package org.jingtao8a;

import org.jingtao8a.model.Dir;
import org.jingtao8a.util.DirectoryStructure;
import org.junit.Test;

import java.io.File;

public class testDirectory {
    private static String root = "D:/video";
    @Test
    public void testDirectory() {
        Dir rootDir = DirectoryStructure.getDirectoryStrucure("D:/video");
//        listFiles(new File("D:/video"), rootDir);
        System.out.println(rootDir.getChildren());
    }
//    public static void listFiles(File directory, Dir dir) {
//        dir.setName(directory.getName());
//        // 获取目录中的所有文件和子目录
//        File[] files = directory.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                // 如果是目录，递归调用listFiles方法
//                if (file.isDirectory()) {
//                    System.out.println("目录: " + file.getAbsolutePath());
//                    Dir child = new Dir();
//                    listFiles(file, child); // 递归调用
//                    dir.getChildren().add(child);
//                } else {
//                    // 如果是文件，直接打印文件路径
//                    System.out.println("文件: " + file.getAbsolutePath());
//                    dir.getFile().add(file.getName());
//                }
//            }
//        }
//    }
}
