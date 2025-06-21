package com.sijla.mla.a;

/* loaded from: classes19.dex */
public abstract class j extends com.sijla.mla.a.r {
    public static com.sijla.mla.a.r c;

    @Override // com.sijla.mla.a.r
    public final boolean E() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.j F() {
        return this;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.j G() {
        return this;
    }

    public final java.lang.String H() {
        java.lang.String name = getClass().getName();
        return name.substring(java.lang.Math.max(name.lastIndexOf(46), name.lastIndexOf(36)) + 1);
    }

    @Override // com.sijla.mla.a.r
    public final int a_() {
        return 6;
    }

    public java.lang.String b_() {
        return H();
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String c() {
        return com.sijla.mla.L2.s1767902568();
    }

    @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
    public java.lang.String g() {
        return "function: " + H();
    }

    @Override // com.sijla.mla.a.r
    public com.sijla.mla.a.r j() {
        return c;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.n s() {
        return com.sijla.mla.a.n.c(g());
    }
}
