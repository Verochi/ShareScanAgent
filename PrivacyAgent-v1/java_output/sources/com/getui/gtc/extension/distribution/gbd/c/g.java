package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class g {
    private java.lang.String a;
    private int b;
    private int c;
    private int d;
    private int e;

    private java.lang.String a() {
        return this.a;
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(java.lang.String str) {
        this.a = str;
    }

    private int b() {
        return this.b;
    }

    private void b(int i) {
        this.c = i;
    }

    private int c() {
        return this.c;
    }

    private void c(int i) {
        this.d = i;
    }

    private int d() {
        return this.d;
    }

    private void d(int i) {
        this.e = i;
    }

    private int e() {
        return this.e;
    }

    public final boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.getui.gtc.extension.distribution.gbd.c.g)) {
            return false;
        }
        com.getui.gtc.extension.distribution.gbd.c.g gVar = (com.getui.gtc.extension.distribution.gbd.c.g) obj;
        return this.a.equals(gVar.a) && this.b == gVar.b && this.c == gVar.c;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
