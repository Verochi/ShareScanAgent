package com.umeng.umzid;

/* loaded from: classes19.dex */
public class Spy {
    public static boolean initSuccess;

    static {
        try {
            java.lang.System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static java.lang.String getID() {
        if (initSuccess) {
            return getNativeID(android.os.Build.VERSION.SDK_INT >= 29);
        }
        return null;
    }

    public static native java.lang.String getNativeID(boolean z);

    public static native java.lang.String getNativeLibraryVersion();

    public static native java.lang.String getNativeTag(boolean z, boolean z2, boolean z3);

    public static synchronized java.lang.String getTag(android.content.Context context) {
        boolean j;
        java.lang.String nativeTag;
        synchronized (com.umeng.umzid.Spy.class) {
            if (context != null) {
                try {
                    j = com.umeng.umzid.d.j(context);
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            } else {
                j = false;
            }
            nativeTag = getNativeTag(j, context != null ? com.umeng.umzid.d.i(context) : false, android.os.Build.VERSION.SDK_INT >= 29);
        }
        return nativeTag;
    }

    public static java.lang.String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
