package com.anythink.expressad.exoplayer.g.b;

/* loaded from: classes12.dex */
public final class g implements com.anythink.expressad.exoplayer.g.b {
    public static final com.anythink.expressad.exoplayer.g.b.g.a a = new com.anythink.expressad.exoplayer.g.b.g.AnonymousClass1();
    public static final int b = com.anythink.expressad.exoplayer.k.af.f("ID3");
    public static final int c = 10;
    private static final java.lang.String d = "Id3Decoder";
    private static final int e = 128;
    private static final int f = 64;
    private static final int g = 32;
    private static final int h = 8;
    private static final int i = 4;
    private static final int j = 64;
    private static final int k = 2;
    private static final int l = 1;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private final com.anythink.expressad.exoplayer.g.b.g.a q;

    /* renamed from: com.anythink.expressad.exoplayer.g.b.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.g.b.g.a {
        @Override // com.anythink.expressad.exoplayer.g.b.g.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return false;
        }
    }

    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    public static final class b {
        private final int a;
        private final boolean b;
        private final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public g() {
        this(null);
    }

    private g(com.anythink.expressad.exoplayer.g.b.g.a aVar) {
        this.q = aVar;
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0044, code lost:
    
        if (((r7 & 64) != 0) != false) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.anythink.expressad.exoplayer.g.a a(byte[] bArr, int i2) {
        com.anythink.expressad.exoplayer.g.b.g.b bVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s(bArr, i2);
        boolean z = false;
        if (sVar.a() >= 10) {
            int g2 = sVar.g();
            if (g2 == b) {
                int d2 = sVar.d();
                sVar.d(1);
                int d3 = sVar.d();
                int l2 = sVar.l();
                if (d2 != 2) {
                    if (d2 == 3) {
                        if ((d3 & 64) != 0) {
                            int i3 = sVar.i();
                            sVar.d(i3);
                            l2 -= i3 + 4;
                        }
                    } else if (d2 == 4) {
                        if ((d3 & 64) != 0) {
                            int l3 = sVar.l();
                            sVar.d(l3 - 4);
                            l2 -= l3;
                        }
                        if ((d3 & 16) != 0) {
                            l2 -= 10;
                        }
                    } else {
                        "Skipped ID3 tag with unsupported majorVersion=".concat(java.lang.String.valueOf(d2));
                    }
                    bVar = new com.anythink.expressad.exoplayer.g.b.g.b(d2, d2 < 4 && (d3 & 128) != 0, l2);
                }
                if (bVar != null) {
                    return null;
                }
                int c2 = sVar.c();
                int i4 = bVar.a == 2 ? 6 : 10;
                int i5 = bVar.c;
                if (bVar.b) {
                    i5 = f(sVar, bVar.c);
                }
                sVar.b(c2 + i5);
                if (!a(sVar, bVar.a, i4, false)) {
                    if (bVar.a != 4 || !a(sVar, 4, i4, true)) {
                        new java.lang.StringBuilder("Failed to validate ID3 tag with majorVersion=").append(bVar.a);
                        return null;
                    }
                    z = true;
                }
                while (sVar.a() >= i4) {
                    com.anythink.expressad.exoplayer.g.b.h a2 = a(bVar.a, sVar, z, i4, this.q);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return new com.anythink.expressad.exoplayer.g.a(arrayList);
            }
            "Unexpected first three bytes of ID3 tag header: ".concat(java.lang.String.valueOf(g2));
        }
        bVar = null;
        if (bVar != null) {
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.a a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3) {
        int b2;
        java.lang.String concat;
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        sVar.a(bArr, 0, i4);
        if (i3 == 2) {
            concat = "image/" + com.anythink.expressad.exoplayer.k.af.d(new java.lang.String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(concat)) {
                concat = "image/jpeg";
            }
            b2 = 2;
        } else {
            b2 = b(bArr, 0);
            java.lang.String d3 = com.anythink.expressad.exoplayer.k.af.d(new java.lang.String(bArr, 0, b2, "ISO-8859-1"));
            concat = d3.indexOf(47) == -1 ? "image/".concat(d3) : d3;
        }
        int i5 = bArr[b2 + 1] & 255;
        int i6 = b2 + 2;
        int a3 = a(bArr, i6, d2);
        return new com.anythink.expressad.exoplayer.g.b.a(concat, new java.lang.String(bArr, i6, a3 - i6, a2), i5, b(bArr, a3 + b(d2), i4));
    }

    private static com.anythink.expressad.exoplayer.g.b.c a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, boolean z, int i4, com.anythink.expressad.exoplayer.g.b.g.a aVar) {
        int c2 = sVar.c();
        int b2 = b(sVar.a, c2);
        java.lang.String str = new java.lang.String(sVar.a, c2, b2 - c2, "ISO-8859-1");
        sVar.c(b2 + 1);
        int i5 = sVar.i();
        int i6 = sVar.i();
        long h2 = sVar.h();
        long j2 = h2 == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT ? -1L : h2;
        long h3 = sVar.h();
        long j3 = h3 == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT ? -1L : h3;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i7 = c2 + i2;
        while (sVar.c() < i7) {
            com.anythink.expressad.exoplayer.g.b.h a2 = a(i3, sVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        com.anythink.expressad.exoplayer.g.b.h[] hVarArr = new com.anythink.expressad.exoplayer.g.b.h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new com.anythink.expressad.exoplayer.g.b.c(str, i5, i6, j2, j3, hVarArr);
    }

    private static com.anythink.expressad.exoplayer.g.b.g.b a(com.anythink.expressad.exoplayer.k.s sVar) {
        if (sVar.a() < 10) {
            return null;
        }
        int g2 = sVar.g();
        if (g2 != b) {
            "Unexpected first three bytes of ID3 tag header: ".concat(java.lang.String.valueOf(g2));
            return null;
        }
        int d2 = sVar.d();
        sVar.d(1);
        int d3 = sVar.d();
        int l2 = sVar.l();
        if (d2 == 2) {
            if ((d3 & 64) != 0) {
                return null;
            }
        } else if (d2 == 3) {
            if ((d3 & 64) != 0) {
                int i2 = sVar.i();
                sVar.d(i2);
                l2 -= i2 + 4;
            }
        } else {
            if (d2 != 4) {
                "Skipped ID3 tag with unsupported majorVersion=".concat(java.lang.String.valueOf(d2));
                return null;
            }
            if ((d3 & 64) != 0) {
                int l3 = sVar.l();
                sVar.d(l3 - 4);
                l2 -= l3;
            }
            if ((d3 & 16) != 0) {
                l2 -= 10;
            }
        }
        return new com.anythink.expressad.exoplayer.g.b.g.b(d2, d2 < 4 && (d3 & 128) != 0, l2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.anythink.expressad.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.anythink.expressad.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    private static com.anythink.expressad.exoplayer.g.b.h a(int i2, com.anythink.expressad.exoplayer.k.s sVar, boolean z, int i3, com.anythink.expressad.exoplayer.g.b.g.a aVar) {
        int m2;
        int i4;
        java.lang.String str;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        int i7;
        int i8;
        ?? eVar;
        int b2;
        java.lang.String d2;
        java.lang.Object jVar;
        java.lang.Object obj;
        com.anythink.expressad.exoplayer.k.s sVar2 = sVar;
        int d3 = sVar.d();
        int d4 = sVar.d();
        int d5 = sVar.d();
        int d6 = i2 >= 3 ? sVar.d() : 0;
        if (i2 == 4) {
            m2 = sVar.m();
            if (!z) {
                m2 = (((m2 >> 24) & 255) << 21) | (m2 & 255) | (((m2 >> 8) & 255) << 7) | (((m2 >> 16) & 255) << 14);
            }
        } else {
            m2 = i2 == 3 ? sVar.m() : sVar.g();
        }
        int i9 = m2;
        int e2 = i2 >= 3 ? sVar.e() : 0;
        if (d3 == 0 && d4 == 0 && d5 == 0 && d6 == 0 && i9 == 0 && e2 == 0) {
            sVar2.c(sVar.b());
            return null;
        }
        int c2 = sVar.c() + i9;
        if (c2 > sVar.b()) {
            sVar2.c(sVar.b());
            return null;
        }
        if (aVar != null) {
            i4 = c2;
            str = null;
            i5 = e2;
            if (!aVar.a(i2, d3, d4, d5, d6)) {
                sVar2.c(i4);
                return null;
            }
        } else {
            i4 = c2;
            str = null;
            i5 = e2;
        }
        if (i2 == 3) {
            int i10 = i5;
            z3 = (i10 & 128) != 0;
            boolean z7 = (i10 & 64) != 0;
            z2 = (i10 & 32) != 0;
            z5 = z7;
            z6 = false;
            z4 = z3;
        } else {
            int i11 = i5;
            if (i2 == 4) {
                boolean z8 = (i11 & 64) != 0;
                z4 = (i11 & 8) != 0;
                z5 = (i11 & 4) != 0;
                z6 = (i11 & 2) != 0;
                if ((i11 & 1) != 0) {
                    z2 = z8;
                    z3 = true;
                } else {
                    z2 = z8;
                    z3 = false;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z4 || z5) {
            ?? r0 = str;
            sVar2.c(i4);
            return r0;
        }
        if (z2) {
            i9--;
            sVar2.d(1);
        }
        if (z3) {
            i9 -= 4;
            sVar2.d(4);
        }
        if (z6) {
            i9 = f(sVar2, i9);
        }
        try {
            try {
                if (d3 == 84 && d4 == 88 && d5 == 88 && (i2 == 2 || d6 == 88)) {
                    if (i9 > 0) {
                        int d7 = sVar.d();
                        java.lang.String a2 = a(d7);
                        int i12 = i9 - 1;
                        byte[] bArr = new byte[i12];
                        sVar2.a(bArr, 0, i12);
                        int a3 = a(bArr, 0, d7);
                        java.lang.String str2 = new java.lang.String(bArr, 0, a3, a2);
                        int b3 = a3 + b(d7);
                        obj = new com.anythink.expressad.exoplayer.g.b.k("TXXX", str2, a(bArr, b3, a(bArr, b3, d7), a2));
                        i8 = i4;
                        eVar = obj;
                    }
                    obj = str;
                    i8 = i4;
                    eVar = obj;
                } else if (d3 == 84) {
                    java.lang.String a4 = a(i2, d3, d4, d5, d6);
                    if (i9 <= 0) {
                        obj = str;
                        i8 = i4;
                        eVar = obj;
                    } else {
                        int d8 = sVar.d();
                        java.lang.String a5 = a(d8);
                        int i13 = i9 - 1;
                        byte[] bArr2 = new byte[i13];
                        sVar2.a(bArr2, 0, i13);
                        obj = new com.anythink.expressad.exoplayer.g.b.k(a4, str, new java.lang.String(bArr2, 0, a(bArr2, 0, d8), a5));
                        i8 = i4;
                        eVar = obj;
                    }
                } else {
                    if (d3 == 87 && d4 == 88 && d5 == 88 && (i2 == 2 || d6 == 88)) {
                        if (i9 > 0) {
                            int d9 = sVar.d();
                            java.lang.String a6 = a(d9);
                            int i14 = i9 - 1;
                            byte[] bArr3 = new byte[i14];
                            sVar2.a(bArr3, 0, i14);
                            int a7 = a(bArr3, 0, d9);
                            java.lang.String str3 = new java.lang.String(bArr3, 0, a7, a6);
                            int b4 = a7 + b(d9);
                            obj = new com.anythink.expressad.exoplayer.g.b.l("WXXX", str3, a(bArr3, b4, b(bArr3, b4), "ISO-8859-1"));
                        }
                        obj = str;
                    } else {
                        if (d3 == 87) {
                            java.lang.String a8 = a(i2, d3, d4, d5, d6);
                            byte[] bArr4 = new byte[i9];
                            sVar2.a(bArr4, 0, i9);
                            jVar = new com.anythink.expressad.exoplayer.g.b.l(a8, str, new java.lang.String(bArr4, 0, b(bArr4, 0), "ISO-8859-1"));
                        } else if (d3 == 80 && d4 == 82 && d5 == 73 && d6 == 86) {
                            byte[] bArr5 = new byte[i9];
                            sVar2.a(bArr5, 0, i9);
                            int b5 = b(bArr5, 0);
                            jVar = new com.anythink.expressad.exoplayer.g.b.j(new java.lang.String(bArr5, 0, b5, "ISO-8859-1"), b(bArr5, b5 + 1, i9));
                        } else if (d3 == 71 && d4 == 69 && d5 == 79 && (d6 == 66 || i2 == 2)) {
                            int d10 = sVar.d();
                            java.lang.String a9 = a(d10);
                            int i15 = i9 - 1;
                            byte[] bArr6 = new byte[i15];
                            sVar2.a(bArr6, 0, i15);
                            int b6 = b(bArr6, 0);
                            java.lang.String str4 = new java.lang.String(bArr6, 0, b6, "ISO-8859-1");
                            int i16 = b6 + 1;
                            int a10 = a(bArr6, i16, d10);
                            java.lang.String a11 = a(bArr6, i16, a10, a9);
                            int b7 = a10 + b(d10);
                            int a12 = a(bArr6, b7, d10);
                            obj = new com.anythink.expressad.exoplayer.g.b.f(str4, a11, a(bArr6, b7, a12, a9), b(bArr6, a12 + b(d10), i15));
                        } else {
                            try {
                                if (i2 != 2 ? !(d3 == 65 && d4 == 80 && d5 == 73 && d6 == 67) : !(d3 == 80 && d4 == 73 && d5 == 67)) {
                                    i8 = i4;
                                    if (d3 != 67 || d4 != 79 || d5 != 77 || (d6 != 77 && i2 != 2)) {
                                        sVar2 = sVar;
                                        if (d3 == 67 && d4 == 72 && d5 == 65 && d6 == 80) {
                                            eVar = a(sVar, i9, i2, z, i3, aVar);
                                        } else if (d3 == 67 && d4 == 84 && d5 == 79 && d6 == 67) {
                                            eVar = b(sVar, i9, i2, z, i3, aVar);
                                        } else {
                                            java.lang.String a13 = a(i2, d3, d4, d5, d6);
                                            byte[] bArr7 = new byte[i9];
                                            sVar2.a(bArr7, 0, i9);
                                            eVar = new com.anythink.expressad.exoplayer.g.b.b(a13, bArr7);
                                        }
                                    } else if (i9 < 4) {
                                        sVar2 = sVar;
                                        eVar = 0;
                                    } else {
                                        int d11 = sVar.d();
                                        java.lang.String a14 = a(d11);
                                        byte[] bArr8 = new byte[3];
                                        sVar2 = sVar;
                                        sVar2.a(bArr8, 0, 3);
                                        java.lang.String str5 = new java.lang.String(bArr8, 0, 3);
                                        int i17 = i9 - 4;
                                        byte[] bArr9 = new byte[i17];
                                        sVar2.a(bArr9, 0, i17);
                                        int a15 = a(bArr9, 0, d11);
                                        java.lang.String str6 = new java.lang.String(bArr9, 0, a15, a14);
                                        int b8 = a15 + b(d11);
                                        eVar = new com.anythink.expressad.exoplayer.g.b.e(str5, str6, a(bArr9, b8, a(bArr9, b8, d11), a14));
                                    }
                                } else {
                                    try {
                                        int d12 = sVar.d();
                                        java.lang.String a16 = a(d12);
                                        int i18 = i9 - 1;
                                        byte[] bArr10 = new byte[i18];
                                        sVar2.a(bArr10, 0, i18);
                                        if (i2 == 2) {
                                            java.lang.StringBuilder sb = new java.lang.StringBuilder("image/");
                                            i8 = i4;
                                            sb.append(com.anythink.expressad.exoplayer.k.af.d(new java.lang.String(bArr10, 0, 3, "ISO-8859-1")));
                                            d2 = sb.toString();
                                            if ("image/jpg".equals(d2)) {
                                                d2 = "image/jpeg";
                                            }
                                            b2 = 2;
                                        } else {
                                            i8 = i4;
                                            b2 = b(bArr10, 0);
                                            d2 = com.anythink.expressad.exoplayer.k.af.d(new java.lang.String(bArr10, 0, b2, "ISO-8859-1"));
                                            if (d2.indexOf(47) == -1) {
                                                d2 = "image/".concat(d2);
                                            }
                                        }
                                        int i19 = bArr10[b2 + 1] & 255;
                                        int i20 = b2 + 2;
                                        int a17 = a(bArr10, i20, d12);
                                        sVar2 = sVar;
                                        eVar = new com.anythink.expressad.exoplayer.g.b.a(d2, new java.lang.String(bArr10, i20, a17 - i20, a16), i19, b(bArr10, a17 + b(d12), i18));
                                    } catch (java.io.UnsupportedEncodingException unused) {
                                        sVar2 = sVar;
                                        i7 = i4;
                                        sVar2.c(i7);
                                        return null;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        sVar2 = sVar;
                                        i6 = i4;
                                        sVar2.c(i6);
                                        throw th;
                                    }
                                }
                            } catch (java.io.UnsupportedEncodingException unused2) {
                                sVar2 = sVar;
                                i7 = i8;
                                sVar2.c(i7);
                                return null;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                sVar2 = sVar;
                                i6 = i8;
                                sVar2.c(i6);
                                throw th;
                            }
                        }
                        obj = jVar;
                    }
                    i8 = i4;
                    eVar = obj;
                }
                if (eVar == 0) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Failed to decode frame: id=");
                    sb2.append(a(i2, d3, d4, d5, d6));
                    sb2.append(", frameSize=");
                    sb2.append(i9);
                }
                sVar2.c(i8);
                return eVar;
            } catch (java.io.UnsupportedEncodingException unused3) {
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.io.UnsupportedEncodingException unused4) {
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.k a(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, d2);
        java.lang.String str = new java.lang.String(bArr, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new com.anythink.expressad.exoplayer.g.b.k("TXXX", str, a(bArr, b2, a(bArr, b2, d2), a2));
    }

    private static com.anythink.expressad.exoplayer.g.b.k a(com.anythink.expressad.exoplayer.k.s sVar, int i2, java.lang.String str) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new com.anythink.expressad.exoplayer.g.b.k(str, null, new java.lang.String(bArr, 0, a(bArr, 0, d2), a2));
    }

    private static java.lang.String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : org.apache.commons.codec.CharEncoding.UTF_16BE : "UTF-16";
    }

    private static java.lang.String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? java.lang.String.format(java.util.Locale.US, "%c%c%c", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5)) : java.lang.String.format(java.util.Locale.US, "%c%c%c%c", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6));
    }

    private static java.lang.String a(byte[] bArr, int i2, int i3, java.lang.String str) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new java.lang.String(bArr, i2, i3 - i2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, boolean z) {
        int g2;
        long g3;
        int i4;
        int i5;
        int c2 = sVar.c();
        while (true) {
            try {
                boolean z2 = true;
                if (sVar.a() < i3) {
                    return true;
                }
                if (i2 >= 3) {
                    g2 = sVar.i();
                    g3 = sVar.h();
                    i4 = sVar.e();
                } else {
                    g2 = sVar.g();
                    g3 = sVar.g();
                    i4 = 0;
                }
                if (g2 == 0 && g3 == 0 && i4 == 0) {
                    return true;
                }
                if (i2 == 4 && !z) {
                    if ((8421504 & g3) != 0) {
                        return false;
                    }
                    g3 = (((g3 >> 24) & 255) << 21) | (g3 & 255) | (((g3 >> 8) & 255) << 7) | (((g3 >> 16) & 255) << 14);
                }
                if (i2 == 4) {
                    i5 = (i4 & 64) != 0 ? 1 : 0;
                } else {
                    if (i2 == 3) {
                        i5 = (i4 & 32) != 0 ? 1 : 0;
                    } else {
                        i5 = 0;
                    }
                    z2 = false;
                    if (z2) {
                        i5 += 4;
                    }
                    if (g3 < i5) {
                        return false;
                    }
                    if (sVar.a() < g3) {
                        return false;
                    }
                    sVar.d((int) g3);
                }
            } finally {
                sVar.c(c2);
            }
        }
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static com.anythink.expressad.exoplayer.g.b.d b(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, boolean z, int i4, com.anythink.expressad.exoplayer.g.b.g.a aVar) {
        int c2 = sVar.c();
        int b2 = b(sVar.a, c2);
        java.lang.String str = new java.lang.String(sVar.a, c2, b2 - c2, "ISO-8859-1");
        sVar.c(b2 + 1);
        int d2 = sVar.d();
        boolean z2 = (d2 & 2) != 0;
        boolean z3 = (d2 & 1) != 0;
        int d3 = sVar.d();
        java.lang.String[] strArr = new java.lang.String[d3];
        for (int i5 = 0; i5 < d3; i5++) {
            int c3 = sVar.c();
            int b3 = b(sVar.a, c3);
            strArr[i5] = new java.lang.String(sVar.a, c3, b3 - c3, "ISO-8859-1");
            sVar.c(b3 + 1);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i6 = c2 + i2;
        while (sVar.c() < i6) {
            com.anythink.expressad.exoplayer.g.b.h a2 = a(i3, sVar, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        com.anythink.expressad.exoplayer.g.b.h[] hVarArr = new com.anythink.expressad.exoplayer.g.b.h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new com.anythink.expressad.exoplayer.g.b.d(str, z2, z3, strArr, hVarArr);
    }

    private static com.anythink.expressad.exoplayer.g.b.l b(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, d2);
        java.lang.String str = new java.lang.String(bArr, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new com.anythink.expressad.exoplayer.g.b.l("WXXX", str, a(bArr, b2, b(bArr, b2), "ISO-8859-1"));
    }

    private static com.anythink.expressad.exoplayer.g.b.l b(com.anythink.expressad.exoplayer.k.s sVar, int i2, java.lang.String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.expressad.exoplayer.g.b.l(str, null, new java.lang.String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? new byte[0] : java.util.Arrays.copyOfRange(bArr, i2, i3);
    }

    private static com.anythink.expressad.exoplayer.g.b.b c(com.anythink.expressad.exoplayer.k.s sVar, int i2, java.lang.String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.expressad.exoplayer.g.b.b(str, bArr);
    }

    private static com.anythink.expressad.exoplayer.g.b.j c(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        return new com.anythink.expressad.exoplayer.g.b.j(new java.lang.String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, i2));
    }

    private static com.anythink.expressad.exoplayer.g.b.f d(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int b2 = b(bArr, 0);
        java.lang.String str = new java.lang.String(bArr, 0, b2, "ISO-8859-1");
        int i4 = b2 + 1;
        int a3 = a(bArr, i4, d2);
        java.lang.String a4 = a(bArr, i4, a3, a2);
        int b3 = a3 + b(d2);
        int a5 = a(bArr, b3, d2);
        return new com.anythink.expressad.exoplayer.g.b.f(str, a4, a(bArr, b3, a5, a2), b(bArr, a5 + b(d2), i3));
    }

    private static com.anythink.expressad.exoplayer.g.b.e e(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int d2 = sVar.d();
        java.lang.String a2 = a(d2);
        byte[] bArr = new byte[3];
        sVar.a(bArr, 0, 3);
        java.lang.String str = new java.lang.String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        sVar.a(bArr2, 0, i3);
        int a3 = a(bArr2, 0, d2);
        java.lang.String str2 = new java.lang.String(bArr2, 0, a3, a2);
        int b2 = a3 + b(d2);
        return new com.anythink.expressad.exoplayer.g.b.e(str, str2, a(bArr2, b2, a(bArr2, b2, d2), a2));
    }

    private static int f(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        byte[] bArr = sVar.a;
        int c2 = sVar.c();
        while (true) {
            int i3 = c2 + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[c2] & 255) == 255 && bArr[i3] == 0) {
                java.lang.System.arraycopy(bArr, c2 + 2, bArr, i3, (i2 - c2) - 2);
                i2--;
            }
            c2 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x004e, code lost:
    
        if (((r8 & 64) != 0) != false) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a3  */
    @Override // com.anythink.expressad.exoplayer.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e eVar) {
        com.anythink.expressad.exoplayer.g.b.g.b bVar;
        java.nio.ByteBuffer byteBuffer = eVar.e;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s(array, limit);
        boolean z = false;
        if (sVar.a() >= 10) {
            int g2 = sVar.g();
            if (g2 == b) {
                int d2 = sVar.d();
                sVar.d(1);
                int d3 = sVar.d();
                int l2 = sVar.l();
                if (d2 != 2) {
                    if (d2 == 3) {
                        if ((d3 & 64) != 0) {
                            int i2 = sVar.i();
                            sVar.d(i2);
                            l2 -= i2 + 4;
                        }
                    } else if (d2 == 4) {
                        if ((d3 & 64) != 0) {
                            int l3 = sVar.l();
                            sVar.d(l3 - 4);
                            l2 -= l3;
                        }
                        if ((d3 & 16) != 0) {
                            l2 -= 10;
                        }
                    } else {
                        "Skipped ID3 tag with unsupported majorVersion=".concat(java.lang.String.valueOf(d2));
                    }
                    bVar = new com.anythink.expressad.exoplayer.g.b.g.b(d2, d2 < 4 && (d3 & 128) != 0, l2);
                }
                if (bVar != null) {
                    return null;
                }
                int c2 = sVar.c();
                int i3 = bVar.a == 2 ? 6 : 10;
                int i4 = bVar.c;
                if (bVar.b) {
                    i4 = f(sVar, bVar.c);
                }
                sVar.b(c2 + i4);
                if (!a(sVar, bVar.a, i3, false)) {
                    if (bVar.a != 4 || !a(sVar, 4, i3, true)) {
                        new java.lang.StringBuilder("Failed to validate ID3 tag with majorVersion=").append(bVar.a);
                        return null;
                    }
                    z = true;
                }
                while (sVar.a() >= i3) {
                    com.anythink.expressad.exoplayer.g.b.h a2 = a(bVar.a, sVar, z, i3, this.q);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                return new com.anythink.expressad.exoplayer.g.a(arrayList);
            }
            "Unexpected first three bytes of ID3 tag header: ".concat(java.lang.String.valueOf(g2));
        }
        bVar = null;
        if (bVar != null) {
        }
    }
}
