package com.vivo.push.util;

/* loaded from: classes19.dex */
public class NotifyUtil {
    private static com.vivo.push.util.BaseNotifyDataAdapter sNotifyData = null;
    private static java.lang.String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static com.vivo.push.util.BaseNotifyLayoutAdapter sNotifyLayout = null;
    private static java.lang.String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    public static com.vivo.push.util.BaseNotifyDataAdapter getNotifyDataAdapter(android.content.Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static com.vivo.push.util.BaseNotifyLayoutAdapter getNotifyLayoutAdapter(android.content.Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }

    private static java.lang.Object getObjectByReflect(java.lang.String str, java.lang.Object obj) {
        java.lang.Class<?> cls;
        java.lang.Object obj2 = null;
        try {
            cls = java.lang.Class.forName(str);
        } catch (java.lang.Exception unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (java.lang.Exception unused2) {
            }
        }
        return obj2 == null ? obj : obj2;
    }

    private static synchronized void initAdapter(android.content.Context context) {
        synchronized (com.vivo.push.util.NotifyUtil.class) {
            if (sNotifyData == null) {
                com.vivo.push.util.BaseNotifyDataAdapter baseNotifyDataAdapter = (com.vivo.push.util.BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new com.vivo.push.util.h());
                sNotifyData = baseNotifyDataAdapter;
                baseNotifyDataAdapter.init(context);
            }
            if (sNotifyLayout == null) {
                com.vivo.push.util.BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (com.vivo.push.util.BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new com.vivo.push.util.i());
                sNotifyLayout = baseNotifyLayoutAdapter;
                baseNotifyLayoutAdapter.init(context);
            }
        }
    }
}
