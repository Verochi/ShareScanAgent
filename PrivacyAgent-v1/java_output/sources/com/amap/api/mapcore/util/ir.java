package com.amap.api.mapcore.util;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public final class ir {
    protected static java.lang.String J;
    protected static java.lang.String L;
    public java.lang.String a = "1";
    protected short b = 0;
    protected java.lang.String c = null;
    protected java.lang.String d = null;
    protected java.lang.String e = null;
    protected java.lang.String f = null;
    protected java.lang.String g = null;
    public java.lang.String h = null;
    public java.lang.String i = null;
    protected java.lang.String j = null;
    protected java.lang.String k = null;
    protected java.lang.String l = null;
    protected java.lang.String m = null;
    protected java.lang.String n = null;
    protected java.lang.String o = null;
    protected java.lang.String p = null;
    protected java.lang.String q = null;
    protected java.lang.String r = null;

    /* renamed from: s, reason: collision with root package name */
    protected java.lang.String f135s = null;
    protected java.lang.String t = null;
    protected java.lang.String u = null;
    protected java.lang.String v = null;
    protected java.lang.String w = null;
    protected java.lang.String x = null;
    protected java.lang.String y = null;
    protected int z = 0;
    protected java.lang.String A = null;
    protected java.lang.String B = null;
    protected java.util.ArrayList<com.amap.api.mapcore.util.jv> C = new java.util.ArrayList<>();
    protected java.lang.String D = null;
    protected java.lang.String E = null;
    protected java.util.ArrayList<android.net.wifi.ScanResult> F = new java.util.ArrayList<>();
    protected java.lang.String G = null;
    protected java.lang.String H = null;
    protected byte[] I = null;
    private byte[] P = null;
    private int Q = 0;
    protected java.lang.String K = null;
    protected java.lang.String M = null;
    protected java.lang.String N = null;
    protected java.lang.String O = null;

    private static int a(java.lang.String str, byte[] bArr, int i) {
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            bArr[i] = 0;
            return i + 1;
        }
        byte[] bytes = str.getBytes("GBK");
        int length = bytes.length;
        if (length > 127) {
            length = 127;
        }
        bArr[i] = (byte) length;
        int i2 = i + 1;
        java.lang.System.arraycopy(bytes, 0, bArr, i2, length);
        return i2 + length;
    }

    private java.lang.String a(java.lang.String str, int i) {
        java.lang.String[] split = this.B.split("\\*")[i].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x000d, code lost:
    
        if (r0.length != 6) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(java.lang.String str) {
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        byte[] bArr = new byte[6];
        if (split != null) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "Req", "getMacBa ".concat(str));
                return a(com.alipay.sdk.m.u.c.b);
            }
        }
        split = new java.lang.String[6];
        for (int i = 0; i < 6; i++) {
            split[i] = "0";
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) java.lang.Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    private java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.A)) {
            return "0";
        }
        if (!this.A.contains(str + ">")) {
            return "0";
        }
        return this.A.substring(this.A.indexOf(str + ">") + str.length() + 1, this.A.indexOf("</".concat(java.lang.String.valueOf(str))));
    }

    private void b() {
        java.lang.String[] strArr = new java.lang.String[29];
        strArr[0] = this.a;
        strArr[1] = this.c;
        strArr[2] = this.d;
        strArr[3] = this.e;
        strArr[4] = this.f;
        strArr[5] = this.g;
        strArr[6] = this.h;
        strArr[7] = this.i;
        strArr[8] = this.l;
        strArr[9] = this.m;
        strArr[10] = this.n;
        strArr[11] = this.o;
        strArr[12] = this.p;
        strArr[13] = this.q;
        strArr[14] = this.r;
        strArr[15] = this.f135s;
        strArr[16] = this.t;
        strArr[17] = this.u;
        strArr[18] = this.v;
        strArr[19] = this.w;
        strArr[20] = this.x;
        strArr[21] = this.A;
        strArr[22] = this.B;
        strArr[23] = this.E;
        strArr[24] = this.G;
        strArr[25] = this.H;
        strArr[26] = J;
        strArr[27] = this.N;
        strArr[28] = this.O;
        for (int i = 0; i < 29; i++) {
            if (android.text.TextUtils.isEmpty(strArr[i])) {
                strArr[i] = "";
            }
        }
        if (android.text.TextUtils.isEmpty(this.j) || (!"0".equals(this.j) && !"2".equals(this.j))) {
            this.j = "0";
        }
        if (android.text.TextUtils.isEmpty(this.k) || (!"0".equals(this.k) && !"1".equals(this.k))) {
            this.k = "0";
        }
        if (android.text.TextUtils.isEmpty(this.y) || (!"1".equals(this.y) && !"2".equals(this.y))) {
            this.y = "0";
        }
        if (!com.amap.api.mapcore.util.jw.a(this.z)) {
            this.z = 0;
        }
        if (this.I == null) {
            this.I = new byte[0];
        }
    }

    public final void a(android.content.Context context, boolean z, boolean z2, com.amap.api.mapcore.util.jw jwVar, com.amap.api.mapcore.util.in inVar, android.net.ConnectivityManager connectivityManager, java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        int i;
        java.lang.String str4;
        android.net.NetworkInfo networkInfo;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.util.ArrayList<android.net.wifi.ScanResult> arrayList;
        java.lang.String str10;
        java.lang.String str11;
        java.util.ArrayList<android.net.wifi.ScanResult> arrayList2;
        int i2;
        java.lang.String f = com.amap.api.mapcore.util.ev.f(context);
        int d = com.amap.api.mapcore.util.ix.d();
        this.K = str;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        java.lang.String str12 = str3;
        java.lang.String str13 = str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int e = jwVar.e();
        int f2 = jwVar.f();
        android.telephony.TelephonyManager g = jwVar.g();
        java.util.ArrayList<com.amap.api.mapcore.util.jv> c = jwVar.c();
        java.util.ArrayList<com.amap.api.mapcore.util.jv> d2 = jwVar.d();
        java.util.ArrayList<android.net.wifi.ScanResult> a = inVar.a();
        java.lang.String str14 = f2 == 2 ? "1" : "0";
        if (g != null) {
            if (android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.g)) {
                try {
                    com.amap.api.mapcore.util.it.g = com.amap.api.mapcore.util.ez.s(context);
                } catch (java.lang.Throwable th) {
                    str4 = "1";
                    com.amap.api.mapcore.util.it.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            i = d;
            if (android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.g) && android.os.Build.VERSION.SDK_INT < 29) {
                com.amap.api.mapcore.util.it.g = "888888888888888";
            }
            if (android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.h)) {
                try {
                    com.amap.api.mapcore.util.it.h = com.amap.api.mapcore.util.ez.v(context);
                } catch (java.lang.SecurityException unused) {
                } catch (java.lang.Throwable th2) {
                    com.amap.api.mapcore.util.it.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.it.h) && android.os.Build.VERSION.SDK_INT < 29) {
                com.amap.api.mapcore.util.it.h = "888888888888888";
            }
        } else {
            i = d;
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Throwable th3) {
            com.amap.api.mapcore.util.it.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a2 = inVar.a(connectivityManager);
        if (com.amap.api.mapcore.util.ix.a(networkInfo) != -1) {
            str5 = com.amap.api.mapcore.util.ix.b(g);
            str6 = a2 ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        java.lang.String str15 = str6;
        java.lang.String str16 = str5;
        if (c.isEmpty()) {
            str7 = f;
            str8 = str13;
            str9 = str12;
            arrayList = a;
            str10 = "0";
            str11 = "";
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            str7 = f;
            str10 = "0";
            str9 = str12;
            str8 = str13;
            if (f2 == 1) {
                com.amap.api.mapcore.util.jv jvVar = c.get(0);
                arrayList = a;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(jvVar.a);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(jvVar.b);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(jvVar.c);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(jvVar.d);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(jvVar.k);
                sb2.append("</signal>");
                str11 = sb2.toString();
                for (int i3 = 1; i3 < c.size(); i3++) {
                    com.amap.api.mapcore.util.jv jvVar2 = c.get(i3);
                    sb.append(jvVar2.c);
                    sb.append(",");
                    sb.append(jvVar2.d);
                    sb.append(",");
                    sb.append(jvVar2.k);
                    if (i3 < c.size() - 1) {
                        sb.append("*");
                    }
                }
            } else if (f2 != 2) {
                arrayList = a;
                str11 = "";
            } else {
                com.amap.api.mapcore.util.jv jvVar3 = c.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(jvVar3.a);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(jvVar3.h);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(jvVar3.i);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(jvVar3.j);
                sb2.append("</bid>");
                if (jvVar3.g > 0 && jvVar3.f > 0) {
                    sb2.append("<lon>");
                    sb2.append(jvVar3.g);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(jvVar3.f);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(jvVar3.k);
                sb2.append("</signal>");
                str11 = sb2.toString();
                arrayList = a;
            }
            sb2.delete(0, sb2.length());
        }
        if ((e & 4) != 4 || d2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(d2);
        }
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        if (inVar.e()) {
            if (a2) {
                android.net.wifi.WifiInfo f3 = inVar.f();
                if (com.amap.api.mapcore.util.in.a(f3)) {
                    sb3.append(f3.getBSSID());
                    sb3.append(",");
                    int rssi = f3.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    java.lang.String ssid = f3.getSSID();
                    try {
                        i2 = f3.getSSID().getBytes("UTF-8").length;
                    } catch (java.lang.Exception unused2) {
                        i2 = 32;
                    }
                    if (i2 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            }
            if (arrayList != null && (arrayList2 = this.F) != null) {
                arrayList2.clear();
                this.F.addAll(arrayList);
            }
        } else {
            inVar.b();
            java.util.ArrayList<android.net.wifi.ScanResult> arrayList3 = this.F;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str8;
        this.d = str9;
        this.f = android.os.Build.MODEL;
        this.g = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE;
        this.h = com.amap.api.mapcore.util.ix.b(context);
        this.i = str14;
        java.lang.String str17 = str10;
        this.j = str17;
        this.k = str17;
        this.l = str17;
        this.m = str17;
        this.n = str17;
        this.o = str7;
        this.p = com.amap.api.mapcore.util.it.g;
        this.q = com.amap.api.mapcore.util.it.h;
        this.f135s = java.lang.String.valueOf(i);
        this.t = com.amap.api.mapcore.util.ix.d(context);
        this.v = "5.3.1";
        this.w = null;
        this.u = "";
        this.x = str16;
        this.y = str15;
        this.z = e;
        this.A = str11;
        this.B = sb.toString();
        this.D = jwVar.j();
        this.G = com.amap.api.mapcore.util.in.i();
        this.E = sb3.toString();
        try {
            if (android.text.TextUtils.isEmpty(J)) {
                J = com.amap.api.mapcore.util.ez.h(context);
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            if (android.text.TextUtils.isEmpty(L)) {
                L = com.amap.api.mapcore.util.ez.a(context);
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            if (android.text.TextUtils.isEmpty(this.N)) {
                this.N = com.amap.api.mapcore.util.ez.i(context);
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            if (android.text.TextUtils.isEmpty(this.O)) {
                this.O = com.amap.api.mapcore.util.ez.g(context);
            }
        } catch (java.lang.Throwable unused6) {
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:12|13|14|(8:215|(1:217)(5:(1:246)|219|(1:221)|222|(2:224|(2:226|227)(3:228|(5:230|(1:232)|233|(2:235|236)(1:238)|237)|241))(1:(2:243|227)))|218|219|(0)|221|222|(0)(0))|17|(14:21|22|23|24|(1:211)(3:27|(9:29|(3:83|(1:85)|86)(3:34|(3:36|(1:38)|39)(1:(3:79|(1:81)|82))|40)|41|(1:43)|44|(2:(6:52|(1:54)|(1:56)|57|58|59)|60)|63|(1:74)(5:65|(1:67)|(1:69)|70|(3:72|58|59)(1:73))|60)|87)|88|(1:210)(14:92|93|94|95|96|97|(1:99)|100|101|102|(4:202|(1:204)|105|(2:107|108))|104|105|(0))|110|(1:112)(7:168|(1:170)(1:201)|(1:172)(1:200)|173|(11:175|176|177|178|179|(1:181)(2:193|(1:195))|182|(1:192)|186|(2:188|189)(1:191)|190)|198|199)|113|114|115|(1:117)|(27:119|120|121|122|123|(1:125)|126|127|(3:158|159|160)|129|130|131|132|133|134|135|(1:137)(1:153)|138|(1:140)|141|(1:143)|144|(1:146)|147|(1:149)|150|151)(27:165|166|121|122|123|(0)|126|127|(0)|129|130|131|132|133|134|135|(0)(0)|138|(0)|141|(0)|144|(0)|147|(0)|150|151))|214|24|(0)|211|88|(1:90)|210|110|(0)(0)|113|114|115|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0584, code lost:
    
        r14[r3] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0475 A[Catch: all -> 0x0480, TRY_LEAVE, TryCatch #0 {all -> 0x0480, blocks: (B:94:0x040f, B:102:0x0445, B:105:0x0456, B:107:0x0475, B:207:0x043c, B:97:0x0424, B:100:0x0431), top: B:93:0x040f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0574 A[Catch: all -> 0x0584, TryCatch #2 {all -> 0x0584, blocks: (B:115:0x0566, B:119:0x0574, B:165:0x0577), top: B:114:0x0566 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0596 A[Catch: all -> 0x05b5, TryCatch #3 {all -> 0x05b5, blocks: (B:123:0x058e, B:125:0x0596, B:126:0x05a0), top: B:122:0x058e }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0577 A[Catch: all -> 0x0584, TRY_LEAVE, TryCatch #2 {all -> 0x0584, blocks: (B:115:0x0566, B:119:0x0574, B:165:0x0577), top: B:114:0x0566 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x023b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0401  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a() {
        int i;
        int i2;
        int i3;
        int length;
        int length2;
        int parseInt;
        java.lang.String str;
        int i4;
        int i5;
        int i6;
        int min;
        byte[] bArr;
        int length3;
        int i7;
        int i8;
        int i9;
        byte[] bArr2;
        int i10;
        int i11;
        int length4;
        boolean isEmpty;
        byte[] bytes;
        int i12;
        int i13;
        int length5;
        int length6;
        b();
        byte[] bArr3 = new byte[2];
        byte[] bArr4 = new byte[4];
        byte[] bArr5 = this.I;
        int i14 = 1;
        int length7 = bArr5 != null ? 4096 + bArr5.length + 1 : 4096;
        byte[] bArr6 = this.P;
        if (bArr6 == null || length7 > this.Q) {
            bArr6 = new byte[length7];
            this.P = bArr6;
            this.Q = length7;
        }
        byte[] bArr7 = bArr6;
        bArr7[0] = com.amap.api.mapcore.util.ix.e(this.a);
        byte[] a = com.amap.api.mapcore.util.ix.a(this.b, (byte[]) null);
        java.lang.System.arraycopy(a, 0, bArr7, 1, a.length);
        int a2 = a(this.q, bArr7, a(this.p, bArr7, a(this.h, bArr7, a(this.u, bArr7, a(this.g, bArr7, a(this.f, bArr7, a(this.e, bArr7, a(this.o, bArr7, a(this.d, bArr7, a(this.c, bArr7, a.length + 1))))))))));
        try {
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Req", "buildV4Dot219");
            bArr7[a2] = 0;
        }
        if (android.text.TextUtils.isEmpty(this.t)) {
            bArr7[a2] = 0;
            i = a2 + 1;
            int a3 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i)))));
            bArr7[a3] = java.lang.Byte.parseByte(this.y);
            int i15 = a3 + 1;
            bArr7[i15] = java.lang.Byte.parseByte(this.j);
            int i16 = i15 + 1;
            int i17 = this.z;
            i2 = i17 & 3;
            bArr7[i16] = (byte) i17;
            i3 = i16 + 1;
            if (i2 != 1 || i2 == 2) {
                byte[] b = com.amap.api.mapcore.util.ix.b(b("mcc"));
                java.lang.System.arraycopy(b, 0, bArr7, i3, b.length);
                int length8 = i3 + b.length;
                if (i2 != 1) {
                    byte[] b2 = com.amap.api.mapcore.util.ix.b(b("mnc"));
                    java.lang.System.arraycopy(b2, 0, bArr7, length8, b2.length);
                    int length9 = length8 + b2.length;
                    byte[] b3 = com.amap.api.mapcore.util.ix.b(b("lac"));
                    java.lang.System.arraycopy(b3, 0, bArr7, length9, b3.length);
                    length = length9 + b3.length;
                    byte[] c = com.amap.api.mapcore.util.ix.c(b("cellid"));
                    java.lang.System.arraycopy(c, 0, bArr7, length, c.length);
                    length2 = c.length;
                } else {
                    if (i2 == 2) {
                        byte[] b4 = com.amap.api.mapcore.util.ix.b(b("sid"));
                        java.lang.System.arraycopy(b4, 0, bArr7, length8, b4.length);
                        int length10 = length8 + b4.length;
                        byte[] b5 = com.amap.api.mapcore.util.ix.b(b("nid"));
                        java.lang.System.arraycopy(b5, 0, bArr7, length10, b5.length);
                        int length11 = length10 + b5.length;
                        byte[] b6 = com.amap.api.mapcore.util.ix.b(b("bid"));
                        java.lang.System.arraycopy(b6, 0, bArr7, length11, b6.length);
                        int length12 = length11 + b6.length;
                        byte[] c2 = com.amap.api.mapcore.util.ix.c(b(com.anythink.core.common.h.c.C));
                        java.lang.System.arraycopy(c2, 0, bArr7, length12, c2.length);
                        length = length12 + c2.length;
                        byte[] c3 = com.amap.api.mapcore.util.ix.c(b("lat"));
                        java.lang.System.arraycopy(c3, 0, bArr7, length, c3.length);
                        length2 = c3.length;
                    }
                    parseInt = java.lang.Integer.parseInt(b("signal"));
                    if (parseInt <= 127 || parseInt < -128) {
                        parseInt = 0;
                    }
                    bArr7[length8] = (byte) parseInt;
                    int i18 = length8 + 1;
                    byte[] a4 = com.amap.api.mapcore.util.ix.a(0, bArr3);
                    java.lang.System.arraycopy(a4, 0, bArr7, i18, a4.length);
                    i3 = i18 + 2;
                    if (i2 == 1) {
                        if (android.text.TextUtils.isEmpty(this.B)) {
                            bArr7[i3] = 0;
                            i3++;
                        } else {
                            int length13 = this.B.split("\\*").length;
                            bArr7[i3] = (byte) length13;
                            i3++;
                            for (int i19 = 0; i19 < length13; i19++) {
                                byte[] b7 = com.amap.api.mapcore.util.ix.b(a("lac", i19));
                                java.lang.System.arraycopy(b7, 0, bArr7, i3, b7.length);
                                int length14 = i3 + b7.length;
                                byte[] c4 = com.amap.api.mapcore.util.ix.c(a("cellid", i19));
                                java.lang.System.arraycopy(c4, 0, bArr7, length14, c4.length);
                                int length15 = length14 + c4.length;
                                int parseInt2 = java.lang.Integer.parseInt(a("signal", i19));
                                if (parseInt2 > 127 || parseInt2 < -128) {
                                    parseInt2 = 0;
                                }
                                bArr7[length15] = (byte) parseInt2;
                                i3 = length15 + 1;
                                if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.2d) {
                                    byte[] a5 = com.amap.api.mapcore.util.ix.a(0, bArr3);
                                    java.lang.System.arraycopy(a5, 0, bArr7, i3, a5.length);
                                    i3 += a5.length;
                                }
                            }
                        }
                    } else if (i2 == 2) {
                        bArr7[i3] = 0;
                        i3++;
                    }
                }
                length8 = length + length2;
                parseInt = java.lang.Integer.parseInt(b("signal"));
                if (parseInt <= 127) {
                }
                parseInt = 0;
                bArr7[length8] = (byte) parseInt;
                int i182 = length8 + 1;
                byte[] a42 = com.amap.api.mapcore.util.ix.a(0, bArr3);
                java.lang.System.arraycopy(a42, 0, bArr7, i182, a42.length);
                i3 = i182 + 2;
                if (i2 == 1) {
                }
            }
            str = this.D;
            if (str != null && (this.z & 8) == 8) {
                try {
                    byte[] bytes2 = str.getBytes("GBK");
                    int min2 = java.lang.Math.min(bytes2.length, 60);
                    bArr7[i3] = (byte) min2;
                    i3++;
                    java.lang.System.arraycopy(bytes2, 0, bArr7, i3, min2);
                    i4 = i3 + min2;
                } catch (java.lang.Exception unused) {
                }
                java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList = this.C;
                int size = arrayList.size();
                if ((this.z & 4) == 4 || size <= 0) {
                    bArr7[i4] = 0;
                    i5 = i4 + 1;
                } else {
                    arrayList.get(0);
                    bArr7[i4] = (byte) size;
                    i5 = i4 + 1;
                    int i20 = 0;
                    while (i20 < size) {
                        com.amap.api.mapcore.util.jv jvVar = arrayList.get(i20);
                        int i21 = jvVar.l;
                        if (i21 == 1 || i21 == 3 || i21 == 4) {
                            i13 = size;
                            byte b8 = (byte) i21;
                            if (jvVar.o) {
                                b8 = (byte) (b8 | 8);
                            }
                            bArr7[i5] = b8;
                            int i22 = i5 + 1;
                            byte[] a6 = com.amap.api.mapcore.util.ix.a(jvVar.a, bArr3);
                            java.lang.System.arraycopy(a6, 0, bArr7, i22, a6.length);
                            int length16 = i22 + a6.length;
                            byte[] a7 = com.amap.api.mapcore.util.ix.a(jvVar.b, bArr3);
                            java.lang.System.arraycopy(a7, 0, bArr7, length16, a7.length);
                            int length17 = length16 + a7.length;
                            byte[] a8 = com.amap.api.mapcore.util.ix.a(jvVar.c, bArr3);
                            java.lang.System.arraycopy(a8, 0, bArr7, length17, a8.length);
                            int length18 = length17 + a8.length;
                            byte[] b9 = com.amap.api.mapcore.util.ix.b(jvVar.d, bArr4);
                            java.lang.System.arraycopy(b9, 0, bArr7, length18, b9.length);
                            i5 = length18 + b9.length;
                        } else {
                            if (i21 == 2) {
                                byte b10 = (byte) i21;
                                if (jvVar.o) {
                                    b10 = (byte) (b10 | 8);
                                }
                                bArr7[i5] = b10;
                                int i23 = i5 + 1;
                                byte[] a9 = com.amap.api.mapcore.util.ix.a(jvVar.a, bArr3);
                                java.lang.System.arraycopy(a9, 0, bArr7, i23, a9.length);
                                int length19 = i23 + a9.length;
                                byte[] a10 = com.amap.api.mapcore.util.ix.a(jvVar.h, bArr3);
                                java.lang.System.arraycopy(a10, 0, bArr7, length19, a10.length);
                                int length20 = length19 + a10.length;
                                byte[] a11 = com.amap.api.mapcore.util.ix.a(jvVar.i, bArr3);
                                java.lang.System.arraycopy(a11, 0, bArr7, length20, a11.length);
                                int length21 = length20 + a11.length;
                                byte[] a12 = com.amap.api.mapcore.util.ix.a(jvVar.j, bArr3);
                                java.lang.System.arraycopy(a12, 0, bArr7, length21, a12.length);
                                int length22 = length21 + a12.length;
                                byte[] b11 = com.amap.api.mapcore.util.ix.b(jvVar.g, bArr4);
                                java.lang.System.arraycopy(b11, 0, bArr7, length22, b11.length);
                                int length23 = length22 + b11.length;
                                byte[] b12 = com.amap.api.mapcore.util.ix.b(jvVar.f, bArr4);
                                java.lang.System.arraycopy(b12, 0, bArr7, length23, b12.length);
                                i5 = length23 + b12.length;
                            } else if (i21 == 5) {
                                byte b13 = (byte) i21;
                                if (jvVar.o) {
                                    b13 = (byte) (b13 | 8);
                                }
                                bArr7[i5] = b13;
                                int i24 = i5 + 1;
                                byte[] a13 = com.amap.api.mapcore.util.ix.a(jvVar.a, bArr3);
                                java.lang.System.arraycopy(a13, 0, bArr7, i24, a13.length);
                                int length24 = i24 + a13.length;
                                byte[] a14 = com.amap.api.mapcore.util.ix.a(jvVar.b, bArr3);
                                java.lang.System.arraycopy(a14, 0, bArr7, length24, a14.length);
                                int length25 = length24 + a14.length;
                                byte[] a15 = com.amap.api.mapcore.util.ix.a(jvVar.c, bArr3);
                                java.lang.System.arraycopy(a15, 0, bArr7, length25, a15.length);
                                int length26 = length25 + a15.length;
                                i13 = size;
                                java.lang.System.arraycopy(com.amap.api.mapcore.util.ix.a(jvVar.e), 0, bArr7, length26, 8);
                                i5 = length26 + 8;
                            }
                            i13 = size;
                        }
                        int i25 = jvVar.k;
                        if (i25 > 127 || i25 < -128) {
                            i25 = 99;
                        }
                        bArr7[i5] = (byte) i25;
                        int i26 = i5 + 1;
                        byte[] a16 = com.amap.api.mapcore.util.ix.a(jvVar.m, bArr3);
                        java.lang.System.arraycopy(a16, 0, bArr7, i26, a16.length);
                        i5 = i26 + a16.length;
                        int i27 = jvVar.l;
                        if (i27 != 3 && i27 != 4 && i27 != 5) {
                            if (i27 == 1 && java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.3d) {
                                int i28 = jvVar.p;
                                if (i28 > 32767) {
                                    i28 = 32767;
                                }
                                byte[] a17 = com.amap.api.mapcore.util.ix.a(i28 >= 0 ? i28 : 32767, bArr3);
                                java.lang.System.arraycopy(a17, 0, bArr7, i5, a17.length);
                                int length27 = i5 + a17.length;
                                byte[] b14 = com.amap.api.mapcore.util.ix.b(jvVar.q, bArr4);
                                java.lang.System.arraycopy(b14, 0, bArr7, length27, b14.length);
                                length5 = length27 + b14.length;
                                byte[] b15 = com.amap.api.mapcore.util.ix.b(jvVar.r, bArr4);
                                java.lang.System.arraycopy(b15, 0, bArr7, length5, b15.length);
                                length6 = b15.length;
                                i5 = length5 + length6;
                            }
                            i20++;
                            size = i13;
                        }
                        if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.0d) {
                            int i29 = jvVar.p;
                            if (i29 > 32767) {
                                i29 = 32767;
                            }
                            byte[] a18 = com.amap.api.mapcore.util.ix.a(i29 >= 0 ? i29 : 32767, bArr3);
                            java.lang.System.arraycopy(a18, 0, bArr7, i5, a18.length);
                            i5 += a18.length;
                            if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.3d) {
                                byte[] b16 = com.amap.api.mapcore.util.ix.b(jvVar.q, bArr4);
                                java.lang.System.arraycopy(b16, 0, bArr7, i5, b16.length);
                                length5 = i5 + b16.length;
                                byte[] b17 = com.amap.api.mapcore.util.ix.b(jvVar.r, bArr4);
                                java.lang.System.arraycopy(b17, 0, bArr7, length5, b17.length);
                                length6 = b17.length;
                                i5 = length5 + length6;
                            }
                        }
                        i20++;
                        size = i13;
                    }
                }
                if (!android.text.TextUtils.isEmpty(this.E) || this.E.length() == 0) {
                    bArr7[i5] = 0;
                    i6 = i5 + 1;
                } else {
                    bArr7[i5] = 1;
                    i6 = i5 + 1;
                    try {
                        java.lang.String[] split = this.E.split(",");
                        byte[] a19 = a(split[0]);
                        java.lang.System.arraycopy(a19, 0, bArr7, i6, a19.length);
                        i6 += a19.length;
                        try {
                            byte[] bytes3 = split[2].getBytes("GBK");
                            int length28 = bytes3.length;
                            if (length28 > 127) {
                                length28 = 127;
                            }
                            bArr7[i6] = (byte) length28;
                            i6++;
                            java.lang.System.arraycopy(bytes3, 0, bArr7, i6, length28);
                            i12 = i6 + length28;
                        } catch (java.lang.Throwable th2) {
                            com.amap.api.mapcore.util.it.a(th2, "Req", "buildV4Dot214");
                            bArr7[i6] = 0;
                            i12 = i6 + 1;
                        }
                        int parseInt3 = java.lang.Integer.parseInt(split[1]);
                        if (parseInt3 <= 127) {
                            if (parseInt3 < -128) {
                            }
                            bArr7[i12] = java.lang.Byte.parseByte(java.lang.String.valueOf(parseInt3));
                            i6 = i12 + 1;
                            if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.2d) {
                                byte[] a20 = com.amap.api.mapcore.util.ix.a(0, bArr3);
                                java.lang.System.arraycopy(a20, 0, bArr7, i6, a20.length);
                                i6 += a20.length;
                            }
                        }
                        parseInt3 = 0;
                        bArr7[i12] = java.lang.Byte.parseByte(java.lang.String.valueOf(parseInt3));
                        i6 = i12 + 1;
                        if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.2d) {
                        }
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.mapcore.util.it.a(th3, "Req", "buildV4Dot216");
                        byte[] a21 = a(com.alipay.sdk.m.u.c.b);
                        java.lang.System.arraycopy(a21, 0, bArr7, i6, a21.length);
                        int length29 = i6 + a21.length;
                        bArr7[length29] = 0;
                        int i30 = length29 + 1;
                        bArr7[i30] = java.lang.Byte.parseByte("0");
                        i6 = i30 + 1;
                    }
                }
                java.util.ArrayList<android.net.wifi.ScanResult> arrayList2 = this.F;
                min = java.lang.Math.min(arrayList2.size(), 25);
                if (min != 0) {
                    bArr7[i6] = 0;
                    length3 = i6 + 1;
                    bArr = bArr7;
                } else {
                    bArr7[i6] = (byte) min;
                    int i31 = i6 + 1;
                    boolean z = com.amap.api.mapcore.util.ix.c() >= 17;
                    long b18 = z ? com.amap.api.mapcore.util.ix.b() / 1000 : 0L;
                    int i32 = 0;
                    while (i32 < min) {
                        android.net.wifi.ScanResult scanResult = arrayList2.get(i32);
                        byte[] a22 = a(scanResult.BSSID);
                        java.lang.System.arraycopy(a22, 0, bArr7, i31, a22.length);
                        int length30 = i31 + a22.length;
                        try {
                            byte[] bytes4 = scanResult.SSID.getBytes("GBK");
                            bArr7[length30] = (byte) bytes4.length;
                            length30++;
                            java.lang.System.arraycopy(bytes4, 0, bArr7, length30, bytes4.length);
                            i7 = length30 + bytes4.length;
                        } catch (java.lang.Exception unused2) {
                            bArr7[length30] = 0;
                            i7 = length30 + i14;
                        }
                        int i33 = scanResult.level;
                        if (i33 > 127) {
                            i33 = 0;
                        } else if (i33 < -128) {
                            i33 = 0;
                        }
                        bArr7[i7] = java.lang.Byte.parseByte(java.lang.String.valueOf(i33));
                        int i34 = i7 + i14;
                        byte[] bArr8 = bArr7;
                        if (!z || (i8 = (int) (b18 - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                            i8 = 0;
                        }
                        if (i8 > 65535) {
                            i8 = 65535;
                        }
                        byte[] a23 = com.amap.api.mapcore.util.ix.a(i8, bArr3);
                        java.lang.System.arraycopy(a23, 0, bArr8, i34, a23.length);
                        int length31 = i34 + a23.length;
                        byte[] a24 = com.amap.api.mapcore.util.ix.a(scanResult.frequency, bArr3);
                        java.lang.System.arraycopy(a24, 0, bArr8, length31, a24.length);
                        i31 = length31 + a24.length;
                        i32++;
                        bArr7 = bArr8;
                        i14 = 1;
                    }
                    bArr = bArr7;
                    byte[] a25 = com.amap.api.mapcore.util.ix.a(java.lang.Integer.parseInt(this.G), bArr3);
                    java.lang.System.arraycopy(a25, 0, bArr, i31, a25.length);
                    length3 = i31 + a25.length;
                }
                bArr[length3] = 0;
                int i35 = length3 + 1;
                bytes = this.H.getBytes("GBK");
                if (bytes.length > 127) {
                    bytes = null;
                }
                if (bytes == null) {
                    bArr[i35] = (byte) bytes.length;
                    int i36 = i35 + 1;
                    java.lang.System.arraycopy(bytes, 0, bArr, i36, bytes.length);
                    i9 = i36 + bytes.length;
                    bArr2 = new byte[]{0, 0};
                    isEmpty = android.text.TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                    }
                    java.lang.System.arraycopy(bArr2, 0, bArr, i9, 2);
                    i11 = i9 + 2;
                    if (!isEmpty) {
                    }
                    i10 = 2;
                    java.lang.System.arraycopy(com.amap.api.mapcore.util.ix.a(0, bArr3), 0, bArr, i11, i10);
                    int i37 = i11 + i10;
                    byte[] bArr9 = new byte[i10];
                    // fill-array-data instruction
                    bArr9[0] = 0;
                    bArr9[1] = 0;
                    java.lang.System.arraycopy(bArr9, 0, bArr, i37, i10);
                    int i38 = i37 + i10;
                    byte[] bArr10 = this.I;
                    if (bArr10 == null) {
                    }
                    byte[] a26 = com.amap.api.mapcore.util.ix.a(length4, (byte[]) null);
                    java.lang.System.arraycopy(a26, 0, bArr, i38, a26.length);
                    int length32 = i38 + a26.length;
                    if (length4 > 0) {
                    }
                    if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.0d) {
                    }
                    if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.1d) {
                    }
                    if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.2d) {
                    }
                    byte[] bArr11 = new byte[length32];
                    java.lang.System.arraycopy(bArr, 0, bArr11, 0, length32);
                    java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                    crc32.update(bArr11);
                    byte[] a27 = com.amap.api.mapcore.util.ix.a(crc32.getValue());
                    byte[] bArr12 = new byte[length32 + 8];
                    java.lang.System.arraycopy(bArr11, 0, bArr12, 0, length32);
                    java.lang.System.arraycopy(a27, 0, bArr12, length32, 8);
                    return bArr12;
                }
                bArr[i35] = 0;
                i9 = i35 + 1;
                bArr2 = new byte[]{0, 0};
                try {
                    isEmpty = android.text.TextUtils.isEmpty(this.K);
                    if (!isEmpty) {
                        bArr2 = com.amap.api.mapcore.util.ix.a(this.K.length(), bArr3);
                    }
                    java.lang.System.arraycopy(bArr2, 0, bArr, i9, 2);
                    i11 = i9 + 2;
                    if (!isEmpty) {
                        try {
                            byte[] bytes5 = this.K.getBytes("GBK");
                            java.lang.System.arraycopy(bytes5, 0, bArr, i11, bytes5.length);
                            i11 += bytes5.length;
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    i10 = 2;
                } catch (java.lang.Throwable unused4) {
                    i10 = 2;
                    i11 = i9 + 2;
                }
                try {
                    java.lang.System.arraycopy(com.amap.api.mapcore.util.ix.a(0, bArr3), 0, bArr, i11, i10);
                } catch (java.lang.Throwable unused5) {
                }
                int i372 = i11 + i10;
                byte[] bArr92 = new byte[i10];
                // fill-array-data instruction
                bArr92[0] = 0;
                bArr92[1] = 0;
                try {
                    java.lang.System.arraycopy(bArr92, 0, bArr, i372, i10);
                } catch (java.lang.Throwable unused6) {
                }
                int i382 = i372 + i10;
                byte[] bArr102 = this.I;
                length4 = bArr102 == null ? bArr102.length : 0;
                byte[] a262 = com.amap.api.mapcore.util.ix.a(length4, (byte[]) null);
                java.lang.System.arraycopy(a262, 0, bArr, i382, a262.length);
                int length322 = i382 + a262.length;
                if (length4 > 0) {
                    byte[] bArr13 = this.I;
                    java.lang.System.arraycopy(bArr13, 0, bArr, length322, bArr13.length);
                    length322 += this.I.length;
                }
                if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.0d) {
                    bArr[length322] = 0;
                    length322 = a(this.N, bArr, length322 + 1);
                }
                if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.1d) {
                    bArr[length322] = 0;
                    length322++;
                }
                if (java.lang.Double.valueOf(com.amap.api.mapcore.util.it.a).doubleValue() >= 5.2d) {
                    length322 = a(this.O, bArr, length322);
                }
                byte[] bArr112 = new byte[length322];
                java.lang.System.arraycopy(bArr, 0, bArr112, 0, length322);
                java.util.zip.CRC32 crc322 = new java.util.zip.CRC32();
                crc322.update(bArr112);
                byte[] a272 = com.amap.api.mapcore.util.ix.a(crc322.getValue());
                byte[] bArr122 = new byte[length322 + 8];
                java.lang.System.arraycopy(bArr112, 0, bArr122, 0, length322);
                java.lang.System.arraycopy(a272, 0, bArr122, length322, 8);
                return bArr122;
            }
            bArr7[i3] = 0;
            i4 = i3 + 1;
            java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList3 = this.C;
            int size2 = arrayList3.size();
            if ((this.z & 4) == 4) {
            }
            bArr7[i4] = 0;
            i5 = i4 + 1;
            if (android.text.TextUtils.isEmpty(this.E)) {
            }
            bArr7[i5] = 0;
            i6 = i5 + 1;
            java.util.ArrayList<android.net.wifi.ScanResult> arrayList22 = this.F;
            min = java.lang.Math.min(arrayList22.size(), 25);
            if (min != 0) {
            }
            bArr[length3] = 0;
            int i352 = length3 + 1;
            bytes = this.H.getBytes("GBK");
            if (bytes.length > 127) {
            }
            if (bytes == null) {
            }
        } else {
            byte[] a28 = a(this.t);
            bArr7[a2] = (byte) a28.length;
            int i39 = a2 + 1;
            java.lang.System.arraycopy(a28, 0, bArr7, i39, a28.length);
            i = i39 + a28.length;
            int a32 = a(this.x, bArr7, a(L, bArr7, a(J, bArr7, a(this.w, bArr7, a(this.v, bArr7, i)))));
            bArr7[a32] = java.lang.Byte.parseByte(this.y);
            int i152 = a32 + 1;
            bArr7[i152] = java.lang.Byte.parseByte(this.j);
            int i162 = i152 + 1;
            int i172 = this.z;
            i2 = i172 & 3;
            bArr7[i162] = (byte) i172;
            i3 = i162 + 1;
            if (i2 != 1) {
            }
            byte[] b19 = com.amap.api.mapcore.util.ix.b(b("mcc"));
            java.lang.System.arraycopy(b19, 0, bArr7, i3, b19.length);
            int length82 = i3 + b19.length;
            if (i2 != 1) {
            }
            length82 = length + length2;
            parseInt = java.lang.Integer.parseInt(b("signal"));
            if (parseInt <= 127) {
            }
            parseInt = 0;
            bArr7[length82] = (byte) parseInt;
            int i1822 = length82 + 1;
            byte[] a422 = com.amap.api.mapcore.util.ix.a(0, bArr3);
            java.lang.System.arraycopy(a422, 0, bArr7, i1822, a422.length);
            i3 = i1822 + 2;
            if (i2 == 1) {
            }
            str = this.D;
            if (str != null) {
                byte[] bytes22 = str.getBytes("GBK");
                int min22 = java.lang.Math.min(bytes22.length, 60);
                bArr7[i3] = (byte) min22;
                i3++;
                java.lang.System.arraycopy(bytes22, 0, bArr7, i3, min22);
                i4 = i3 + min22;
                java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList32 = this.C;
                int size22 = arrayList32.size();
                if ((this.z & 4) == 4) {
                }
                bArr7[i4] = 0;
                i5 = i4 + 1;
                if (android.text.TextUtils.isEmpty(this.E)) {
                }
                bArr7[i5] = 0;
                i6 = i5 + 1;
                java.util.ArrayList<android.net.wifi.ScanResult> arrayList222 = this.F;
                min = java.lang.Math.min(arrayList222.size(), 25);
                if (min != 0) {
                }
                bArr[length3] = 0;
                int i3522 = length3 + 1;
                bytes = this.H.getBytes("GBK");
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
            bArr7[i3] = 0;
            i4 = i3 + 1;
            java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList322 = this.C;
            int size222 = arrayList322.size();
            if ((this.z & 4) == 4) {
            }
            bArr7[i4] = 0;
            i5 = i4 + 1;
            if (android.text.TextUtils.isEmpty(this.E)) {
            }
            bArr7[i5] = 0;
            i6 = i5 + 1;
            java.util.ArrayList<android.net.wifi.ScanResult> arrayList2222 = this.F;
            min = java.lang.Math.min(arrayList2222.size(), 25);
            if (min != 0) {
            }
            bArr[length3] = 0;
            int i35222 = length3 + 1;
            bytes = this.H.getBytes("GBK");
            if (bytes.length > 127) {
            }
            if (bytes == null) {
            }
        }
    }
}
