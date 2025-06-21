package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public final class g {
    public final int a;
    private final com.anythink.expressad.exoplayer.i.f[] b;
    private int c;

    public g(com.anythink.expressad.exoplayer.i.f... fVarArr) {
        this.b = fVarArr;
        this.a = fVarArr.length;
    }

    @androidx.annotation.Nullable
    public final com.anythink.expressad.exoplayer.i.f a(int i) {
        return this.b[i];
    }

    public final com.anythink.expressad.exoplayer.i.f[] a() {
        return (com.anythink.expressad.exoplayer.i.f[]) this.b.clone();
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.anythink.expressad.exoplayer.i.g.class != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.b, ((com.anythink.expressad.exoplayer.i.g) obj).b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = java.util.Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }
}
