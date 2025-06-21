package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class i {
    private static java.lang.String a(java.lang.String str, com.anythink.basead.c.b bVar) {
        java.lang.String str2 = bVar.a;
        if (str2 == null) {
            str2 = "";
        }
        return str.replaceAll("\\{__CLICK_ID__\\}", str2);
    }

    private static java.lang.String a(java.lang.String str, com.anythink.basead.c.i iVar) {
        java.lang.String str2;
        java.lang.String str3 = "{}";
        com.anythink.basead.c.a aVar = iVar.g;
        int i = iVar.e;
        int i2 = iVar.f;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("down_x", aVar.e);
            jSONObject.put("down_y", aVar.f);
            jSONObject.put("up_x", aVar.g);
            jSONObject.put("up_y", aVar.h);
        } catch (org.json.JSONException unused) {
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            float f = i;
            jSONObject2.put("down_x", (int) ((aVar.e / f) * 1000.0f));
            float f2 = i2;
            jSONObject2.put("down_y", (int) ((aVar.e / f2) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar.g / f) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar.h / f2) * 1000.0f));
        } catch (org.json.JSONException unused2) {
        }
        try {
            str2 = java.net.URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            str2 = "{}";
        }
        try {
            str3 = java.net.URLEncoder.encode(jSONObject2.toString(), "utf-8");
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        int i3 = aVar.i ? 1 : 2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(aVar.a);
        java.lang.String replaceAll = str.replaceAll("\\{__DOWN_X__\\}", sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(aVar.b);
        java.lang.String replaceAll2 = replaceAll.replaceAll("\\{__DOWN_Y__\\}", sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(aVar.c);
        java.lang.String replaceAll3 = replaceAll2.replaceAll("\\{__UP_X__\\}", sb3.toString());
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(aVar.d);
        java.lang.String replaceAll4 = replaceAll3.replaceAll("\\{__UP_Y__\\}", sb4.toString());
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(aVar.e);
        java.lang.String replaceAll5 = replaceAll4.replaceAll("\\{__RE_DOWN_X__\\}", sb5.toString());
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(aVar.f);
        java.lang.String replaceAll6 = replaceAll5.replaceAll("\\{__RE_DOWN_Y__\\}", sb6.toString());
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(aVar.g);
        java.lang.String replaceAll7 = replaceAll6.replaceAll("\\{__RE_UP_X__\\}", sb7.toString());
        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
        sb8.append(aVar.h);
        java.lang.String replaceAll8 = replaceAll7.replaceAll("\\{__RE_UP_Y__\\}", sb8.toString()).replaceAll("\\{ABSOLUTE_COORD\\}", str2).replaceAll("\\{RELATIVE_COORD\\}", str3).replaceAll("\\{__DPLINK_TYPE__\\}", java.lang.String.valueOf(i3));
        if (aVar.i) {
            replaceAll8 = replaceAll8.replaceAll("&apk_ptype=\\{apk_ptype\\}", "");
        }
        int i4 = aVar.j;
        return (i4 == -1 ? replaceAll8.replaceAll("&apk_ptype=\\{apk_ptype\\}", "") : replaceAll8.replaceAll("\\{apk_ptype\\}", java.lang.String.valueOf(i4))).replaceAll("\\{opdptype\\}", aVar.i ? "1" : "0");
    }

    public static java.lang.String a(java.lang.String str, com.anythink.basead.c.i iVar, long j) {
        java.lang.String sb;
        java.lang.String sb2;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (iVar.g != null) {
            str = a(str, iVar);
        }
        com.anythink.basead.c.j jVar = iVar.h;
        if (jVar != null) {
            str = a(str, jVar);
        }
        com.anythink.basead.c.b bVar = iVar.i;
        if (bVar != null) {
            str = a(str, bVar);
        }
        long j2 = j / 1000;
        if (iVar.c == 0) {
            sb = "__REQ_WIDTH__";
        } else {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(iVar.c);
            sb = sb3.toString();
        }
        java.lang.String replaceAll = str.replaceAll("\\{__REQ_WIDTH__\\}", sb);
        if (iVar.d == 0) {
            sb2 = "__REQ_HEIGHT__";
        } else {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(iVar.d);
            sb2 = sb4.toString();
        }
        java.lang.String replaceAll2 = replaceAll.replaceAll("\\{__REQ_HEIGHT__\\}", sb2);
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(iVar.e);
        java.lang.String replaceAll3 = replaceAll2.replaceAll("\\{__WIDTH__\\}", sb5.toString());
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(iVar.f);
        return replaceAll3.replaceAll("\\{__HEIGHT__\\}", sb6.toString()).replaceAll("\\{__TS__\\}", java.lang.String.valueOf(j2)).replaceAll("\\{__TS_MSEC__\\}", java.lang.String.valueOf(j)).replaceAll("\\{__END_TS__\\}", java.lang.String.valueOf(j2)).replaceAll("\\{__END_TS_MSEC__\\}", java.lang.String.valueOf(j)).replaceAll("\\{__PLAY_SEC__\\}", "0").replaceAll("\\{", "").replaceAll("\\}", "");
    }

    private static java.lang.String a(java.lang.String str, com.anythink.basead.c.j jVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(jVar.a);
        java.lang.String replaceAll = str.replaceAll("\\{__VIDEO_TIME__\\}", sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(jVar.b);
        java.lang.String replaceAll2 = replaceAll.replaceAll("\\{__BEGIN_TIME__\\}", sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(jVar.c);
        java.lang.String replaceAll3 = replaceAll2.replaceAll("\\{__END_TIME__\\}", sb3.toString());
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append(jVar.d);
        java.lang.String replaceAll4 = replaceAll3.replaceAll("\\{__PLAY_FIRST_FRAME__\\}", sb4.toString());
        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
        sb5.append(jVar.e);
        java.lang.String replaceAll5 = replaceAll4.replaceAll("\\{__PLAY_LAST_FRAME__\\}", sb5.toString());
        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
        sb6.append(jVar.l);
        java.lang.String replaceAll6 = replaceAll5.replaceAll("\\{__SCENE__\\}", sb6.toString());
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(jVar.o);
        java.lang.String replaceAll7 = replaceAll6.replaceAll("\\{__TYPE__\\}", sb7.toString());
        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
        sb8.append(jVar.r);
        java.lang.String replaceAll8 = replaceAll7.replaceAll("\\{__BEHAVIOR__\\}", sb8.toString());
        java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
        sb9.append(jVar.u);
        java.lang.String replaceAll9 = replaceAll8.replaceAll("\\{__STATUS__\\}", sb9.toString());
        java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
        sb10.append(jVar.h);
        java.lang.String replaceAll10 = replaceAll9.replaceAll("\\{__PLAY_SEC__\\}", sb10.toString());
        java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
        sb11.append(jVar.f / 1000);
        java.lang.String replaceAll11 = replaceAll10.replaceAll("\\{__TS__\\}", sb11.toString());
        java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
        sb12.append(jVar.f);
        java.lang.String replaceAll12 = replaceAll11.replaceAll("\\{__TS_MSEC__\\}", sb12.toString());
        java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
        sb13.append(jVar.g / 1000);
        java.lang.String replaceAll13 = replaceAll12.replaceAll("\\{__END_TS__\\}", sb13.toString());
        java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
        sb14.append(jVar.g);
        java.lang.String replaceAll14 = replaceAll13.replaceAll("\\{__END_TS_MSEC__\\}", sb14.toString());
        java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
        sb15.append(jVar.h / 1000);
        java.lang.String replaceAll15 = replaceAll14.replaceAll("\\{__PLAY_SEC__\\}", sb15.toString());
        java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
        sb16.append(jVar.h);
        return replaceAll15.replaceAll("\\{__PLAY_MSEC__\\}", sb16.toString());
    }

    private static void a(int i, @androidx.annotation.NonNull com.anythink.basead.c.i iVar, com.anythink.core.common.f.ai aiVar, com.anythink.core.common.f.ak akVar, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String str;
        switch (i) {
            case 1:
                str = akVar.C();
                break;
            case 2:
                str = akVar.D();
                break;
            case 3:
                str = akVar.E();
                break;
            case 4:
                str = akVar.F();
                break;
            case 5:
                str = akVar.G();
                break;
            case 6:
                str = akVar.L();
                break;
            case 7:
                str = akVar.M();
                break;
            case 8:
                str = akVar.A();
                break;
            case 9:
                str = akVar.B();
                break;
            case 10:
                str = akVar.z();
                break;
            case 11:
                str = akVar.H();
                break;
            case 12:
                str = akVar.J();
                break;
            case 13:
                str = akVar.K();
                break;
            case 14:
                str = akVar.I();
                break;
            case 15:
                str = akVar.Z();
                break;
            case 16:
                str = akVar.aa();
                break;
            case 17:
                str = akVar.ab();
                break;
            case 18:
                str = akVar.N();
                break;
            case 19:
                str = akVar.O();
                break;
            case 20:
                str = akVar.ac();
                break;
            case 21:
                str = akVar.P();
                break;
            case 22:
            case 32:
            default:
                str = "";
                break;
            case 23:
                str = akVar.ad();
                break;
            case 24:
                str = akVar.ae();
                break;
            case 25:
                str = akVar.af();
                break;
            case 26:
                str = akVar.ag();
                break;
            case 27:
                str = akVar.ah();
                break;
            case 28:
                str = akVar.aj();
                break;
            case 29:
                str = akVar.ai();
                break;
            case 30:
                str = akVar.ak();
                break;
            case 31:
                str = akVar.al();
                break;
            case 33:
                str = akVar.am();
                break;
            case 34:
                str = akVar.an();
                break;
            case 35:
                str = akVar.ap();
                break;
        }
        if (a(str)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i, aiVar, str, map);
        fVar.a(iVar.b);
        fVar.a(0, (com.anythink.core.common.h.k) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0103 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #0 {all -> 0x00e3, blocks: (B:8:0x0016, B:16:0x00fb, B:18:0x0103, B:22:0x00f3, B:63:0x001c, B:64:0x0022, B:65:0x0028, B:68:0x0032, B:69:0x0040, B:70:0x0046, B:71:0x004c, B:72:0x0052, B:73:0x0058, B:74:0x005e, B:75:0x0064, B:76:0x006a, B:77:0x0070, B:78:0x0076, B:79:0x007c, B:80:0x0082, B:81:0x0088, B:82:0x008e, B:83:0x0093, B:84:0x0098, B:85:0x009d, B:86:0x00a2, B:87:0x00a7, B:88:0x00ac, B:89:0x00b1, B:90:0x00b6, B:91:0x00bb, B:92:0x00c0, B:93:0x00c5, B:94:0x00ca, B:95:0x00cf, B:96:0x00d4, B:97:0x00d9, B:98:0x00de), top: B:6:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i, com.anythink.core.common.f.ai aiVar, @androidx.annotation.NonNull com.anythink.basead.c.i iVar) {
        java.lang.String str;
        java.lang.String[] strArr;
        boolean aa;
        com.anythink.core.common.f.ak ad = aiVar.ad();
        if (ad == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.Object> c = com.anythink.core.common.o.i.c(ad.c());
        try {
            switch (i) {
                case 1:
                    strArr = ad.g();
                    break;
                case 2:
                    strArr = ad.h();
                    break;
                case 3:
                    strArr = ad.i();
                    break;
                case 4:
                    strArr = ad.j();
                    break;
                case 5:
                    strArr = ad.k();
                    break;
                case 6:
                    strArr = ad.p();
                    break;
                case 7:
                    strArr = ad.q();
                    break;
                case 8:
                    strArr = ad.e();
                    break;
                case 9:
                    strArr = ad.f();
                    break;
                case 10:
                    strArr = ad.d();
                    break;
                case 11:
                    strArr = ad.l();
                    break;
                case 12:
                    strArr = ad.n();
                    break;
                case 13:
                    strArr = ad.o();
                    break;
                case 14:
                    strArr = ad.m();
                    break;
                case 15:
                    strArr = ad.Q();
                    break;
                case 16:
                    strArr = ad.R();
                    break;
                case 17:
                    strArr = ad.S();
                    break;
                case 18:
                    strArr = ad.r();
                    break;
                case 19:
                    strArr = ad.s();
                    break;
                case 20:
                    strArr = ad.T();
                    break;
                case 21:
                    strArr = ad.t();
                    break;
                case 22:
                default:
                    strArr = null;
                    break;
                case 23:
                    strArr = ad.U();
                    break;
                case 24:
                    strArr = ad.V();
                    break;
                case 25:
                    strArr = ad.W();
                    break;
                case 26:
                    strArr = ad.X();
                    break;
                case 27:
                    strArr = ad.Y();
                    break;
                case 28:
                    strArr = ad.v();
                    break;
                case 29:
                    strArr = ad.u();
                    break;
                case 30:
                    strArr = ad.w();
                    break;
                case 31:
                    strArr = ad.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.h;
                    java.util.Map<java.lang.Integer, java.lang.String[]> y = ad.y();
                    if (jVar != null && y != null) {
                        strArr = y.get(java.lang.Integer.valueOf(jVar.i));
                        break;
                    }
                    strArr = null;
                    break;
                case 33:
                    strArr = ad.a();
                    break;
                case 34:
                    strArr = ad.b();
                    break;
                case 35:
                    strArr = ad.ao();
                    break;
            }
            if (strArr != null) {
                if (i != 8 && i != 9) {
                    aa = false;
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    for (java.lang.String str2 : strArr) {
                        com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i, a(str2, iVar, currentTimeMillis), aiVar, c);
                        eVar.a(aa);
                        eVar.a(0, (com.anythink.core.common.h.k) null);
                    }
                }
                aa = aiVar.n().aa();
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                while (r9 < r8) {
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        switch (i) {
            case 1:
                str = ad.C();
                break;
            case 2:
                str = ad.D();
                break;
            case 3:
                str = ad.E();
                break;
            case 4:
                str = ad.F();
                break;
            case 5:
                str = ad.G();
                break;
            case 6:
                str = ad.L();
                break;
            case 7:
                str = ad.M();
                break;
            case 8:
                str = ad.A();
                break;
            case 9:
                str = ad.B();
                break;
            case 10:
                str = ad.z();
                break;
            case 11:
                str = ad.H();
                break;
            case 12:
                str = ad.J();
                break;
            case 13:
                str = ad.K();
                break;
            case 14:
                str = ad.I();
                break;
            case 15:
                str = ad.Z();
                break;
            case 16:
                str = ad.aa();
                break;
            case 17:
                str = ad.ab();
                break;
            case 18:
                str = ad.N();
                break;
            case 19:
                str = ad.O();
                break;
            case 20:
                str = ad.ac();
                break;
            case 21:
                str = ad.P();
                break;
            case 22:
            case 32:
            default:
                str = "";
                break;
            case 23:
                str = ad.ad();
                break;
            case 24:
                str = ad.ae();
                break;
            case 25:
                str = ad.af();
                break;
            case 26:
                str = ad.ag();
                break;
            case 27:
                str = ad.ah();
                break;
            case 28:
                str = ad.aj();
                break;
            case 29:
                str = ad.ai();
                break;
            case 30:
                str = ad.ak();
                break;
            case 31:
                str = ad.al();
                break;
            case 33:
                str = ad.am();
                break;
            case 34:
                str = ad.an();
                break;
            case 35:
                str = ad.ap();
                break;
        }
        if (a(str)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i, aiVar, str, c);
        fVar.a(iVar.b);
        fVar.a(0, (com.anythink.core.common.h.k) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f4 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:4:0x0006, B:12:0x00ec, B:14:0x00f4, B:20:0x00e4, B:22:0x000c, B:23:0x0012, B:24:0x0018, B:27:0x0022, B:28:0x0030, B:29:0x0036, B:30:0x003c, B:31:0x0042, B:32:0x0048, B:33:0x004e, B:34:0x0054, B:35:0x005a, B:36:0x0060, B:37:0x0066, B:38:0x006c, B:39:0x0072, B:40:0x0078, B:41:0x007e, B:42:0x0083, B:43:0x0088, B:44:0x008d, B:45:0x0092, B:46:0x0097, B:47:0x009c, B:48:0x00a1, B:49:0x00a6, B:50:0x00ab, B:51:0x00b0, B:52:0x00b5, B:53:0x00ba, B:54:0x00bf, B:55:0x00c4, B:56:0x00c9, B:57:0x00ce), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(int i, com.anythink.core.common.f.ai aiVar, com.anythink.core.common.f.ak akVar, java.util.Map<java.lang.String, java.lang.Object> map, @androidx.annotation.NonNull com.anythink.basead.c.i iVar) {
        java.lang.String[] strArr;
        boolean aa;
        try {
            switch (i) {
                case 1:
                    strArr = akVar.g();
                    break;
                case 2:
                    strArr = akVar.h();
                    break;
                case 3:
                    strArr = akVar.i();
                    break;
                case 4:
                    strArr = akVar.j();
                    break;
                case 5:
                    strArr = akVar.k();
                    break;
                case 6:
                    strArr = akVar.p();
                    break;
                case 7:
                    strArr = akVar.q();
                    break;
                case 8:
                    strArr = akVar.e();
                    break;
                case 9:
                    strArr = akVar.f();
                    break;
                case 10:
                    strArr = akVar.d();
                    break;
                case 11:
                    strArr = akVar.l();
                    break;
                case 12:
                    strArr = akVar.n();
                    break;
                case 13:
                    strArr = akVar.o();
                    break;
                case 14:
                    strArr = akVar.m();
                    break;
                case 15:
                    strArr = akVar.Q();
                    break;
                case 16:
                    strArr = akVar.R();
                    break;
                case 17:
                    strArr = akVar.S();
                    break;
                case 18:
                    strArr = akVar.r();
                    break;
                case 19:
                    strArr = akVar.s();
                    break;
                case 20:
                    strArr = akVar.T();
                    break;
                case 21:
                    strArr = akVar.t();
                    break;
                case 22:
                default:
                    strArr = null;
                    break;
                case 23:
                    strArr = akVar.U();
                    break;
                case 24:
                    strArr = akVar.V();
                    break;
                case 25:
                    strArr = akVar.W();
                    break;
                case 26:
                    strArr = akVar.X();
                    break;
                case 27:
                    strArr = akVar.Y();
                    break;
                case 28:
                    strArr = akVar.v();
                    break;
                case 29:
                    strArr = akVar.u();
                    break;
                case 30:
                    strArr = akVar.w();
                    break;
                case 31:
                    strArr = akVar.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.h;
                    java.util.Map<java.lang.Integer, java.lang.String[]> y = akVar.y();
                    if (jVar != null && y != null) {
                        strArr = y.get(java.lang.Integer.valueOf(jVar.i));
                        break;
                    }
                    strArr = null;
                    break;
                case 33:
                    strArr = akVar.a();
                    break;
                case 34:
                    strArr = akVar.b();
                    break;
                case 35:
                    strArr = akVar.ao();
                    break;
            }
            if (strArr != null) {
                if (i != 8 && i != 9) {
                    aa = false;
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    for (java.lang.String str : strArr) {
                        com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i, a(str, iVar, currentTimeMillis), aiVar, map);
                        eVar.a(aa);
                        eVar.a(0, (com.anythink.core.common.h.k) null);
                    }
                }
                aa = aiVar.n().aa();
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                while (r6 < r5) {
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        return new org.json.JSONObject(str).length() <= 0;
    }
}
