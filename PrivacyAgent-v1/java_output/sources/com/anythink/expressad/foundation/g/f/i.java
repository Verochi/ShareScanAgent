package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public abstract class i<T> implements java.lang.Comparable<com.anythink.expressad.foundation.g.f.i<T>> {
    private static final java.lang.String c = "i";
    protected java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> a;
    protected com.anythink.expressad.foundation.g.f.e<T> b;
    private final int d;
    private final java.lang.String e;
    private java.lang.Integer f;
    private com.anythink.expressad.foundation.g.f.j g;
    private boolean h;
    private com.anythink.expressad.foundation.g.f.l i;
    private java.lang.Object j;

    public interface a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
    }

    public class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        private b() {
        }
    }

    public i(int i, java.lang.String str, com.anythink.expressad.foundation.g.f.e<T> eVar) {
        this.a = new java.util.concurrent.ConcurrentHashMap<>();
        this.h = false;
        this.e = str;
        this.d = i;
        this.b = eVar;
        this.i = new com.anythink.expressad.foundation.g.f.b();
    }

    public i(java.lang.String str) {
        this.a = new java.util.concurrent.ConcurrentHashMap<>();
        this.b = null;
        this.h = false;
        this.e = str;
        this.d = 0;
        this.i = new com.anythink.expressad.foundation.g.f.b();
    }

    private int a(com.anythink.expressad.foundation.g.f.i<T> iVar) {
        int j = j();
        int j2 = iVar.j();
        return j == j2 ? this.f.intValue() - iVar.f.intValue() : j2 - j;
    }

    public static com.anythink.expressad.foundation.g.f.a.a a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.anythink.expressad.foundation.g.f.i<?> a(java.lang.Object obj) {
        this.j = obj;
        return this;
    }

    private void a(java.lang.String str) {
        this.a.remove(str);
    }

    private static byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        try {
            java.io.InputStream c2 = bVar.c();
            try {
                if (com.anythink.expressad.foundation.g.f.g.d.b(bVar.b()) && !(c2 instanceof java.util.zip.GZIPInputStream)) {
                    c2 = new java.util.zip.GZIPInputStream(c2);
                }
                if (c2 == null) {
                    throw new com.anythink.expressad.foundation.g.f.a.a(7, null);
                }
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = c2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        c2.close();
                        byteArrayOutputStream2.close();
                    } catch (java.io.IOException e) {
                        e.getMessage();
                    }
                    return byteArray;
                } catch (java.lang.Throwable th) {
                    inputStream = c2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (java.io.IOException e2) {
                            e2.getMessage();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = c2;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    private int p() {
        java.lang.Integer num = this.f;
        if (num != null) {
            return num.intValue();
        }
        throw new java.lang.IllegalStateException("getSequence called before setSequence");
    }

    private static void q() {
    }

    private static void r() {
    }

    public final int a() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.anythink.expressad.foundation.g.f.i<?> a(int i) {
        this.f = java.lang.Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.anythink.expressad.foundation.g.f.i<?> a(com.anythink.expressad.foundation.g.f.j jVar) {
        this.g = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.anythink.expressad.foundation.g.f.i<?> a(com.anythink.expressad.foundation.g.f.l lVar) {
        this.i = lVar;
        return this;
    }

    public abstract com.anythink.expressad.foundation.g.f.k<T> a(com.anythink.expressad.foundation.g.f.f.c cVar);

    public final void a(long j, long j2) {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(j, j2);
        }
    }

    public final void a(com.anythink.expressad.foundation.g.f.e<T> eVar) {
        this.b = eVar;
    }

    public final void a(com.anythink.expressad.foundation.g.f.k<T> kVar) {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(kVar);
        }
    }

    public void a(java.io.OutputStream outputStream) {
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        this.a.remove(str);
        this.a.put(str, str2);
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar, com.anythink.expressad.foundation.g.f.c cVar) {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    public final java.lang.Object b() {
        return this.j;
    }

    public final void b(com.anythink.expressad.foundation.g.f.a.a aVar) {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public final void c() {
        com.anythink.expressad.foundation.g.f.j jVar = this.g;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(java.lang.Object obj) {
        com.anythink.expressad.foundation.g.f.i iVar = (com.anythink.expressad.foundation.g.f.i) obj;
        int j = j();
        int j2 = iVar.j();
        return j == j2 ? this.f.intValue() - iVar.f.intValue() : j2 - j;
    }

    public final java.lang.String d() {
        return this.e;
    }

    public final void e() {
        this.h = true;
    }

    public final boolean f() {
        return this.h;
    }

    public final java.util.Map<java.lang.String, java.lang.String> g() {
        return this.a;
    }

    public byte[] h() {
        return null;
    }

    public void i() {
        a(com.google.common.net.HttpHeaders.CONNECTION, "close");
        a("Charset", "UTF-8");
    }

    public int j() {
        return 2;
    }

    public final int k() {
        return this.i.b();
    }

    public final com.anythink.expressad.foundation.g.f.l l() {
        return this.i;
    }

    public final void m() {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void n() {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void o() {
        com.anythink.expressad.foundation.g.f.e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.h ? "[X] " : "[ ] ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(j());
        sb.append(" ");
        sb.append(this.f);
        return sb.toString();
    }
}
