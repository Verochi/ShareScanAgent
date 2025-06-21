package cn.shuzilm.core;

/* loaded from: classes.dex */
public class Main {
    private static java.lang.String a;

    public static void getDeviceLabel(int i, cn.shuzilm.core.Listener listener) {
        cn.shuzilm.core.DUHelper.f2c071(i, listener);
    }

    public static void getHMSOpenAnmsID(android.content.Context context, cn.shuzilm.core.Listener listener) {
        cn.shuzilm.core.DUHelper.ZVTFJRA(context, listener, 1, true);
    }

    public static void getNetCode(android.content.Context context, cn.shuzilm.core.Listener listener) {
        cn.shuzilm.core.DUHelper.m(context, 2, listener);
    }

    public static void getOpenAnmsID(android.content.Context context, cn.shuzilm.core.Listener listener) {
        cn.shuzilm.core.DUHelper.ZVTFJRA(context, listener, 0, true);
    }

    @java.lang.Deprecated
    public static java.lang.String getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
            a = str;
            return cn.shuzilm.core.DUHelper.getQueryID(context, str, str2, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        try {
            if (android.os.Looper.myLooper() == null) {
                android.os.Looper.prepare();
            }
            a = str;
            return cn.shuzilm.core.DUHelper.getQueryID(context, str, str2, z);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @java.lang.Deprecated
    public static void getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2, int i, cn.shuzilm.core.Listener listener) {
        a = str;
        cn.shuzilm.core.DUHelper.getQueryID(context, str, str2, true, i, listener, 2);
    }

    public static void getQueryID(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, cn.shuzilm.core.Listener listener) {
        a = str;
        cn.shuzilm.core.DUHelper.getQueryID(context, str, str2, z, 1, listener, 2);
    }

    public static java.lang.String getSupplementalID(android.content.Context context, int i) {
        return cn.shuzilm.core.DUHelper.s(context, i);
    }

    public static java.lang.String getTraceInfo(android.content.Context context) {
        return cn.shuzilm.core.DUHelper.n(context);
    }

    public static java.lang.String getVersion() {
        return "v8.5.7";
    }

    @java.lang.Deprecated
    public static void init(android.content.Context context, java.lang.String str) {
        if (android.os.Looper.myLooper() == null) {
            android.os.Looper.prepare();
        }
        cn.shuzilm.core.DUHelper.init(context, str, true);
    }

    public static void init(android.content.Context context, java.lang.String str, boolean z) {
        if (android.os.Looper.myLooper() == null) {
            android.os.Looper.prepare();
        }
        cn.shuzilm.core.DUHelper.init(context, str, z);
    }

    public static java.util.Map onEvent(android.content.Context context, java.lang.String str, java.lang.String str2, int i, cn.shuzilm.core.Listener listener) {
        try {
            return cn.shuzilm.core.DUHelper.onEvent(context, str, str2, i, listener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void optReport(android.content.Context context, java.lang.String str) {
        cn.shuzilm.core.DUHelper.o(context, a, str, true, 1, null, 201);
    }

    public static int setConfig(java.lang.String str, java.lang.String str2) {
        try {
            return cn.shuzilm.core.DUHelper.setConfig(str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int setData(java.lang.String str, java.lang.String str2) {
        try {
            return cn.shuzilm.core.DUHelper.setData(str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
