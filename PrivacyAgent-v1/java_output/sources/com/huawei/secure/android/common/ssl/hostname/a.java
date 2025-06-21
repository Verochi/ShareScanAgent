package com.huawei.secure.android.common.ssl.hostname;

/* loaded from: classes22.dex */
public class a {
    public final java.lang.String a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public char[] g;

    public a(javax.security.auth.x500.X500Principal x500Principal) {
        java.lang.String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    public final int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.b) {
            throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
        }
        char[] cArr = this.g;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public java.lang.String a(java.lang.String str) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        java.lang.String f = f();
        if (f == null) {
            return null;
        }
        do {
            int i = this.c;
            if (i == this.b) {
                return null;
            }
            char c = this.g[i];
            java.lang.String b = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : b() : e() : g();
            if (str.equalsIgnoreCase(f)) {
                return b;
            }
            int i2 = this.c;
            if (i2 >= this.b) {
                return null;
            }
            char c2 = this.g[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
            }
            this.c = i2 + 1;
            f = f();
        } while (f != null);
        throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.String b() {
        char[] cArr;
        int i;
        int i2;
        char c;
        int i3 = this.c;
        this.d = i3;
        this.e = i3;
        while (true) {
            int i4 = this.c;
            if (i4 >= this.b) {
                char[] cArr2 = this.g;
                int i5 = this.d;
                return new java.lang.String(cArr2, i5, this.e - i5);
            }
            cArr = this.g;
            char c2 = cArr[i4];
            if (c2 == ' ') {
                int i6 = this.e;
                this.f = i6;
                this.c = i4 + 1;
                this.e = i6 + 1;
                cArr[i6] = ' ';
                while (true) {
                    i = this.c;
                    i2 = this.b;
                    if (i >= i2) {
                        break;
                    }
                    char[] cArr3 = this.g;
                    if (cArr3[i] != ' ') {
                        break;
                    }
                    int i7 = this.e;
                    this.e = i7 + 1;
                    cArr3[i7] = ' ';
                    this.c = i + 1;
                }
                if (i == i2 || (c = this.g[i]) == ',' || c == '+' || c == ';') {
                    break;
                }
            } else {
                if (c2 == ';') {
                    break;
                }
                if (c2 == '\\') {
                    int i8 = this.e;
                    this.e = i8 + 1;
                    cArr[i8] = c();
                    this.c++;
                } else {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i9 = this.e;
                    this.e = i9 + 1;
                    cArr[i9] = c2;
                    this.c = i4 + 1;
                }
            }
        }
        int i10 = this.d;
        return new java.lang.String(cArr, i10, this.e - i10);
    }

    public java.util.List<java.lang.String> b(java.lang.String str) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        java.util.List<java.lang.String> emptyList = java.util.Collections.emptyList();
        java.lang.String f = f();
        if (f == null) {
            return emptyList;
        }
        do {
            int i = this.c;
            if (i < this.b) {
                char c = this.g[i];
                java.lang.String b = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : b() : e() : g();
                if (str.equalsIgnoreCase(f)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new java.util.ArrayList<>();
                    }
                    emptyList.add(b);
                }
                int i2 = this.c;
                if (i2 < this.b) {
                    char c2 = this.g[i2];
                    if (c2 != ',' && c2 != ';' && c2 != '+') {
                        throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
                    }
                    this.c = i2 + 1;
                    f = f();
                }
            }
            return emptyList;
        } while (f != null);
        throw new java.lang.IllegalStateException("Malformed DN: " + this.a);
    }

    public final char c() {
        int i = this.c + 1;
        this.c = i;
        if (i == this.b) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
        }
        char c = this.g[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return d();
                }
        }
    }

    public final char d() {
        int i;
        int i2;
        int a = a(this.c);
        this.c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i = a & 31;
            i2 = 1;
        } else if (a <= 239) {
            i = a & 15;
            i2 = 2;
        } else {
            i = a & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 == this.b || this.g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.c = i5;
            int a2 = a(i5);
            this.c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (a2 & 63);
        }
        return (char) i;
    }

    public final java.lang.String e() {
        int i;
        char[] cArr;
        char c;
        int i2 = this.c;
        if (i2 + 4 >= this.b) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.d = i2;
        this.c = i2 + 1;
        while (true) {
            i = this.c;
            if (i == this.b || (c = (cArr = this.g)[i]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.e = i;
                this.c = i + 1;
                while (true) {
                    int i3 = this.c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.c = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i] = (char) (c + ' ');
                }
                this.c = i + 1;
            }
        }
        this.e = i;
        int i4 = this.e;
        int i5 = this.d;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) a(i8);
            i8 += 2;
        }
        return new java.lang.String(this.g, this.d, i6);
    }

    public final java.lang.String f() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        char c2;
        char c3;
        int i5;
        int i6;
        char c4;
        char c5;
        while (true) {
            i = this.c;
            i2 = this.b;
            if (i >= i2 || this.g[i] != ' ') {
                break;
            }
            this.c = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.d = i;
        this.c = i + 1;
        while (true) {
            i3 = this.c;
            i4 = this.b;
            if (i3 >= i4 || (c5 = this.g[i3]) == '=' || c5 == ' ') {
                break;
            }
            this.c = i3 + 1;
        }
        if (i3 >= i4) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.e = i3;
        if (this.g[i3] == ' ') {
            while (true) {
                i5 = this.c;
                i6 = this.b;
                if (i5 >= i6 || (c4 = this.g[i5]) == '=' || c4 != ' ') {
                    break;
                }
                this.c = i5 + 1;
            }
            if (this.g[i5] != '=' || i5 == i6) {
                throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        this.c++;
        while (true) {
            int i7 = this.c;
            if (i7 >= this.b || this.g[i7] != ' ') {
                break;
            }
            this.c = i7 + 1;
        }
        int i8 = this.e;
        int i9 = this.d;
        if (i8 - i9 > 4) {
            char[] cArr = this.g;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && (((c2 = cArr[i9 + 1]) == 'I' || c2 == 'i') && ((c3 = cArr[i9 + 2]) == 'D' || c3 == 'd')))) {
                this.d = i9 + 4;
            }
        }
        char[] cArr2 = this.g;
        int i10 = this.d;
        return new java.lang.String(cArr2, i10, i8 - i10);
    }

    public final java.lang.String g() {
        int i = this.c + 1;
        this.c = i;
        this.d = i;
        this.e = i;
        while (true) {
            int i2 = this.c;
            if (i2 == this.b) {
                throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char[] cArr = this.g;
            char c = cArr[i2];
            if (c == '\"') {
                this.c = i2 + 1;
                while (true) {
                    int i3 = this.c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.c = i3 + 1;
                }
                char[] cArr2 = this.g;
                int i4 = this.d;
                return new java.lang.String(cArr2, i4, this.e - i4);
            }
            if (c == '\\') {
                cArr[this.e] = c();
            } else {
                cArr[this.e] = c;
            }
            this.c++;
            this.e++;
        }
    }
}
