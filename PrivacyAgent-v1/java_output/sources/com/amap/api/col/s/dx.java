package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dx extends com.amap.api.col.s.dy {
    protected int a;
    protected long b;
    public java.lang.String d;
    public android.content.Context e;

    public dx(android.content.Context context, int i, java.lang.String str, com.amap.api.col.s.dy dyVar) {
        super(dyVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.s.dy
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            java.lang.String str = this.d;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.b = currentTimeMillis;
            com.amap.api.col.s.ch.a(this.e, str, java.lang.String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.s.dy
    public final boolean a() {
        if (this.b == 0) {
            java.lang.String a = com.amap.api.col.s.ch.a(this.e, this.d);
            this.b = android.text.TextUtils.isEmpty(a) ? 0L : java.lang.Long.parseLong(a);
        }
        return java.lang.System.currentTimeMillis() - this.b >= ((long) this.a);
    }
}
