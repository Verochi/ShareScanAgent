package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class p {
    public int a;
    public int b;
    public java.lang.String c;
    public long d;
    public int e;

    private int a() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    private void a(long j) {
        this.d = j;
    }

    private void a(java.lang.String str) {
        this.c = str;
    }

    private int b() {
        return this.b;
    }

    private void b(int i) {
        this.b = i;
    }

    private java.lang.String c() {
        return this.c;
    }

    private void c(int i) {
        this.e = i;
    }

    private long d() {
        return this.d;
    }

    private int e() {
        return this.e;
    }

    public final boolean equals(java.lang.Object obj) {
        try {
            if (!(obj instanceof com.getui.gtc.extension.distribution.gbd.c.p)) {
                return false;
            }
            com.getui.gtc.extension.distribution.gbd.c.p pVar = (com.getui.gtc.extension.distribution.gbd.c.p) obj;
            if (android.text.TextUtils.isEmpty(pVar.c) || android.text.TextUtils.isEmpty(this.c)) {
                return false;
            }
            return pVar.c.equals(this.c);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    public final int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        java.lang.String str = this.c;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.d;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }
}
