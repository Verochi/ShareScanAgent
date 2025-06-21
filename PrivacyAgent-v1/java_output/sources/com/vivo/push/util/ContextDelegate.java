package com.vivo.push.util;

/* loaded from: classes19.dex */
public class ContextDelegate {
    private static final java.lang.String TAG = "ContextDelegate";
    private static android.content.Context mContext;
    private static java.lang.reflect.Method mCreateCredentialProtectedStorageContext;
    private static java.lang.reflect.Method mCreateDeviceProtectedStorageContext;
    private static boolean mDelegateEnable;
    private static java.lang.Boolean mIsFbeProject;

    public static class a {
        private static com.vivo.push.util.ContextDelegate a = new com.vivo.push.util.ContextDelegate();
    }

    private static android.content.Context createCredentialProtectedStorageContext(android.content.Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = android.content.Context.class.getMethod("createCredentialProtectedStorageContext", new java.lang.Class[0]);
            }
            return (android.content.Context) mCreateCredentialProtectedStorageContext.invoke(context, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return context;
        }
    }

    private static android.content.Context createDeviceProtectedStorageContext(android.content.Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = android.content.Context.class.getMethod("createDeviceProtectedStorageContext", new java.lang.Class[0]);
            }
            return (android.content.Context) mCreateDeviceProtectedStorageContext.invoke(context, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return context;
        }
    }

    public static android.content.Context getContext(android.content.Context context) {
        if (!isFBEProject() || context == null) {
            return context;
        }
        android.content.Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    public static com.vivo.push.util.ContextDelegate getInstance() {
        return com.vivo.push.util.ContextDelegate.a.a;
    }

    public static boolean isFBEProject() {
        if (mIsFbeProject == null) {
            try {
                mIsFbeProject = java.lang.Boolean.valueOf("file".equals(com.vivo.push.util.j.a("ro.crypto.type", "unknow")));
                com.vivo.push.util.p.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (java.lang.Exception e) {
                com.vivo.push.util.p.a(TAG, "mIsFbeProject = " + e.getMessage());
            }
        }
        java.lang.Boolean bool = mIsFbeProject;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void setAppContext() {
        android.content.Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(android.content.Context context) {
        mContext = !mDelegateEnable ? createCredentialProtectedStorageContext(context) : createDeviceProtectedStorageContext(context);
    }

    public static void setEnable(boolean z) {
        mDelegateEnable = z;
        setAppContext();
    }
}
