package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class bt {
    public static long vw(java.io.File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return vw(file, file.lastModified(), 0);
    }

    private static long vw(java.io.File file, long j, int i) {
        java.io.File[] listFiles;
        if (file != null && file.exists()) {
            j = java.lang.Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (java.io.File file2 : listFiles) {
                    j = java.lang.Math.max(j, vw(file2, j, i2));
                }
            }
        }
        return j;
    }
}
