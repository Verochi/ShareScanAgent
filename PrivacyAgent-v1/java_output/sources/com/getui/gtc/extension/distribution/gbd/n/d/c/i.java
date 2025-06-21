package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
public final class i {
    private static final char c = '\\';
    private java.lang.String a;
    private int b = 0;

    public i(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        this.a = str;
    }

    private void a(java.lang.Character ch) {
        this.a = ch.toString() + this.a.substring(this.b);
        this.b = 0;
    }

    private boolean a(char... cArr) {
        if (a()) {
            return false;
        }
        for (char c2 : cArr) {
            if (this.a.charAt(this.b) == c2) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String f(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c2 = 0;
        while (i < length) {
            char c3 = charArray[i];
            if (c3 != '\\' || (c2 != 0 && c2 == '\\')) {
                sb.append(c3);
            }
            i++;
            c2 = c3;
        }
        return sb.toString();
    }

    private void g(java.lang.String str) {
        this.a = str + this.a.substring(this.b);
        this.b = 0;
    }

    private int h() {
        return this.a.length() - this.b;
    }

    private boolean h(java.lang.String str) {
        return this.a.startsWith(str, this.b);
    }

    private char i() {
        if (a()) {
            return (char) 0;
        }
        return this.a.charAt(this.b);
    }

    private java.lang.String i(java.lang.String str) {
        int i;
        int i2;
        int i3 = this.b;
        java.lang.String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!a() && !a(str)) {
            if (equals) {
                int indexOf = this.a.indexOf(substring, this.b);
                int i4 = this.b;
                int i5 = indexOf - i4;
                if (i5 == 0) {
                    i2 = i4 + 1;
                } else if (i5 < 0) {
                    i = this.a.length();
                } else {
                    i2 = i4 + i5;
                }
                this.b = i2;
            } else {
                i = this.b + 1;
            }
            this.b = i;
        }
        return this.a.substring(i3, this.b);
    }

    private java.lang.String j(java.lang.String str) {
        int i;
        int i2;
        int i3 = this.b;
        java.lang.String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!a() && !a(str)) {
            if (equals) {
                int indexOf = this.a.indexOf(substring, this.b);
                int i4 = this.b;
                int i5 = indexOf - i4;
                if (i5 == 0) {
                    i2 = i4 + 1;
                } else if (i5 < 0) {
                    i = this.a.length();
                } else {
                    i2 = i4 + i5;
                }
                this.b = i2;
            } else {
                i = this.b + 1;
            }
            this.b = i;
        }
        java.lang.String substring2 = this.a.substring(i3, this.b);
        b(str);
        return substring2;
    }

    private boolean j() {
        return h() >= 2 && this.a.charAt(this.b) == '<' && java.lang.Character.isLetter(this.a.charAt(this.b + 1));
    }

    private boolean k() {
        return !a() && com.getui.gtc.extension.distribution.gbd.n.d.a.d.b(this.a.charAt(this.b));
    }

    private void l() {
        if (a()) {
            return;
        }
        this.b++;
    }

    private java.lang.String m() {
        int i = this.b;
        while (b()) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    private java.lang.String n() {
        int i = this.b;
        while (!a() && (b() || a(':', '_', '-'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    private java.lang.String o() {
        int i = this.b;
        while (!a() && (b() || a('-', '_', ':'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public final java.lang.String a(char c2, char c3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char c4 = 0;
        int i = 0;
        while (!a()) {
            java.lang.Character valueOf = java.lang.Character.valueOf(c());
            if (c4 == 0 || c4 != '\\') {
                if (valueOf.equals(java.lang.Character.valueOf(c2))) {
                    i++;
                } else if (valueOf.equals(java.lang.Character.valueOf(c3))) {
                    i--;
                }
            }
            if (i > 0 && c4 != 0) {
                sb.append(valueOf);
            }
            c4 = valueOf.charValue();
            if (i <= 0) {
                break;
            }
        }
        return sb.toString();
    }

    public final boolean a() {
        return h() == 0;
    }

    public final boolean a(java.lang.String str) {
        return this.a.regionMatches(true, this.b, str, 0, str.length());
    }

    public final boolean a(java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (a(str)) {
                return true;
            }
        }
        return false;
    }

    public final java.lang.String b(java.lang.String... strArr) {
        int i = this.b;
        while (!a() && !a(strArr)) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public final boolean b() {
        return !a() && java.lang.Character.isLetterOrDigit(this.a.charAt(this.b));
    }

    public final boolean b(java.lang.String str) {
        if (!a(str)) {
            return false;
        }
        this.b += str.length();
        return true;
    }

    public final char c() {
        java.lang.String str = this.a;
        int i = this.b;
        this.b = i + 1;
        return str.charAt(i);
    }

    public final void c(java.lang.String str) {
        if (!a(str)) {
            throw new java.lang.IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > h()) {
            throw new java.lang.IllegalStateException("Queue not long enough to consume sequence");
        }
        this.b += length;
    }

    public final java.lang.String d(java.lang.String str) {
        int indexOf = this.a.indexOf(str, this.b);
        if (indexOf == -1) {
            return g();
        }
        java.lang.String substring = this.a.substring(this.b, indexOf);
        this.b += substring.length();
        return substring;
    }

    public final boolean d() {
        boolean z = false;
        while (true) {
            if (!(!a() && com.getui.gtc.extension.distribution.gbd.n.d.a.d.b(this.a.charAt(this.b)))) {
                return z;
            }
            this.b++;
            z = true;
        }
    }

    public final java.lang.String e() {
        int i = this.b;
        while (!a() && (b() || a('|', '_', '-'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public final java.lang.String e(java.lang.String str) {
        java.lang.String d = d(str);
        b(str);
        return d;
    }

    public final java.lang.String f() {
        int i = this.b;
        while (!a() && (b() || a('-', '_'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public final java.lang.String g() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (!a()) {
            sb.append(c());
        }
        return sb.toString();
    }

    public final java.lang.String toString() {
        return this.a.substring(this.b);
    }
}
