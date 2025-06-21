package com.loc;

/* loaded from: classes23.dex */
public final class ee extends com.loc.eb {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public ee() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    public ee(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.loc.eb
    /* renamed from: a */
    public final com.loc.eb clone() {
        com.loc.ee eeVar = new com.loc.ee(this.h);
        eeVar.a(this);
        eeVar.j = this.j;
        eeVar.k = this.k;
        eeVar.l = this.l;
        eeVar.m = this.m;
        eeVar.n = this.n;
        return eeVar;
    }

    @Override // com.loc.eb
    public final java.lang.String toString() {
        return "AmapCellLte{tac=" + this.j + ", ci=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
