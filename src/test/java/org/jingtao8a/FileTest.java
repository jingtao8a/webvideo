package org.jingtao8a;

import org.junit.Test;

import java.io.File;

public class FileTest {

    @Test
    public void fileTest() {
        File dir = new File("test.txt");
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
        System.out.println(dir.getParentFile().getAbsolutePath());
    }
}
