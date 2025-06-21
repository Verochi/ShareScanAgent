package com.loc;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes23.dex */
public final class ft {
    protected static java.lang.String I;
    protected static java.lang.String K;
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
    protected java.lang.String f409s = null;
    protected java.lang.String t = null;
    protected java.lang.String u = null;
    protected java.lang.String v = null;
    protected java.lang.String w = null;
    protected java.lang.String x = null;
    protected java.lang.String y = null;
    protected int z = 0;
    protected java.util.ArrayList<com.loc.fc> A = new java.util.ArrayList<>();
    protected java.util.ArrayList<com.loc.fc> B = new java.util.ArrayList<>();
    protected java.lang.String C = null;
    protected java.lang.String D = null;
    protected java.util.ArrayList<com.loc.ei> E = new java.util.ArrayList<>();
    protected java.lang.String F = null;
    protected java.lang.String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected java.lang.String J = null;
    protected java.lang.String L = null;
    protected java.lang.String M = null;
    protected java.lang.String N = null;
    protected int O = 0;
    private java.util.List<com.loc.fe> S = null;
    private java.util.List<com.loc.fc> T = java.util.Collections.synchronizedList(new java.util.ArrayList());
    final int P = 3;

    private static int a(java.lang.String str, byte[] bArr, int i) {
        try {
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Req", "copyContentWithByteLen");
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

    private static void a(com.loc.fc fcVar, java.util.List<com.loc.fc> list) {
        if (fcVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(fcVar);
            return;
        }
        int i = -1;
        long j = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            com.loc.fc fcVar2 = list.get(i2);
            if (fcVar.c() == null || !fcVar.c().equals(fcVar2.c())) {
                j = java.lang.Math.min(j, fcVar2.t);
                if (j == fcVar2.t) {
                    i3 = i2;
                }
                i2++;
            } else {
                int i4 = fcVar.f406s;
                if (i4 != fcVar2.f406s) {
                    fcVar2.t = fcVar.t;
                    fcVar2.f406s = i4;
                }
            }
        }
        if (i >= 0) {
            if (size < 3) {
                list.add(fcVar);
            } else {
                if (fcVar.t <= j || i >= size) {
                    return;
                }
                list.remove(i);
                list.add(fcVar);
            }
        }
    }

    private void a(java.util.ArrayList<com.loc.fc> arrayList, java.util.ArrayList<com.loc.fc> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            java.util.Iterator<com.loc.fc> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.loc.fc next = it.next();
                if (next.r && next.n) {
                    a(next, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
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
                com.loc.fv.a(th, "Req", "getMacBa ".concat(str));
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

    private void b() {
        java.lang.String[] strArr = new java.lang.String[27];
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
        strArr[15] = this.f409s;
        strArr[16] = this.t;
        strArr[17] = this.u;
        strArr[18] = this.v;
        strArr[19] = this.w;
        strArr[20] = this.x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        for (int i = 0; i < 27; i++) {
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
        if (!com.loc.fd.a(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    public final void a(android.content.Context context, boolean z, boolean z2, com.loc.fd fdVar, com.loc.fj fjVar, android.net.ConnectivityManager connectivityManager, java.lang.String str, com.loc.ff ffVar) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        android.net.NetworkInfo networkInfo;
        java.lang.String str5;
        java.lang.String str6;
        java.util.ArrayList<com.loc.ei> arrayList;
        int i;
        java.lang.String f = com.loc.m.f(context);
        int d = com.loc.gd.d();
        this.J = str;
        this.S = null;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        java.lang.String str7 = str3;
        java.lang.String str8 = str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int g = fdVar.g();
        int h = fdVar.h();
        android.telephony.TelephonyManager i2 = fdVar.i();
        java.util.ArrayList<com.loc.fc> c = fdVar.c();
        java.util.ArrayList<com.loc.fc> d2 = fdVar.d();
        java.util.ArrayList<com.loc.ei> e = fjVar.e();
        java.lang.String str9 = h == 2 ? "1" : "0";
        if (i2 != null) {
            if (android.text.TextUtils.isEmpty(com.loc.fv.g)) {
                try {
                    com.loc.fv.g = com.loc.p.k();
                } catch (java.lang.Throwable th) {
                    com.loc.fv.a(th, "Aps", "getApsReq part4");
                }
            }
            str4 = "1";
            if (android.text.TextUtils.isEmpty(com.loc.fv.g) && android.os.Build.VERSION.SDK_INT < 29) {
                com.loc.fv.g = "888888888888888";
            }
            if (android.text.TextUtils.isEmpty(com.loc.fv.h)) {
                try {
                    com.loc.fv.h = com.loc.p.n();
                } catch (java.lang.SecurityException unused) {
                } catch (java.lang.Throwable th2) {
                    com.loc.fv.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (android.text.TextUtils.isEmpty(com.loc.fv.h) && android.os.Build.VERSION.SDK_INT < 29) {
                com.loc.fv.h = "888888888888888";
            }
        } else {
            str4 = "1";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Throwable th3) {
            com.loc.fv.a(th3, "Aps", "getApsReq part");
            networkInfo = null;
        }
        boolean a = fjVar.a(connectivityManager);
        if (com.loc.gd.a(networkInfo) != -1) {
            str5 = com.loc.gd.a(connectivityManager);
            str6 = a ? "2" : str4;
        } else {
            str5 = "";
            str6 = str5;
        }
        if ((g & 4) != 4 || d2.isEmpty()) {
            this.B.clear();
        } else {
            this.B.clear();
            this.B.addAll(d2);
        }
        this.A.clear();
        this.A.addAll(c);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        if (fjVar.l()) {
            if (a) {
                com.loc.fi n = fjVar.n();
                if (com.loc.fj.a(n)) {
                    sb2.append(n.a());
                    sb2.append(",");
                    int c2 = n.c();
                    if (c2 < -128 || c2 > 127) {
                        c2 = 0;
                    }
                    sb2.append(c2);
                    sb2.append(",");
                    java.lang.String b = n.b();
                    try {
                        i = b.getBytes("UTF-8").length;
                    } catch (java.lang.Exception unused2) {
                        i = 32;
                    }
                    if (i >= 32) {
                        b = "unkwn";
                    }
                    sb2.append(b.replace("*", "."));
                }
            }
            if (e != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(e);
            }
        } else {
            fjVar.g();
            java.util.ArrayList<com.loc.ei> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str8;
        this.d = str7;
        this.f = android.os.Build.MODEL;
        this.g = com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE;
        this.h = com.loc.gd.b(context);
        this.i = str9;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = f;
        this.p = com.loc.fv.g;
        this.q = com.loc.fv.h;
        this.f409s = java.lang.String.valueOf(d);
        this.t = com.loc.gd.i(context);
        this.v = "6.4.5";
        this.w = null;
        this.u = "";
        this.x = str5;
        this.y = str6;
        this.z = g;
        this.C = fdVar.l();
        this.F = com.loc.fj.q();
        this.D = sb2.toString();
        this.O = (int) ((com.loc.gd.b() - fjVar.r()) / 1000);
        try {
            if (android.text.TextUtils.isEmpty(I)) {
                I = com.loc.p.f(context);
            }
        } catch (java.lang.Throwable unused3) {
        }
        try {
            if (android.text.TextUtils.isEmpty(K)) {
                K = com.loc.p.a(context);
            }
        } catch (java.lang.Throwable unused4) {
        }
        try {
            if (android.text.TextUtils.isEmpty(this.M)) {
                this.M = com.loc.p.f();
            }
        } catch (java.lang.Throwable unused5) {
        }
        try {
            if (android.text.TextUtils.isEmpty(this.N)) {
                this.N = com.loc.p.e(context);
            }
        } catch (java.lang.Throwable unused6) {
        }
        try {
            this.S = ffVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (java.lang.Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:12|13|14|(17:279|(1:281)(1:382)|282|(7:284|(1:286)(1:359)|287|(1:289)(1:358)|290|(1:292)(1:357)|293)(12:(11:361|(1:363)(1:381)|364|(1:366)(1:380)|367|(1:369)(1:379)|370|(1:372)(1:378)|373|(1:375)(1:377)|376)|295|(1:297)(1:356)|(1:299)|300|(1:302)(1:354)|303|(1:305)|306|(1:308)|309|(2:311|(1:313)(3:314|(11:316|(1:318)(1:349)|319|(1:321)(1:348)|322|(1:324)(1:347)|325|(1:327)|328|(8:330|(1:332)(1:342)|333|(1:335)|336|(1:338)|339|340)(2:343|344)|341)|350))(17:351|(1:353)|19|(13:23|24|25|26|(1:275)(4:29|(6:31|(3:85|(1:87)|88)(1:(3:37|(1:39)|40)(2:79|(3:81|(1:83)|84)))|41|(1:43)|44|(3:65|(1:76)(5:67|(1:69)|(1:71)|72|(3:74|60|61)(1:75))|62)(3:50|(6:54|(1:56)|(1:58)|59|60|61)|62))|89|90)|91|(1:274)(15:95|96|97|98|99|100|(1:102)|103|104|105|(5:266|(1:268)|108|(2:110|111)|113)|107|108|(0)|113)|114|(1:116)(7:234|(1:236)(1:265)|(1:238)|239|(11:241|242|243|244|245|(1:259)(1:247)|248|249|(1:258)|(2:254|255)(1:257)|256)|263|264)|117|118|119|(28:121|122|123|124|125|(1:127)|128|129|(3:218|219|220)|131|132|133|134|135|136|137|138|(1:140)(1:213)|141|(1:143)|144|(5:146|(1:148)(1:185)|149|(5:152|153|(9:156|(2:162|(6:164|(1:166)|167|168|169|170)(4:171|(3:173|(1:175)|176)|169|170))|177|(1:179)|180|168|169|170|154)|181|182)|151)|186|(4:188|(1:190)(1:206)|191|(3:193|(6:196|(1:198)|199|(2:201|202)(1:204)|203|194)|205))|207|(1:209)|210|211)(3:225|(1:227)|(29:229|230|122|123|124|125|(0)|128|129|(0)|131|132|133|134|135|136|137|138|(0)(0)|141|(0)|144|(0)|186|(0)|207|(0)|210|211)(28:231|232|123|124|125|(0)|128|129|(0)|131|132|133|134|135|136|137|138|(0)(0)|141|(0)|144|(0)|186|(0)|207|(0)|210|211)))|278|26|(0)|275|91|(1:93)|274|114|(0)(0)|117|118|119|(0)(0)))|294|295|(0)(0)|(0)|299|300|(0)(0)|303|(0)|306|(0)|309|(0)(0))(1:17)|18|19|(16:21|23|24|25|26|(0)|275|91|(0)|274|114|(0)(0)|117|118|119|(0)(0))|278|26|(0)|275|91|(0)|274|114|(0)(0)|117|118|119|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x06e0, code lost:
    
        r13[r8] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x066b, code lost:
    
        if (r15 < (-128)) goto L247;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05c2 A[Catch: all -> 0x05d2, TRY_LEAVE, TryCatch #2 {all -> 0x05d2, blocks: (B:97:0x0558, B:105:0x0591, B:108:0x05a3, B:110:0x05c2, B:271:0x0587, B:100:0x056e, B:103:0x057b), top: B:96:0x0558, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x06bf A[Catch: all -> 0x06e0, TryCatch #0 {all -> 0x06e0, blocks: (B:119:0x06bb, B:121:0x06bf, B:225:0x06c2, B:229:0x06ce, B:231:0x06d2), top: B:118:0x06bb }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x06f3 A[Catch: all -> 0x0714, TryCatch #4 {all -> 0x0714, blocks: (B:125:0x06eb, B:127:0x06f3, B:128:0x06fd), top: B:124:0x06eb }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0705 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x06c2 A[Catch: all -> 0x06e0, TryCatch #0 {all -> 0x06e0, blocks: (B:119:0x06bb, B:121:0x06bf, B:225:0x06c2, B:229:0x06ce, B:231:0x06d2), top: B:118:0x06bb }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0364 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x054a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a() {
        int i;
        int i2;
        int i3;
        int length;
        int length2;
        int i4;
        byte[] bArr;
        long j;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        long j2;
        java.lang.String str;
        int i5;
        byte[] bArr5;
        byte[] bArr6;
        byte b;
        int i6;
        int i7;
        byte b2;
        int i8;
        int min;
        byte b3;
        int length3;
        int i9;
        int i10;
        int i11;
        int i12;
        byte[] bArr7;
        int i13;
        int i14;
        int length4;
        int length5;
        int length6;
        boolean isEmpty;
        java.lang.String str2;
        int i15;
        byte[] bArr8;
        int length7;
        int length8;
        b();
        int i16 = 2;
        byte[] bArr9 = new byte[2];
        byte[] bArr10 = new byte[4];
        byte[] bArr11 = this.H;
        int i17 = 1;
        int length9 = bArr11 != null ? 4096 + bArr11.length + 1 : 4096;
        byte[] bArr12 = this.Q;
        if (bArr12 == null || length9 > this.R) {
            bArr12 = new byte[length9];
            this.Q = bArr12;
            this.R = length9;
        }
        byte[] bArr13 = bArr12;
        int i18 = 0;
        bArr13[0] = com.loc.gd.g(this.a);
        byte[] bArr14 = null;
        byte[] a = com.loc.gd.a(this.b, (byte[]) null);
        java.lang.System.arraycopy(a, 0, bArr13, 1, a.length);
        int a2 = a(this.q, bArr13, a(this.p, bArr13, a(this.h, bArr13, a(this.u, bArr13, a(this.g, bArr13, a(this.f, bArr13, a(this.e, bArr13, a(this.o, bArr13, a(this.d, bArr13, a(this.c, bArr13, a.length + 1))))))))));
        try {
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Req", "buildV4Dot219");
            bArr13[a2] = 0;
        }
        if (android.text.TextUtils.isEmpty(this.t)) {
            bArr13[a2] = 0;
            i = a2 + 1;
            int a3 = a(this.x, bArr13, a(K, bArr13, a(I, bArr13, a(this.w, bArr13, a(this.v, bArr13, i)))));
            bArr13[a3] = java.lang.Byte.parseByte(this.y);
            int i19 = a3 + 1;
            bArr13[i19] = java.lang.Byte.parseByte(this.j);
            int i20 = i19 + 1;
            int i21 = this.z;
            i2 = i21 & 3;
            bArr13[i20] = (byte) i21;
            i3 = i20 + 1;
            if (i2 != 1 || i2 == 2) {
                byte[] a4 = com.loc.gd.a(this.A.size() <= 0 ? this.A.get(0).a : 0, (byte[]) null);
                java.lang.System.arraycopy(a4, 0, bArr13, i3, a4.length);
                int length10 = i3 + a4.length;
                if (i2 != 1) {
                    byte[] a5 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(0).b : 0, (byte[]) null);
                    java.lang.System.arraycopy(a5, 0, bArr13, length10, a5.length);
                    int length11 = length10 + a5.length;
                    byte[] a6 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(0).c : 0, (byte[]) null);
                    java.lang.System.arraycopy(a6, 0, bArr13, length11, a6.length);
                    length = length11 + a6.length;
                    byte[] b4 = com.loc.gd.b(this.A.size() > 0 ? this.A.get(0).d : 0, (byte[]) null);
                    java.lang.System.arraycopy(b4, 0, bArr13, length, b4.length);
                    length2 = b4.length;
                } else {
                    if (i2 == 2) {
                        byte[] a7 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(0).h : 0, (byte[]) null);
                        java.lang.System.arraycopy(a7, 0, bArr13, length10, a7.length);
                        int length12 = length10 + a7.length;
                        byte[] a8 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(0).i : 0, (byte[]) null);
                        java.lang.System.arraycopy(a8, 0, bArr13, length12, a8.length);
                        int length13 = length12 + a8.length;
                        byte[] a9 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(0).j : 0, (byte[]) null);
                        java.lang.System.arraycopy(a9, 0, bArr13, length13, a9.length);
                        int length14 = length13 + a9.length;
                        byte[] b5 = com.loc.gd.b(this.A.size() > 0 ? this.A.get(0).g : 0, (byte[]) null);
                        java.lang.System.arraycopy(b5, 0, bArr13, length14, b5.length);
                        length = length14 + b5.length;
                        byte[] b6 = com.loc.gd.b(this.A.size() > 0 ? this.A.get(0).f : 0, (byte[]) null);
                        java.lang.System.arraycopy(b6, 0, bArr13, length, b6.length);
                        length2 = b6.length;
                    }
                    i4 = this.A.size() > 0 ? this.A.get(0).k : 0;
                    if (i4 <= 127 || i4 < -128) {
                        i4 = 0;
                    }
                    bArr13[length10] = (byte) i4;
                    int i22 = length10 + 1;
                    if (this.A.size() > 0) {
                        bArr = bArr10;
                        j = (com.loc.gd.b() - this.A.get(0).t) / 1000;
                    } else {
                        bArr = bArr10;
                        j = 0;
                    }
                    if (j > 65535) {
                        j = 65535;
                    }
                    if (j < 0) {
                        j = 0;
                    }
                    byte[] a10 = com.loc.gd.a((int) j, bArr9);
                    java.lang.System.arraycopy(a10, 0, bArr13, i22, a10.length);
                    i3 = i22 + 2;
                    if (i2 != 1) {
                        bArr2 = bArr13;
                        if (i2 == 2) {
                            bArr2[i3] = 0;
                            i3++;
                        }
                        str = this.C;
                        if (str != null && (this.z & 8) == 8) {
                            try {
                                byte[] bytes = str.getBytes("GBK");
                                int min2 = java.lang.Math.min(bytes.length, 60);
                                bArr2[i3] = (byte) min2;
                                i3++;
                                java.lang.System.arraycopy(bytes, 0, bArr2, i3, min2);
                                i5 = i3 + min2;
                            } catch (java.lang.Exception unused) {
                            }
                            java.util.ArrayList<com.loc.fc> arrayList = this.B;
                            int size = arrayList.size();
                            int i23 = 5;
                            int i24 = 3;
                            if ((this.z & 4) == 4 || size <= 0) {
                                bArr5 = bArr2;
                                bArr6 = bArr;
                                bArr5[i5] = 0;
                                b = 1;
                                i6 = i5 + 1;
                            } else {
                                arrayList.get(0);
                                bArr2[i5] = (byte) size;
                                int i25 = 1;
                                i6 = i5 + 1;
                                int i26 = 0;
                                while (i26 < size) {
                                    com.loc.fc fcVar = arrayList.get(i26);
                                    int i27 = fcVar.l;
                                    if (i27 == i25 || i27 == i24 || i27 == 4) {
                                        bArr8 = bArr;
                                        byte b7 = (byte) i27;
                                        if (fcVar.n) {
                                            b7 = (byte) (b7 | 8);
                                        }
                                        bArr2[i6] = b7;
                                        int i28 = i6 + 1;
                                        byte[] a11 = com.loc.gd.a(fcVar.a, bArr9);
                                        java.lang.System.arraycopy(a11, i18, bArr2, i28, a11.length);
                                        int length15 = i28 + a11.length;
                                        byte[] a12 = com.loc.gd.a(fcVar.b, bArr9);
                                        java.lang.System.arraycopy(a12, i18, bArr2, length15, a12.length);
                                        int length16 = length15 + a12.length;
                                        byte[] a13 = com.loc.gd.a(fcVar.c, bArr9);
                                        java.lang.System.arraycopy(a13, i18, bArr2, length16, a13.length);
                                        int length17 = length16 + a13.length;
                                        byte[] b8 = com.loc.gd.b(fcVar.d, bArr8);
                                        java.lang.System.arraycopy(b8, i18, bArr2, length17, b8.length);
                                        i6 = length17 + b8.length;
                                    } else if (i27 == i16) {
                                        byte b9 = (byte) i27;
                                        if (fcVar.n) {
                                            b9 = (byte) (b9 | 8);
                                        }
                                        bArr2[i6] = b9;
                                        int i29 = i6 + 1;
                                        byte[] a14 = com.loc.gd.a(fcVar.a, bArr9);
                                        java.lang.System.arraycopy(a14, i18, bArr2, i29, a14.length);
                                        int length18 = i29 + a14.length;
                                        byte[] a15 = com.loc.gd.a(fcVar.h, bArr9);
                                        java.lang.System.arraycopy(a15, i18, bArr2, length18, a15.length);
                                        int length19 = length18 + a15.length;
                                        byte[] a16 = com.loc.gd.a(fcVar.i, bArr9);
                                        java.lang.System.arraycopy(a16, i18, bArr2, length19, a16.length);
                                        int length20 = length19 + a16.length;
                                        byte[] a17 = com.loc.gd.a(fcVar.j, bArr9);
                                        java.lang.System.arraycopy(a17, i18, bArr2, length20, a17.length);
                                        int length21 = length20 + a17.length;
                                        bArr8 = bArr;
                                        byte[] b10 = com.loc.gd.b(fcVar.g, bArr8);
                                        java.lang.System.arraycopy(b10, i18, bArr2, length21, b10.length);
                                        int length22 = length21 + b10.length;
                                        byte[] b11 = com.loc.gd.b(fcVar.f, bArr8);
                                        java.lang.System.arraycopy(b11, i18, bArr2, length22, b11.length);
                                        i6 = length22 + b11.length;
                                    } else {
                                        bArr8 = bArr;
                                        if (i27 == i23) {
                                            byte b12 = (byte) i27;
                                            if (fcVar.n) {
                                                b12 = (byte) (b12 | 8);
                                            }
                                            bArr2[i6] = b12;
                                            int i30 = i6 + 1;
                                            byte[] a18 = com.loc.gd.a(fcVar.a, bArr9);
                                            java.lang.System.arraycopy(a18, i18, bArr2, i30, a18.length);
                                            int length23 = i30 + a18.length;
                                            byte[] a19 = com.loc.gd.a(fcVar.b, bArr9);
                                            java.lang.System.arraycopy(a19, i18, bArr2, length23, a19.length);
                                            int length24 = length23 + a19.length;
                                            byte[] a20 = com.loc.gd.a(fcVar.c, bArr9);
                                            java.lang.System.arraycopy(a20, i18, bArr2, length24, a20.length);
                                            int length25 = length24 + a20.length;
                                            java.lang.System.arraycopy(com.loc.gd.a(fcVar.e), i18, bArr2, length25, 8);
                                            i6 = length25 + 8;
                                        }
                                    }
                                    int i31 = fcVar.k;
                                    if (i31 > 127 || i31 < -128) {
                                        i31 = 99;
                                    }
                                    bArr2[i6] = (byte) i31;
                                    int i32 = i6 + 1;
                                    byte[] bArr15 = bArr2;
                                    byte[] a21 = com.loc.gd.a((short) ((com.loc.gd.b() - fcVar.t) / 1000), bArr9);
                                    java.lang.System.arraycopy(a21, 0, bArr15, i32, a21.length);
                                    i6 = i32 + a21.length;
                                    int i33 = fcVar.l;
                                    if (i33 == 3 || i33 == 4 || i33 == 5) {
                                        if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.0d) {
                                            int i34 = fcVar.o;
                                            if (i34 > 32767) {
                                                i34 = 32767;
                                            }
                                            byte[] a22 = com.loc.gd.a(i34 >= 0 ? i34 : 32767, bArr9);
                                            java.lang.System.arraycopy(a22, 0, bArr15, i6, a22.length);
                                            i6 += a22.length;
                                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                                                byte[] b13 = com.loc.gd.b(fcVar.p, bArr8);
                                                java.lang.System.arraycopy(b13, 0, bArr15, i6, b13.length);
                                                length7 = i6 + b13.length;
                                                byte[] b14 = com.loc.gd.b(fcVar.q, bArr8);
                                                java.lang.System.arraycopy(b14, 0, bArr15, length7, b14.length);
                                                length8 = b14.length;
                                                i6 = length7 + length8;
                                            }
                                        }
                                        i26++;
                                        bArr = bArr8;
                                        bArr2 = bArr15;
                                        i16 = 2;
                                        i18 = 0;
                                        i25 = 1;
                                        i23 = 5;
                                        i24 = 3;
                                    } else {
                                        if (i33 == 1 && java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                                            int i35 = fcVar.o;
                                            if (i35 > 32767) {
                                                i35 = 32767;
                                            }
                                            byte[] a23 = com.loc.gd.a(i35 >= 0 ? i35 : 32767, bArr9);
                                            java.lang.System.arraycopy(a23, 0, bArr15, i6, a23.length);
                                            int length26 = i6 + a23.length;
                                            byte[] b15 = com.loc.gd.b(fcVar.p, bArr8);
                                            java.lang.System.arraycopy(b15, 0, bArr15, length26, b15.length);
                                            length7 = length26 + b15.length;
                                            byte[] b16 = com.loc.gd.b(fcVar.q, bArr8);
                                            java.lang.System.arraycopy(b16, 0, bArr15, length7, b16.length);
                                            length8 = b16.length;
                                            i6 = length7 + length8;
                                        }
                                        i26++;
                                        bArr = bArr8;
                                        bArr2 = bArr15;
                                        i16 = 2;
                                        i18 = 0;
                                        i25 = 1;
                                        i23 = 5;
                                        i24 = 3;
                                    }
                                }
                                bArr5 = bArr2;
                                bArr6 = bArr;
                                b = 1;
                            }
                            if (!android.text.TextUtils.isEmpty(this.D) || this.D.length() == 0) {
                                i7 = 1;
                                b2 = 0;
                                bArr5[i6] = 0;
                                i8 = i6 + 1;
                            } else {
                                bArr5[i6] = b;
                                i8 = i6 + 1;
                                try {
                                    java.lang.String[] split = this.D.split(",");
                                    byte[] a24 = a(split[0]);
                                    java.lang.System.arraycopy(a24, 0, bArr5, i8, a24.length);
                                    i8 += a24.length;
                                    try {
                                        byte[] bytes2 = split[2].getBytes("GBK");
                                        int length27 = bytes2.length;
                                        if (length27 > 127) {
                                            length27 = 127;
                                        }
                                        bArr5[i8] = (byte) length27;
                                        i8++;
                                        java.lang.System.arraycopy(bytes2, 0, bArr5, i8, length27);
                                        i15 = i8 + length27;
                                    } catch (java.lang.Throwable th2) {
                                        com.loc.fv.a(th2, "Req", "buildV4Dot214");
                                        bArr5[i8] = 0;
                                        i15 = i8 + 1;
                                    }
                                    int parseInt = java.lang.Integer.parseInt(split[1]);
                                    if (parseInt <= 127) {
                                        if (parseInt < -128) {
                                        }
                                        bArr5[i15] = java.lang.Byte.parseByte(java.lang.String.valueOf(parseInt));
                                        i8 = i15 + 1;
                                        if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                            byte[] a25 = com.loc.gd.a(this.O, bArr9);
                                            java.lang.System.arraycopy(a25, 0, bArr5, i8, a25.length);
                                            i8 += a25.length;
                                        }
                                        i7 = 1;
                                        b2 = 0;
                                    }
                                    parseInt = 0;
                                    bArr5[i15] = java.lang.Byte.parseByte(java.lang.String.valueOf(parseInt));
                                    i8 = i15 + 1;
                                    if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                    }
                                    i7 = 1;
                                    b2 = 0;
                                } catch (java.lang.Throwable th3) {
                                    com.loc.fv.a(th3, "Req", "buildV4Dot216");
                                    byte[] a26 = a(com.alipay.sdk.m.u.c.b);
                                    b2 = 0;
                                    java.lang.System.arraycopy(a26, 0, bArr5, i8, a26.length);
                                    int length28 = i8 + a26.length;
                                    bArr5[length28] = 0;
                                    i7 = 1;
                                    int i36 = length28 + 1;
                                    bArr5[i36] = java.lang.Byte.parseByte("0");
                                    i8 = i36 + 1;
                                }
                            }
                            java.util.ArrayList<com.loc.ei> arrayList2 = this.E;
                            min = java.lang.Math.min(arrayList2.size(), 25);
                            if (min != 0) {
                                bArr5[i8] = b2;
                                length3 = i8 + i7;
                                b3 = 0;
                            } else {
                                bArr5[i8] = (byte) min;
                                int i37 = i8 + i7;
                                boolean z = com.loc.gd.c() >= 17;
                                long b17 = z ? com.loc.gd.b() / 1000 : 0L;
                                for (int i38 = 0; i38 < min; i38++) {
                                    com.loc.ei eiVar = arrayList2.get(i38);
                                    byte[] a27 = a(com.loc.ei.a(eiVar.a));
                                    java.lang.System.arraycopy(a27, 0, bArr5, i37, a27.length);
                                    int length29 = i37 + a27.length;
                                    try {
                                        byte[] bytes3 = eiVar.b.getBytes("GBK");
                                        bArr5[length29] = (byte) bytes3.length;
                                        length29++;
                                        java.lang.System.arraycopy(bytes3, 0, bArr5, length29, bytes3.length);
                                        i10 = length29 + bytes3.length;
                                        i9 = 1;
                                    } catch (java.lang.Exception unused2) {
                                        bArr5[length29] = 0;
                                        i9 = 1;
                                        i10 = length29 + 1;
                                    }
                                    int i39 = eiVar.c;
                                    if (i39 <= 127) {
                                    }
                                    i39 = 0;
                                    bArr5[i10] = java.lang.Byte.parseByte(java.lang.String.valueOf(i39));
                                    int i40 = i10 + i9;
                                    if (!z || (i11 = (int) (b17 - (eiVar.f / 1000))) < 0) {
                                        i11 = 0;
                                    }
                                    if (i11 > 65535) {
                                        i11 = 65535;
                                    }
                                    byte[] a28 = com.loc.gd.a(i11, bArr9);
                                    java.lang.System.arraycopy(a28, 0, bArr5, i40, a28.length);
                                    int length30 = i40 + a28.length;
                                    byte[] a29 = com.loc.gd.a(eiVar.d, bArr9);
                                    java.lang.System.arraycopy(a29, 0, bArr5, length30, a29.length);
                                    i37 = length30 + a29.length;
                                }
                                b3 = 0;
                                byte[] a30 = com.loc.gd.a(java.lang.Integer.parseInt(this.F), bArr9);
                                java.lang.System.arraycopy(a30, 0, bArr5, i37, a30.length);
                                length3 = i37 + a30.length;
                            }
                            bArr5[length3] = b3;
                            int i41 = 1;
                            int i42 = length3 + 1;
                            str2 = this.G;
                            if (str2 == null) {
                                byte[] bytes4 = str2.getBytes("GBK");
                                if (bytes4.length > 127) {
                                    bytes4 = null;
                                }
                                if (bytes4 == null) {
                                    bArr5[i42] = 0;
                                    i41 = 1;
                                    i12 = i42 + i41;
                                    bArr7 = new byte[]{0, 0};
                                    isEmpty = android.text.TextUtils.isEmpty(this.J);
                                    if (!isEmpty) {
                                    }
                                    java.lang.System.arraycopy(bArr7, 0, bArr5, i12, 2);
                                    i14 = i12 + 2;
                                    if (!isEmpty) {
                                    }
                                    i13 = 2;
                                    java.lang.System.arraycopy(com.loc.gd.a(0, bArr9), 0, bArr5, i14, i13);
                                    int i43 = i14 + i13;
                                    byte[] bArr16 = new byte[i13];
                                    // fill-array-data instruction
                                    bArr16[0] = 0;
                                    bArr16[1] = 0;
                                    java.lang.System.arraycopy(bArr16, 0, bArr5, i43, i13);
                                    int i44 = i43 + i13;
                                    byte[] bArr17 = this.H;
                                    if (bArr17 != null) {
                                    }
                                    byte[] a31 = com.loc.gd.a(length4, (byte[]) null);
                                    java.lang.System.arraycopy(a31, 0, bArr5, i44, a31.length);
                                    int length31 = i44 + a31.length;
                                    if (length4 > 0) {
                                    }
                                    if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.0d) {
                                    }
                                    if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                    }
                                    if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                                    }
                                    byte[] bArr18 = new byte[length31];
                                    java.lang.System.arraycopy(bArr5, 0, bArr18, 0, length31);
                                    java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                                    crc32.update(bArr18);
                                    byte[] a32 = com.loc.gd.a(crc32.getValue());
                                    byte[] bArr19 = new byte[length31 + 8];
                                    java.lang.System.arraycopy(bArr18, 0, bArr19, 0, length31);
                                    java.lang.System.arraycopy(a32, 0, bArr19, length31, 8);
                                    return bArr19;
                                }
                                bArr5[i42] = (byte) bytes4.length;
                                int i45 = i42 + 1;
                                java.lang.System.arraycopy(bytes4, 0, bArr5, i45, bytes4.length);
                                i12 = i45 + bytes4.length;
                                bArr7 = new byte[]{0, 0};
                                isEmpty = android.text.TextUtils.isEmpty(this.J);
                                if (!isEmpty) {
                                }
                                java.lang.System.arraycopy(bArr7, 0, bArr5, i12, 2);
                                i14 = i12 + 2;
                                if (!isEmpty) {
                                }
                                i13 = 2;
                                java.lang.System.arraycopy(com.loc.gd.a(0, bArr9), 0, bArr5, i14, i13);
                                int i432 = i14 + i13;
                                byte[] bArr162 = new byte[i13];
                                // fill-array-data instruction
                                bArr162[0] = 0;
                                bArr162[1] = 0;
                                java.lang.System.arraycopy(bArr162, 0, bArr5, i432, i13);
                                int i442 = i432 + i13;
                                byte[] bArr172 = this.H;
                                if (bArr172 != null) {
                                }
                                byte[] a312 = com.loc.gd.a(length4, (byte[]) null);
                                java.lang.System.arraycopy(a312, 0, bArr5, i442, a312.length);
                                int length312 = i442 + a312.length;
                                if (length4 > 0) {
                                }
                                if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.0d) {
                                }
                                if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                }
                                if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                                }
                                byte[] bArr182 = new byte[length312];
                                java.lang.System.arraycopy(bArr5, 0, bArr182, 0, length312);
                                java.util.zip.CRC32 crc322 = new java.util.zip.CRC32();
                                crc322.update(bArr182);
                                byte[] a322 = com.loc.gd.a(crc322.getValue());
                                byte[] bArr192 = new byte[length312 + 8];
                                java.lang.System.arraycopy(bArr182, 0, bArr192, 0, length312);
                                java.lang.System.arraycopy(a322, 0, bArr192, length312, 8);
                                return bArr192;
                            }
                            bArr5[i42] = b3;
                            i12 = i42 + i41;
                            bArr7 = new byte[]{0, 0};
                            try {
                                isEmpty = android.text.TextUtils.isEmpty(this.J);
                                if (!isEmpty) {
                                    bArr7 = com.loc.gd.a(this.J.length(), bArr9);
                                }
                                java.lang.System.arraycopy(bArr7, 0, bArr5, i12, 2);
                                i14 = i12 + 2;
                                if (!isEmpty) {
                                    try {
                                        byte[] bytes5 = this.J.getBytes("GBK");
                                        java.lang.System.arraycopy(bytes5, 0, bArr5, i14, bytes5.length);
                                        i14 += bytes5.length;
                                    } catch (java.lang.Throwable unused3) {
                                    }
                                }
                                i13 = 2;
                            } catch (java.lang.Throwable unused4) {
                                i13 = 2;
                                i14 = i12 + 2;
                            }
                            try {
                                java.lang.System.arraycopy(com.loc.gd.a(0, bArr9), 0, bArr5, i14, i13);
                            } catch (java.lang.Throwable unused5) {
                            }
                            int i4322 = i14 + i13;
                            byte[] bArr1622 = new byte[i13];
                            // fill-array-data instruction
                            bArr1622[0] = 0;
                            bArr1622[1] = 0;
                            try {
                                java.lang.System.arraycopy(bArr1622, 0, bArr5, i4322, i13);
                            } catch (java.lang.Throwable unused6) {
                            }
                            int i4422 = i4322 + i13;
                            byte[] bArr1722 = this.H;
                            length4 = bArr1722 != null ? bArr1722.length : 0;
                            byte[] a3122 = com.loc.gd.a(length4, (byte[]) null);
                            java.lang.System.arraycopy(a3122, 0, bArr5, i4422, a3122.length);
                            int length3122 = i4422 + a3122.length;
                            if (length4 > 0) {
                                byte[] bArr20 = this.H;
                                java.lang.System.arraycopy(bArr20, 0, bArr5, length3122, bArr20.length);
                                length3122 += this.H.length;
                            }
                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.0d) {
                                java.util.List<com.loc.fc> list = this.T;
                                int size2 = list != null ? list.size() : 0;
                                bArr5[length3122] = (byte) size2;
                                int i46 = length3122 + 1;
                                byte[] bArr21 = new byte[i46];
                                java.lang.System.arraycopy(bArr5, 0, bArr21, 0, i46);
                                if (size2 > 0) {
                                    try {
                                        int i47 = i46;
                                        for (com.loc.fc fcVar2 : this.T) {
                                            int i48 = fcVar2.l;
                                            if (i48 != 1 && i48 != 3 && i48 != 4) {
                                                if (i48 == 2) {
                                                    byte b18 = (byte) i48;
                                                    if (fcVar2.n) {
                                                        b18 = (byte) (b18 | 8);
                                                    }
                                                    bArr5[i47] = b18;
                                                    int i49 = i47 + 1;
                                                    byte[] a33 = com.loc.gd.a(fcVar2.h, bArr9);
                                                    java.lang.System.arraycopy(a33, 0, bArr5, i49, a33.length);
                                                    int length32 = i49 + a33.length;
                                                    byte[] a34 = com.loc.gd.a(fcVar2.i, bArr9);
                                                    java.lang.System.arraycopy(a34, 0, bArr5, length32, a34.length);
                                                    length5 = length32 + a34.length;
                                                    byte[] a35 = com.loc.gd.a(fcVar2.j, bArr9);
                                                    java.lang.System.arraycopy(a35, 0, bArr5, length5, a35.length);
                                                    length6 = a35.length;
                                                    i47 = length5 + length6;
                                                    byte[] a36 = com.loc.gd.a((short) ((com.loc.gd.b() - fcVar2.t) / 1000), bArr9);
                                                    java.lang.System.arraycopy(a36, 0, bArr5, i47, a36.length);
                                                    i47 += a36.length;
                                                } else {
                                                    if (i48 == 5) {
                                                        byte b19 = (byte) i48;
                                                        if (fcVar2.n) {
                                                            b19 = (byte) (b19 | 8);
                                                        }
                                                        bArr5[i47] = b19;
                                                        int i50 = i47 + 1;
                                                        byte[] a37 = com.loc.gd.a(fcVar2.c, bArr9);
                                                        java.lang.System.arraycopy(a37, 0, bArr5, i50, a37.length);
                                                        int length33 = i50 + a37.length;
                                                        java.lang.System.arraycopy(com.loc.gd.a(fcVar2.e), 0, bArr5, length33, 8);
                                                        i47 = length33 + 8;
                                                    }
                                                    byte[] a362 = com.loc.gd.a((short) ((com.loc.gd.b() - fcVar2.t) / 1000), bArr9);
                                                    java.lang.System.arraycopy(a362, 0, bArr5, i47, a362.length);
                                                    i47 += a362.length;
                                                }
                                            }
                                            byte b20 = (byte) i48;
                                            if (fcVar2.n) {
                                                b20 = (byte) (b20 | 8);
                                            }
                                            bArr5[i47] = b20;
                                            int i51 = i47 + 1;
                                            byte[] a38 = com.loc.gd.a(fcVar2.c, bArr9);
                                            java.lang.System.arraycopy(a38, 0, bArr5, i51, a38.length);
                                            length5 = i51 + a38.length;
                                            byte[] b21 = com.loc.gd.b(fcVar2.d, bArr6);
                                            java.lang.System.arraycopy(b21, 0, bArr5, length5, b21.length);
                                            length6 = b21.length;
                                            i47 = length5 + length6;
                                            byte[] a3622 = com.loc.gd.a((short) ((com.loc.gd.b() - fcVar2.t) / 1000), bArr9);
                                            java.lang.System.arraycopy(a3622, 0, bArr5, i47, a3622.length);
                                            i47 += a3622.length;
                                        }
                                        i46 = i47;
                                    } catch (java.lang.Throwable unused7) {
                                        java.lang.System.arraycopy(bArr21, 0, bArr5, 0, i46);
                                        bArr5[i46 - 1] = 0;
                                    }
                                }
                                length3122 = a(this.M, bArr5, i46);
                            }
                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                java.util.List<com.loc.fe> list2 = this.S;
                                int size3 = list2 == null ? 0 : list2.size();
                                bArr5[length3122] = (byte) size3;
                                length3122++;
                                if (size3 > 0) {
                                    for (com.loc.fe feVar : this.S) {
                                        int currentTimeMillis = ((int) (java.lang.System.currentTimeMillis() - feVar.d)) / 1000;
                                        if (currentTimeMillis > 65535) {
                                            currentTimeMillis = 65535;
                                        }
                                        java.lang.System.arraycopy(com.loc.gd.a(currentTimeMillis, bArr9), 0, bArr5, length3122, 2);
                                        int i52 = length3122 + 2;
                                        java.lang.System.arraycopy(com.loc.gd.b((int) java.lang.Math.round(feVar.c * 1.0E7d), bArr6), 0, bArr5, i52, 4);
                                        int i53 = i52 + 4;
                                        java.lang.System.arraycopy(com.loc.gd.b((int) java.lang.Math.round(feVar.b * 1.0E7d), bArr6), 0, bArr5, i53, 4);
                                        int i54 = i53 + 4;
                                        float f = feVar.e;
                                        if (f > 65535.0f) {
                                            f = 65535.0f;
                                        }
                                        java.lang.System.arraycopy(com.loc.gd.a((int) f, bArr9), 0, bArr5, i54, 2);
                                        int i55 = i54 + 2;
                                        java.lang.System.arraycopy(com.loc.gd.a((short) ((feVar.h | (feVar.a << 13) | (feVar.g << 6)) & 65535), bArr9), 0, bArr5, i55, 2);
                                        length3122 = i55 + 2;
                                    }
                                }
                            }
                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.3d) {
                                length3122 = a(this.N, bArr5, length3122);
                            }
                            byte[] bArr1822 = new byte[length3122];
                            java.lang.System.arraycopy(bArr5, 0, bArr1822, 0, length3122);
                            java.util.zip.CRC32 crc3222 = new java.util.zip.CRC32();
                            crc3222.update(bArr1822);
                            byte[] a3222 = com.loc.gd.a(crc3222.getValue());
                            byte[] bArr1922 = new byte[length3122 + 8];
                            java.lang.System.arraycopy(bArr1822, 0, bArr1922, 0, length3122);
                            java.lang.System.arraycopy(a3222, 0, bArr1922, length3122, 8);
                            return bArr1922;
                        }
                        bArr2[i3] = 0;
                        i5 = i3 + 1;
                        java.util.ArrayList<com.loc.fc> arrayList3 = this.B;
                        int size4 = arrayList3.size();
                        int i232 = 5;
                        int i242 = 3;
                        if ((this.z & 4) == 4) {
                        }
                        bArr5 = bArr2;
                        bArr6 = bArr;
                        bArr5[i5] = 0;
                        b = 1;
                        i6 = i5 + 1;
                        if (android.text.TextUtils.isEmpty(this.D)) {
                        }
                        i7 = 1;
                        b2 = 0;
                        bArr5[i6] = 0;
                        i8 = i6 + 1;
                        java.util.ArrayList<com.loc.ei> arrayList22 = this.E;
                        min = java.lang.Math.min(arrayList22.size(), 25);
                        if (min != 0) {
                        }
                        bArr5[length3] = b3;
                        int i412 = 1;
                        int i422 = length3 + 1;
                        str2 = this.G;
                        if (str2 == null) {
                        }
                    } else if (this.A.size() == 0) {
                        bArr13[i3] = 0;
                        i3++;
                    } else {
                        int size5 = this.A.size();
                        bArr13[i3] = (byte) size5;
                        i3++;
                        int i56 = 0;
                        while (i56 < size5) {
                            byte[] a39 = com.loc.gd.a(this.A.size() > 0 ? this.A.get(i56).c : 0, bArr14);
                            java.lang.System.arraycopy(a39, 0, bArr13, i3, a39.length);
                            int length34 = i3 + a39.length;
                            byte[] b22 = com.loc.gd.b(this.A.size() > 0 ? this.A.get(i56).d : 0, bArr14);
                            java.lang.System.arraycopy(b22, 0, bArr13, length34, b22.length);
                            int length35 = length34 + b22.length;
                            int i57 = this.A.size() > 0 ? this.A.get(i56).k : 0;
                            if (i57 > 127 || i57 < -128) {
                                i57 = 0;
                            }
                            bArr13[length35] = (byte) i57;
                            i3 = length35 + i17;
                            if (java.lang.Double.valueOf(com.loc.fv.a).doubleValue() >= 5.2d) {
                                if (this.A.size() > 0) {
                                    bArr4 = bArr13;
                                    j2 = (com.loc.gd.b() - this.A.get(0).t) / 1000;
                                } else {
                                    bArr4 = bArr13;
                                    j2 = 0;
                                }
                                if (j2 > 65535) {
                                    j2 = 65535;
                                }
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                byte[] a40 = com.loc.gd.a((int) j2, bArr9);
                                bArr3 = bArr4;
                                java.lang.System.arraycopy(a40, 0, bArr3, i3, a40.length);
                                i3 += a40.length;
                            } else {
                                bArr3 = bArr13;
                            }
                            i56++;
                            bArr13 = bArr3;
                            i17 = 1;
                            bArr14 = null;
                        }
                    }
                }
                length10 = length + length2;
                if (this.A.size() > 0) {
                }
                if (i4 <= 127) {
                }
                i4 = 0;
                bArr13[length10] = (byte) i4;
                int i222 = length10 + 1;
                if (this.A.size() > 0) {
                }
                if (j > 65535) {
                }
                if (j < 0) {
                }
                byte[] a102 = com.loc.gd.a((int) j, bArr9);
                java.lang.System.arraycopy(a102, 0, bArr13, i222, a102.length);
                i3 = i222 + 2;
                if (i2 != 1) {
                }
            } else {
                bArr = bArr10;
            }
            bArr2 = bArr13;
            str = this.C;
            if (str != null) {
                byte[] bytes6 = str.getBytes("GBK");
                int min22 = java.lang.Math.min(bytes6.length, 60);
                bArr2[i3] = (byte) min22;
                i3++;
                java.lang.System.arraycopy(bytes6, 0, bArr2, i3, min22);
                i5 = i3 + min22;
                java.util.ArrayList<com.loc.fc> arrayList32 = this.B;
                int size42 = arrayList32.size();
                int i2322 = 5;
                int i2422 = 3;
                if ((this.z & 4) == 4) {
                }
                bArr5 = bArr2;
                bArr6 = bArr;
                bArr5[i5] = 0;
                b = 1;
                i6 = i5 + 1;
                if (android.text.TextUtils.isEmpty(this.D)) {
                }
                i7 = 1;
                b2 = 0;
                bArr5[i6] = 0;
                i8 = i6 + 1;
                java.util.ArrayList<com.loc.ei> arrayList222 = this.E;
                min = java.lang.Math.min(arrayList222.size(), 25);
                if (min != 0) {
                }
                bArr5[length3] = b3;
                int i4122 = 1;
                int i4222 = length3 + 1;
                str2 = this.G;
                if (str2 == null) {
                }
            }
            bArr2[i3] = 0;
            i5 = i3 + 1;
            java.util.ArrayList<com.loc.fc> arrayList322 = this.B;
            int size422 = arrayList322.size();
            int i23222 = 5;
            int i24222 = 3;
            if ((this.z & 4) == 4) {
            }
            bArr5 = bArr2;
            bArr6 = bArr;
            bArr5[i5] = 0;
            b = 1;
            i6 = i5 + 1;
            if (android.text.TextUtils.isEmpty(this.D)) {
            }
            i7 = 1;
            b2 = 0;
            bArr5[i6] = 0;
            i8 = i6 + 1;
            java.util.ArrayList<com.loc.ei> arrayList2222 = this.E;
            min = java.lang.Math.min(arrayList2222.size(), 25);
            if (min != 0) {
            }
            bArr5[length3] = b3;
            int i41222 = 1;
            int i42222 = length3 + 1;
            str2 = this.G;
            if (str2 == null) {
            }
        } else {
            byte[] a41 = a(this.t);
            bArr13[a2] = (byte) a41.length;
            int i58 = a2 + 1;
            java.lang.System.arraycopy(a41, 0, bArr13, i58, a41.length);
            i = i58 + a41.length;
            int a310 = a(this.x, bArr13, a(K, bArr13, a(I, bArr13, a(this.w, bArr13, a(this.v, bArr13, i)))));
            bArr13[a310] = java.lang.Byte.parseByte(this.y);
            int i192 = a310 + 1;
            bArr13[i192] = java.lang.Byte.parseByte(this.j);
            int i202 = i192 + 1;
            int i212 = this.z;
            i2 = i212 & 3;
            bArr13[i202] = (byte) i212;
            i3 = i202 + 1;
            if (i2 != 1) {
            }
            byte[] a42 = com.loc.gd.a(this.A.size() <= 0 ? this.A.get(0).a : 0, (byte[]) null);
            java.lang.System.arraycopy(a42, 0, bArr13, i3, a42.length);
            int length102 = i3 + a42.length;
            if (i2 != 1) {
            }
            length102 = length + length2;
            if (this.A.size() > 0) {
            }
            if (i4 <= 127) {
            }
            i4 = 0;
            bArr13[length102] = (byte) i4;
            int i2222 = length102 + 1;
            if (this.A.size() > 0) {
            }
            if (j > 65535) {
            }
            if (j < 0) {
            }
            byte[] a1022 = com.loc.gd.a((int) j, bArr9);
            java.lang.System.arraycopy(a1022, 0, bArr13, i2222, a1022.length);
            i3 = i2222 + 2;
            if (i2 != 1) {
            }
        }
    }
}
