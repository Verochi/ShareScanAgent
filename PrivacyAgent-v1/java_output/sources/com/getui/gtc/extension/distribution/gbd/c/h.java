package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class h {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;

    public h(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    private java.lang.String a() {
        return this.a;
    }

    private void a(java.lang.String str) {
        this.a = str;
    }

    private java.lang.String b() {
        return this.b;
    }

    private void b(java.lang.String str) {
        this.b = str;
    }

    private java.lang.String c() {
        return this.c;
    }

    private void c(java.lang.String str) {
        this.c = str;
    }

    private static boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String upperCase = str.toUpperCase();
        upperCase.hashCode();
        switch (upperCase) {
        }
        return false;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj instanceof com.getui.gtc.extension.distribution.gbd.c.h) {
            com.getui.gtc.extension.distribution.gbd.c.h hVar = (com.getui.gtc.extension.distribution.gbd.c.h) obj;
            if (hVar.a.equals(this.a) && hVar.b.equals(this.b) && d(this.c) == d(hVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return java.util.Objects.hash(this.a, this.b, java.lang.Boolean.valueOf(d(this.c)));
    }

    public final java.lang.String toString() {
        return "LanMacBean{ip='" + this.a + "', mac='" + this.b + "', status='" + this.c + "'}";
    }
}
