package com.github.jjYBdx4IL.graphics.opencv;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import java.io.IOException;
import java.util.logging.Level;

import org.junit.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Github jjYBdx4IL Projects
 */
public class InitTest {

    private static final Logger LOG = LoggerFactory.getLogger(InitTest.class);

    static {
        NativeLibrary.getInstance("opencv");
//        try {
//            LOG.info(lib.getFile().getCanonicalPath());
//            if (!lib.getFile().exists()) {
//                System.load(lib.getFile().getCanonicalPath());
//            }
//        } catch (IOException ex) {
//            LOG.error("", ex);
//        }
    }

    @Test
    public void testInit() throws InterruptedException {
        //NativeLibrary lib = Init.lib;

        //Thread.sleep(600000l);

        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        LOG.info("mat = " + mat.dump());
    }
}
