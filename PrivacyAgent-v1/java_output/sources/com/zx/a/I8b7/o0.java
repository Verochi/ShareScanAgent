package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class o0 implements com.zx.a.I8b7.j0 {
    public com.zx.a.I8b7.l0 a;
    public boolean b = true;

    public o0(com.zx.a.I8b7.l0 l0Var) {
        this.a = (com.zx.a.I8b7.l0) com.zx.a.I8b7.f2.a(l0Var);
    }

    @Override // com.zx.a.I8b7.j0
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if ((i & 240) != 0) {
            i &= 15;
        }
        this.a.a(i, str, str2, th);
    }

    @Override // com.zx.a.I8b7.j0
    public boolean a(int i, java.lang.String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.b;
        }
        return false;
    }
}
