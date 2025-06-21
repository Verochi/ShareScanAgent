package com.jd.ad.sdk.jad_dq;

/* loaded from: classes23.dex */
public class jad_an {
    public static java.lang.String jad_an(android.content.Context context, java.lang.String str) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((java.lang.Integer) declaredMethod.invoke(null, java.lang.Integer.valueOf(android.os.Process.myUid()))).intValue();
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.HashSet hashSet2 = new java.util.HashSet();
            java.util.HashSet hashSet3 = new java.util.HashSet();
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.provider.Settings$Global");
                java.lang.reflect.Field declaredField = cls.getDeclaredField("MOVED_TO_SECURE");
                declaredField.setAccessible(true);
                hashSet = (java.util.HashSet) declaredField.get(cls);
            } catch (java.lang.Exception unused) {
            }
            try {
                java.lang.Class<?> cls2 = java.lang.Class.forName("android.provider.Settings$Secure");
                java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("MOVED_TO_LOCK_SETTINGS");
                declaredField2.setAccessible(true);
                hashSet2 = (java.util.HashSet) declaredField2.get(cls2);
            } catch (java.lang.Exception unused2) {
            }
            try {
                java.lang.Class<?> cls3 = java.lang.Class.forName("android.provider.Settings$Secure");
                java.lang.reflect.Field declaredField3 = cls3.getDeclaredField("MOVED_TO_GLOBAL");
                declaredField3.setAccessible(true);
                hashSet3 = (java.util.HashSet) declaredField3.get(cls3);
            } catch (java.lang.Exception unused3) {
            }
            if (!hashSet.contains(str)) {
                if (hashSet3.contains(str)) {
                    java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName("android.provider.Global").getDeclaredMethod("getStringForUser", android.content.ContentResolver.class, java.lang.String.class, java.lang.Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return (java.lang.String) declaredMethod2.invoke(null, contentResolver, str, java.lang.Integer.valueOf(intValue));
                }
                if (hashSet2.contains(str)) {
                    java.lang.reflect.Method declaredMethod3 = java.lang.Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new java.lang.Class[0]);
                    declaredMethod3.setAccessible(true);
                    android.os.IBinder iBinder = (android.os.IBinder) declaredMethod3.invoke(null, "lock_settings");
                    java.lang.reflect.Method declaredMethod4 = java.lang.Class.forName("com.android.internal.widget.ILockSettings$Stub").getDeclaredMethod("asInterface", android.os.IBinder.class);
                    declaredMethod4.setAccessible(true);
                    java.lang.Object invoke = declaredMethod4.invoke(null, iBinder);
                    boolean z = android.os.Process.myUid() == 1000;
                    if (hashSet2.contains(str) && invoke != null && !z) {
                        return (java.lang.String) invoke.getClass().getDeclaredMethod("getString", java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE).invoke(str, "0", java.lang.Integer.valueOf(intValue));
                    }
                }
            }
            java.lang.reflect.Field declaredField4 = java.lang.Class.forName("android.provider.Settings$Secure").getDeclaredField("sNameValueCache");
            declaredField4.setAccessible(true);
            java.lang.Object obj = declaredField4.get(null);
            return (java.lang.String) obj.getClass().getDeclaredMethod("getStringForUser", android.content.ContentResolver.class, java.lang.String.class, java.lang.Integer.TYPE).invoke(obj, contentResolver, str, java.lang.Integer.valueOf(intValue));
        } catch (java.lang.Throwable unused4) {
            return "";
        }
    }

    public static java.lang.String jad_bo(android.content.Context context, java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.UserHandle");
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
            declaredMethod.setAccessible(true);
            int intValue = ((java.lang.Integer) declaredMethod.invoke(null, java.lang.Integer.valueOf(android.os.Process.myUid()))).intValue();
            java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName("android.provider.Settings$Secure").getDeclaredMethod("getStringForUser", android.content.ContentResolver.class, java.lang.String.class, cls2);
            declaredMethod2.setAccessible(true);
            return (java.lang.String) declaredMethod2.invoke(null, context.getContentResolver(), str, java.lang.Integer.valueOf(intValue));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
