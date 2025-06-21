package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dz extends com.amap.api.col.s.dy {
    public android.content.Context d;
    public boolean e = false;

    public dz(android.content.Context context) {
        this.d = context;
    }

    @Override // com.amap.api.col.s.dy
    public final boolean a() {
        return com.amap.api.col.s.bm.n(this.d) == 1 || this.e;
    }
}
