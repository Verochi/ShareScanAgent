package com.loc;

/* loaded from: classes23.dex */
public final class ec extends com.loc.eb {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public ec() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    public ec(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.loc.eb
    /* renamed from: a */
    public final com.loc.eb clone() {
        com.loc.ec ecVar = new com.loc.ec(this.h, this.i);
        ecVar.a(this);
        ecVar.j = this.j;
        ecVar.k = this.k;
        ecVar.l = this.l;
        ecVar.m = this.m;
        ecVar.n = this.n;
        return ecVar;
    }

    @Override // com.loc.eb
    public final java.lang.String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
