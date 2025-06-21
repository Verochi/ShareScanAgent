package com.sijla.h;

/* loaded from: classes19.dex */
public final class f {
    public com.sijla.mla.a.n a;
    public final boolean b;
    public final short c;

    public f(com.sijla.mla.a.n nVar, boolean z, int i) {
        this.a = nVar;
        this.b = z;
        this.c = (short) i;
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (com.sijla.b.g.b() == null) {
            com.sijla.b.g.a(context);
        }
        com.sijla.a.a.a(new com.sijla.h.g(context, str, str2, "", "-1"));
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((int) this.c);
        sb.append(this.b ? " instack " : " closed ");
        sb.append(java.lang.String.valueOf(this.a));
        return sb.toString();
    }
}
