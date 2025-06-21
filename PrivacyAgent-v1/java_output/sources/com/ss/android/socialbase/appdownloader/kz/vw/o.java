package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
public class o extends java.lang.Exception {
    protected int t;
    protected java.lang.Throwable vw;
    protected int wg;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public o(java.lang.String str, com.ss.android.socialbase.appdownloader.kz.vw.bt btVar, java.lang.Throwable th) {
        super(r0.toString());
        java.lang.String str2;
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (btVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + btVar.v() + ") ";
        }
        sb.append(str3);
        sb.append(th != null ? "caused by: ".concat(java.lang.String.valueOf(th)) : "");
        this.wg = -1;
        this.t = -1;
        if (btVar != null) {
            this.wg = btVar.t();
            this.t = btVar.kz();
        }
        this.vw = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.vw == null) {
            super.printStackTrace();
            return;
        }
        synchronized (java.lang.System.err) {
            java.lang.System.err.println(super.getMessage() + "; nested exception is:");
            this.vw.printStackTrace();
        }
    }
}
