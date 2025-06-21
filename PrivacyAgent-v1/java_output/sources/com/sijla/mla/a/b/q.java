package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class q extends com.sijla.mla.a.b.s {
    private static final com.sijla.mla.a.n a = com.sijla.mla.a.n.c("^$*+?.([%-");
    private static final byte[] b = new byte[256];

    public static class a {
        public final int a;
        public final int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;

        public a(com.sijla.mla.a.n nVar, int i) {
            int N = nVar.N();
            int i2 = 0;
            int i3 = i;
            boolean z = true;
            int i4 = 0;
            while (z) {
                if (i3 < N) {
                    i4 = nVar.h(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                if (i4 == 32) {
                    this.f = true;
                } else if (i4 == 35) {
                    this.g = true;
                } else if (i4 == 43) {
                    this.e = true;
                } else if (i4 == 45) {
                    this.c = true;
                } else if (i4 != 48) {
                    z = false;
                } else {
                    this.d = true;
                }
            }
            if (i3 - i > 5) {
                com.sijla.mla.a.r.d("invalid format (repeated flags)");
            }
            this.h = -1;
            if (java.lang.Character.isDigit((char) i4)) {
                this.h = i4 - 48;
                if (i3 < N) {
                    i4 = nVar.h(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                if (java.lang.Character.isDigit((char) i4)) {
                    this.h = (this.h * 10) + (i4 - 48);
                    if (i3 < N) {
                        i4 = nVar.h(i3);
                        i3++;
                    } else {
                        i4 = 0;
                    }
                }
            }
            this.i = -1;
            if (i4 == 46) {
                if (i3 < N) {
                    i4 = nVar.h(i3);
                    i3++;
                } else {
                    i4 = 0;
                }
                if (java.lang.Character.isDigit((char) i4)) {
                    this.i = i4 - 48;
                    if (i3 < N) {
                        i4 = nVar.h(i3);
                        i3++;
                    } else {
                        i4 = 0;
                    }
                    if (java.lang.Character.isDigit((char) i4)) {
                        this.i = (this.i * 10) + (i4 - 48);
                        if (i3 < N) {
                            i2 = nVar.h(i3);
                            i3++;
                        }
                        i4 = i2;
                    }
                }
            }
            if (java.lang.Character.isDigit((char) i4)) {
                com.sijla.mla.a.r.d("invalid format (width or precision too long)");
            }
            this.d &= !this.c;
            this.a = i4;
            this.b = i3 - i;
        }

        private static void a(com.sijla.mla.a.a aVar, char c, int i) {
            byte b = (byte) c;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                aVar.a(b);
                i = i2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(com.sijla.mla.a.a aVar, long j) {
            int i;
            java.lang.String l;
            int i2;
            int i3;
            if (j == 0 && this.i == 0) {
                l = "";
            } else {
                int i4 = this.a;
                if (i4 != 88) {
                    if (i4 == 111) {
                        i = 8;
                    } else if (i4 != 120) {
                        i = 10;
                    }
                    l = java.lang.Long.toString(j, i);
                    if (this.a == 88) {
                        l = l.toUpperCase();
                    }
                }
                i = 16;
                l = java.lang.Long.toString(j, i);
                if (this.a == 88) {
                }
            }
            int length = l.length();
            if (j < 0) {
                i2 = length;
                length--;
            } else {
                i2 = (this.e || this.f) ? length + 1 : length;
            }
            int i5 = this.i;
            int i6 = i5 > length ? i5 - length : (i5 == -1 && this.d && (i3 = this.h) > i2) ? i3 - i2 : 0;
            int i7 = i2 + i6;
            int i8 = this.h;
            int i9 = i8 > i7 ? i8 - i7 : 0;
            if (!this.c) {
                a(aVar, ' ', i9);
            }
            if (j < 0) {
                if (i6 > 0) {
                    aVar.a((byte) 45);
                    l = l.substring(1);
                }
            } else if (this.e) {
                aVar.a((byte) 43);
            } else if (this.f) {
                aVar.a((byte) 32);
            }
            if (i6 > 0) {
                a(aVar, '0', i6);
            }
            aVar.a(l);
            if (this.c) {
                a(aVar, ' ', i9);
            }
        }
    }

    public static class b extends com.sijla.mla.a.b.t {
        private final int a;
        private final com.sijla.mla.a.b.q.c b;
        private int f = 0;

        public b(com.sijla.mla.a.y yVar, com.sijla.mla.a.n nVar, com.sijla.mla.a.n nVar2) {
            this.a = nVar.N();
            this.b = new com.sijla.mla.a.b.q.c(yVar, nVar, nVar2);
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            while (true) {
                int i = this.f;
                if (i >= this.a) {
                    return com.sijla.mla.a.r.k;
                }
                com.sijla.mla.a.b.q.c cVar = this.b;
                cVar.a = 0;
                int a = cVar.a(i, 0);
                if (a >= 0) {
                    int i2 = this.f;
                    this.f = a;
                    return this.b.a(true, i2, a);
                }
                this.f++;
            }
        }
    }

    public static class c {
        private com.sijla.mla.a.n b;
        private com.sijla.mla.a.n c;
        private com.sijla.mla.a.y d;
        int a = 0;
        private int[] e = new int[32];
        private int[] f = new int[32];

        public c(com.sijla.mla.a.y yVar, com.sijla.mla.a.n nVar, com.sijla.mla.a.n nVar2) {
            this.b = nVar;
            this.c = nVar2;
            this.d = yVar;
        }

        private int a(int i) {
            int i2 = i + 1;
            int h = this.c.h(i);
            if (h == 37) {
                if (i2 == this.c.N()) {
                    com.sijla.mla.a.r.d("malformed pattern (ends with %)");
                }
                return i2 + 1;
            }
            if (h != 91) {
                return i2;
            }
            if (this.c.h(i2) == 94) {
                i2++;
            }
            do {
                if (i2 == this.c.N()) {
                    com.sijla.mla.a.r.d("malformed pattern (missing ])");
                }
                int i3 = i2 + 1;
                if (this.c.h(i2) == 37 && i3 != this.c.N()) {
                    i3++;
                }
                i2 = i3;
            } while (this.c.h(i2) != 93);
            return i2 + 1;
        }

        private com.sijla.mla.a.r a(int i, int i2, int i3) {
            if (i >= this.a) {
                return i == 0 ? this.b.a(i2, i3) : com.sijla.mla.a.r.d("invalid capture index");
            }
            int i4 = this.f[i];
            if (i4 == -1) {
                return com.sijla.mla.a.r.d("unfinished capture");
            }
            if (i4 == -2) {
                return com.sijla.mla.a.r.o(this.e[i] + 1);
            }
            int i5 = this.e[i];
            return this.b.a(i5, i4 + i5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
        
            if ((r1 & Byte.MIN_VALUE) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x003f, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0043, code lost:
        
            if ((r1 & 9) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0048, code lost:
        
            if ((r1 & 8) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x004d, code lost:
        
            if ((r1 & com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0050, code lost:
        
            if (r5 == 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0055, code lost:
        
            if ((r1 & 4) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x005a, code lost:
        
            if ((r1 & 32) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x005f, code lost:
        
            if ((r1 & 16) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0064, code lost:
        
            if ((r1 & 2) != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0069, code lost:
        
            if ((r1 & 1) != 0) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean b(int i, int i2) {
            boolean z;
            char lowerCase = java.lang.Character.toLowerCase((char) i2);
            byte b = com.sijla.mla.a.b.q.b[i];
            if (lowerCase != 'a') {
                if (lowerCase != 'l') {
                    if (lowerCase != 'p') {
                        if (lowerCase != 's') {
                            if (lowerCase != 'u') {
                                if (lowerCase != 'z') {
                                    if (lowerCase != 'c') {
                                        if (lowerCase != 'd') {
                                            if (lowerCase != 'w') {
                                                if (lowerCase != 'x') {
                                                    return i2 == i;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return lowerCase == i2 ? z : !z;
        }

        private boolean b(int i, int i2, int i3) {
            boolean z;
            int i4;
            int i5 = i2 + 1;
            if (this.c.h(i5) == 94) {
                i2 = i5;
                z = false;
            } else {
                z = true;
            }
            while (true) {
                i2++;
                if (i2 >= i3) {
                    return !z;
                }
                if (this.c.h(i2) == 37) {
                    i2++;
                    if (b(i, this.c.h(i2))) {
                        return z;
                    }
                } else if (this.c.h(i2 + 1) != 45 || (i4 = i2 + 2) >= i3) {
                    if (this.c.h(i2) == i) {
                        return z;
                    }
                } else {
                    if (this.c.h(i4 - 2) <= i && i <= this.c.h(i4)) {
                        return z;
                    }
                    i2 = i4;
                }
            }
        }

        private boolean c(int i, int i2, int i3) {
            int h = this.c.h(i2);
            if (h == 37) {
                return b(i, this.c.h(i2 + 1));
            }
            if (h != 46) {
                return h != 91 ? this.c.h(i2) == i : b(i, i2, i3 - 1);
            }
            return true;
        }

        private int d(int i, int i2, int i3) {
            int i4 = 0;
            while (true) {
                int i5 = i + i4;
                if (i5 >= this.b.N() || !c(this.b.h(i5), i2, i3)) {
                    break;
                }
                i4++;
            }
            while (i4 >= 0) {
                int a = a(i + i4, i3 + 1);
                if (a != -1) {
                    return a;
                }
                i4--;
            }
            return -1;
        }

        private int e(int i, int i2, int i3) {
            int i4 = this.a;
            if (i4 >= 32) {
                com.sijla.mla.a.r.d("too many captures");
            }
            this.e[i4] = i;
            this.f[i4] = i3;
            this.a = i4 + 1;
            int a = a(i, i2);
            if (a == -1) {
                this.a--;
            }
            return a;
        }

        /* JADX WARN: Removed duplicated region for block: B:126:0x01e9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00c7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x019a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int a(int i, int i2) {
            int i3;
            int a;
            int h;
            while (i2 != this.c.N()) {
                int h2 = this.c.h(i2);
                if (h2 != 36) {
                    if (h2 == 37) {
                        int i4 = i2 + 1;
                        if (i4 == this.c.N()) {
                            com.sijla.mla.a.r.d("malformed pattern (ends with '%')");
                        }
                        int h3 = this.c.h(i4);
                        if (h3 == 98) {
                            int i5 = i2 + 2;
                            int N = this.c.N();
                            if (i5 == N || i5 + 1 == N) {
                                com.sijla.mla.a.r.d("unbalanced pattern");
                            }
                            int N2 = this.b.N();
                            if (i < N2 && this.b.h(i) == (h = this.c.h(i5))) {
                                int h4 = this.c.h(i5 + 1);
                                int i6 = 1;
                                while (true) {
                                    i++;
                                    if (i >= N2) {
                                        break;
                                    }
                                    if (this.b.h(i) == h4) {
                                        i6--;
                                        if (i6 == 0) {
                                            i++;
                                            break;
                                        }
                                    } else if (this.b.h(i) == h) {
                                        i6++;
                                    }
                                }
                            }
                            i = -1;
                            if (i == -1) {
                                return -1;
                            }
                            i2 += 4;
                        } else if (h3 != 102) {
                            int h5 = this.c.h(i4);
                            if (java.lang.Character.isDigit((char) h5)) {
                                int i7 = h5 - 49;
                                if (i7 < 0 || i7 >= this.a || this.f[i7] == -1) {
                                    com.sijla.mla.a.r.d("invalid capture index");
                                }
                                int i8 = this.f[i7];
                                if (this.b.N() - i >= i8) {
                                    com.sijla.mla.a.n nVar = this.b;
                                    if (com.sijla.mla.a.n.a(nVar, this.e[i7], nVar, i, i8)) {
                                        i += i8;
                                        if (i != -1) {
                                            return -1;
                                        }
                                        i2 += 2;
                                    }
                                }
                                i = -1;
                                if (i != -1) {
                                }
                            }
                        } else {
                            int i9 = i2 + 2;
                            if (this.c.h(i9) != 91) {
                                com.sijla.mla.a.r.d("Missing [ after %f in pattern");
                            }
                            i3 = a(i9);
                            int i10 = i3 - 1;
                            if (b(i == 0 ? -1 : this.b.h(i - 1), i9, i10) || b(this.b.h(i), i9, i10)) {
                                return -1;
                            }
                            i2 = i3;
                        }
                    } else {
                        if (h2 == 40) {
                            int i11 = i2 + 1;
                            return (i11 >= this.c.N() || this.c.h(i11) != 41) ? e(i, i11, -1) : e(i, i11 + 1, -2);
                        }
                        if (h2 == 41) {
                            int i12 = i2 + 1;
                            int i13 = this.a - 1;
                            while (true) {
                                if (i13 < 0) {
                                    com.sijla.mla.a.r.d("invalid pattern capture");
                                    break;
                                }
                                if (this.f[i13] == -1) {
                                    r2 = i13;
                                    break;
                                }
                                i13--;
                            }
                            this.f[r2] = i - this.e[r2];
                            int a2 = a(i, i12);
                            if (a2 == -1) {
                                this.f[r2] = -1;
                            }
                            return a2;
                        }
                        i3 = a(i2);
                        boolean z = i >= this.b.N() && c(this.b.h(i), i2, i3);
                        r2 = i3 < this.c.N() ? this.c.h(i3) : 0;
                        if (r2 != 42) {
                            return d(i, i2, i3);
                        }
                        if (r2 == 43) {
                            if (z) {
                                return d(i + 1, i2, i3);
                            }
                            return -1;
                        }
                        if (r2 == 45) {
                            while (true) {
                                int a3 = a(i, i3 + 1);
                                if (a3 != -1) {
                                    return a3;
                                }
                                if (i >= this.b.N() || !c(this.b.h(i), i2, i3)) {
                                    break;
                                }
                                i++;
                            }
                            return -1;
                        }
                        if (r2 != 63) {
                            if (!z) {
                                return -1;
                            }
                            i++;
                            i2 = i3;
                        } else {
                            if (z && (a = a(i + 1, i3 + 1)) != -1) {
                                return a;
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
                if (i2 + 1 == this.c.N()) {
                    if (i == this.b.N()) {
                        return i;
                    }
                    return -1;
                }
                i3 = a(i2);
                if (i >= this.b.N()) {
                }
                if (i3 < this.c.N()) {
                }
                if (r2 != 42) {
                }
            }
            return i;
        }

        public final com.sijla.mla.a.y a(boolean z, int i, int i2) {
            int i3 = this.a;
            if (i3 == 0 && z) {
                i3 = 1;
            }
            if (i3 == 0) {
                return com.sijla.mla.a.r.n;
            }
            if (i3 == 1) {
                return a(0, i, i2);
            }
            com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                rVarArr[i4] = a(i4, i, i2);
            }
            return com.sijla.mla.a.r.a(rVarArr);
        }

        public final void a(com.sijla.mla.a.a aVar, int i, int i2, com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r a;
            int a_ = rVar.a_();
            int i3 = 0;
            if (a_ == 3 || a_ == 4) {
                com.sijla.mla.a.n s2 = rVar.s();
                int N = s2.N();
                while (i3 < N) {
                    byte h = (byte) s2.h(i3);
                    if (h == 37) {
                        i3++;
                        h = (byte) s2.h(i3);
                        if (java.lang.Character.isDigit((char) h)) {
                            aVar.a(h == 48 ? this.b.a(i, i2) : a(h - 49, i, i2).s());
                            i3++;
                        }
                    }
                    aVar.a(h);
                    i3++;
                }
                return;
            }
            if (a_ == 5) {
                a = rVar.a(a(0, i, i2));
            } else {
                if (a_ != 6) {
                    com.sijla.mla.a.r.d("bad argument: string/function/table expected");
                    return;
                }
                a = rVar.a(a(true, i, i2)).h();
            }
            if (!a.f()) {
                a = this.b.a(i, i2);
            } else if (!a.v()) {
                com.sijla.mla.a.r.d("invalid replacement value (a " + a.c() + ")");
            }
            aVar.a(a.s());
        }
    }

    public static final class d extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.n w = yVar.w(1);
            int i = w.d;
            int a = com.sijla.mla.a.b.q.a(yVar.c(2, 1), i);
            int a2 = com.sijla.mla.a.b.q.a(yVar.c(3, a), i);
            if (a <= 0) {
                a = 1;
            }
            if (a2 <= i) {
                i = a2;
            }
            if (a > i) {
                return com.sijla.mla.a.r.n;
            }
            int i2 = (i - a) + 1;
            if (a + i2 <= i) {
                com.sijla.mla.a.r.d("string slice too long");
            }
            com.sijla.mla.a.r[] rVarArr = new com.sijla.mla.a.r[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                rVarArr[i3] = com.sijla.mla.a.k.c_(w.h((a + i3) - 1));
            }
            return com.sijla.mla.a.r.a(rVarArr);
        }
    }

    public static final class e extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            int e = yVar.e();
            byte[] bArr = new byte[e];
            int i = 0;
            int i2 = 1;
            while (i < e) {
                int u = yVar.u(i2);
                if (u < 0 || u >= 256) {
                    com.sijla.mla.a.r.a(i2, "invalid value");
                }
                bArr[i] = (byte) u;
                i++;
                i2++;
            }
            return com.sijla.mla.a.n.b(bArr);
        }
    }

    public static final class f extends com.sijla.mla.a.b.l {
        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.j F = rVar.F();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                com.sijla.mla.a.a.b.a(((com.sijla.mla.a.g) F).a, byteArrayOutputStream);
                return com.sijla.mla.a.n.b(byteArrayOutputStream.toByteArray());
            } catch (java.io.IOException e) {
                return com.sijla.mla.a.r.d(e.getMessage());
            }
        }
    }

    public static final class g extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            return com.sijla.mla.a.b.q.a(yVar, true);
        }
    }

    public static final class h extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            java.lang.String str;
            long q;
            int i = 1;
            com.sijla.mla.a.n w = yVar.w(1);
            int N = w.N();
            com.sijla.mla.a.a aVar = new com.sijla.mla.a.a(N);
            int i2 = 0;
            while (i2 < N) {
                int i3 = i2 + 1;
                int h = w.h(i2);
                if (h != 10) {
                    if (h == 37) {
                        if (i3 < N) {
                            if (w.h(i3) == 37) {
                                i2 = i3 + 1;
                                aVar.a((byte) 37);
                            } else {
                                i++;
                                com.sijla.mla.a.b.q.a aVar2 = new com.sijla.mla.a.b.q.a(w, i3);
                                i3 += aVar2.b;
                                int i4 = aVar2.a;
                                if (i4 != 69 && i4 != 71) {
                                    if (i4 != 88) {
                                        if (i4 != 105) {
                                            if (i4 != 111) {
                                                if (i4 == 113) {
                                                    com.sijla.mla.a.b.q.a(aVar, yVar.w(i));
                                                } else if (i4 == 115) {
                                                    com.sijla.mla.a.n a = yVar.a(i, com.sijla.mla.a.n.c(com.sijla.mla.L2.s34781011()));
                                                    if (aVar2.i != -1 || a.N() < 100) {
                                                        int i5 = 0;
                                                        while (true) {
                                                            if (i5 >= a.d) {
                                                                i5 = -1;
                                                            } else if (a.b[a.c + i5] != 0) {
                                                                i5++;
                                                            }
                                                        }
                                                        if (i5 != -1) {
                                                            a = a.a(0, i5);
                                                        }
                                                    }
                                                    aVar.a(a);
                                                } else if (i4 != 117 && i4 != 120) {
                                                    switch (i4) {
                                                        case 99:
                                                            h = yVar.u(i);
                                                            break;
                                                        case 100:
                                                            break;
                                                        case 101:
                                                        case 102:
                                                        case 103:
                                                            break;
                                                        default:
                                                            com.sijla.mla.a.r.d("invalid option '%" + ((char) aVar2.a) + "' to 'format'");
                                                            break;
                                                    }
                                                }
                                            }
                                        }
                                        q = yVar.u(i);
                                        aVar2.a(aVar, q);
                                    }
                                    q = yVar.c(i).z().q();
                                    aVar2.a(aVar, q);
                                }
                                str = java.lang.String.valueOf(yVar.s(i));
                            }
                        }
                        i2 = i3;
                    }
                    aVar.a((byte) h);
                    i2 = i3;
                } else {
                    str = "\n";
                }
                aVar.a(str);
                i2 = i3;
            }
            return aVar.b();
        }
    }

    public static final class i extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            return new com.sijla.mla.a.b.q.b(yVar, yVar.w(1), yVar.w(2));
        }
    }

    public static final class j extends com.sijla.mla.a.b.t {
        /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
        
            if (r3.h(0) == 94) goto L12;
         */
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            int i = 1;
            com.sijla.mla.a.n w = yVar.w(1);
            int N = w.N();
            com.sijla.mla.a.n w2 = yVar.w(2);
            com.sijla.mla.a.r c = yVar.c(3);
            int c2 = yVar.c(4, N + 1);
            if (w2.N() > 0) {
                if (w2.d <= 0) {
                    throw new java.lang.IndexOutOfBoundsException();
                }
            }
            i = 0;
            com.sijla.mla.a.a aVar = new com.sijla.mla.a.a(N);
            com.sijla.mla.a.b.q.c cVar = new com.sijla.mla.a.b.q.c(yVar, w, w2);
            int i2 = 0;
            int i3 = 0;
            while (i2 < c2) {
                cVar.a = 0;
                int a = cVar.a(i3, i);
                if (a != -1) {
                    i2++;
                    cVar.a(aVar, i3, a, c);
                }
                if (a == -1 || a <= i3) {
                    if (i3 >= N) {
                        break;
                    }
                    a = i3 + 1;
                    aVar.a((byte) w.h(i3));
                }
                i3 = a;
                if (i != 0) {
                    break;
                }
            }
            aVar.a(w.a(i3, N));
            return com.sijla.mla.a.r.a((com.sijla.mla.a.r) aVar.b(), (com.sijla.mla.a.y) com.sijla.mla.a.k.c_(i2));
        }
    }

    public static final class k extends com.sijla.mla.a.b.l {
        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return rVar.C().M();
        }
    }

    public static final class l extends com.sijla.mla.a.b.l {
        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.n.c(rVar.B().toLowerCase());
        }
    }

    public static final class m extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            return com.sijla.mla.a.b.q.a(yVar, false);
        }
    }

    public static final class n extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.n w = yVar.w(1);
            int N = w.N() * yVar.u(2);
            byte[] bArr = new byte[N];
            int N2 = w.N();
            for (int i = 0; i < N; i += N2) {
                w.c(bArr, i, N2);
            }
            return com.sijla.mla.a.n.b(bArr);
        }
    }

    public static final class o extends com.sijla.mla.a.b.l {
        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.n C = rVar.C();
            int N = C.N();
            byte[] bArr = new byte[N];
            int i = N - 1;
            int i2 = 0;
            while (i2 < N) {
                bArr[i] = (byte) C.h(i2);
                i2++;
                i--;
            }
            return com.sijla.mla.a.n.b(bArr);
        }
    }

    public static final class p extends com.sijla.mla.a.b.t {
        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.n w = yVar.w(1);
            int N = w.N();
            int a = com.sijla.mla.a.b.q.a(yVar.u(2), N);
            int a2 = com.sijla.mla.a.b.q.a(yVar.c(3, -1), N);
            if (a <= 0) {
                a = 1;
            }
            if (a2 <= N) {
                N = a2;
            }
            return a <= N ? w.a(a - 1, N) : com.sijla.mla.a.r.J;
        }
    }

    /* renamed from: com.sijla.mla.a.b.q$q, reason: collision with other inner class name */
    public static final class C0463q extends com.sijla.mla.a.b.l {
        @Override // com.sijla.mla.a.b.l, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.n.c(rVar.B().toUpperCase());
        }
    }

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            char c2 = (char) i2;
            byte[] bArr = b;
            byte b2 = (byte) (((c2 < ' ' || c2 == 127) ? 64 : 0) | (java.lang.Character.isDigit(c2) ? 8 : 0) | (java.lang.Character.isLowerCase(c2) ? 2 : 0) | (java.lang.Character.isUpperCase(c2) ? 4 : 0));
            bArr[i2] = b2;
            if ((c2 >= 'a' && c2 <= 'f') || ((c2 >= 'A' && c2 <= 'F') || (c2 >= '0' && c2 <= '9'))) {
                bArr[i2] = (byte) (b2 | Byte.MIN_VALUE);
            }
            if ((c2 >= '!' && c2 <= '/') || (c2 >= ':' && c2 <= '@')) {
                bArr[i2] = (byte) (bArr[i2] | 16);
            }
            byte b3 = bArr[i2];
            if ((b3 & 6) != 0) {
                bArr[i2] = (byte) (b3 | 1);
            }
        }
        byte[] bArr2 = b;
        bArr2[32] = 32;
        bArr2[13] = (byte) (bArr2[13] | 32);
        bArr2[10] = (byte) (bArr2[10] | 32);
        bArr2[9] = (byte) (bArr2[9] | 32);
        byte b4 = (byte) (bArr2[12] | 32);
        bArr2[12] = b4;
        bArr2[12] = (byte) (b4 | 32);
    }

    public static /* synthetic */ int a(int i2, int i3) {
        return i2 >= 0 ? i2 : i3 + i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        if (r7 == (-1)) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.sijla.mla.a.y a(com.sijla.mla.a.y yVar, boolean z) {
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        com.sijla.mla.a.n w = yVar.w(1);
        com.sijla.mla.a.n w2 = yVar.w(2);
        int c2 = yVar.c(3, 1);
        if (c2 > 0) {
            c2 = java.lang.Math.min(c2 - 1, w.N());
        } else if (c2 < 0) {
            c2 = java.lang.Math.max(0, w.N() + c2);
        }
        if (z) {
            if (!yVar.c(4).f()) {
                com.sijla.mla.a.n nVar = a;
                int i4 = w2.c;
                int i5 = w2.d + i4;
                int i6 = nVar.c + nVar.d;
                loop0: while (true) {
                    if (i4 >= i5) {
                        i3 = -1;
                        break;
                    }
                    for (int i7 = nVar.c; i7 < i6; i7++) {
                        if (w2.b[i4] == nVar.b[i7]) {
                            i3 = i4 - w2.c;
                            break loop0;
                        }
                    }
                    i4++;
                }
            }
            z2 = true;
            if (z2) {
                com.sijla.mla.a.b.q.c cVar = new com.sijla.mla.a.b.q.c(yVar, w, w2);
                if (w2.h(0) == 94) {
                    i2 = 1;
                    z3 = true;
                } else {
                    i2 = 0;
                    z3 = false;
                }
                while (true) {
                    cVar.a = 0;
                    int a2 = cVar.a(c2, i2);
                    if (a2 != -1) {
                        return z ? com.sijla.mla.a.r.a(com.sijla.mla.a.k.c_(c2 + 1), com.sijla.mla.a.k.c_(a2), cVar.a(false, c2, a2)) : cVar.a(true, c2, a2);
                    }
                    int i8 = c2 + 1;
                    if (c2 >= w.N() || z3) {
                        break;
                    }
                    c2 = i8;
                }
            } else {
                int a3 = w.a(w2, c2);
                if (a3 != -1) {
                    return com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.k.c_(a3 + 1), (com.sijla.mla.a.y) com.sijla.mla.a.k.c_(a3 + w2.N()));
                }
            }
            return com.sijla.mla.a.r.k;
        }
        z2 = false;
        if (z2) {
        }
        return com.sijla.mla.a.r.k;
    }

    public static /* synthetic */ void a(com.sijla.mla.a.a aVar, com.sijla.mla.a.n nVar) {
        aVar.a((byte) 34);
        int N = nVar.N();
        for (int i2 = 0; i2 < N; i2++) {
            int h2 = nVar.h(i2);
            if (h2 == 10 || h2 == 34 || h2 == 92) {
                aVar.a((byte) 92);
            } else if (h2 <= 31 || h2 == 127) {
                aVar.a((byte) 92);
                int i3 = i2 + 1;
                if (i3 == N || nVar.h(i3) < 48 || nVar.h(i3) > 57) {
                    aVar.a(java.lang.Integer.toString(h2));
                } else {
                    aVar.a(org.apache.tools.tar.TarConstants.LF_NORMAL);
                    aVar.a((byte) ((h2 / 10) + 48));
                    h2 = (h2 % 10) + 48;
                }
            }
            aVar.a((byte) h2);
        }
        aVar.a((byte) 34);
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        oVar.a(com.sijla.mla.L2.s1067615544(), new com.sijla.mla.a.b.q.d());
        oVar.a(com.sijla.mla.L2.s1068014762(), new com.sijla.mla.a.b.q.e());
        oVar.a(com.sijla.mla.L2.s1069337036(), new com.sijla.mla.a.b.q.f());
        oVar.a(com.sijla.mla.L2.s1070827175(), new com.sijla.mla.a.b.q.g());
        oVar.a(com.sijla.mla.L2.s1551434583(), new com.sijla.mla.a.b.q.h());
        oVar.a(com.sijla.mla.L2.s736678974(), new com.sijla.mla.a.b.q.i());
        oVar.a(com.sijla.mla.L2.s1072055271(), new com.sijla.mla.a.b.q.j());
        oVar.a(com.sijla.mla.L2.s34717647(), new com.sijla.mla.a.b.q.k());
        oVar.a(com.sijla.mla.L2.s986508317(), new com.sijla.mla.a.b.q.l());
        oVar.a(com.sijla.mla.L2.s970900065(), new com.sijla.mla.a.b.q.m());
        oVar.a(com.sijla.mla.L2.s34896455(), new com.sijla.mla.a.b.q.n());
        oVar.a(com.sijla.mla.L2.s1588410462(), new com.sijla.mla.a.b.q.o());
        oVar.a(com.sijla.mla.L2.s34941188(), new com.sijla.mla.a.b.q.p());
        oVar.a(com.sijla.mla.L2.s728130974(), new com.sijla.mla.a.b.q.C0463q());
        com.sijla.mla.a.o oVar2 = new com.sijla.mla.a.o(new com.sijla.mla.a.r[]{com.sijla.mla.a.r.f428s, oVar});
        rVar2.a(com.sijla.mla.L2.s1539217359(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s1539217359(), oVar);
        if (com.sijla.mla.a.n.a == null) {
            com.sijla.mla.a.n.a = oVar2;
        }
        return oVar;
    }
}
