package com.loc;

/* loaded from: classes23.dex */
public final class ef extends com.loc.eb {
    public int j;
    public int k;
    public int l;
    public int m;

    public ef() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    public ef(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
    }

    @Override // com.loc.eb
    /* renamed from: a */
    public final com.loc.eb clone() {
        com.loc.ef efVar = new com.loc.ef(this.h, this.i);
        efVar.a(this);
        efVar.j = this.j;
        efVar.k = this.k;
        efVar.l = this.l;
        efVar.m = this.m;
        return efVar;
    }

    @Override // com.loc.eb
    public final java.lang.String toString() {
        return "AmapCellWcdma{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", uarfcn=" + this.m + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
