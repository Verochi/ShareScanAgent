package com.aliyun.svideosdk.nativeload;

/* loaded from: classes12.dex */
public class AlivcAudioProxy {
    public static boolean sNeedAudiTrack;
    public static java.lang.String sPackageName;

    public static boolean registAudioInstance(java.lang.String str) {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName(str);
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            return false;
        }
        sPackageName = str.replace(".", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        return true;
    }
}
