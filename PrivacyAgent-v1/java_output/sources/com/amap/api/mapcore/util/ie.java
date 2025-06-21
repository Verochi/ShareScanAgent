package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ie extends com.amap.api.mapcore.util.Cif {
    protected int a;
    protected long b;
    private java.lang.String d;
    private android.content.Context e;

    public ie(android.content.Context context, int i, java.lang.String str, com.amap.api.mapcore.util.Cif cif) {
        super(cif);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final void a_(boolean z) {
        super.a_(z);
        if (z) {
            java.lang.String str = this.d;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.b = currentTimeMillis;
            com.amap.api.mapcore.util.gb.a(this.e, str, java.lang.String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final boolean c() {
        if (this.b == 0) {
            java.lang.String a = com.amap.api.mapcore.util.gb.a(this.e, this.d);
            this.b = android.text.TextUtils.isEmpty(a) ? 0L : java.lang.Long.parseLong(a);
        }
        return java.lang.System.currentTimeMillis() - this.b >= ((long) this.a);
    }
}
