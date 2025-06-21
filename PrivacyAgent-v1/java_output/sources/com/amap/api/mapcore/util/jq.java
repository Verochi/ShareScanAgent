package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jq extends com.amap.api.mapcore.util.jn {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public jq(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.mapcore.util.jn
    /* renamed from: a */
    public final com.amap.api.mapcore.util.jn clone() {
        com.amap.api.mapcore.util.jq jqVar = new com.amap.api.mapcore.util.jq(this.h);
        jqVar.a(this);
        jqVar.j = this.j;
        jqVar.k = this.k;
        jqVar.l = this.l;
        jqVar.m = this.m;
        jqVar.n = this.n;
        return jqVar;
    }

    @Override // com.amap.api.mapcore.util.jn
    public final java.lang.String toString() {
        return "AmapCellLte{lac=" + this.j + ", cid=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + '}' + super.toString();
    }
}
