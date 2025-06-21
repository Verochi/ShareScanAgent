package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public abstract class FileUtil {
    public static final java.lang.String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final java.lang.String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;
    public static boolean a;
    public static java.util.concurrent.ScheduledExecutorService b = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();

    public static class a implements java.lang.Runnable {
        public final /* synthetic */ java.io.File a;
        public final /* synthetic */ long b;
        public final /* synthetic */ java.lang.String c;

        public a(java.io.File file, long j, java.lang.String str) {
            this.a = file;
            this.b = j;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.File file = this.a;
            if (file == null) {
                com.huawei.hms.support.log.HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            java.io.File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                com.huawei.hms.support.log.HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
                return;
            }
            java.io.RandomAccessFile randomAccessFile = null;
            try {
                try {
                    long length = this.a.length();
                    if (length > this.b) {
                        java.lang.String canonicalPath = this.a.getCanonicalPath();
                        if (!this.a.delete()) {
                            com.huawei.hms.support.log.HMSLog.e("FileUtil", "last file delete failed.");
                        }
                        randomAccessFile = new java.io.RandomAccessFile(new java.io.File(canonicalPath), "rw");
                    } else {
                        java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(this.a, "rw");
                        try {
                            randomAccessFile2.seek(length);
                            randomAccessFile = randomAccessFile2;
                        } catch (java.io.IOException e) {
                            e = e;
                            randomAccessFile = randomAccessFile2;
                            com.huawei.hms.support.log.HMSLog.e("FileUtil", "writeFile exception:", e);
                            com.huawei.hms.utils.IOUtils.closeQuietly(randomAccessFile);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile2;
                            com.huawei.hms.utils.IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile.writeBytes(this.c + java.lang.System.getProperty("line.separator"));
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
            com.huawei.hms.utils.IOUtils.closeQuietly(randomAccessFile);
        }
    }

    public static boolean verifyHash(java.lang.String str, java.io.File file) {
        byte[] digest = com.huawei.hms.utils.SHA256.digest(file);
        return digest != null && com.huawei.hms.utils.HEX.encodeHexString(digest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(java.io.File file, java.lang.String str, long j) {
        b.execute(new com.huawei.hms.utils.FileUtil.a(file, j, str));
    }

    public static void writeFileReport(android.content.Context context, java.io.File file, java.io.File file2, java.lang.String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    com.huawei.hms.support.log.HMSLog.e("FileUtil", "file delete failed.");
                }
                a = true;
            }
            writeFile(file2, str + "|" + j + "|" + i, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
