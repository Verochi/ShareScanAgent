package com.meizu.cloud.pushsdk.d.c;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.d.c.a {
    private final java.lang.String a;
    private final java.lang.String b;
    private final java.lang.String c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;
    private final java.lang.String g;
    private final java.lang.String h;
    private final int i;

    public static abstract class a<T extends com.meizu.cloud.pushsdk.d.c.b.a<T>> extends com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a<T> {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private java.lang.String e;
        private java.lang.String f;
        private java.lang.String g;
        private java.lang.String h;
        private int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(java.lang.String str) {
            this.a = str;
            return (T) a();
        }

        public T b(java.lang.String str) {
            this.b = str;
            return (T) a();
        }

        public com.meizu.cloud.pushsdk.d.c.b b() {
            return new com.meizu.cloud.pushsdk.d.c.b(this);
        }

        public T c(java.lang.String str) {
            this.c = str;
            return (T) a();
        }

        public T d(java.lang.String str) {
            this.d = str;
            return (T) a();
        }

        public T e(java.lang.String str) {
            this.e = str;
            return (T) a();
        }

        public T f(java.lang.String str) {
            this.f = str;
            return (T) a();
        }

        public T g(java.lang.String str) {
            this.g = str;
            return (T) a();
        }

        public T h(java.lang.String str) {
            this.h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b, reason: collision with other inner class name */
    public static class C0426b extends com.meizu.cloud.pushsdk.d.c.b.a<com.meizu.cloud.pushsdk.d.c.b.C0426b> {
        private C0426b() {
        }

        public /* synthetic */ C0426b(com.meizu.cloud.pushsdk.d.c.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.meizu.cloud.pushsdk.d.c.a.AbstractC0425a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.d.c.b.C0426b a() {
            return this;
        }
    }

    public b(com.meizu.cloud.pushsdk.d.c.b.a<?> aVar) {
        super(aVar);
        this.b = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).b;
        this.c = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).c;
        this.a = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).a;
        this.d = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).d;
        this.e = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).e;
        this.f = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).f;
        this.g = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).g;
        this.h = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).h;
        this.i = ((com.meizu.cloud.pushsdk.d.c.b.a) aVar).i;
    }

    public static com.meizu.cloud.pushsdk.d.c.b.a<?> d() {
        return new com.meizu.cloud.pushsdk.d.c.b.C0426b(null);
    }

    public com.meizu.cloud.pushsdk.d.a.c e() {
        com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
        cVar.a("en", this.a);
        cVar.a("ti", this.b);
        cVar.a(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, this.c);
        cVar.a(com.umeng.analytics.pro.f.T, this.d);
        cVar.a("pn", this.e);
        cVar.a("si", this.f);
        cVar.a("ms", this.g);
        cVar.a("ect", this.h);
        cVar.a("br", java.lang.Integer.valueOf(this.i));
        return a(cVar);
    }
}
