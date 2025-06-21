package com.igexin.assist.control.meizu;

/* loaded from: classes22.dex */
public class A {
    private static final java.util.HashMap<java.lang.String, java.lang.Class<?>> a = new java.util.HashMap<>();
    private java.lang.Class<?> b;
    private java.lang.String c;
    private java.lang.Object d;

    private A(java.lang.Object obj) {
        this.d = obj;
    }

    private A(java.lang.String str) {
        this.c = str;
    }

    public static com.igexin.assist.control.meizu.A a(java.lang.String str) {
        return new com.igexin.assist.control.meizu.A(str);
    }

    public com.igexin.assist.control.meizu.c a(java.lang.String str, java.lang.Class<?>... clsArr) {
        return new com.igexin.assist.control.meizu.c(this, str, clsArr);
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
        if (cls2 != null) {
            return cls2;
        }
        java.lang.Class<?> cls3 = java.lang.Class.forName(this.c);
        hashMap.put(this.c, cls3);
        return cls3;
    }
}
