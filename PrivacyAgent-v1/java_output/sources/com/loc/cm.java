package com.loc;

/* loaded from: classes23.dex */
public final class cm extends com.loc.cq {
    private int a;
    private java.lang.String b;

    public cm(java.lang.String str, com.loc.cq cqVar) {
        super(cqVar);
        this.a = 30;
        this.b = str;
    }

    private static int a(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.loc.cq
    public final boolean a() {
        return a(this.b) >= this.a;
    }
}
