package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class co implements java.io.Serializable {
    private static java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.cc>, java.util.Map<? extends com.umeng.analytics.pro.cj, com.umeng.analytics.pro.co>> d = new java.util.HashMap();
    public final java.lang.String a;
    public final byte b;
    public final com.umeng.analytics.pro.cp c;

    public co(java.lang.String str, byte b, com.umeng.analytics.pro.cp cpVar) {
        this.a = str;
        this.b = b;
        this.c = cpVar;
    }

    public static java.util.Map<? extends com.umeng.analytics.pro.cj, com.umeng.analytics.pro.co> a(java.lang.Class<? extends com.umeng.analytics.pro.cc> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (java.lang.InstantiationException e2) {
                throw new java.lang.RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }

    public static void a(java.lang.Class<? extends com.umeng.analytics.pro.cc> cls, java.util.Map<? extends com.umeng.analytics.pro.cj, com.umeng.analytics.pro.co> map) {
        d.put(cls, map);
    }
}
