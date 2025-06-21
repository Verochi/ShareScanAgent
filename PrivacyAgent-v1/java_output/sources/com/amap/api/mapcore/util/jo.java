package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jo extends com.amap.api.mapcore.util.jn {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public jo(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.amap.api.mapcore.util.jn
    /* renamed from: a */
    public final com.amap.api.mapcore.util.jn clone() {
        com.amap.api.mapcore.util.jo joVar = new com.amap.api.mapcore.util.jo(this.h, this.i);
        joVar.a(this);
        this.j = joVar.j;
        this.k = joVar.k;
        this.l = joVar.l;
        this.m = joVar.m;
        this.n = joVar.n;
        return joVar;
    }

    @Override // com.amap.api.mapcore.util.jn
    public final java.lang.String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + '}' + super.toString();
    }
}
