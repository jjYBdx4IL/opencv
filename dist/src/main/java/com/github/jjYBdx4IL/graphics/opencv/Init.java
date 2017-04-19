package com.github.jjYBdx4IL.graphics.opencv;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

/**
 *
 * @author Github jjYBdx4IL Projects
 */
public class Init {

    public static NativeLibrary lib = null;

    static {
//        synchronized (Init.class) {
//            if (lib == null) {
                lib = NativeLibrary.getInstance("opencv");
                Native.register(lib);
//            }
//        }
    }

}
