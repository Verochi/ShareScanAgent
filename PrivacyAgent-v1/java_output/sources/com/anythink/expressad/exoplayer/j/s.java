package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public interface s extends com.anythink.expressad.exoplayer.j.h {
    public static final com.anythink.expressad.exoplayer.k.u<java.lang.String> c = new com.anythink.expressad.exoplayer.j.s.AnonymousClass1();

    /* renamed from: com.anythink.expressad.exoplayer.j.s$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.k.u<java.lang.String> {
        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static boolean a2(java.lang.String str) {
            java.lang.String d = com.anythink.expressad.exoplayer.k.af.d(str);
            if (android.text.TextUtils.isEmpty(d)) {
                return false;
            }
            return ((d.contains("text") && !d.contains("text/vtt")) || d.contains(com.baidu.mobads.sdk.internal.a.f) || d.contains(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML)) ? false : true;
        }

        @Override // com.anythink.expressad.exoplayer.k.u
        public final /* synthetic */ boolean a(java.lang.String str) {
            java.lang.String d = com.anythink.expressad.exoplayer.k.af.d(str);
            if (android.text.TextUtils.isEmpty(d)) {
                return false;
            }
            return ((d.contains("text") && !d.contains("text/vtt")) || d.contains(com.baidu.mobads.sdk.internal.a.f) || d.contains(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML)) ? false : true;
        }
    }

    public static abstract class a implements com.anythink.expressad.exoplayer.j.s.b {
        private final com.anythink.expressad.exoplayer.j.s.f a = new com.anythink.expressad.exoplayer.j.s.f();

        public abstract com.anythink.expressad.exoplayer.j.s a(com.anythink.expressad.exoplayer.j.s.f fVar);

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @java.lang.Deprecated
        public final void a(java.lang.String str) {
            this.a.a(str);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @java.lang.Deprecated
        public final void a(java.lang.String str, java.lang.String str2) {
            this.a.a(str, str2);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b, com.anythink.expressad.exoplayer.j.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.anythink.expressad.exoplayer.j.s a() {
            return a(this.a);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        public final com.anythink.expressad.exoplayer.j.s.f c() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @java.lang.Deprecated
        public final void d() {
            this.a.a();
        }
    }

    public interface b extends com.anythink.expressad.exoplayer.j.h.a {
        @Override // com.anythink.expressad.exoplayer.j.h.a
        /* synthetic */ com.anythink.expressad.exoplayer.j.h a();

        @java.lang.Deprecated
        void a(java.lang.String str);

        @java.lang.Deprecated
        void a(java.lang.String str, java.lang.String str2);

        /* renamed from: b */
        com.anythink.expressad.exoplayer.j.s a();

        com.anythink.expressad.exoplayer.j.s.f c();

        @java.lang.Deprecated
        void d();
    }

    public static class c extends java.io.IOException {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public final int d;
        public final com.anythink.expressad.exoplayer.j.k e;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface a {
        }

        private c(com.anythink.expressad.exoplayer.j.k kVar, int i) {
            this.e = kVar;
            this.d = i;
        }

        public c(java.io.IOException iOException, com.anythink.expressad.exoplayer.j.k kVar, int i) {
            super(iOException);
            this.e = kVar;
            this.d = i;
        }

        public c(java.lang.String str, com.anythink.expressad.exoplayer.j.k kVar) {
            super(str);
            this.e = kVar;
            this.d = 1;
        }

        public c(java.lang.String str, java.io.IOException iOException, com.anythink.expressad.exoplayer.j.k kVar) {
            super(str, iOException);
            this.e = kVar;
            this.d = 1;
        }
    }

    public static final class d extends com.anythink.expressad.exoplayer.j.s.c {
        public final java.lang.String f;

        public d(java.lang.String str, com.anythink.expressad.exoplayer.j.k kVar) {
            super("Invalid content type: ".concat(java.lang.String.valueOf(str)), kVar);
            this.f = str;
        }
    }

    public static final class e extends com.anythink.expressad.exoplayer.j.s.c {
        public final int f;
        public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> g;

        public e(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.anythink.expressad.exoplayer.j.k kVar) {
            super("Response code: ".concat(java.lang.String.valueOf(i)), kVar);
            this.f = i;
            this.g = map;
        }
    }

    public static final class f {
        private final java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();
        private java.util.Map<java.lang.String, java.lang.String> b;

        private synchronized void a(java.util.Map<java.lang.String, java.lang.String> map) {
            this.b = null;
            this.a.putAll(map);
        }

        private synchronized void b(java.util.Map<java.lang.String, java.lang.String> map) {
            this.b = null;
            this.a.clear();
            this.a.putAll(map);
        }

        public final synchronized void a() {
            this.b = null;
            this.a.clear();
        }

        public final synchronized void a(java.lang.String str) {
            this.b = null;
            this.a.remove(str);
        }

        public final synchronized void a(java.lang.String str, java.lang.String str2) {
            this.b = null;
            this.a.put(str, str2);
        }

        public final synchronized java.util.Map<java.lang.String, java.lang.String> b() {
            if (this.b == null) {
                this.b = java.util.Collections.unmodifiableMap(new java.util.HashMap(this.a));
            }
            return this.b;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    int a(byte[] bArr, int i, int i2);

    @Override // com.anythink.expressad.exoplayer.j.h
    long a(com.anythink.expressad.exoplayer.j.k kVar);

    void a(java.lang.String str);

    void a(java.lang.String str, java.lang.String str2);

    @Override // com.anythink.expressad.exoplayer.j.h
    void b();

    java.util.Map<java.lang.String, java.util.List<java.lang.String>> c();

    void d();
}
