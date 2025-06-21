package com.loc;

/* loaded from: classes23.dex */
public final class cn extends com.loc.cq {
    private android.content.Context b;
    private boolean d;
    private int e;
    private int f;
    private java.lang.String a = "iKey";
    private int g = 0;

    public cn(android.content.Context context, boolean z, int i, int i2, java.lang.String str) {
        a(context, z, i, i2, str, 0);
    }

    public cn(android.content.Context context, boolean z, int i, int i2, java.lang.String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    private void a(android.content.Context context, boolean z, int i, int i2, java.lang.String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    @Override // com.loc.cq
    public final void a(int i) {
        if (com.loc.p.j(this.b) == 1) {
            return;
        }
        java.lang.String a = com.loc.y.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
        java.lang.String a2 = com.loc.au.a(this.b, this.a);
        if (!android.text.TextUtils.isEmpty(a2)) {
            java.lang.String[] split = a2.split("\\|");
            if (split == null || split.length < 2) {
                com.loc.au.b(this.b, this.a);
            } else if (a.equals(split[0])) {
                i += java.lang.Integer.parseInt(split[1]);
            }
        }
        com.loc.au.a(this.b, this.a, a + "|" + i);
    }

    @Override // com.loc.cq
    public final boolean a() {
        if (com.loc.p.j(this.b) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        java.lang.String a = com.loc.au.a(this.b, this.a);
        if (android.text.TextUtils.isEmpty(a)) {
            return true;
        }
        java.lang.String[] split = a.split("\\|");
        if (split != null && split.length >= 2) {
            return !com.loc.y.a(java.lang.System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || java.lang.Integer.parseInt(split[1]) < this.f;
        }
        com.loc.au.b(this.b, this.a);
        return true;
    }

    @Override // com.loc.cq
    public final int b() {
        int i;
        if ((com.loc.p.j(this.b) == 1 || (i = this.e) <= 0) && ((i = this.g) <= 0 || i >= Integer.MAX_VALUE)) {
            i = Integer.MAX_VALUE;
        }
        com.loc.cq cqVar = this.c;
        return cqVar != null ? java.lang.Math.max(i, cqVar.b()) : i;
    }
}
