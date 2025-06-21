package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dv extends com.amap.api.col.s.dy {
    public android.content.Context e;
    public boolean f;
    public int g;
    public int h;
    public java.lang.String d = "iKey";
    public int i = 0;

    public dv(android.content.Context context, boolean z, int i, int i2, java.lang.String str, int i3) {
        d(context, z, i, i2, str, i3);
    }

    @Override // com.amap.api.col.s.dy
    public final void a(int i) {
        if (com.amap.api.col.s.bm.n(this.e) == 1) {
            return;
        }
        java.lang.String a = com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
        java.lang.String a2 = com.amap.api.col.s.ch.a(this.e, this.d);
        if (!android.text.TextUtils.isEmpty(a2)) {
            java.lang.String[] split = a2.split("\\|");
            if (split == null || split.length < 2) {
                com.amap.api.col.s.ch.b(this.e, this.d);
            } else if (a.equals(split[0])) {
                i += java.lang.Integer.parseInt(split[1]);
            }
        }
        com.amap.api.col.s.ch.a(this.e, this.d, a + "|" + i);
    }

    @Override // com.amap.api.col.s.dy
    public final boolean a() {
        if (com.amap.api.col.s.bm.n(this.e) == 1) {
            return true;
        }
        if (!this.f) {
            return false;
        }
        java.lang.String a = com.amap.api.col.s.ch.a(this.e, this.d);
        if (android.text.TextUtils.isEmpty(a)) {
            return true;
        }
        java.lang.String[] split = a.split("\\|");
        if (split != null && split.length >= 2) {
            return !com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || java.lang.Integer.parseInt(split[1]) < this.h;
        }
        com.amap.api.col.s.ch.b(this.e, this.d);
        return true;
    }

    @Override // com.amap.api.col.s.dy
    public final int b() {
        int i;
        if ((com.amap.api.col.s.bm.n(this.e) == 1 || (i = this.g) <= 0) && ((i = this.i) <= 0 || i >= Integer.MAX_VALUE)) {
            i = Integer.MAX_VALUE;
        }
        com.amap.api.col.s.dy dyVar = this.c;
        return dyVar != null ? java.lang.Math.max(i, dyVar.b()) : i;
    }

    public final void d(android.content.Context context, boolean z, int i, int i2, java.lang.String str, int i3) {
        this.e = context;
        this.f = z;
        this.g = i;
        this.h = i2;
        this.d = str;
        this.i = i3;
    }
}
