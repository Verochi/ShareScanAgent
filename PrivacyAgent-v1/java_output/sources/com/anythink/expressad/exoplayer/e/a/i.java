package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
final class i {
    private static final int a = 4096;
    private static final int[] b = {com.anythink.expressad.exoplayer.k.af.f("isom"), com.anythink.expressad.exoplayer.k.af.f("iso2"), com.anythink.expressad.exoplayer.k.af.f("iso3"), com.anythink.expressad.exoplayer.k.af.f("iso4"), com.anythink.expressad.exoplayer.k.af.f("iso5"), com.anythink.expressad.exoplayer.k.af.f("iso6"), com.anythink.expressad.exoplayer.k.af.f("avc1"), com.anythink.expressad.exoplayer.k.af.f("hvc1"), com.anythink.expressad.exoplayer.k.af.f("hev1"), com.anythink.expressad.exoplayer.k.af.f("mp41"), com.anythink.expressad.exoplayer.k.af.f("mp42"), com.anythink.expressad.exoplayer.k.af.f("3g2a"), com.anythink.expressad.exoplayer.k.af.f("3g2b"), com.anythink.expressad.exoplayer.k.af.f("3gr6"), com.anythink.expressad.exoplayer.k.af.f("3gs6"), com.anythink.expressad.exoplayer.k.af.f("3ge6"), com.anythink.expressad.exoplayer.k.af.f("3gg6"), com.anythink.expressad.exoplayer.k.af.f("M4V "), com.anythink.expressad.exoplayer.k.af.f("M4A "), com.anythink.expressad.exoplayer.k.af.f("f4v "), com.anythink.expressad.exoplayer.k.af.f("kddi"), com.anythink.expressad.exoplayer.k.af.f("M4VP"), com.anythink.expressad.exoplayer.k.af.f("qt  "), com.anythink.expressad.exoplayer.k.af.f("MSNV")};

    private i() {
    }

    private static boolean a(int i) {
        if ((i >>> 8) == com.anythink.expressad.exoplayer.k.af.f("3gp")) {
            return true;
        }
        for (int i2 : b) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return a(fVar, true);
    }

    private static boolean a(com.anythink.expressad.exoplayer.e.f fVar, boolean z) {
        boolean z2;
        int i;
        long d = fVar.d();
        long j = -1;
        if (d == -1 || d > 4096) {
            d = 4096;
        }
        int i2 = (int) d;
        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s(64);
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            sVar.a(8);
            fVar.d(sVar.a, 0, 8);
            long h = sVar.h();
            int i4 = sVar.i();
            if (h == 1) {
                fVar.d(sVar.a, 8, 8);
                sVar.b(16);
                h = sVar.n();
                i = 16;
            } else {
                if (h == 0) {
                    long d2 = fVar.d();
                    if (d2 != j) {
                        h = 8 + (d2 - fVar.c());
                    }
                }
                i = 8;
            }
            long j2 = i;
            if (h >= j2) {
                i3 += i;
                if (i4 != com.anythink.expressad.exoplayer.e.a.a.G) {
                    if (i4 != com.anythink.expressad.exoplayer.e.a.a.P && i4 != com.anythink.expressad.exoplayer.e.a.a.R) {
                        if ((i3 + h) - j2 >= i2) {
                            break;
                        }
                        int i5 = (int) (h - j2);
                        i3 += i5;
                        if (i4 == com.anythink.expressad.exoplayer.e.a.a.f) {
                            if (i5 < 8) {
                                return false;
                            }
                            sVar.a(i5);
                            fVar.d(sVar.a, 0, i5);
                            int i6 = i5 / 4;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    break;
                                }
                                if (i7 == 1) {
                                    sVar.d(4);
                                } else if (a(sVar.i())) {
                                    z3 = true;
                                    break;
                                }
                                i7++;
                            }
                            if (!z3) {
                                return false;
                            }
                        } else if (i5 != 0) {
                            fVar.e(i5);
                        }
                        j = -1;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        z2 = false;
        return z3 && z == z2;
    }

    public static boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        return a(fVar, false);
    }
}
