package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class b {
    private static final java.util.HashMap<java.lang.String, java.lang.String> a;

    static {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        a = hashMap;
        hashMap.put("FFD8FF", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG);
        hashMap.put("89504E47", com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG);
        hashMap.put("47494638", "gif");
        hashMap.put("474946", "gif");
        hashMap.put("424D", "bmp");
    }

    public static long a(java.io.File file) {
        long j = 0;
        try {
            java.io.File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return j;
    }
}
