package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ContextHolder {
    private static final java.lang.String TAG = "ContextHolder";

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static android.content.Context sAppContext;

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static android.content.Context sKitContext;

    public static android.content.Context getAppContext() {
        return sAppContext;
    }

    public static android.content.Context getKitContext() {
        return sKitContext;
    }

    public static android.content.Context getResourceContext() {
        return getKitContext() != null ? getKitContext() : getAppContext();
    }

    public static void setAppContext(android.content.Context context) {
        com.huawei.hms.framework.common.CheckParamUtils.checkNotNull(context, "sAppContext == null");
        sAppContext = context.getApplicationContext();
    }

    public static void setKitContext(android.content.Context context) {
        com.huawei.hms.framework.common.CheckParamUtils.checkNotNull(context, "sKitContext == null");
        sKitContext = context;
    }
}
