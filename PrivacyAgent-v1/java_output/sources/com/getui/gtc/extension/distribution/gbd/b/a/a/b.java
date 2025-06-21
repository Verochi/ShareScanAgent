package com.getui.gtc.extension.distribution.gbd.b.a.a;

/* loaded from: classes22.dex */
public final class b {
    public static final int a = 16;
    private static final long f = android.system.Os.sysconf(android.system.OsConstants._SC_CLK_TCK);
    public int b;
    public int c;
    public int d;
    public int e;

    private long a() {
        return a(this.b);
    }

    private static long a(int i) {
        return ((i & (-1)) * 1000) / f;
    }

    public static com.getui.gtc.extension.distribution.gbd.b.a.a.b a(java.nio.ByteBuffer byteBuffer) {
        if (!(byteBuffer != null && byteBuffer.remaining() >= 16)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.b.a.a.b bVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.b();
        bVar.b = byteBuffer.getInt();
        bVar.c = byteBuffer.getInt();
        bVar.d = byteBuffer.getInt();
        bVar.e = byteBuffer.getInt();
        return bVar;
    }

    private long b() {
        return a(this.c);
    }

    private static boolean b(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer != null && byteBuffer.remaining() >= 16;
    }

    private long c() {
        return a(this.d);
    }

    public final java.lang.String toString() {
        return "NdaCacheInfo{ ndm_used{" + a(this.b) + "}, ndm_confirmed{" + a(this.c) + "}, ndm_updated{" + a(this.d) + "}, ndm_refcnt{" + this.e + "} }";
    }
}
