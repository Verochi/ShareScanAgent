package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class o2 {
    public final com.zx.a.I8b7.x a;
    public final java.util.List<com.zx.a.I8b7.n0> b;
    public final javax.net.ssl.SSLSocketFactory c;
    public final javax.net.ssl.HostnameVerifier d;
    public final boolean e;
    public final int f;
    public final int g;

    public static final class a {
        public javax.net.ssl.SSLSocketFactory c;
        public final java.util.List<com.zx.a.I8b7.n0> b = new java.util.ArrayList();
        public com.zx.a.I8b7.x a = new com.zx.a.I8b7.x();
        public boolean e = true;
        public int f = com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
        public int g = com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
        public javax.net.ssl.HostnameVerifier d = com.zx.a.I8b7.n2.a;
    }

    public o2(com.zx.a.I8b7.o2.a aVar) {
        this.a = aVar.a;
        java.util.List<com.zx.a.I8b7.n0> a2 = com.zx.a.I8b7.c2.a(aVar.b);
        this.b = a2;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        if (a2.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: ".concat(java.lang.String.valueOf(a2)));
        }
    }
}
