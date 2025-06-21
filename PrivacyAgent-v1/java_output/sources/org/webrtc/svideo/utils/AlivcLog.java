package org.webrtc.svideo.utils;

/* loaded from: classes26.dex */
public class AlivcLog {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private static int d = 4;
    private static int e = 5;

    private static java.lang.String a() {
        return new java.lang.Exception().getStackTrace()[2].getFileName();
    }

    public static synchronized void a(java.lang.String str, java.lang.String str2) {
        synchronized (org.webrtc.svideo.utils.AlivcLog.class) {
            nativeLog(a(), b(), b, str, str2);
        }
    }

    private static int b() {
        return new java.lang.Exception().getStackTrace()[2].getLineNumber();
    }

    public static synchronized void b(java.lang.String str, java.lang.String str2) {
        synchronized (org.webrtc.svideo.utils.AlivcLog.class) {
            nativeLog(a(), b(), e, str, c() + str2);
        }
    }

    private static java.lang.String c() {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Exception().getStackTrace()[2];
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("[");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static synchronized void c(java.lang.String str, java.lang.String str2) {
        synchronized (org.webrtc.svideo.utils.AlivcLog.class) {
            nativeLog(a(), b(), c, str, str2);
        }
    }

    public static synchronized void d(java.lang.String str, java.lang.String str2) {
        synchronized (org.webrtc.svideo.utils.AlivcLog.class) {
            nativeLog(a(), b(), a, str, str2);
        }
    }

    public static synchronized void e(java.lang.String str, java.lang.String str2) {
        synchronized (org.webrtc.svideo.utils.AlivcLog.class) {
            nativeLog(a(), b(), d, str, str2);
        }
    }

    public static native void nativeLog(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3);
}
