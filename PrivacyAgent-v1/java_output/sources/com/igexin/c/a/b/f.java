package com.igexin.c.a.b;

/* loaded from: classes22.dex */
public abstract class f extends com.igexin.c.a.d.f {
    protected static final int e = -2048;
    public java.lang.String b;
    public com.igexin.c.a.b.d c;
    public java.lang.Object d;

    private f(int i, com.igexin.c.a.b.d dVar) {
        this(i, null, dVar);
    }

    public f(int i, java.lang.String str, com.igexin.c.a.b.d dVar) {
        super(i);
        if (str != null) {
            java.lang.String[] a = com.igexin.c.a.b.g.a(str);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (!a[0].equals("")) {
                sb.append(a[0]);
                sb.append("://");
            }
            if (!a[1].equals("")) {
                sb.append(a[1]);
            }
            if (!a[2].equals("")) {
                sb.append(':');
                sb.append(a[2]);
            }
            if (!a[3].equals("")) {
                sb.append(a[3]);
                if (!a[3].equals(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    sb.append('/');
                }
            }
            if (!a[4].equals("")) {
                sb.append(a[4]);
            }
            if (!a[5].equals("")) {
                sb.append('?');
                sb.append(a[5]);
            }
            this.b = sb.toString();
        }
        this.c = dVar;
    }

    public f(java.lang.String str, com.igexin.c.a.b.d dVar) {
        this(0, str, dVar);
    }

    private static java.lang.String a(java.lang.String str) {
        java.lang.String[] a = com.igexin.c.a.b.g.a(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!a[0].equals("")) {
            sb.append(a[0]);
            sb.append("://");
        }
        if (!a[1].equals("")) {
            sb.append(a[1]);
        }
        if (!a[2].equals("")) {
            sb.append(':');
            sb.append(a[2]);
        }
        if (!a[3].equals("")) {
            sb.append(a[3]);
            if (!a[3].equals(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                sb.append('/');
            }
        }
        if (!a[4].equals("")) {
            sb.append(a[4]);
        }
        if (!a[5].equals("")) {
            sb.append('?');
            sb.append(a[5]);
        }
        return sb.toString();
    }

    private void a(com.igexin.c.a.b.f fVar) {
        super.a((com.igexin.c.a.d.f) fVar);
        this.b = fVar.b;
        this.c = fVar.c;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public void a() {
        com.igexin.c.a.b.d dVar = this.c;
        if (dVar != null) {
            dVar.b();
        }
        super.a();
    }
}
