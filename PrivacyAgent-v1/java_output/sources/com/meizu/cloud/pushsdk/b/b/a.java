package com.meizu.cloud.pushsdk.b.b;

/* loaded from: classes23.dex */
public class a {
    private static final java.util.HashMap<java.lang.String, java.lang.Class<?>> a = new java.util.HashMap<>();
    private java.lang.Class<?> b;
    private java.lang.String c;
    private java.lang.Object d;

    private a(java.lang.Object obj) {
        this.d = obj;
    }

    private a(java.lang.String str) {
        this.c = str;
    }

    public static com.meizu.cloud.pushsdk.b.b.a a(java.lang.Object obj) {
        return new com.meizu.cloud.pushsdk.b.b.a(obj);
    }

    public static com.meizu.cloud.pushsdk.b.b.a a(java.lang.String str) {
        return new com.meizu.cloud.pushsdk.b.b.a(str);
    }

    public com.meizu.cloud.pushsdk.b.b.b a(java.lang.Class<?>... clsArr) {
        return new com.meizu.cloud.pushsdk.b.b.b(this, clsArr);
    }

    public com.meizu.cloud.pushsdk.b.b.c a(java.lang.String str, java.lang.Class<?>... clsArr) {
        return new com.meizu.cloud.pushsdk.b.b.c(this, str, clsArr);
    }

    public java.lang.Class<?> a() throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        java.lang.Object obj = this.d;
        if (obj != null) {
            return obj.getClass();
        }
        java.util.HashMap<java.lang.String, java.lang.Class<?>> hashMap = a;
        java.lang.Class<?> cls2 = hashMap.get(this.c);
        if (cls2 == null) {
            cls2 = java.lang.Class.forName(this.c);
            hashMap.put(this.c, cls2);
        }
        return cls2;
    }
}
