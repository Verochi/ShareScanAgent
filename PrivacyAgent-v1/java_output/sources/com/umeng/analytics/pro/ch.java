package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ch {
    public static com.umeng.analytics.pro.cg a(java.lang.Class<? extends com.umeng.analytics.pro.cg> cls, int i) {
        try {
            return (com.umeng.analytics.pro.cg) cls.getMethod("findByValue", java.lang.Integer.TYPE).invoke(null, java.lang.Integer.valueOf(i));
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }
}
