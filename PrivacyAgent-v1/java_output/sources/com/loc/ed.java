package com.loc;

/* loaded from: classes23.dex */
public final class ed extends com.loc.eb {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public ed() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    public ed(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
    }

    @Override // com.loc.eb
    /* renamed from: a */
    public final com.loc.eb clone() {
        com.loc.ed edVar = new com.loc.ed(this.h, this.i);
        edVar.a(this);
        edVar.j = this.j;
        edVar.k = this.k;
        edVar.l = this.l;
        edVar.m = this.m;
        edVar.n = this.n;
        edVar.o = this.o;
        return edVar;
    }

    @Override // com.loc.eb
    public final java.lang.String toString() {
        return "AmapCellGsm{lac=" + this.j + ", cid=" + this.k + ", psc=" + this.l + ", arfcn=" + this.m + ", bsic=" + this.n + ", timingAdvance=" + this.o + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
