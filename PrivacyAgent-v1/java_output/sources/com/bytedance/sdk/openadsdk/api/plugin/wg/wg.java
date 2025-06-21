package com.bytedance.sdk.openadsdk.api.plugin.wg;

/* loaded from: classes31.dex */
final class wg {
    private char[] bt;
    private int kz;
    private int t;
    private int v;
    private final java.lang.String vw;
    private final int wg;
    private int yl;

    public wg(javax.security.auth.x500.X500Principal x500Principal) {
        java.lang.String name = x500Principal.getName("RFC2253");
        this.vw = name;
        this.wg = name.length();
    }

    private char kz() {
        int i;
        int i2;
        int vw = vw(this.t);
        this.t++;
        if (vw < 128) {
            return (char) vw;
        }
        if (vw < 192 || vw > 247) {
            return '?';
        }
        if (vw <= 223) {
            i = vw & 31;
            i2 = 1;
        } else if (vw <= 239) {
            i = vw & 15;
            i2 = 2;
        } else {
            i = vw & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.t + 1;
            this.t = i4;
            if (i4 == this.wg || this.bt[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.t = i5;
            int vw2 = vw(i5);
            this.t++;
            if ((vw2 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (vw2 & 63);
        }
        return (char) i;
    }

    private java.lang.String t() {
        int i;
        char[] cArr;
        char c;
        int i2 = this.t;
        if (i2 + 4 >= this.wg) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
        }
        this.v = i2;
        this.t = i2 + 1;
        while (true) {
            i = this.t;
            if (i == this.wg || (c = (cArr = this.bt)[i]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.yl = i;
                this.t = i + 1;
                while (true) {
                    int i3 = this.t;
                    if (i3 >= this.wg || this.bt[i3] != ' ') {
                        break;
                    }
                    this.t = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i] = (char) (c + ' ');
                }
                this.t = i + 1;
            }
        }
        this.yl = i;
        int i4 = this.yl;
        int i5 = this.v;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) vw(i8);
            i8 += 2;
        }
        return new java.lang.String(this.bt, this.v, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.kz - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String v() {
        char[] cArr;
        int i;
        int i2;
        char c;
        int i3 = this.t;
        this.v = i3;
        this.yl = i3;
        while (true) {
            int i4 = this.t;
            if (i4 >= this.wg) {
                char[] cArr2 = this.bt;
                int i5 = this.v;
                return new java.lang.String(cArr2, i5, this.yl - i5);
            }
            cArr = this.bt;
            char c2 = cArr[i4];
            if (c2 == ' ') {
                int i6 = this.yl;
                this.kz = i6;
                this.t = i4 + 1;
                this.yl = i6 + 1;
                cArr[i6] = ' ';
                while (true) {
                    i = this.t;
                    i2 = this.wg;
                    if (i >= i2) {
                        break;
                    }
                    char[] cArr3 = this.bt;
                    if (cArr3[i] != ' ') {
                        break;
                    }
                    int i7 = this.yl;
                    this.yl = i7 + 1;
                    cArr3[i7] = ' ';
                    this.t = i + 1;
                }
                if (i == i2 || (c = this.bt[i]) == ',' || c == '+' || c == ';') {
                    break;
                }
            } else {
                if (c2 == ';') {
                    break;
                }
                if (c2 == '\\') {
                    int i8 = this.yl;
                    this.yl = i8 + 1;
                    cArr[i8] = yl();
                    this.t++;
                } else {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i9 = this.yl;
                    this.yl = i9 + 1;
                    cArr[i9] = c2;
                    this.t = i4 + 1;
                }
            }
        }
        int i10 = this.v;
        return new java.lang.String(cArr, i10, this.yl - i10);
    }

    private int vw(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.wg) {
            throw new java.lang.IllegalStateException("Malformed DN: " + this.vw);
        }
        char[] cArr = this.bt;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.vw);
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
                throw new java.lang.IllegalStateException("Malformed DN: " + this.vw);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private java.lang.String vw() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.t;
            i2 = this.wg;
            if (i >= i2 || this.bt[i] != ' ') {
                break;
            }
            this.t = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.v = i;
        this.t = i + 1;
        while (true) {
            i3 = this.t;
            i4 = this.wg;
            if (i3 >= i4 || (c3 = this.bt[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.t = i3 + 1;
        }
        if (i3 >= i4) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
        }
        this.yl = i3;
        if (this.bt[i3] == ' ') {
            while (true) {
                i6 = this.t;
                i7 = this.wg;
                if (i6 >= i7 || (c2 = this.bt[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.t = i6 + 1;
            }
            if (this.bt[i6] != '=' || i6 == i7) {
                throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
            }
        }
        do {
            i5 = this.t + 1;
            this.t = i5;
            if (i5 >= this.wg) {
                break;
            }
        } while (this.bt[i5] == ' ');
        int i8 = this.yl;
        int i9 = this.v;
        if (i8 - i9 > 4) {
            char[] cArr = this.bt;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.v = i9 + 4;
            }
        }
        char[] cArr2 = this.bt;
        int i10 = this.v;
        return new java.lang.String(cArr2, i10, i8 - i10);
    }

    private java.lang.String wg() {
        int i = this.t + 1;
        this.t = i;
        this.v = i;
        this.yl = i;
        while (true) {
            int i2 = this.t;
            if (i2 == this.wg) {
                throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
            }
            char[] cArr = this.bt;
            char c = cArr[i2];
            if (c == '\"') {
                this.t = i2 + 1;
                while (true) {
                    int i3 = this.t;
                    if (i3 >= this.wg || this.bt[i3] != ' ') {
                        break;
                    }
                    this.t = i3 + 1;
                }
                char[] cArr2 = this.bt;
                int i4 = this.v;
                return new java.lang.String(cArr2, i4, this.yl - i4);
            }
            if (c == '\\') {
                cArr[this.yl] = yl();
            } else {
                cArr[this.yl] = c;
            }
            this.t++;
            this.yl++;
        }
    }

    private char yl() {
        int i = this.t + 1;
        this.t = i;
        if (i == this.wg) {
            throw new java.lang.IllegalStateException("Unexpected end of DN: " + this.vw);
        }
        char c = this.bt[i];
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
                        return kz();
                }
        }
    }

    public java.lang.String vw(java.lang.String str) {
        this.t = 0;
        this.v = 0;
        this.yl = 0;
        this.kz = 0;
        this.bt = this.vw.toCharArray();
        java.lang.String vw = vw();
        if (vw == null) {
            return null;
        }
        do {
            int i = this.t;
            if (i == this.wg) {
                return null;
            }
            char c = this.bt[i];
            java.lang.String v = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : v() : t() : wg();
            if (str.equalsIgnoreCase(vw)) {
                return v;
            }
            int i2 = this.t;
            if (i2 >= this.wg) {
                return null;
            }
            char c2 = this.bt[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new java.lang.IllegalStateException("Malformed DN: " + this.vw);
            }
            this.t = i2 + 1;
            vw = vw();
        } while (vw != null);
        throw new java.lang.IllegalStateException("Malformed DN: " + this.vw);
    }
}
