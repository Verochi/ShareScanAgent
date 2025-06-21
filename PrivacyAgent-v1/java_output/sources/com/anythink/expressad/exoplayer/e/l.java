package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public final class l {
    public static final com.anythink.expressad.exoplayer.e.l a = new com.anythink.expressad.exoplayer.e.l(0, 0);
    public final long b;
    public final long c;

    public l(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.exoplayer.e.l.class == obj.getClass()) {
            com.anythink.expressad.exoplayer.e.l lVar = (com.anythink.expressad.exoplayer.e.l) obj;
            if (this.b == lVar.b && this.c == lVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.b) * 31) + ((int) this.c);
    }

    public final java.lang.String toString() {
        return "[timeUs=" + this.b + ", position=" + this.c + "]";
    }
}
