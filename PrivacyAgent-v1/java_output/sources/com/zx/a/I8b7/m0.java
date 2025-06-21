package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class m0 {
    public static void a(java.io.File file) {
        for (java.io.File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(new java.io.File(file2.getPath()));
            } else {
                file2.delete();
            }
        }
        if (file.listFiles().length <= 0) {
            file.delete();
        }
    }
}
