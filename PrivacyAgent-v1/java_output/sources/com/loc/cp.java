package com.loc;

/* loaded from: classes23.dex */
public final class cp extends com.loc.cq {
    protected int a;
    protected long b;
    private java.lang.String d;
    private android.content.Context e;

    public cp(android.content.Context context, int i, java.lang.String str, com.loc.cq cqVar) {
        super(cqVar);
        this.a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.loc.cq
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            java.lang.String str = this.d;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.b = currentTimeMillis;
            com.loc.au.a(this.e, str, java.lang.String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.loc.cq
    public final boolean a() {
        if (this.b == 0) {
            java.lang.String a = com.loc.au.a(this.e, this.d);
            this.b = android.text.TextUtils.isEmpty(a) ? 0L : java.lang.Long.parseLong(a);
        }
        return java.lang.System.currentTimeMillis() - this.b >= ((long) this.a);
    }
}
