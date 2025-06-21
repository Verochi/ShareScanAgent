package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ax extends com.baidu.mobads.sdk.internal.aw {
    public static final java.lang.String b = "logout";
    private static final java.lang.String[] c = {"#", "#", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST, androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.aw, com.baidu.mobads.sdk.internal.ay.a
    @androidx.annotation.NonNull
    public java.lang.String a() {
        return b;
    }

    @Override // com.baidu.mobads.sdk.internal.aw, com.baidu.mobads.sdk.internal.ay.a
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        try {
            com.baidu.mobads.sdk.api.IXAdContainerFactory c2 = com.baidu.mobads.sdk.internal.aa.a().c();
            if (c2 != null) {
                c2.getRemoteParam("debugLogout", (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", java.util.Locale.getDefault()).format(new java.util.Date()) + " " + c[i] + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str + ": ") + "当前线程：" + java.lang.Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
