package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jp extends com.amap.api.mapcore.util.jn {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public jp(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.jn
    /* renamed from: a */
    public final com.amap.api.mapcore.util.jn clone() {
        com.amap.api.mapcore.util.jp jpVar = new com.amap.api.mapcore.util.jp(this.h, this.i);
        jpVar.a(this);
        jpVar.j = this.j;
        jpVar.k = this.k;
        jpVar.l = this.l;
        jpVar.m = this.m;
        jpVar.n = this.n;
        jpVar.o = this.o;
        return jpVar;
    }

    @Override // com.amap.api.mapcore.util.jn
    public final java.lang.String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + '}' + super.toString();
    }
}
