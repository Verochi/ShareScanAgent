package com.efs.sdk.pa.a;

/* loaded from: classes22.dex */
final class e implements android.util.Printer {
    private long f;
    private boolean b = false;
    private java.lang.String c = null;
    private long d = -1;
    private long e = -1;
    java.util.Vector<com.efs.sdk.pa.a.d> a = new java.util.Vector<>();

    @Override // android.util.Printer
    public final void println(java.lang.String str) {
        if (str.startsWith(">")) {
            this.d = android.os.SystemClock.elapsedRealtime();
            this.e = android.os.SystemClock.currentThreadTimeMillis();
            this.c = str;
            this.b = true;
            java.util.Iterator<com.efs.sdk.pa.a.d> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            return;
        }
        if (this.b && str.startsWith("<")) {
            this.b = false;
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.d;
            if (elapsedRealtime > this.f) {
                long currentThreadTimeMillis = android.os.SystemClock.currentThreadTimeMillis() - this.e;
                java.util.Iterator<com.efs.sdk.pa.a.d> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.c, elapsedRealtime, currentThreadTimeMillis);
                }
            }
        }
    }
}
