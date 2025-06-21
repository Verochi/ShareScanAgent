package com.tencent.open.log;

/* loaded from: classes19.dex */
public final class g {
    public static final com.tencent.open.log.g a = new com.tencent.open.log.g();

    public final java.lang.String a(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST : androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST : "I" : "D" : androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }

    public java.lang.String a(int i, java.lang.Thread thread, long j, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        long j2 = j % 1000;
        android.text.format.Time time = new android.text.format.Time();
        time.set(j);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(a(i));
        sb.append('/');
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j2 < 10) {
            sb.append(org.apache.tools.tar.TarConstants.VERSION_POSIX);
        } else if (j2 < 100) {
            sb.append('0');
        }
        sb.append(j2);
        sb.append(' ');
        sb.append('[');
        if (thread == null) {
            sb.append("N/A");
        } else {
            sb.append(thread.getName());
        }
        sb.append(']');
        sb.append('[');
        sb.append(str);
        sb.append(']');
        sb.append(' ');
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(android.util.Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }
}
