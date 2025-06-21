package com.alibaba.sdk.android.vod.upload.common.utils;

/* loaded from: classes.dex */
public class SharedPreferencesUtil {
    public static boolean clearUploadInfo(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context.getSharedPreferences(str, 0).edit().remove(str2).commit();
    }

    public static com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo getUploadInfo(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return (com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo) new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(android.util.Base64.decode(context.getSharedPreferences(str, 0).getString(str2, "").getBytes(), 0))).readObject();
        } catch (java.io.IOException | java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public static void saveUploadInfp(android.content.Context context, java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo oSSUploadInfo) throws java.lang.Exception {
        if (!(oSSUploadInfo instanceof java.io.Serializable)) {
            throw new java.lang.Exception("User must implements Serializable");
        }
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            new java.io.ObjectOutputStream(byteArrayOutputStream).writeObject(oSSUploadInfo);
            edit.putString(str2, new java.lang.String(android.util.Base64.encode(byteArrayOutputStream.toByteArray(), 0)));
            edit.commit();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
