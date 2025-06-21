package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.exoplayer.h.b.d.b {
    private static final java.lang.String a = "BaseMediaChunkOutput";
    private final int[] b;
    private final com.anythink.expressad.exoplayer.h.x[] c;

    public b(int[] iArr, com.anythink.expressad.exoplayer.h.x[] xVarArr) {
        this.b = iArr;
        this.c = xVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.d.b
    public final com.anythink.expressad.exoplayer.e.m a(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.b;
            if (i2 >= iArr.length) {
                "Unmatched track of type: ".concat(java.lang.String.valueOf(i));
                return new com.anythink.expressad.exoplayer.e.d();
            }
            if (i == iArr[i2]) {
                return this.c[i2];
            }
            i2++;
        }
    }

    public final void a(long j) {
        for (com.anythink.expressad.exoplayer.h.x xVar : this.c) {
            if (xVar != null) {
                xVar.a(j);
            }
        }
    }

    public final int[] a() {
        int[] iArr = new int[this.c.length];
        int i = 0;
        while (true) {
            com.anythink.expressad.exoplayer.h.x[] xVarArr = this.c;
            if (i >= xVarArr.length) {
                return iArr;
            }
            com.anythink.expressad.exoplayer.h.x xVar = xVarArr[i];
            if (xVar != null) {
                iArr[i] = xVar.b();
            }
            i++;
        }
    }
}
