package com.loc;

/* loaded from: classes23.dex */
public final class da extends com.loc.cx {
    private static com.loc.da b = new com.loc.da();

    private da() {
        super(com.badlogic.gdx.graphics.GL20.GL_BYTE);
    }

    private static java.lang.String a(java.lang.String str) {
        return str == null ? "" : str;
    }

    public static com.loc.da b() {
        return b;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, java.util.List<? extends com.loc.de> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int a = com.loc.dh.a((com.loc.gf) this.a, bArr);
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                com.loc.de deVar = list.get(i);
                iArr[i] = com.loc.dm.a(this.a, (byte) deVar.a(), com.loc.dm.a(this.a, deVar.b()));
            }
            this.a.c(com.loc.dh.a(this.a, a, bArr2 != null ? com.loc.dh.b(this.a, bArr2) : 0, com.loc.dh.a(this.a, iArr)));
            return this.a.c();
        } catch (java.lang.Throwable th) {
            com.loc.el.a(th);
            return null;
        }
    }

    public final byte[] c() {
        super.a();
        try {
            this.a.c(com.loc.ek.a(this.a, com.loc.ej.a(), this.a.a(com.loc.ej.f()), this.a.a(com.loc.ej.c()), (byte) com.loc.ej.m(), this.a.a(com.loc.ej.i()), this.a.a(com.loc.ej.h()), this.a.a(a(com.loc.ej.g())), this.a.a(a(com.loc.ej.j())), com.loc.ei.a(com.loc.ej.n()), this.a.a(com.loc.ej.l()), this.a.a(com.loc.ej.k()), this.a.a(com.loc.ej.d()), this.a.a(com.loc.ej.e())));
            return this.a.c();
        } catch (java.lang.Exception e) {
            com.loc.el.a(e);
            return null;
        }
    }
}
