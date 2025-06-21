package com.aliyun.vod.log.util;

/* loaded from: classes12.dex */
public class CRC64Util {
    public static java.lang.String calculateCrc64(java.lang.String str) {
        byte[] bArr = new byte[1024];
        com.aliyun.vod.log.util.CRC64 crc64 = new com.aliyun.vod.log.util.CRC64();
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(fileInputStream);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    bufferedInputStream.close();
                    return java.lang.String.valueOf(crc64.getValue());
                }
                crc64.update(bArr, 0, read);
            }
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
