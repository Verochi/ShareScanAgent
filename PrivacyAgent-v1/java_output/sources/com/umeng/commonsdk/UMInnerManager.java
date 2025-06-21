package com.umeng.commonsdk;

/* loaded from: classes19.dex */
public class UMInnerManager {
    private static java.lang.Class<?> innerImplClazz;
    private static java.lang.reflect.Method sendInternalMethod;

    static {
        try {
            int i = com.umeng.commonsdk.UMInnerImpl.a;
            innerImplClazz = com.umeng.commonsdk.UMInnerImpl.class;
            java.lang.reflect.Method declaredMethod = com.umeng.commonsdk.UMInnerImpl.class.getDeclaredMethod("initAndSendInternal", android.content.Context.class);
            if (declaredMethod != null) {
                sendInternalMethod = declaredMethod;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void sendInnerPackage(android.content.Context context) {
        java.lang.reflect.Method method;
        if (context == null || !com.umeng.commonsdk.utils.UMUtils.isMainProgress(context)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE == 1) {
            com.umeng.commonsdk.UMConfigureInternation.sendInternal(context);
            return;
        }
        java.lang.Class<?> cls = innerImplClazz;
        if (cls == null || (method = sendInternalMethod) == null) {
            return;
        }
        try {
            method.invoke(cls, context);
        } catch (java.lang.Throwable unused) {
        }
    }
}
