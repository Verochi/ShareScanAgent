package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class d {
    int a;
    private com.sijla.mla.a.r[] b;

    public d(com.sijla.mla.a.r[] rVarArr, int i) {
        this.b = rVarArr;
        this.a = i;
    }

    public final com.sijla.mla.a.r a() {
        return this.b[this.a];
    }

    public final void a(com.sijla.mla.a.r rVar) {
        this.b[this.a] = rVar;
    }

    public final void b() {
        com.sijla.mla.a.r[] rVarArr = this.b;
        int i = this.a;
        this.b = new com.sijla.mla.a.r[]{rVarArr[i]};
        rVarArr[i] = null;
        this.a = 0;
    }

    public final java.lang.String toString() {
        return this.a + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.b.length + " " + this.b[this.a];
    }
}
