package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class g implements com.anythink.expressad.exoplayer.h.z {
    protected final com.anythink.expressad.exoplayer.h.z[] a;

    public g(com.anythink.expressad.exoplayer.h.z[] zVarArr) {
        this.a = zVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        for (com.anythink.expressad.exoplayer.h.z zVar : this.a) {
            zVar.a_(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long e = e();
            if (e == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (com.anythink.expressad.exoplayer.h.z zVar : this.a) {
                long e2 = zVar.e();
                boolean z3 = e2 != Long.MIN_VALUE && e2 <= j;
                if (e2 == e || z3) {
                    z |= zVar.c(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long j = Long.MAX_VALUE;
        for (com.anythink.expressad.exoplayer.h.z zVar : this.a) {
            long d = zVar.d();
            if (d != Long.MIN_VALUE) {
                j = java.lang.Math.min(j, d);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long j = Long.MAX_VALUE;
        for (com.anythink.expressad.exoplayer.h.z zVar : this.a) {
            long e = zVar.e();
            if (e != Long.MIN_VALUE) {
                j = java.lang.Math.min(j, e);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
