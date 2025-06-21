package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jr extends com.amap.api.mapcore.util.jn {
    public int j;
    public int k;
    public int l;
    public int m;

    public jr(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.jn
    /* renamed from: a */
    public final com.amap.api.mapcore.util.jn clone() {
        com.amap.api.mapcore.util.jr jrVar = new com.amap.api.mapcore.util.jr(this.h, this.i);
        jrVar.a(this);
        jrVar.j = this.j;
        jrVar.k = this.k;
        jrVar.l = this.l;
        jrVar.m = this.m;
        return jrVar;
    }

    @Override // com.amap.api.mapcore.util.jn
    public final java.lang.String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + '}' + super.toString();
    }
}
