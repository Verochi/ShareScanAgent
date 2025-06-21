package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
final class f {
    private static final java.lang.String F = "und";
    private static final java.lang.String a = "MetadataUtil";
    private static final int b = com.anythink.expressad.exoplayer.k.af.f("nam");
    private static final int c = com.anythink.expressad.exoplayer.k.af.f("trk");
    private static final int d = com.anythink.expressad.exoplayer.k.af.f("cmt");
    private static final int e = com.anythink.expressad.exoplayer.k.af.f(org.apache.tools.ant.taskdefs.WaitFor.Unit.DAY);
    private static final int f = com.anythink.expressad.exoplayer.k.af.f("ART");
    private static final int g = com.anythink.expressad.exoplayer.k.af.f("too");
    private static final int h = com.anythink.expressad.exoplayer.k.af.f("alb");
    private static final int i = com.anythink.expressad.exoplayer.k.af.f("com");
    private static final int j = com.anythink.expressad.exoplayer.k.af.f("wrt");
    private static final int k = com.anythink.expressad.exoplayer.k.af.f("lyr");
    private static final int l = com.anythink.expressad.exoplayer.k.af.f("gen");
    private static final int m = com.anythink.expressad.exoplayer.k.af.f("covr");
    private static final int n = com.anythink.expressad.exoplayer.k.af.f("gnre");
    private static final int o = com.anythink.expressad.exoplayer.k.af.f("grp");
    private static final int p = com.anythink.expressad.exoplayer.k.af.f("disk");
    private static final int q = com.anythink.expressad.exoplayer.k.af.f("trkn");
    private static final int r = com.anythink.expressad.exoplayer.k.af.f("tmpo");

    /* renamed from: s, reason: collision with root package name */
    private static final int f215s = com.anythink.expressad.exoplayer.k.af.f("cpil");
    private static final int t = com.anythink.expressad.exoplayer.k.af.f("aART");
    private static final int u = com.anythink.expressad.exoplayer.k.af.f("sonm");
    private static final int v = com.anythink.expressad.exoplayer.k.af.f("soal");
    private static final int w = com.anythink.expressad.exoplayer.k.af.f("soar");
    private static final int x = com.anythink.expressad.exoplayer.k.af.f("soaa");
    private static final int y = com.anythink.expressad.exoplayer.k.af.f("soco");
    private static final int z = com.anythink.expressad.exoplayer.k.af.f("rtng");
    private static final int A = com.anythink.expressad.exoplayer.k.af.f("pgap");
    private static final int B = com.anythink.expressad.exoplayer.k.af.f("sosn");
    private static final int C = com.anythink.expressad.exoplayer.k.af.f("tvsh");
    private static final int D = com.anythink.expressad.exoplayer.k.af.f("----");
    private static final java.lang.String[] E = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", com.google.common.net.HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private f() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x022c, TRY_LEAVE, TryCatch #0 {all -> 0x022c, blocks: (B:6:0x001f, B:8:0x0024, B:10:0x002a, B:12:0x002f, B:14:0x0036, B:20:0x0040, B:22:0x0044, B:25:0x004e, B:27:0x0052, B:30:0x005c, B:32:0x0061, B:35:0x006b, B:37:0x006f, B:40:0x0079, B:42:0x007d, B:44:0x0089, B:48:0x00a2, B:49:0x00ac, B:57:0x00c2, B:59:0x00c6, B:62:0x00d0, B:64:0x00d4, B:67:0x00de, B:69:0x00e2, B:72:0x00ec, B:74:0x00f0, B:77:0x00fa, B:79:0x00fe, B:82:0x0108, B:84:0x010c, B:87:0x0116, B:89:0x011a, B:92:0x0124, B:94:0x0128, B:97:0x0132, B:99:0x0136, B:102:0x0140, B:104:0x0144, B:107:0x014e, B:109:0x0152, B:112:0x0206, B:116:0x015e, B:118:0x0162, B:120:0x016e, B:123:0x0181, B:124:0x0193, B:126:0x0197, B:129:0x019d, B:131:0x01a1, B:134:0x01a6, B:136:0x01aa, B:139:0x01b4, B:141:0x01b8, B:144:0x01c2, B:146:0x01c6, B:149:0x01d0, B:151:0x01d4, B:154:0x01de, B:156:0x01e2, B:159:0x01ec, B:161:0x01f0, B:164:0x01f8, B:166:0x01fc, B:169:0x0218, B:172:0x0222), top: B:2:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a(com.anythink.expressad.exoplayer.k.s sVar) {
        java.lang.String str;
        int c2 = sVar.c() + sVar.i();
        int i2 = sVar.i();
        int i3 = (i2 >> 24) & 255;
        try {
            if (i3 == 169 || i3 == 65533) {
                int i4 = 16777215 & i2;
                if (i4 == d) {
                    int i5 = sVar.i();
                    if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aK) {
                        sVar.d(8);
                        java.lang.String e2 = sVar.e(i5 - 16);
                        r5 = new com.anythink.expressad.exoplayer.g.b.e("und", e2, e2);
                    } else {
                        new java.lang.StringBuilder("Failed to parse comment attribute: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
                    }
                    return r5;
                }
                if (i4 != b && i4 != c) {
                    if (i4 != i && i4 != j) {
                        if (i4 == e) {
                            return a(i2, "TDRC", sVar);
                        }
                        if (i4 == f) {
                            return a(i2, "TPE1", sVar);
                        }
                        if (i4 == g) {
                            return a(i2, "TSSE", sVar);
                        }
                        if (i4 == h) {
                            return a(i2, "TALB", sVar);
                        }
                        if (i4 == k) {
                            return a(i2, "USLT", sVar);
                        }
                        if (i4 == l) {
                            return a(i2, "TCON", sVar);
                        }
                        if (i4 == o) {
                            return a(i2, "TIT1", sVar);
                        }
                    }
                    return a(i2, "TCOM", sVar);
                }
                return a(i2, "TIT2", sVar);
            }
            if (i2 == n) {
                int d2 = d(sVar);
                if (d2 > 0) {
                    java.lang.String[] strArr = E;
                    if (d2 <= strArr.length) {
                        str = strArr[d2 - 1];
                        return str != null ? new com.anythink.expressad.exoplayer.g.b.k("TCON", null, str) : null;
                    }
                }
                str = null;
                return str != null ? new com.anythink.expressad.exoplayer.g.b.k("TCON", null, str) : null;
            }
            if (i2 == p) {
                return b(i2, "TPOS", sVar);
            }
            if (i2 == q) {
                return b(i2, "TRCK", sVar);
            }
            if (i2 == r) {
                return a(i2, "TBPM", sVar, true, false);
            }
            if (i2 == f215s) {
                return a(i2, "TCMP", sVar, true, true);
            }
            if (i2 == m) {
                int i6 = sVar.i();
                if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aK) {
                    int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
                    java.lang.String str2 = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
                    if (str2 == null) {
                        "Unrecognized cover art flags: ".concat(java.lang.String.valueOf(b2));
                    } else {
                        sVar.d(4);
                        int i7 = i6 - 16;
                        byte[] bArr = new byte[i7];
                        sVar.a(bArr, 0, i7);
                        r5 = new com.anythink.expressad.exoplayer.g.b.a(str2, null, 3, bArr);
                    }
                }
                return r5;
            }
            if (i2 == t) {
                return a(i2, "TPE2", sVar);
            }
            if (i2 == u) {
                return a(i2, "TSOT", sVar);
            }
            if (i2 == v) {
                return a(i2, "TSO2", sVar);
            }
            if (i2 == w) {
                return a(i2, "TSOA", sVar);
            }
            if (i2 == x) {
                return a(i2, "TSOP", sVar);
            }
            if (i2 == y) {
                return a(i2, "TSOC", sVar);
            }
            if (i2 == z) {
                return a(i2, "ITUNESADVISORY", sVar, false, false);
            }
            if (i2 == A) {
                return a(i2, "ITUNESGAPLESS", sVar, false, true);
            }
            if (i2 == B) {
                return a(i2, "TVSHOWSORT", sVar);
            }
            if (i2 == C) {
                return a(i2, "TVSHOW", sVar);
            }
            if (i2 == D) {
                return a(sVar, c2);
            }
            new java.lang.StringBuilder("Skipped unknown metadata entry: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
            return null;
        } finally {
            sVar.c(c2);
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.e a(int i2, com.anythink.expressad.exoplayer.k.s sVar) {
        int i3 = sVar.i();
        if (sVar.i() != com.anythink.expressad.exoplayer.e.a.a.aK) {
            new java.lang.StringBuilder("Failed to parse comment attribute: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
            return null;
        }
        sVar.d(8);
        java.lang.String e2 = sVar.e(i3 - 16);
        return new com.anythink.expressad.exoplayer.g.b.e("und", e2, e2);
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(int i2, java.lang.String str, com.anythink.expressad.exoplayer.k.s sVar, boolean z2, boolean z3) {
        int d2 = d(sVar);
        if (z3) {
            d2 = java.lang.Math.min(1, d2);
        }
        if (d2 >= 0) {
            return z2 ? new com.anythink.expressad.exoplayer.g.b.k(str, null, java.lang.Integer.toString(d2)) : new com.anythink.expressad.exoplayer.g.b.e("und", str, java.lang.Integer.toString(d2));
        }
        new java.lang.StringBuilder("Failed to parse uint8 attribute: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(com.anythink.expressad.exoplayer.k.s sVar, int i2) {
        java.lang.String str = null;
        java.lang.String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (sVar.c() < i2) {
            int c2 = sVar.c();
            int i5 = sVar.i();
            int i6 = sVar.i();
            sVar.d(4);
            if (i6 == com.anythink.expressad.exoplayer.e.a.a.aI) {
                str = sVar.e(i5 - 12);
            } else if (i6 == com.anythink.expressad.exoplayer.e.a.a.aJ) {
                str2 = sVar.e(i5 - 12);
            } else {
                if (i6 == com.anythink.expressad.exoplayer.e.a.a.aK) {
                    i3 = c2;
                    i4 = i5;
                }
                sVar.d(i5 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        sVar.c(i3);
        sVar.d(16);
        return new com.anythink.expressad.exoplayer.g.b.i(str, str2, sVar.e(i4 - 16));
    }

    private static com.anythink.expressad.exoplayer.g.b.k a(int i2, java.lang.String str, com.anythink.expressad.exoplayer.k.s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aK) {
            sVar.d(8);
            return new com.anythink.expressad.exoplayer.g.b.k(str, null, sVar.e(i3 - 16));
        }
        new java.lang.StringBuilder("Failed to parse text attribute: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.k b(int i2, java.lang.String str, com.anythink.expressad.exoplayer.k.s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == com.anythink.expressad.exoplayer.e.a.a.aK && i3 >= 22) {
            sVar.d(10);
            int e2 = sVar.e();
            if (e2 > 0) {
                java.lang.String valueOf = java.lang.String.valueOf(e2);
                int e3 = sVar.e();
                if (e3 > 0) {
                    valueOf = valueOf + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + e3;
                }
                return new com.anythink.expressad.exoplayer.g.b.k(str, null, valueOf);
            }
        }
        new java.lang.StringBuilder("Failed to parse index/count attribute: ").append(com.anythink.expressad.exoplayer.e.a.a.c(i2));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.anythink.expressad.exoplayer.g.b.k b(com.anythink.expressad.exoplayer.k.s sVar) {
        java.lang.String str;
        int d2 = d(sVar);
        if (d2 > 0) {
            java.lang.String[] strArr = E;
            if (d2 <= strArr.length) {
                str = strArr[d2 - 1];
                if (str == null) {
                    return new com.anythink.expressad.exoplayer.g.b.k("TCON", null, str);
                }
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.a c(com.anythink.expressad.exoplayer.k.s sVar) {
        int i2 = sVar.i();
        if (sVar.i() != com.anythink.expressad.exoplayer.e.a.a.aK) {
            return null;
        }
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        java.lang.String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
        if (str == null) {
            "Unrecognized cover art flags: ".concat(java.lang.String.valueOf(b2));
            return null;
        }
        sVar.d(4);
        int i3 = i2 - 16;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new com.anythink.expressad.exoplayer.g.b.a(str, null, 3, bArr);
    }

    private static int d(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.d(4);
        if (sVar.i() != com.anythink.expressad.exoplayer.e.a.a.aK) {
            return -1;
        }
        sVar.d(8);
        return sVar.d();
    }
}
