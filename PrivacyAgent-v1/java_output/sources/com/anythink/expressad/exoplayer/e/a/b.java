package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
final class b {
    private static final java.lang.String a = "AtomParsers";
    private static final int b = com.anythink.expressad.exoplayer.k.af.f("vide");
    private static final int c = com.anythink.expressad.exoplayer.k.af.f("soun");
    private static final int d = com.anythink.expressad.exoplayer.k.af.f("text");
    private static final int e = com.anythink.expressad.exoplayer.k.af.f("sbtl");
    private static final int f = com.anythink.expressad.exoplayer.k.af.f("subt");
    private static final int g = com.anythink.expressad.exoplayer.k.af.f("clcp");
    private static final int h = com.anythink.expressad.exoplayer.k.af.f(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_META);
    private static final int i = 3;

    public static final class a {
        public final int a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final com.anythink.expressad.exoplayer.k.s f;
        private final com.anythink.expressad.exoplayer.k.s g;
        private int h;
        private int i;

        public a(com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.k.s sVar2, boolean z) {
            this.g = sVar;
            this.f = sVar2;
            this.e = z;
            sVar2.c(12);
            this.a = sVar2.m();
            sVar.c(12);
            this.i = sVar.m();
            com.anythink.expressad.exoplayer.k.a.b(sVar.i() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public final boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.n() : this.f.h();
            if (this.b == this.h) {
                this.c = this.g.m();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.m() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.e.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0191b {
        int a();

        int b();

        boolean c();
    }

    public static final class c {
        public static final int a = 8;
        public final com.anythink.expressad.exoplayer.e.a.k[] b;
        public com.anythink.expressad.exoplayer.m c;
        public int d;
        public int e = 0;

        public c(int i) {
            this.b = new com.anythink.expressad.exoplayer.e.a.k[i];
        }
    }

    public static final class d implements com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b {
        private final int a;
        private final int b;
        private final com.anythink.expressad.exoplayer.k.s c;

        public d(com.anythink.expressad.exoplayer.e.a.a.b bVar) {
            com.anythink.expressad.exoplayer.k.s sVar = bVar.aV;
            this.c = sVar;
            sVar.c(12);
            this.a = sVar.m();
            this.b = sVar.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final int b() {
            int i = this.a;
            return i == 0 ? this.c.m() : i;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final boolean c() {
            return this.a != 0;
        }
    }

    public static final class e implements com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b {
        private final com.anythink.expressad.exoplayer.k.s a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        public e(com.anythink.expressad.exoplayer.e.a.a.b bVar) {
            com.anythink.expressad.exoplayer.k.s sVar = bVar.aV;
            this.a = sVar;
            sVar.c(12);
            this.c = sVar.m() & 255;
            this.b = sVar.m();
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final int b() {
            int i = this.c;
            if (i == 8) {
                return this.a.d();
            }
            if (i == 16) {
                return this.a.e();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int d = this.a.d();
            this.e = d;
            return (d & 240) >> 4;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b
        public final boolean c() {
            return false;
        }
    }

    public static final class f {
        private final int a;
        private final long b;
        private final int c;

        public f(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    public static final class g extends com.anythink.expressad.exoplayer.t {
    }

    private b() {
    }

    private static int a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3) {
        int c2 = sVar.c();
        while (c2 - i2 < i3) {
            sVar.c(c2);
            int i4 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                return c2;
            }
            c2 += i4;
        }
        return -1;
    }

    private static long a(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(8);
        sVar.d(com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) != 0 ? 16 : 8);
        return sVar.h();
    }

    private static android.util.Pair<long[], long[]> a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a) {
        com.anythink.expressad.exoplayer.e.a.a.b d2;
        if (c0190a == null || (d2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.V)) == null) {
            return android.util.Pair.create(null, null);
        }
        com.anythink.expressad.exoplayer.k.s sVar = d2.aV;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        int m = sVar.m();
        long[] jArr = new long[m];
        long[] jArr2 = new long[m];
        for (int i2 = 0; i2 < m; i2++) {
            jArr[i2] = a2 == 1 ? sVar.n() : sVar.h();
            jArr2[i2] = a2 == 1 ? sVar.j() : sVar.i();
            if (sVar.f() != 1) {
                throw new java.lang.IllegalArgumentException("Unsupported media rate.");
            }
            sVar.d(2);
        }
        return android.util.Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x033a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.anythink.expressad.exoplayer.e.a.b.c a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, java.lang.String str, com.anythink.expressad.exoplayer.d.e eVar, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7;
        com.anythink.expressad.exoplayer.d.e eVar2;
        byte[] bArr;
        java.lang.String str2;
        java.util.List<byte[]> list;
        java.lang.String str3;
        com.anythink.expressad.exoplayer.d.e eVar3;
        int i8;
        int i9;
        int i10;
        com.anythink.expressad.exoplayer.d.e eVar4;
        int i11;
        java.lang.String str4;
        com.anythink.expressad.exoplayer.d.e eVar5;
        int i12;
        int c2;
        java.lang.String str5;
        int i13;
        java.lang.String str6;
        java.lang.String str7;
        int i14;
        java.lang.String str8;
        com.anythink.expressad.exoplayer.d.e eVar6;
        java.lang.String str9;
        java.lang.String str10;
        java.util.List list2;
        sVar.c(12);
        int i15 = sVar.i();
        com.anythink.expressad.exoplayer.e.a.b.c cVar = new com.anythink.expressad.exoplayer.e.a.b.c(i15);
        int i16 = 0;
        int i17 = 0;
        while (i17 < i15) {
            int c3 = sVar.c();
            int i18 = sVar.i();
            java.lang.String str11 = "childAtomSize should be positive";
            com.anythink.expressad.exoplayer.k.a.a(i18 > 0, "childAtomSize should be positive");
            int i19 = sVar.i();
            if (i19 == com.anythink.expressad.exoplayer.e.a.a.g || i19 == com.anythink.expressad.exoplayer.e.a.a.h || i19 == com.anythink.expressad.exoplayer.e.a.a.ae || i19 == com.anythink.expressad.exoplayer.e.a.a.aq || i19 == com.anythink.expressad.exoplayer.e.a.a.i || i19 == com.anythink.expressad.exoplayer.e.a.a.j || i19 == com.anythink.expressad.exoplayer.e.a.a.k || i19 == com.anythink.expressad.exoplayer.e.a.a.aP || i19 == com.anythink.expressad.exoplayer.e.a.a.aQ) {
                i4 = i17;
                i5 = c3;
                i6 = i15;
                i7 = i18;
                sVar.c(i5 + 8 + 8);
                sVar.d(16);
                int e2 = sVar.e();
                int e3 = sVar.e();
                sVar.d(50);
                int c4 = sVar.c();
                if (i19 == com.anythink.expressad.exoplayer.e.a.a.ae) {
                    android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> b2 = b(sVar, i5, i7);
                    if (b2 != null) {
                        i19 = ((java.lang.Integer) b2.first).intValue();
                        eVar3 = eVar == null ? null : eVar.a(((com.anythink.expressad.exoplayer.e.a.k) b2.second).b);
                        cVar.b[i4] = (com.anythink.expressad.exoplayer.e.a.k) b2.second;
                    } else {
                        eVar3 = eVar;
                    }
                    sVar.c(c4);
                    eVar2 = eVar3;
                } else {
                    eVar2 = eVar;
                }
                java.lang.String str12 = null;
                java.util.List<byte[]> list3 = null;
                byte[] bArr2 = null;
                boolean z2 = false;
                float f2 = 1.0f;
                int i20 = -1;
                while (c4 - i5 < i7) {
                    sVar.c(c4);
                    int c5 = sVar.c();
                    int i21 = sVar.i();
                    if (i21 == 0 && sVar.c() - i5 == i7) {
                        break;
                    }
                    com.anythink.expressad.exoplayer.k.a.a(i21 > 0, "childAtomSize should be positive");
                    int i22 = sVar.i();
                    if (i22 == com.anythink.expressad.exoplayer.e.a.a.M) {
                        com.anythink.expressad.exoplayer.k.a.b(str12 == null);
                        sVar.c(c5 + 8);
                        com.anythink.expressad.exoplayer.l.a a2 = com.anythink.expressad.exoplayer.l.a.a(sVar);
                        list = a2.a;
                        cVar.d = a2.b;
                        if (!z2) {
                            f2 = a2.e;
                        }
                        str3 = "video/avc";
                    } else if (i22 == com.anythink.expressad.exoplayer.e.a.a.N) {
                        com.anythink.expressad.exoplayer.k.a.b(str12 == null);
                        sVar.c(c5 + 8);
                        com.anythink.expressad.exoplayer.l.d a3 = com.anythink.expressad.exoplayer.l.d.a(sVar);
                        list = a3.a;
                        cVar.d = a3.b;
                        str3 = "video/hevc";
                    } else {
                        if (i22 == com.anythink.expressad.exoplayer.e.a.a.aR) {
                            com.anythink.expressad.exoplayer.k.a.b(str12 == null);
                            str2 = i19 == com.anythink.expressad.exoplayer.e.a.a.aP ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        } else if (i22 == com.anythink.expressad.exoplayer.e.a.a.l) {
                            com.anythink.expressad.exoplayer.k.a.b(str12 == null);
                            str2 = "video/3gpp";
                        } else {
                            if (i22 == com.anythink.expressad.exoplayer.e.a.a.O) {
                                com.anythink.expressad.exoplayer.k.a.b(str12 == null);
                                android.util.Pair<java.lang.String, byte[]> d2 = d(sVar, c5);
                                java.lang.String str13 = (java.lang.String) d2.first;
                                list3 = java.util.Collections.singletonList((byte[]) d2.second);
                                str12 = str13;
                            } else if (i22 == com.anythink.expressad.exoplayer.e.a.a.an) {
                                sVar.c(c5 + 8);
                                f2 = sVar.m() / sVar.m();
                                z2 = true;
                            } else if (i22 == com.anythink.expressad.exoplayer.e.a.a.aN) {
                                int i23 = c5 + 8;
                                while (true) {
                                    if (i23 - c5 >= i21) {
                                        bArr = null;
                                        break;
                                    }
                                    sVar.c(i23);
                                    int i24 = sVar.i();
                                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                                        bArr = java.util.Arrays.copyOfRange(sVar.a, i23, i24 + i23);
                                        break;
                                    }
                                    i23 += i24;
                                }
                                bArr2 = bArr;
                            } else if (i22 == com.anythink.expressad.exoplayer.e.a.a.aM) {
                                int d3 = sVar.d();
                                sVar.d(3);
                                if (d3 == 0) {
                                    int d4 = sVar.d();
                                    if (d4 == 0) {
                                        i20 = 0;
                                    } else if (d4 == 1) {
                                        i20 = 1;
                                    } else if (d4 == 2) {
                                        i20 = 2;
                                    } else if (d4 == 3) {
                                        i20 = 3;
                                    }
                                    c4 += i21;
                                }
                            }
                            c4 += i21;
                        }
                        str12 = str2;
                        c4 += i21;
                    }
                    str12 = str3;
                    list3 = list;
                    c4 += i21;
                }
                if (str12 != null) {
                    cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), str12, null, -1, -1, e2, e3, -1.0f, list3, i3, f2, bArr2, i20, null, eVar2);
                }
            } else if (i19 == com.anythink.expressad.exoplayer.e.a.a.n || i19 == com.anythink.expressad.exoplayer.e.a.a.af || i19 == com.anythink.expressad.exoplayer.e.a.a.f213s || i19 == com.anythink.expressad.exoplayer.e.a.a.u || i19 == com.anythink.expressad.exoplayer.e.a.a.w || i19 == com.anythink.expressad.exoplayer.e.a.a.z || i19 == com.anythink.expressad.exoplayer.e.a.a.x || i19 == com.anythink.expressad.exoplayer.e.a.a.y || i19 == com.anythink.expressad.exoplayer.e.a.a.aD || i19 == com.anythink.expressad.exoplayer.e.a.a.aE || i19 == com.anythink.expressad.exoplayer.e.a.a.q || i19 == com.anythink.expressad.exoplayer.e.a.a.r || i19 == com.anythink.expressad.exoplayer.e.a.a.o || i19 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                i4 = i17;
                i6 = i15;
                i5 = c3;
                sVar.c(i5 + 8 + 8);
                if (z) {
                    i8 = sVar.e();
                    sVar.d(6);
                } else {
                    sVar.d(8);
                    i8 = 0;
                }
                if (i8 == 0 || i8 == 1) {
                    int e4 = sVar.e();
                    sVar.d(6);
                    int k = sVar.k();
                    if (i8 == 1) {
                        sVar.d(16);
                    }
                    i9 = k;
                    i10 = e4;
                } else if (i8 == 2) {
                    sVar.d(16);
                    i9 = (int) java.lang.Math.round(java.lang.Double.longBitsToDouble(sVar.j()));
                    i10 = sVar.m();
                    sVar.d(20);
                } else {
                    i7 = i18;
                }
                int c6 = sVar.c();
                if (i19 == com.anythink.expressad.exoplayer.e.a.a.af) {
                    android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> b3 = b(sVar, i5, i18);
                    if (b3 != null) {
                        i19 = ((java.lang.Integer) b3.first).intValue();
                        eVar6 = eVar != null ? eVar.a(((com.anythink.expressad.exoplayer.e.a.k) b3.second).b) : null;
                        cVar.b[i4] = (com.anythink.expressad.exoplayer.e.a.k) b3.second;
                    } else {
                        eVar6 = eVar;
                    }
                    sVar.c(c6);
                    eVar4 = eVar6;
                } else {
                    eVar4 = eVar;
                }
                java.lang.String str14 = "audio/raw";
                int i25 = i10;
                int i26 = i9;
                int i27 = c6;
                byte[] bArr3 = null;
                java.lang.String str15 = i19 == com.anythink.expressad.exoplayer.e.a.a.f213s ? "audio/ac3" : i19 == com.anythink.expressad.exoplayer.e.a.a.u ? "audio/eac3" : i19 == com.anythink.expressad.exoplayer.e.a.a.w ? "audio/vnd.dts" : (i19 == com.anythink.expressad.exoplayer.e.a.a.x || i19 == com.anythink.expressad.exoplayer.e.a.a.y) ? "audio/vnd.dts.hd" : i19 == com.anythink.expressad.exoplayer.e.a.a.z ? "audio/vnd.dts.hd;profile=lbr" : i19 == com.anythink.expressad.exoplayer.e.a.a.aD ? "audio/3gpp" : i19 == com.anythink.expressad.exoplayer.e.a.a.aE ? "audio/amr-wb" : (i19 == com.anythink.expressad.exoplayer.e.a.a.q || i19 == com.anythink.expressad.exoplayer.e.a.a.r) ? "audio/raw" : i19 == com.anythink.expressad.exoplayer.e.a.a.o ? "audio/mpeg" : i19 == com.anythink.expressad.exoplayer.e.a.a.aT ? "audio/alac" : null;
                while (i27 - i5 < i18) {
                    sVar.c(i27);
                    int i28 = sVar.i();
                    com.anythink.expressad.exoplayer.k.a.a(i28 > 0, str11);
                    int i29 = sVar.i();
                    int i30 = com.anythink.expressad.exoplayer.e.a.a.O;
                    if (i29 == i30 || (z && i29 == com.anythink.expressad.exoplayer.e.a.a.p)) {
                        i11 = i28;
                        str4 = str14;
                        java.lang.String str16 = str11;
                        java.lang.String str17 = str15;
                        eVar5 = eVar4;
                        i12 = i27;
                        if (i29 == i30) {
                            c2 = i12;
                            str5 = str16;
                        } else {
                            c2 = sVar.c();
                            while (c2 - i12 < i11) {
                                sVar.c(c2);
                                int i31 = sVar.i();
                                str5 = str16;
                                com.anythink.expressad.exoplayer.k.a.a(i31 > 0, str5);
                                if (sVar.i() != com.anythink.expressad.exoplayer.e.a.a.O) {
                                    c2 += i31;
                                    str16 = str5;
                                }
                            }
                            str5 = str16;
                            i13 = -1;
                            c2 = -1;
                            if (c2 == i13) {
                                android.util.Pair<java.lang.String, byte[]> d5 = d(sVar, c2);
                                str6 = (java.lang.String) d5.first;
                                bArr3 = (byte[]) d5.second;
                                if ("audio/mp4a-latm".equals(str6)) {
                                    android.util.Pair<java.lang.Integer, java.lang.Integer> a4 = com.anythink.expressad.exoplayer.k.d.a(bArr3);
                                    int intValue = ((java.lang.Integer) a4.first).intValue();
                                    i25 = ((java.lang.Integer) a4.second).intValue();
                                    i26 = intValue;
                                }
                            } else {
                                str6 = str17;
                            }
                            str7 = str6;
                        }
                        i13 = -1;
                        if (c2 == i13) {
                        }
                        str7 = str6;
                    } else {
                        if (i29 == com.anythink.expressad.exoplayer.e.a.a.t) {
                            sVar.c(i27 + 8);
                            cVar.c = com.anythink.expressad.exoplayer.b.a.a(sVar, java.lang.Integer.toString(i2), str, eVar4);
                        } else if (i29 == com.anythink.expressad.exoplayer.e.a.a.v) {
                            sVar.c(i27 + 8);
                            cVar.c = com.anythink.expressad.exoplayer.b.a.b(sVar, java.lang.Integer.toString(i2), str, eVar4);
                        } else {
                            if (i29 == com.anythink.expressad.exoplayer.e.a.a.A) {
                                i11 = i28;
                                i14 = i27;
                                str4 = str14;
                                str8 = str11;
                                str7 = str15;
                                eVar5 = eVar4;
                                cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), str15, null, -1, i25, i26, null, eVar4, str);
                            } else {
                                i11 = i28;
                                i14 = i27;
                                str4 = str14;
                                str8 = str11;
                                str7 = str15;
                                eVar5 = eVar4;
                                if (i29 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                                    byte[] bArr4 = new byte[i11];
                                    i12 = i14;
                                    sVar.c(i12);
                                    sVar.a(bArr4, 0, i11);
                                    bArr3 = bArr4;
                                    str5 = str8;
                                }
                            }
                            i12 = i14;
                            str5 = str8;
                        }
                        i11 = i28;
                        str4 = str14;
                        str8 = str11;
                        str7 = str15;
                        eVar5 = eVar4;
                        i12 = i27;
                        str5 = str8;
                    }
                    i27 = i12 + i11;
                    str11 = str5;
                    eVar4 = eVar5;
                    str14 = str4;
                    str15 = str7;
                }
                java.lang.String str18 = str14;
                java.lang.String str19 = str15;
                com.anythink.expressad.exoplayer.d.e eVar7 = eVar4;
                if (cVar.c != null || str19 == null) {
                    i7 = i18;
                } else {
                    i7 = i18;
                    cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), str19, (java.lang.String) null, -1, i25, i26, str18.equals(str19) ? 2 : -1, (java.util.List<byte[]>) (bArr3 == null ? null : java.util.Collections.singletonList(bArr3)), eVar7, str);
                }
            } else {
                int i32 = com.anythink.expressad.exoplayer.e.a.a.ao;
                if (i19 == i32 || i19 == com.anythink.expressad.exoplayer.e.a.a.az || i19 == com.anythink.expressad.exoplayer.e.a.a.aA || i19 == com.anythink.expressad.exoplayer.e.a.a.aB || i19 == com.anythink.expressad.exoplayer.e.a.a.aC) {
                    sVar.c(c3 + 8 + 8);
                    long j = Long.MAX_VALUE;
                    if (i19 != i32) {
                        if (i19 == com.anythink.expressad.exoplayer.e.a.a.az) {
                            int i33 = (i18 - 8) - 8;
                            byte[] bArr5 = new byte[i33];
                            sVar.a(bArr5, i16, i33);
                            java.util.List singletonList = java.util.Collections.singletonList(bArr5);
                            str10 = "application/x-quicktime-tx3g";
                            list2 = singletonList;
                        } else {
                            if (i19 == com.anythink.expressad.exoplayer.e.a.a.aA) {
                                str9 = "application/x-mp4-vtt";
                            } else if (i19 == com.anythink.expressad.exoplayer.e.a.a.aB) {
                                j = 0;
                            } else {
                                if (i19 != com.anythink.expressad.exoplayer.e.a.a.aC) {
                                    throw new java.lang.IllegalStateException();
                                }
                                cVar.e = 1;
                                str9 = "application/x-mp4-cea-608";
                            }
                            str10 = str9;
                            list2 = null;
                        }
                        i4 = i17;
                        i6 = i15;
                        cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), str10, (java.lang.String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, (java.util.List<byte[]>) list2);
                        i7 = i18;
                        i5 = c3;
                    }
                    list2 = null;
                    str10 = "application/ttml+xml";
                    i4 = i17;
                    i6 = i15;
                    cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), str10, (java.lang.String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, (java.util.List<byte[]>) list2);
                    i7 = i18;
                    i5 = c3;
                } else {
                    if (i19 == com.anythink.expressad.exoplayer.e.a.a.aS) {
                        cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i2), "application/x-camera-motion", (java.lang.String) null, (com.anythink.expressad.exoplayer.d.e) null);
                    }
                    i4 = i17;
                    i5 = c3;
                    i6 = i15;
                    i7 = i18;
                }
            }
            sVar.c(i5 + i7);
            i17 = i4 + 1;
            i15 = i6;
            i16 = 0;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a4, code lost:
    
        if (r5 == 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.expressad.exoplayer.e.a.j a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, com.anythink.expressad.exoplayer.e.a.a.b bVar, long j, com.anythink.expressad.exoplayer.d.e eVar, boolean z, boolean z2) {
        boolean z3;
        long h2;
        com.anythink.expressad.exoplayer.e.a.a.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        com.anythink.expressad.exoplayer.e.a.a.C0190a e2 = c0190a.e(com.anythink.expressad.exoplayer.e.a.a.J);
        com.anythink.expressad.exoplayer.k.s sVar = e2.d(com.anythink.expressad.exoplayer.e.a.a.X).aV;
        sVar.c(16);
        int i2 = sVar.i();
        int i3 = i2 == c ? 1 : i2 == b ? 2 : (i2 == d || i2 == e || i2 == f || i2 == g) ? 3 : i2 == h ? 4 : -1;
        if (i3 == -1) {
            return null;
        }
        com.anythink.expressad.exoplayer.k.s sVar2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.T).aV;
        sVar2.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar2.i());
        sVar2.d(a2 == 0 ? 8 : 16);
        int i4 = sVar2.i();
        sVar2.d(4);
        int c2 = sVar2.c();
        int i5 = a2 == 0 ? 4 : 8;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= i5) {
                z3 = true;
                break;
            }
            if (sVar2.a[c2 + i7] != -1) {
                z3 = false;
                break;
            }
            i7++;
        }
        if (z3) {
            sVar2.d(i5);
        } else {
            h2 = a2 == 0 ? sVar2.h() : sVar2.n();
        }
        h2 = -9223372036854775807L;
        sVar2.d(16);
        int i8 = sVar2.i();
        int i9 = sVar2.i();
        sVar2.d(4);
        int i10 = sVar2.i();
        int i11 = sVar2.i();
        if (i8 == 0 && i9 == 65536 && i10 == -65536 && i11 == 0) {
            i6 = 90;
        } else if (i8 == 0 && i9 == -65536 && i10 == 65536 && i11 == 0) {
            i6 = 270;
        } else if (i8 == -65536 && i9 == 0 && i10 == 0 && i11 == -65536) {
            i6 = 180;
        }
        com.anythink.expressad.exoplayer.e.a.b.f fVar = new com.anythink.expressad.exoplayer.e.a.b.f(i4, h2, i6);
        if (j == -9223372036854775807L) {
            j2 = fVar.b;
            bVar2 = bVar;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        com.anythink.expressad.exoplayer.k.s sVar3 = bVar2.aV;
        sVar3.c(8);
        sVar3.d(com.anythink.expressad.exoplayer.e.a.a.a(sVar3.i()) == 0 ? 8 : 16);
        long h3 = sVar3.h();
        long a3 = j2 != -9223372036854775807L ? com.anythink.expressad.exoplayer.k.af.a(j2, 1000000L, h3) : -9223372036854775807L;
        com.anythink.expressad.exoplayer.e.a.a.C0190a e3 = e2.e(com.anythink.expressad.exoplayer.e.a.a.K).e(com.anythink.expressad.exoplayer.e.a.a.L);
        com.anythink.expressad.exoplayer.k.s sVar4 = e2.d(com.anythink.expressad.exoplayer.e.a.a.W).aV;
        sVar4.c(8);
        int a4 = com.anythink.expressad.exoplayer.e.a.a.a(sVar4.i());
        sVar4.d(a4 == 0 ? 8 : 16);
        long h4 = sVar4.h();
        sVar4.d(a4 == 0 ? 4 : 8);
        int e4 = sVar4.e();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((char) (((e4 >> 10) & 31) + 96));
        sb.append((char) (((e4 >> 5) & 31) + 96));
        sb.append((char) ((e4 & 31) + 96));
        android.util.Pair create = android.util.Pair.create(java.lang.Long.valueOf(h4), sb.toString());
        com.anythink.expressad.exoplayer.e.a.b.c a5 = a(e3.d(com.anythink.expressad.exoplayer.e.a.a.Y).aV, fVar.a, fVar.c, (java.lang.String) create.second, eVar, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            android.util.Pair<long[], long[]> a6 = a(c0190a.e(com.anythink.expressad.exoplayer.e.a.a.U));
            long[] jArr3 = (long[]) a6.first;
            jArr2 = (long[]) a6.second;
            jArr = jArr3;
        }
        if (a5.c == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.e.a.j(fVar.a, i3, ((java.lang.Long) create.first).longValue(), h3, a3, a5.c, a5.e, a5.b, a5.d, jArr, jArr2);
    }

    private static com.anythink.expressad.exoplayer.e.a.k a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, java.lang.String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            sVar.c(i6);
            int i7 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.ad) {
                int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
                sVar.d(1);
                if (a2 == 0) {
                    sVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int d2 = sVar.d();
                    i4 = d2 & 15;
                    i5 = (d2 & 240) >> 4;
                }
                boolean z = sVar.d() == 1;
                int d3 = sVar.d();
                byte[] bArr2 = new byte[16];
                sVar.a(bArr2, 0, 16);
                if (z && d3 == 0) {
                    int d4 = sVar.d();
                    bArr = new byte[d4];
                    sVar.a(bArr, 0, d4);
                }
                return new com.anythink.expressad.exoplayer.e.a.k(z, str, d3, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    public static com.anythink.expressad.exoplayer.e.a.m a(com.anythink.expressad.exoplayer.e.a.j jVar, com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, com.anythink.expressad.exoplayer.e.i iVar) {
        com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b eVar;
        boolean z;
        int i2;
        int i3;
        com.anythink.expressad.exoplayer.e.a.j jVar2;
        int i4;
        long[] jArr;
        int[] iArr;
        long j;
        int[] iArr2;
        long[] jArr2;
        int i5;
        int[] iArr3;
        long j2;
        int[] iArr4;
        long[] jArr3;
        int[] iArr5;
        int[] iArr6;
        int i6;
        long[] jArr4;
        int[] iArr7;
        long[] jArr5;
        int i7;
        int i8;
        com.anythink.expressad.exoplayer.e.a.b.InterfaceC0191b interfaceC0191b;
        long[] jArr6;
        int i9;
        int i10;
        com.anythink.expressad.exoplayer.e.a.a.b d2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.av);
        if (d2 != null) {
            eVar = new com.anythink.expressad.exoplayer.e.a.b.d(d2);
        } else {
            com.anythink.expressad.exoplayer.e.a.a.b d3 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.aw);
            if (d3 == null) {
                throw new com.anythink.expressad.exoplayer.t("Track has no sample table size information");
            }
            eVar = new com.anythink.expressad.exoplayer.e.a.b.e(d3);
        }
        int a2 = eVar.a();
        if (a2 == 0) {
            return new com.anythink.expressad.exoplayer.e.a.m(jVar, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        com.anythink.expressad.exoplayer.e.a.a.b d4 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ax);
        if (d4 == null) {
            d4 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ay);
            z = true;
        } else {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.s sVar = d4.aV;
        com.anythink.expressad.exoplayer.k.s sVar2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.au).aV;
        com.anythink.expressad.exoplayer.k.s sVar3 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ar).aV;
        com.anythink.expressad.exoplayer.e.a.a.b d5 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.as);
        com.anythink.expressad.exoplayer.k.s sVar4 = null;
        com.anythink.expressad.exoplayer.k.s sVar5 = d5 != null ? d5.aV : null;
        com.anythink.expressad.exoplayer.e.a.a.b d6 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.at);
        com.anythink.expressad.exoplayer.k.s sVar6 = d6 != null ? d6.aV : null;
        com.anythink.expressad.exoplayer.e.a.b.a aVar = new com.anythink.expressad.exoplayer.e.a.b.a(sVar2, sVar, z);
        sVar3.c(12);
        int m = sVar3.m() - 1;
        int m2 = sVar3.m();
        int m3 = sVar3.m();
        if (sVar6 != null) {
            sVar6.c(12);
            i2 = sVar6.m();
        } else {
            i2 = 0;
        }
        int i11 = -1;
        if (sVar5 != null) {
            sVar5.c(12);
            i3 = sVar5.m();
            if (i3 > 0) {
                i11 = sVar5.m() - 1;
                sVar4 = sVar5;
            }
        } else {
            sVar4 = sVar5;
            i3 = 0;
        }
        long j3 = 0;
        if (eVar.c() && "audio/raw".equals(jVar.h.h) && m == 0 && i2 == 0 && i3 == 0) {
            jVar2 = jVar;
            int i12 = aVar.a;
            long[] jArr7 = new long[i12];
            int[] iArr8 = new int[i12];
            while (aVar.a()) {
                int i13 = aVar.b;
                jArr7[i13] = aVar.d;
                iArr8[i13] = aVar.c;
            }
            com.anythink.expressad.exoplayer.m mVar = jVar2.h;
            com.anythink.expressad.exoplayer.e.a.d.a a3 = com.anythink.expressad.exoplayer.e.a.d.a(com.anythink.expressad.exoplayer.k.af.b(mVar.w, mVar.u), jArr7, iArr8, m3);
            long[] jArr8 = a3.a;
            int[] iArr9 = a3.b;
            i4 = a3.c;
            jArr = a3.d;
            iArr = a3.e;
            j = a3.f;
            iArr2 = iArr9;
            jArr2 = jArr8;
        } else {
            long[] jArr9 = new long[a2];
            iArr2 = new int[a2];
            long[] jArr10 = new long[a2];
            int i14 = i3;
            int[] iArr10 = new int[a2];
            int i15 = i11;
            long j4 = 0;
            long j5 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = i2;
            int i22 = m3;
            int i23 = m2;
            int i24 = m;
            int i25 = i14;
            while (i16 < a2) {
                while (i20 == 0) {
                    com.anythink.expressad.exoplayer.k.a.b(aVar.a());
                    j5 = aVar.d;
                    i20 = aVar.c;
                    i22 = i22;
                    i23 = i23;
                }
                int i26 = i23;
                int i27 = i22;
                if (sVar6 != null) {
                    while (i19 == 0 && i21 > 0) {
                        i19 = sVar6.m();
                        i18 = sVar6.i();
                        i21--;
                    }
                    i19--;
                }
                int i28 = i18;
                jArr9[i16] = j5;
                int b2 = eVar.b();
                iArr2[i16] = b2;
                if (b2 > i17) {
                    jArr6 = jArr9;
                    i17 = b2;
                    interfaceC0191b = eVar;
                } else {
                    interfaceC0191b = eVar;
                    jArr6 = jArr9;
                }
                jArr10[i16] = j4 + i28;
                iArr10[i16] = sVar4 == null ? 1 : 0;
                if (i16 == i15) {
                    iArr10[i16] = 1;
                    i25--;
                    if (i25 > 0) {
                        i15 = sVar4.m() - 1;
                    }
                }
                int[] iArr11 = iArr10;
                j4 += i27;
                int i29 = i26 - 1;
                if (i29 != 0 || i24 <= 0) {
                    i9 = i27;
                    i10 = i29;
                } else {
                    i10 = sVar3.m();
                    i9 = sVar3.i();
                    i24--;
                }
                int i30 = i10;
                int i31 = i9;
                j5 += iArr2[i16];
                i20--;
                i16++;
                eVar = interfaceC0191b;
                jArr9 = jArr6;
                iArr10 = iArr11;
                i22 = i31;
                i18 = i28;
                i23 = i30;
            }
            int[] iArr12 = iArr10;
            int i32 = i23;
            int i33 = i18;
            long[] jArr11 = jArr9;
            long j6 = j4 + i33;
            com.anythink.expressad.exoplayer.k.a.a(i19 == 0);
            while (i21 > 0) {
                com.anythink.expressad.exoplayer.k.a.a(sVar6.m() == 0);
                sVar6.i();
                i21--;
            }
            if (i25 == 0 && i32 == 0) {
                i8 = i20;
                if (i8 == 0 && i24 == 0) {
                    jVar2 = jVar;
                    jArr = jArr10;
                    i4 = i17;
                    jArr2 = jArr11;
                    j = j6;
                    iArr = iArr12;
                }
            } else {
                i8 = i20;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Inconsistent stbl box for track ");
            jVar2 = jVar;
            sb.append(jVar2.c);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i25);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i32);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i8);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i24);
            jArr = jArr10;
            i4 = i17;
            jArr2 = jArr11;
            j = j6;
            iArr = iArr12;
        }
        long a4 = com.anythink.expressad.exoplayer.k.af.a(j, 1000000L, jVar2.e);
        if (jVar2.j == null || iVar.a()) {
            int[] iArr13 = iArr2;
            com.anythink.expressad.exoplayer.k.af.a(jArr, jVar2.e);
            return new com.anythink.expressad.exoplayer.e.a.m(jVar, jArr2, iArr13, i4, jArr, iArr, a4);
        }
        long[] jArr12 = jVar2.j;
        if (jArr12.length == 1 && jVar2.d == 1 && jArr.length >= 2) {
            long j7 = jVar2.k[0];
            iArr3 = iArr2;
            long a5 = com.anythink.expressad.exoplayer.k.af.a(jArr12[0], jVar2.e, jVar2.f) + j7;
            int length = jArr.length - 1;
            i5 = a2;
            int a6 = com.anythink.expressad.exoplayer.k.af.a(3, 0, length);
            int a7 = com.anythink.expressad.exoplayer.k.af.a(jArr.length - 3, 0, length);
            long j8 = jArr[0];
            if (j8 <= j7 && j7 < jArr[a6] && jArr[a7] < a5 && a5 <= j) {
                long j9 = j - a5;
                long a8 = com.anythink.expressad.exoplayer.k.af.a(j7 - j8, jVar2.h.v, jVar2.e);
                long a9 = com.anythink.expressad.exoplayer.k.af.a(j9, jVar2.h.v, jVar2.e);
                if ((a8 != 0 || a9 != 0) && a8 <= 2147483647L && a9 <= 2147483647L) {
                    iVar.b = (int) a8;
                    iVar.c = (int) a9;
                    com.anythink.expressad.exoplayer.k.af.a(jArr, jVar2.e);
                    return new com.anythink.expressad.exoplayer.e.a.m(jVar, jArr2, iArr3, i4, jArr, iArr, a4);
                }
            }
        } else {
            i5 = a2;
            iArr3 = iArr2;
        }
        long[] jArr13 = jVar2.j;
        if (jArr13.length == 1 && jArr13[0] == 0) {
            long j10 = jVar2.k[0];
            for (int i34 = 0; i34 < jArr.length; i34++) {
                jArr[i34] = com.anythink.expressad.exoplayer.k.af.a(jArr[i34] - j10, 1000000L, jVar2.e);
            }
            return new com.anythink.expressad.exoplayer.e.a.m(jVar, jArr2, iArr3, i4, jArr, iArr, com.anythink.expressad.exoplayer.k.af.a(j - j10, 1000000L, jVar2.e));
        }
        boolean z2 = jVar2.d == 1;
        boolean z3 = false;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        while (true) {
            long[] jArr14 = jVar2.j;
            j2 = -1;
            if (i37 >= jArr14.length) {
                break;
            }
            long j11 = jVar2.k[i37];
            if (j11 != -1) {
                jArr5 = jArr2;
                i7 = i4;
                long a10 = com.anythink.expressad.exoplayer.k.af.a(jArr14[i37], jVar2.e, jVar2.f);
                int a11 = com.anythink.expressad.exoplayer.k.af.a(jArr, j11, true, true);
                int a12 = com.anythink.expressad.exoplayer.k.af.a(jArr, j11 + a10, z2, false);
                i35 += a12 - a11;
                z3 |= i36 != a11;
                i36 = a12;
            } else {
                jArr5 = jArr2;
                i7 = i4;
            }
            i37++;
            jArr2 = jArr5;
            i4 = i7;
        }
        long[] jArr15 = jArr2;
        int i38 = i4;
        boolean z4 = z3 | (i35 != i5);
        long[] jArr16 = z4 ? new long[i35] : jArr15;
        int[] iArr14 = z4 ? new int[i35] : iArr3;
        if (z4) {
            i38 = 0;
        }
        int[] iArr15 = z4 ? new int[i35] : iArr;
        long[] jArr17 = new long[i35];
        int i39 = 0;
        int i40 = 0;
        while (true) {
            long[] jArr18 = jVar2.j;
            if (i39 >= jArr18.length) {
                return new com.anythink.expressad.exoplayer.e.a.m(jVar, jArr16, iArr14, i38, jArr17, iArr15, com.anythink.expressad.exoplayer.k.af.a(j3, 1000000L, jVar2.e));
            }
            int[] iArr16 = iArr;
            int[] iArr17 = iArr15;
            long j12 = jVar2.k[i39];
            long j13 = jArr18[i39];
            if (j12 != j2) {
                long a13 = com.anythink.expressad.exoplayer.k.af.a(j13, jVar2.e, jVar2.f) + j12;
                int a14 = com.anythink.expressad.exoplayer.k.af.a(jArr, j12, true, true);
                int a15 = com.anythink.expressad.exoplayer.k.af.a(jArr, a13, z2, false);
                if (z4) {
                    int i41 = a15 - a14;
                    java.lang.System.arraycopy(jArr15, a14, jArr16, i40, i41);
                    iArr4 = iArr3;
                    java.lang.System.arraycopy(iArr4, a14, iArr14, i40, i41);
                    jArr3 = jArr15;
                    iArr5 = iArr16;
                    jArr4 = jArr16;
                    iArr7 = iArr17;
                    java.lang.System.arraycopy(iArr5, a14, iArr7, i40, i41);
                } else {
                    iArr4 = iArr3;
                    jArr3 = jArr15;
                    iArr5 = iArr16;
                    jArr4 = jArr16;
                    iArr7 = iArr17;
                }
                if (a14 < a15 && (iArr7[i40] & 1) == 0) {
                    throw new com.anythink.expressad.exoplayer.e.a.b.g();
                }
                int i42 = i38;
                while (a14 < a15) {
                    int i43 = i39;
                    int[] iArr18 = iArr7;
                    long j14 = j12;
                    jArr17[i40] = com.anythink.expressad.exoplayer.k.af.a(j3, 1000000L, jVar2.f) + com.anythink.expressad.exoplayer.k.af.a(jArr[a14] - j12, 1000000L, jVar2.e);
                    if (z4 && iArr14[i40] > i42) {
                        i42 = iArr4[a14];
                    }
                    i40++;
                    a14++;
                    iArr7 = iArr18;
                    j12 = j14;
                    i39 = i43;
                }
                i6 = i39;
                iArr6 = iArr7;
                i38 = i42;
            } else {
                iArr4 = iArr3;
                jArr3 = jArr15;
                iArr5 = iArr16;
                iArr6 = iArr17;
                i6 = i39;
                jArr4 = jArr16;
            }
            j3 += j13;
            i39 = i6 + 1;
            iArr15 = iArr6;
            iArr = iArr5;
            jArr16 = jArr4;
            j2 = -1;
            jArr15 = jArr3;
            iArr3 = iArr4;
        }
    }

    public static com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.e.a.a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        com.anythink.expressad.exoplayer.k.s sVar = bVar.aV;
        sVar.c(8);
        while (sVar.a() >= 8) {
            int c2 = sVar.c();
            int i2 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aG) {
                sVar.c(c2);
                int i3 = c2 + i2;
                sVar.d(12);
                while (true) {
                    if (sVar.c() >= i3) {
                        break;
                    }
                    int c3 = sVar.c();
                    int i4 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                        sVar.c(c3);
                        int i5 = c3 + i4;
                        sVar.d(8);
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        while (sVar.c() < i5) {
                            com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new com.anythink.expressad.exoplayer.g.a(arrayList);
                        }
                    } else {
                        sVar.d(i4 - 8);
                    }
                }
                return null;
            }
            sVar.d(i2 - 8);
        }
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        sVar.d(12);
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int i3 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aH) {
                sVar.c(c2);
                int i4 = c2 + i3;
                sVar.d(8);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (sVar.c() < i4) {
                    com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new com.anythink.expressad.exoplayer.g.a(arrayList);
            }
            sVar.d(i3 - 8);
        }
        return null;
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, int i4, int i5, int i6, com.anythink.expressad.exoplayer.d.e eVar, com.anythink.expressad.exoplayer.e.a.b.c cVar, int i7) {
        int i8 = i3;
        com.anythink.expressad.exoplayer.d.e eVar2 = eVar;
        sVar.c(i8 + 8 + 8);
        sVar.d(16);
        int e2 = sVar.e();
        int e3 = sVar.e();
        sVar.d(50);
        int c2 = sVar.c();
        int i9 = i2;
        if (i9 == com.anythink.expressad.exoplayer.e.a.a.ae) {
            android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> b2 = b(sVar, i8, i4);
            if (b2 != null) {
                i9 = ((java.lang.Integer) b2.first).intValue();
                eVar2 = eVar2 == null ? null : eVar2.a(((com.anythink.expressad.exoplayer.e.a.k) b2.second).b);
                cVar.b[i7] = (com.anythink.expressad.exoplayer.e.a.k) b2.second;
            }
            sVar.c(c2);
        }
        com.anythink.expressad.exoplayer.d.e eVar3 = eVar2;
        boolean z = false;
        java.lang.String str = null;
        java.util.List<byte[]> list = null;
        float f2 = 1.0f;
        byte[] bArr = null;
        int i10 = -1;
        while (c2 - i8 < i4) {
            sVar.c(c2);
            int c3 = sVar.c();
            int i11 = sVar.i();
            if (i11 == 0 && sVar.c() - i8 == i4) {
                break;
            }
            com.anythink.expressad.exoplayer.k.a.a(i11 > 0, "childAtomSize should be positive");
            int i12 = sVar.i();
            if (i12 == com.anythink.expressad.exoplayer.e.a.a.M) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                sVar.c(c3 + 8);
                com.anythink.expressad.exoplayer.l.a a2 = com.anythink.expressad.exoplayer.l.a.a(sVar);
                list = a2.a;
                cVar.d = a2.b;
                if (!z) {
                    f2 = a2.e;
                }
                str = "video/avc";
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.N) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                sVar.c(c3 + 8);
                com.anythink.expressad.exoplayer.l.d a3 = com.anythink.expressad.exoplayer.l.d.a(sVar);
                list = a3.a;
                cVar.d = a3.b;
                str = "video/hevc";
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.aR) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                str = i9 == com.anythink.expressad.exoplayer.e.a.a.aP ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.l) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                str = "video/3gpp";
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.O) {
                com.anythink.expressad.exoplayer.k.a.b(str == null);
                android.util.Pair<java.lang.String, byte[]> d2 = d(sVar, c3);
                str = (java.lang.String) d2.first;
                list = java.util.Collections.singletonList((byte[]) d2.second);
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.an) {
                sVar.c(c3 + 8);
                f2 = sVar.m() / sVar.m();
                z = true;
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.aN) {
                int i13 = c3 + 8;
                while (true) {
                    if (i13 - c3 >= i11) {
                        bArr = null;
                        break;
                    }
                    sVar.c(i13);
                    int i14 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                        bArr = java.util.Arrays.copyOfRange(sVar.a, i13, i14 + i13);
                        break;
                    }
                    i13 += i14;
                }
            } else if (i12 == com.anythink.expressad.exoplayer.e.a.a.aM) {
                int d3 = sVar.d();
                sVar.d(3);
                if (d3 == 0) {
                    int d4 = sVar.d();
                    if (d4 == 0) {
                        i10 = 0;
                    } else if (d4 == 1) {
                        i10 = 1;
                    } else if (d4 == 2) {
                        i10 = 2;
                    } else if (d4 == 3) {
                        i10 = 3;
                    }
                }
            }
            c2 += i11;
            i8 = i3;
        }
        if (str == null) {
            return;
        }
        cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i5), str, null, -1, -1, e2, e3, -1.0f, list, i6, f2, bArr, i10, null, eVar3);
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, int i4, int i5, java.lang.String str, com.anythink.expressad.exoplayer.e.a.b.c cVar) {
        sVar.c(i3 + 8 + 8);
        java.lang.String str2 = "application/ttml+xml";
        java.util.List list = null;
        long j = Long.MAX_VALUE;
        if (i2 != com.anythink.expressad.exoplayer.e.a.a.ao) {
            if (i2 == com.anythink.expressad.exoplayer.e.a.a.az) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                sVar.a(bArr, 0, i6);
                list = java.util.Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aA) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.aB) {
                j = 0;
            } else {
                if (i2 != com.anythink.expressad.exoplayer.e.a.a.aC) {
                    throw new java.lang.IllegalStateException();
                }
                cVar.e = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i5), str2, (java.lang.String) null, -1, 0, str, -1, (com.anythink.expressad.exoplayer.d.e) null, j, (java.util.List<byte[]>) list);
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3, int i4, int i5, java.lang.String str, boolean z, com.anythink.expressad.exoplayer.d.e eVar, com.anythink.expressad.exoplayer.e.a.b.c cVar, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        java.lang.String str2;
        java.lang.String str3;
        com.anythink.expressad.exoplayer.d.e eVar2;
        int c2;
        int i12 = i3;
        com.anythink.expressad.exoplayer.d.e eVar3 = eVar;
        sVar.c(i12 + 8 + 8);
        if (z) {
            i7 = sVar.e();
            sVar.d(6);
        } else {
            sVar.d(8);
            i7 = 0;
        }
        if (i7 == 0 || i7 == 1) {
            int e2 = sVar.e();
            sVar.d(6);
            int k = sVar.k();
            if (i7 == 1) {
                sVar.d(16);
            }
            i8 = k;
            i9 = e2;
        } else {
            if (i7 != 2) {
                return;
            }
            sVar.d(16);
            i8 = (int) java.lang.Math.round(java.lang.Double.longBitsToDouble(sVar.j()));
            i9 = sVar.m();
            sVar.d(20);
        }
        int c3 = sVar.c();
        int i13 = i2;
        if (i13 == com.anythink.expressad.exoplayer.e.a.a.af) {
            android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> b2 = b(sVar, i12, i4);
            if (b2 != null) {
                i13 = ((java.lang.Integer) b2.first).intValue();
                eVar3 = eVar3 == null ? null : eVar3.a(((com.anythink.expressad.exoplayer.e.a.k) b2.second).b);
                cVar.b[i6] = (com.anythink.expressad.exoplayer.e.a.k) b2.second;
            }
            sVar.c(c3);
        }
        com.anythink.expressad.exoplayer.d.e eVar4 = eVar3;
        java.lang.String str4 = "audio/raw";
        java.lang.String str5 = i13 == com.anythink.expressad.exoplayer.e.a.a.f213s ? "audio/ac3" : i13 == com.anythink.expressad.exoplayer.e.a.a.u ? "audio/eac3" : i13 == com.anythink.expressad.exoplayer.e.a.a.w ? "audio/vnd.dts" : (i13 == com.anythink.expressad.exoplayer.e.a.a.x || i13 == com.anythink.expressad.exoplayer.e.a.a.y) ? "audio/vnd.dts.hd" : i13 == com.anythink.expressad.exoplayer.e.a.a.z ? "audio/vnd.dts.hd;profile=lbr" : i13 == com.anythink.expressad.exoplayer.e.a.a.aD ? "audio/3gpp" : i13 == com.anythink.expressad.exoplayer.e.a.a.aE ? "audio/amr-wb" : (i13 == com.anythink.expressad.exoplayer.e.a.a.q || i13 == com.anythink.expressad.exoplayer.e.a.a.r) ? "audio/raw" : i13 == com.anythink.expressad.exoplayer.e.a.a.o ? "audio/mpeg" : i13 == com.anythink.expressad.exoplayer.e.a.a.aT ? "audio/alac" : null;
        int i14 = i9;
        int i15 = i8;
        int i16 = c3;
        byte[] bArr = null;
        while (i16 - i12 < i4) {
            sVar.c(i16);
            int i17 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i17 > 0, "childAtomSize should be positive");
            int i18 = sVar.i();
            int i19 = com.anythink.expressad.exoplayer.e.a.a.O;
            if (i18 == i19 || (z && i18 == com.anythink.expressad.exoplayer.e.a.a.p)) {
                i10 = i17;
                i11 = i16;
                str2 = str5;
                str3 = str4;
                eVar2 = eVar4;
                if (i18 != i19) {
                    c2 = sVar.c();
                    while (true) {
                        if (c2 - i11 >= i10) {
                            c2 = -1;
                            break;
                        }
                        sVar.c(c2);
                        int i20 = sVar.i();
                        com.anythink.expressad.exoplayer.k.a.a(i20 > 0, "childAtomSize should be positive");
                        if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.O) {
                            break;
                        } else {
                            c2 += i20;
                        }
                    }
                } else {
                    c2 = i11;
                }
                if (c2 != -1) {
                    android.util.Pair<java.lang.String, byte[]> d2 = d(sVar, c2);
                    java.lang.String str6 = (java.lang.String) d2.first;
                    byte[] bArr2 = (byte[]) d2.second;
                    if ("audio/mp4a-latm".equals(str6)) {
                        android.util.Pair<java.lang.Integer, java.lang.Integer> a2 = com.anythink.expressad.exoplayer.k.d.a(bArr2);
                        int intValue = ((java.lang.Integer) a2.first).intValue();
                        bArr = bArr2;
                        str5 = str6;
                        i14 = ((java.lang.Integer) a2.second).intValue();
                        i15 = intValue;
                    } else {
                        bArr = bArr2;
                        str5 = str6;
                    }
                    i16 = i11 + i10;
                    i12 = i3;
                    eVar4 = eVar2;
                    str4 = str3;
                }
            } else {
                if (i18 == com.anythink.expressad.exoplayer.e.a.a.t) {
                    sVar.c(i16 + 8);
                    cVar.c = com.anythink.expressad.exoplayer.b.a.a(sVar, java.lang.Integer.toString(i5), str, eVar4);
                } else if (i18 == com.anythink.expressad.exoplayer.e.a.a.v) {
                    sVar.c(i16 + 8);
                    cVar.c = com.anythink.expressad.exoplayer.b.a.b(sVar, java.lang.Integer.toString(i5), str, eVar4);
                } else if (i18 == com.anythink.expressad.exoplayer.e.a.a.A) {
                    i10 = i17;
                    str2 = str5;
                    str3 = str4;
                    eVar2 = eVar4;
                    i11 = i16;
                    cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i5), str5, null, -1, i14, i15, null, eVar4, str);
                } else {
                    i10 = i17;
                    i11 = i16;
                    str2 = str5;
                    str3 = str4;
                    eVar2 = eVar4;
                    if (i18 == com.anythink.expressad.exoplayer.e.a.a.aT) {
                        byte[] bArr3 = new byte[i10];
                        sVar.c(i11);
                        sVar.a(bArr3, 0, i10);
                        bArr = bArr3;
                    }
                }
                i10 = i17;
                i11 = i16;
                str2 = str5;
                str3 = str4;
                eVar2 = eVar4;
            }
            str5 = str2;
            i16 = i11 + i10;
            i12 = i3;
            eVar4 = eVar2;
            str4 = str3;
        }
        java.lang.String str7 = str5;
        java.lang.String str8 = str4;
        com.anythink.expressad.exoplayer.d.e eVar5 = eVar4;
        if (cVar.c != null || str7 == null) {
            return;
        }
        cVar.c = com.anythink.expressad.exoplayer.m.a(java.lang.Integer.toString(i5), str7, (java.lang.String) null, -1, i14, i15, str8.equals(str7) ? 2 : -1, (java.util.List<byte[]>) (bArr == null ? null : java.util.Collections.singletonList(bArr)), eVar5, str);
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[com.anythink.expressad.exoplayer.k.af.a(3, 0, length)] && jArr[com.anythink.expressad.exoplayer.k.af.a(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    private static android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> b(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3) {
        android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> c2;
        int c3 = sVar.c();
        while (c3 - i2 < i3) {
            sVar.c(c3);
            int i4 = sVar.i();
            com.anythink.expressad.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aa && (c2 = c(sVar, c3, i4)) != null) {
                return c2;
            }
            c3 += i4;
        }
        return null;
    }

    private static com.anythink.expressad.exoplayer.e.a.b.f b(com.anythink.expressad.exoplayer.k.s sVar) {
        boolean z;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(a2 == 0 ? 8 : 16);
        int i2 = sVar.i();
        sVar.d(4);
        int c2 = sVar.c();
        int i3 = a2 == 0 ? 4 : 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                z = true;
                break;
            }
            if (sVar.a[c2 + i5] != -1) {
                z = false;
                break;
            }
            i5++;
        }
        long j = -9223372036854775807L;
        if (z) {
            sVar.d(i3);
        } else {
            long h2 = a2 == 0 ? sVar.h() : sVar.n();
            if (h2 != 0) {
                j = h2;
            }
        }
        sVar.d(16);
        int i6 = sVar.i();
        int i7 = sVar.i();
        sVar.d(4);
        int i8 = sVar.i();
        int i9 = sVar.i();
        if (i6 == 0 && i7 == 65536 && i8 == -65536 && i9 == 0) {
            i4 = 90;
        } else if (i6 == 0 && i7 == -65536 && i8 == 65536 && i9 == 0) {
            i4 = 270;
        } else if (i6 == -65536 && i7 == 0 && i8 == 0 && i9 == -65536) {
            i4 = 180;
        }
        return new com.anythink.expressad.exoplayer.e.a.b.f(i2, j, i4);
    }

    private static com.anythink.expressad.exoplayer.g.a b(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        sVar.d(8);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (sVar.c() < i2) {
            com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a2 = com.anythink.expressad.exoplayer.e.a.f.a(sVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.g.a(arrayList);
    }

    private static float c(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        sVar.c(i2 + 8);
        return sVar.m() / sVar.m();
    }

    private static int c(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(16);
        int i2 = sVar.i();
        if (i2 == c) {
            return 1;
        }
        if (i2 == b) {
            return 2;
        }
        if (i2 == d || i2 == e || i2 == f || i2 == g) {
            return 3;
        }
        return i2 == h ? 4 : -1;
    }

    private static android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.k> c(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        java.lang.String str = null;
        java.lang.Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i7 = sVar.i();
            int i8 = sVar.i();
            if (i8 == com.anythink.expressad.exoplayer.e.a.a.ag) {
                num = java.lang.Integer.valueOf(sVar.i());
            } else if (i8 == com.anythink.expressad.exoplayer.e.a.a.ab) {
                sVar.d(4);
                str = sVar.o();
            } else if (i8 == com.anythink.expressad.exoplayer.e.a.a.ac) {
                i5 = i4;
                i6 = i7;
            }
            i4 += i7;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        com.anythink.expressad.exoplayer.k.a.a(num != null, "frma atom is mandatory");
        com.anythink.expressad.exoplayer.k.a.a(i5 != -1, "schi atom is mandatory");
        com.anythink.expressad.exoplayer.e.a.k a2 = a(sVar, i5, i6, str);
        com.anythink.expressad.exoplayer.k.a.a(a2 != null, "tenc atom is mandatory");
        return android.util.Pair.create(num, a2);
    }

    private static android.util.Pair<java.lang.Long, java.lang.String> d(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(a2 == 0 ? 8 : 16);
        long h2 = sVar.h();
        sVar.d(a2 == 0 ? 4 : 8);
        int e2 = sVar.e();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((char) (((e2 >> 10) & 31) + 96));
        sb.append((char) (((e2 >> 5) & 31) + 96));
        sb.append((char) ((e2 & 31) + 96));
        return android.util.Pair.create(java.lang.Long.valueOf(h2), sb.toString());
    }

    private static android.util.Pair<java.lang.String, byte[]> d(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        sVar.c(i2 + 8 + 4);
        sVar.d(1);
        e(sVar);
        sVar.d(2);
        int d2 = sVar.d();
        if ((d2 & 128) != 0) {
            sVar.d(2);
        }
        if ((d2 & 64) != 0) {
            sVar.d(sVar.e());
        }
        if ((d2 & 32) != 0) {
            sVar.d(2);
        }
        sVar.d(1);
        e(sVar);
        java.lang.String a2 = com.anythink.expressad.exoplayer.k.o.a(sVar.d());
        if ("audio/mpeg".equals(a2) || "audio/vnd.dts".equals(a2) || "audio/vnd.dts.hd".equals(a2)) {
            return android.util.Pair.create(a2, null);
        }
        sVar.d(12);
        sVar.d(1);
        int e2 = e(sVar);
        byte[] bArr = new byte[e2];
        sVar.a(bArr, 0, e2);
        return android.util.Pair.create(a2, bArr);
    }

    private static byte[] d(com.anythink.expressad.exoplayer.k.s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i5 = sVar.i();
            if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aO) {
                return java.util.Arrays.copyOfRange(sVar.a, i4, i5 + i4);
            }
            i4 += i5;
        }
        return null;
    }

    private static int e(com.anythink.expressad.exoplayer.k.s sVar) {
        int d2 = sVar.d();
        int i2 = d2 & 127;
        while ((d2 & 128) == 128) {
            d2 = sVar.d();
            i2 = (i2 << 7) | (d2 & 127);
        }
        return i2;
    }
}
