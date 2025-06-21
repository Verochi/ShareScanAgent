package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class k {
    private final com.meizu.cloud.pushsdk.c.c.i a;
    private final int b;
    private final java.lang.String c;
    private final com.meizu.cloud.pushsdk.c.c.c d;
    private final com.meizu.cloud.pushsdk.c.c.l e;
    private final com.meizu.cloud.pushsdk.c.c.k f;
    private final com.meizu.cloud.pushsdk.c.c.k g;
    private final com.meizu.cloud.pushsdk.c.c.k h;

    public static class a {
        private com.meizu.cloud.pushsdk.c.c.i a;
        private java.lang.String c;
        private com.meizu.cloud.pushsdk.c.c.l e;
        private com.meizu.cloud.pushsdk.c.c.k f;
        private com.meizu.cloud.pushsdk.c.c.k g;
        private com.meizu.cloud.pushsdk.c.c.k h;
        private int b = -1;
        private com.meizu.cloud.pushsdk.c.c.c.a d = new com.meizu.cloud.pushsdk.c.c.c.a();

        public com.meizu.cloud.pushsdk.c.c.k.a a(int i) {
            this.b = i;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.k.a a(com.meizu.cloud.pushsdk.c.c.c cVar) {
            this.d = cVar.c();
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.k.a a(com.meizu.cloud.pushsdk.c.c.i iVar) {
            this.a = iVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.k.a a(com.meizu.cloud.pushsdk.c.c.l lVar) {
            this.e = lVar;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.k.a a(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.k a() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.b >= 0) {
                return new com.meizu.cloud.pushsdk.c.c.k(this, null);
            }
            throw new java.lang.IllegalStateException("code < 0: " + this.b);
        }
    }

    private k(com.meizu.cloud.pushsdk.c.c.k.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public /* synthetic */ k(com.meizu.cloud.pushsdk.c.c.k.a aVar, com.meizu.cloud.pushsdk.c.c.k.AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public int a() {
        return this.b;
    }

    public com.meizu.cloud.pushsdk.c.c.l b() {
        return this.e;
    }

    public java.lang.String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.c + ", url=" + this.a.a() + '}';
    }
}
