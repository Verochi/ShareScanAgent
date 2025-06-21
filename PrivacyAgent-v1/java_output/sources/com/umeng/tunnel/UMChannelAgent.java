package com.umeng.tunnel;

/* loaded from: classes19.dex */
public class UMChannelAgent {
    private static final java.lang.String TAG = "UMChannelAgent";
    private static final java.lang.String UMENG_VCHANNEL = "com.umeng.commonsdk.vchannel.Sender";
    private static boolean vChannelReady;

    static {
        try {
            java.lang.String str = com.umeng.commonsdk.vchannel.Sender.VCHANNEL_VERSION;
            vChannelReady = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean init() {
        return vChannelReady;
    }

    public static void onDebugEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        reflectOnEvent(context, str, map);
    }

    private static void reflectOnEvent(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String str2 = com.umeng.commonsdk.vchannel.Sender.VCHANNEL_VERSION;
            com.umeng.commonsdk.vchannel.Sender.class.getMethod("onEvent", android.content.Context.class, java.lang.String.class, java.util.Map.class).invoke(null, context, str, map);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.SecurityException | java.lang.Exception unused) {
        }
    }

    private static void reflectSetCustomHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            java.lang.String str = com.umeng.commonsdk.vchannel.Sender.VCHANNEL_VERSION;
            com.umeng.commonsdk.vchannel.Sender.class.getMethod("setCustomHeader", java.util.Map.class).invoke(null, map);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.SecurityException | java.lang.Exception unused) {
        }
    }

    public static void setCustomHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        reflectSetCustomHeader(map);
    }
}
