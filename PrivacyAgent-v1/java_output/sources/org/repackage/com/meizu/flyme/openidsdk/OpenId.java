package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
class OpenId {
    public long a;
    public java.lang.String b;
    public java.lang.String c;
    public int d;

    public OpenId(java.lang.String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(long j) {
        this.a = j;
    }

    public void c(java.lang.String str) {
        this.b = str;
    }

    public boolean d() {
        return this.a > java.lang.System.currentTimeMillis();
    }

    public void e() {
        this.a = 0L;
    }
}
