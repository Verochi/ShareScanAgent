package com.meizu.cloud.pushsdk.c.a;

/* loaded from: classes23.dex */
public class c<T> {
    private final T a;
    private final com.meizu.cloud.pushsdk.c.b.a b;
    private com.meizu.cloud.pushsdk.c.c.k c;

    public c(com.meizu.cloud.pushsdk.c.b.a aVar) {
        this.a = null;
        this.b = aVar;
    }

    public c(T t) {
        this.a = t;
        this.b = null;
    }

    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        return new com.meizu.cloud.pushsdk.c.a.c<>(aVar);
    }

    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(T t) {
        return new com.meizu.cloud.pushsdk.c.a.c<>(t);
    }

    public T a() {
        return this.a;
    }

    public void a(com.meizu.cloud.pushsdk.c.c.k kVar) {
        this.c = kVar;
    }

    public boolean b() {
        return this.b == null;
    }

    public com.meizu.cloud.pushsdk.c.b.a c() {
        return this.b;
    }
}
