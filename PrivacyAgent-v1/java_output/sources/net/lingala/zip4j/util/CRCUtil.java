package net.lingala.zip4j.util;

/* loaded from: classes23.dex */
public class CRCUtil {
    public static long computeFileCRC(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        return computeFileCRC(str, null);
    }

    public static long computeFileCRC(java.lang.String str, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        java.io.FileInputStream fileInputStream;
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null or empty, cannot calculate CRC for the file");
        }
        java.io.FileInputStream fileInputStream2 = null;
        try {
            try {
                net.lingala.zip4j.util.Zip4jUtil.checkFileReadAccess(str);
                fileInputStream = new java.io.FileInputStream(new java.io.File(str));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[16384];
            java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    long value = crc32.getValue();
                    try {
                        fileInputStream.close();
                        return value;
                    } catch (java.io.IOException unused) {
                        throw new net.lingala.zip4j.exception.ZipException("error while closing the file after calculating crc");
                    }
                }
                crc32.update(bArr, 0, read);
                if (progressMonitor != null) {
                    progressMonitor.updateWorkCompleted(read);
                    if (progressMonitor.isCancelAllTasks()) {
                        progressMonitor.setResult(3);
                        progressMonitor.setState(0);
                        try {
                            fileInputStream.close();
                            return 0L;
                        } catch (java.io.IOException unused2) {
                            throw new net.lingala.zip4j.exception.ZipException("error while closing the file after calculating crc");
                        }
                    }
                }
            }
        } catch (java.io.IOException e3) {
            e = e3;
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e4) {
            e = e4;
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException unused3) {
                    throw new net.lingala.zip4j.exception.ZipException("error while closing the file after calculating crc");
                }
            }
            throw th;
        }
    }
}
