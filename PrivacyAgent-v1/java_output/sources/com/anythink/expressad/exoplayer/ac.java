package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
public final class ac {
    public static final com.anythink.expressad.exoplayer.ac a;
    public static final com.anythink.expressad.exoplayer.ac b;
    public static final com.anythink.expressad.exoplayer.ac c;
    public static final com.anythink.expressad.exoplayer.ac d;
    public static final com.anythink.expressad.exoplayer.ac e;
    public final long f;
    public final long g;

    static {
        com.anythink.expressad.exoplayer.ac acVar = new com.anythink.expressad.exoplayer.ac(0L, 0L);
        a = acVar;
        b = new com.anythink.expressad.exoplayer.ac(Long.MAX_VALUE, Long.MAX_VALUE);
        c = new com.anythink.expressad.exoplayer.ac(Long.MAX_VALUE, 0L);
        d = new com.anythink.expressad.exoplayer.ac(0L, Long.MAX_VALUE);
        e = acVar;
    }

    public ac(long j, long j2) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        this.f = j;
        this.g = j2;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.ac.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.ac acVar = (com.anythink.expressad.exoplayer.ac) obj;
            if (this.f == acVar.f && this.g == acVar.g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f) * 31) + ((int) this.g);
    }
}
