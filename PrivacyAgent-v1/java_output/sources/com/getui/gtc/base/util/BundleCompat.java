package com.getui.gtc.base.util;

/* loaded from: classes22.dex */
public final class BundleCompat {

    public static class BundleCompatBaseImpl {
        private static final java.lang.String TAG = "BundleCompatBaseImpl";
        private static java.lang.reflect.Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static java.lang.reflect.Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BundleCompatBaseImpl() {
        }

        public static android.os.IBinder getBinder(android.os.Bundle bundle, java.lang.String str) {
            if (!sGetIBinderMethodFetched) {
                try {
                    java.lang.reflect.Method method = android.os.Bundle.class.getMethod("getIBinder", java.lang.String.class);
                    sGetIBinderMethod = method;
                    method.setAccessible(true);
                } catch (java.lang.NoSuchMethodException unused) {
                }
                sGetIBinderMethodFetched = true;
            }
            java.lang.reflect.Method method2 = sGetIBinderMethod;
            if (method2 != null) {
                try {
                    return (android.os.IBinder) method2.invoke(bundle, str);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused2) {
                    sGetIBinderMethod = null;
                }
            }
            return null;
        }

        public static void putBinder(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) {
            if (!sPutIBinderMethodFetched) {
                try {
                    java.lang.reflect.Method method = android.os.Bundle.class.getMethod("putIBinder", java.lang.String.class, android.os.IBinder.class);
                    sPutIBinderMethod = method;
                    method.setAccessible(true);
                } catch (java.lang.NoSuchMethodException unused) {
                }
                sPutIBinderMethodFetched = true;
            }
            java.lang.reflect.Method method2 = sPutIBinderMethod;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused2) {
                    sPutIBinderMethod = null;
                }
            }
        }
    }

    private BundleCompat() {
    }

    public static android.os.IBinder getBinder(android.os.Bundle bundle, java.lang.String str) {
        return bundle.getBinder(str);
    }

    public static void putBinder(android.os.Bundle bundle, java.lang.String str, android.os.IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
