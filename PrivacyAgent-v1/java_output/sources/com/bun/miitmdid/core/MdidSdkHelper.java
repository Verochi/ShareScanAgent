package com.bun.miitmdid.core;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class MdidSdkHelper {
    public static java.lang.String TAG = "MdidSdkHelper";

    @androidx.annotation.Keep
    public static boolean _OuterIsOk = true;

    @androidx.annotation.Keep
    private java.lang.String sdk_date = "2020011018";

    @androidx.annotation.Keep
    public static int InitSdk(android.content.Context context, boolean z, com.bun.supplier.IIdentifierListener iIdentifierListener) {
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener != null) {
                    iIdentifierListener.OnSupport(false, new com.bun.supplier.a());
                }
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.reflect.Constructor constructor = com.bun.miitmdid.core.MdidSdk.class.getConstructor(java.lang.Boolean.TYPE);
            if (constructor == null) {
                logd(z, "not found MdidSdk Constructor");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.Object newInstance = constructor.newInstance(java.lang.Boolean.valueOf(z));
            if (newInstance == null) {
                logd(z, "Create MdidSdk Instance failed");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.reflect.Method declaredMethod = com.bun.miitmdid.core.MdidSdk.class.getDeclaredMethod("InitSdk", android.content.Context.class, com.bun.supplier.IIdentifierListener.class);
            if (declaredMethod == null) {
                logd(z, "not found MdidSdk InitSdk function");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            int intValue = ((java.lang.Integer) declaredMethod.invoke(newInstance, context, iIdentifierListener)).intValue();
            logd(z, "call and retvalue:" + intValue);
            return intValue;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            loge(z, e);
            logd(z, "exception exit");
            return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z, java.lang.String str) {
    }

    public static void loge(boolean z, java.lang.Exception exc) {
        if (z) {
            exc.getClass();
        }
    }
}
