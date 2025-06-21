package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
final class a {
    static final char a = 65535;
    final java.lang.String b;
    int c = 0;
    int d = 0;
    private final int e;

    public a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.lang.String replaceAll = str.replaceAll("\r\n?", "\n");
        this.b = replaceAll;
        this.e = replaceAll.length();
    }

    private java.lang.String c(java.lang.String str) {
        int indexOf = this.b.indexOf(str, this.c);
        if (indexOf == -1) {
            return g();
        }
        java.lang.String substring = this.b.substring(this.c, indexOf);
        this.c += substring.length();
        return substring;
    }

    private boolean d(java.lang.String str) {
        return this.b.startsWith(str, this.c);
    }

    private boolean e(java.lang.String str) {
        return this.b.regionMatches(true, this.c, str, 0, str.length());
    }

    private boolean f(java.lang.String str) {
        return this.b.indexOf(str.toLowerCase(), this.c) >= 0 || this.b.indexOf(str.toUpperCase(), this.c) >= 0;
    }

    private int j() {
        return this.c;
    }

    private void k() {
        this.d = this.c;
    }

    private java.lang.String l() {
        java.lang.String str = this.b;
        int i = this.c;
        this.c = i + 1;
        return str.substring(i, i);
    }

    private java.lang.String m() {
        char charAt;
        char charAt2;
        int i = this.c;
        while (!a() && (((charAt2 = this.b.charAt(this.c)) >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
            this.c++;
        }
        while (!a() && (charAt = this.b.charAt(this.c)) >= '0' && charAt <= '9') {
            this.c++;
        }
        return this.b.substring(i, this.c);
    }

    private java.lang.String n() {
        char charAt;
        int i = this.c;
        while (!a() && (((charAt = this.b.charAt(this.c)) >= '0' && charAt <= '9') || ((charAt >= 'A' && charAt <= 'F') || (charAt >= 'a' && charAt <= 'f')))) {
            this.c++;
        }
        return this.b.substring(i, this.c);
    }

    private java.lang.String o() {
        char charAt;
        int i = this.c;
        while (!a() && (charAt = this.b.charAt(this.c)) >= '0' && charAt <= '9') {
            this.c++;
        }
        return this.b.substring(i, this.c);
    }

    private boolean p() {
        char charAt;
        return !a() && (charAt = this.b.charAt(this.c)) >= '0' && charAt <= '9';
    }

    public final java.lang.String a(char c) {
        int indexOf = this.b.indexOf(c, this.c);
        if (indexOf == -1) {
            return g();
        }
        java.lang.String substring = this.b.substring(this.c, indexOf);
        this.c += substring.length();
        return substring;
    }

    public final java.lang.String a(char... cArr) {
        int i = this.c;
        loop0: while (!a()) {
            char charAt = this.b.charAt(this.c);
            for (char c : cArr) {
                if (c == charAt) {
                    break loop0;
                }
            }
            this.c++;
        }
        int i2 = this.c;
        return i2 > i ? this.b.substring(i, i2) : "";
    }

    public final boolean a() {
        return this.c >= this.e;
    }

    public final boolean a(java.lang.String str) {
        if (!this.b.startsWith(str, this.c)) {
            return false;
        }
        this.c += str.length();
        return true;
    }

    public final char b() {
        if (a()) {
            return (char) 65535;
        }
        return this.b.charAt(this.c);
    }

    public final boolean b(char c) {
        return !a() && this.b.charAt(this.c) == c;
    }

    public final boolean b(java.lang.String str) {
        if (!this.b.regionMatches(true, this.c, str, 0, str.length())) {
            return false;
        }
        this.c += str.length();
        return true;
    }

    public final boolean b(char... cArr) {
        if (a()) {
            return false;
        }
        char charAt = this.b.charAt(this.c);
        for (char c : cArr) {
            if (c == charAt) {
                return true;
            }
        }
        return false;
    }

    public final char c() {
        char charAt = a() ? (char) 65535 : this.b.charAt(this.c);
        this.c++;
        return charAt;
    }

    public final void d() {
        this.c--;
    }

    public final void e() {
        this.c++;
    }

    public final void f() {
        this.c = this.d;
    }

    public final java.lang.String g() {
        java.lang.String str = this.b;
        java.lang.String substring = str.substring(this.c, str.length());
        this.c = this.b.length();
        return substring;
    }

    public final java.lang.String h() {
        char charAt;
        int i = this.c;
        while (!a() && (((charAt = this.b.charAt(this.c)) >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z'))) {
            this.c++;
        }
        return this.b.substring(i, this.c);
    }

    public final boolean i() {
        if (a()) {
            return false;
        }
        char charAt = this.b.charAt(this.c);
        if (charAt < 'A' || charAt > 'Z') {
            return charAt >= 'a' && charAt <= 'z';
        }
        return true;
    }

    public final java.lang.String toString() {
        return this.b.substring(this.c);
    }
}
