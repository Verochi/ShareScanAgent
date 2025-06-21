package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class j extends com.anythink.core.common.f.ai {
    public static final int a = 1;
    public static final int b = 2;
    private java.lang.String W;
    private java.lang.String X;
    private int ar = 1;

    public final java.lang.String a() {
        return this.X;
    }

    public final void a(int i) {
        this.ar = i;
    }

    public final void a(java.lang.String str) {
        this.X = str;
    }

    public final java.lang.String b() {
        return this.W;
    }

    public final void b(java.lang.String str) {
        this.W = str;
    }

    public final int c() {
        return this.ar;
    }

    @Override // com.anythink.core.common.f.l
    public final int d() {
        return this.ar == 1 ? 2 : 4;
    }
}
